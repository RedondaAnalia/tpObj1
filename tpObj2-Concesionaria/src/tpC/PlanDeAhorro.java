package tpC;

import java.util.ArrayList;

public class PlanDeAhorro {

	
	private Integer nroGrupo;
	private PlanDePago planDePago;
	private FormaDeAdjudicacion adjudicacion;
	private ArrayList<Participante> participantes;
	private ModeloDeAuto modeloAuto;
	
	public PlanDeAhorro(){
		participantes = new ArrayList<Participante>();
		nroGrupo = new Integer(0);
		planDePago = new PlanDePago();
		adjudicacion = new FormaDeAdjudicacion();
		modeloAuto = new ModeloDeAuto();
	}
	
	public Integer inscribirParticipante(Participante unParticipante) {
		this.participantes.add(unParticipante);
		return this.participantes.size();
	}
	
	public  ArrayList<Participante> getParticipantes(){
		return this.participantes;
	}

	public Integer cantDeCuotas() {
		return planDePago.cantDeCuotas();
	}
		
	
}