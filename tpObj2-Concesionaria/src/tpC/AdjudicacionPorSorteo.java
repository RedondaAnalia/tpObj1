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
		ArrayList<Participante> clone= (ArrayList<Participante>) unPlanDeAhorro.getParticipantes().clone();
		clone.stream().filter(participante->participante.getCalidadDelParticipante().getClass()== ParticipanteStd.class);
		if (clone.size()==0){
			throw new NoHayParticipantesException("No hay participantes para adjudicar");
		}
		return clone.get(sorteo.primerPremio(clone.size()));
	}


}
