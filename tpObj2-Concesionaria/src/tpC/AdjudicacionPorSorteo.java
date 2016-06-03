package tpC;

public class AdjudicacionPorSorteo implements FormaDeAdjudicacion{

	@Override
	public Participante adjudicar(PlanDeAhorro unPlan) {
		SorteoLoteriaNacional sorteo= new SorteoLoteriaNacional();
		return unPlan.getParticipantes().get(sorteo.primerPremio());
	}


}
