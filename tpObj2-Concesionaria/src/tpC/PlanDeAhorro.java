package tpC;

import java.util.ArrayList;

public class PlanDeAhorro {

	
	private Integer nroGrupo;
	private DateTime fchInscripcion;
	private PlanDePago planDePago;
	private FormaDeAdjudicacion adjudicacion;
	private ArrayList<Participante> participantes;
	
	public Integer inscribirParticipante(Participante unParticipante) {
		this.participantes.add(unParticipante);
		return this.participantes.size();
	}
	
}
