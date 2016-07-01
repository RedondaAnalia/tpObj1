/**
 * @author Anita
 */

package tpC;

import java.util.ArrayList;

public class AdjudicacionPorSorteo implements FormaDeAdjudicacion{
	SorteoLoteriaNacional sorteo;

/**
 * Propósito: Crea una instancia de Adjudicacion Por Sorteo	
 * @param Sorteo Loteria Nacional
 */
	public AdjudicacionPorSorteo(SorteoLoteriaNacional unSorteo){
		sorteo=unSorteo;
	}

/**
 * Propósito: Adjudica a un participante por un numero al azar.
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
		}
		
		/*
		ArrayList<Participante> clone= (ArrayList<Participante>) unPlanDeAhorro.getParticipantes().clone();
		clone.stream().filter(participante-> (participante.getCalidadDelParticipante().getClass() == ParticipanteStd.class));
		System.out.println(ParticipanteStd.class);
		System.out.println(clone.get(0).getCalidadDelParticipante().getClass());
		System.out.println(clone.get(1));
		System.out.println(clone.get(2));
		*/
		if (clone.size()==0){
			throw new NoHayParticipantesException("No hay participantes para adjudicar");
		}
		Participante ganador= clone.get(sorteo.primerPremio(clone.size()));
		ganador.stateAdjudicado();
		return ganador;
	}


}
