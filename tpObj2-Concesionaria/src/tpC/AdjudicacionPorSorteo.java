package tpC;


public class AdjudicacionPorSorteo extends FormaDeAdjudicacion{

	
	public Participante adjudicar(PlanDeAhorro unPlan, SorteoLoteriaNacional sorteo) throws NoHayPartipantesException{
		if (unPlan.cantDeParticipantes()==0){
			throw new NoHayPartipantesException();
		}
		return unPlan.getParticipantes().get(sorteo.primerPremio(unPlan.cantDeParticipantes()));
	}


}
