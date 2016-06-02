package tpC;

public class AdjudicacionPorSorteo implements FormaDeAdjudicacion{

	@Override
	public Integer adjudicar(PlanDeAhorro unPlan) {
		
		return new SorteoLoteriaNacional().primerPremio();
	}


}
