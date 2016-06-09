package tpC;


public class AdjudicacionPorSorteo extends FormaDeAdjudicacion{

	
	public Participante adjudicar(PlanDeAhorro unPlan, SorteoLoteriaNacional sorteo){
		return unPlan.getParticipantes().get(sorteo.primerPremio(unPlan.cantDeParticipantes()));
	}


}
