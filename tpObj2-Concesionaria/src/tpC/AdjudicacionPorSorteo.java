package tpC;


public class AdjudicacionPorSorteo extends FormaDeAdjudicacion{

	
	public Participante adjudicar(PlanDeAhorro unPlan, SorteoLoteriaNacional sorteo) throws NoHayParticipantesException{
		if (unPlan.cantDeParticipantes()==0){
			throw new NoHayParticipantesException("No hay participantes");
		}
		return unPlan.getParticipantes().get(sorteo.primerPremio(unPlan.cantDeParticipantes()));
	}


}
