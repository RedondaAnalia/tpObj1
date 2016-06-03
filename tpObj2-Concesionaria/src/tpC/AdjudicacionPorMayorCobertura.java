package tpC;

public class AdjudicacionPorMayorCobertura implements FormaDeAdjudicacion{

	@Override
	public Participante adjudicar(PlanDeAhorro unPlan) {
		//Participante ret = new Participante();
		Participante ret = unPlan.getParticipantes().get(0);
		//guardo el primer elemento de la lista
		for(Participante p: unPlan.getParticipantes()){ 
			if(p.porcentajePago()>ret.porcentajePago())
				ret = p;			
		}
		
		return ret;
	}

}
