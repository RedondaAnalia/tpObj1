/**
 * @author Anita
 */

package tpC;


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
		return unPlanDeAhorro.getParticipantes().get(sorteo.primerPremio(unPlanDeAhorro.cantDeParticipantes()));
	}


}
