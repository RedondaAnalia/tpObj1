package tpC;


public class AdjudicacionPorSorteo implements FormaDeAdjudicacion{
	SorteoLoteriaNacional sorteo;
	
	public AdjudicacionPorSorteo(SorteoLoteriaNacional azar){
		sorteo=azar;
	}
	
	 
	public Participante adjudicar(PlanDeAhorro unPlan) throws NoHayParticipantesException{
		if (unPlan.cantDeParticipantes()==0){
			throw new NoHayParticipantesException("No hay participantes");
		}
		return unPlan.getParticipantes().get(sorteo.primerPremio(unPlan.cantDeParticipantes()));
	}


}
