/**
 *@author Anita
 */
package tpC; 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.joda.time.LocalDate;

import java.util.*; 

public class AdjudicacionPorMayorCobertura implements FormaDeAdjudicacion {	
	
	/**
	 * Prop�sito: Adjudicar un plan de ahorro espec�fico.
	 * @param PlanDeAhorro
	 * @return Participante
	 */
	public Participante adjudicar(PlanDeAhorro unPlanDeAhorro) throws NoHayParticipantesException{
		
		if (unPlanDeAhorro.cantDeParticipantes()==0){
			throw new NoHayParticipantesException("No hay participantes");
		}
		
		ArrayList<Participante> clone = new ArrayList<Participante>();
		
		for (Participante participante : unPlanDeAhorro.getParticipantes()) {
			if(participante.getCalidadDelParticipante().getClass()==ParticipanteStd.class)
				clone.add(participante);
		}/*
		ArrayList<Participante> clone= (ArrayList<Participante>) unPlanDeAhorro.getParticipantes().clone();
		clone.stream().filter(participante->(participante.getCalidadDelParticipante().getClass()) != ParticipanteStd.class);
		*/
		if (clone.size()==0){
			throw new NoHayParticipantesException("No hay participantes para adjudicar");
		}
		
		//Se filtra como est� por mayor cobertura...
		double max= unPlanDeAhorro.mayorPorcentajeDePago();
		List<Participante> participantesFiltrados= new ArrayList<Participante>();
		participantesFiltrados= clone.stream().filter(participante -> participante.porcentajePago()== max).collect(Collectors.toList());
		if (participantesFiltrados.size()==1){
			return participantesFiltrados.get(0);
		}
		
		//Si hay mas de uno, busco la antiguedad en la concesionaria(una fecha es mas "chica" que otra si es mas reciente.)
		//Ordeno la lista
		Collections.sort(participantesFiltrados, new Comparator<Participante>() {
			 public int compare(Participante p1, Participante p2) {
				 return (p1.getCliente().getFchIngreso()).compareTo((p2.getCliente().getFchIngreso()));
	            }
});	
		//y me fijo si hay mas de uno con la misma antiguedad
		LocalDate aux=participantesFiltrados.get(0).getCliente().getFchIngreso();
		participantesFiltrados= participantesFiltrados.stream().filter(participante -> participante.getCliente().getFchIngreso()== aux).collect(Collectors.toList());
		if (participantesFiltrados.size()==1){
			return participantesFiltrados.get(0);
		}
		
		// Si sigue habiendo mas de uno, busco la antiguedad en el plan de ahorro. 
		// Si hay 2 en iguales condiciones, devuelve el primero que qued� en la lista.
		Collections.sort(participantesFiltrados, new Comparator<Participante>() {
			 public int compare(Participante p1, Participante p2) {
				 return (p1.getFchInscripcion()).compareTo((p2.getFchInscripcion()));
	  
			 }});	
	participantesFiltrados.get(0).stateAdjudicado();	
    return participantesFiltrados.get(0);
    }
}


