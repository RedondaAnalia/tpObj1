package tpC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.joda.time.LocalDate;

import java.util.*;

public class AdjudicacionPorMayorCobertura extends FormaDeAdjudicacion{	
	
	public Participante adjudicar (PlanDeAhorro unPlan) {
		
		//Se filtra como está por mayor cobertura...
		double max= unPlan.mayorPorcentajeDePago();
		List<Participante> participantesFiltrados= new ArrayList<Participante>();
		participantesFiltrados= unPlan.getParticipantes().stream().filter(participante -> participante.porcentajePago()== max).collect(Collectors.toList());
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
		// Si hay 2 en iguales condiciones, devuelve el primero que quedó en la lista.
		Collections.sort(participantesFiltrados, new Comparator<Participante>() {
			 public int compare(Participante p1, Participante p2) {
				 return (p1.getFchInscripcion()).compareTo((p2.getFchInscripcion()));
	  
			 }});	
    return participantesFiltrados.get(0);
    }
}


