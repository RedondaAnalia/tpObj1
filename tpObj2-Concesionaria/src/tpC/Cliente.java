package tpC;

import java.util.*;

public class Cliente {

	private ArrayList<PlanDeAhorro> planes ;
	private ArrayList<Participante> participantes;
	private String apellido;

	public Cliente(){
		this.planes= new ArrayList <PlanDeAhorro>();
		this.participantes = new ArrayList<Participante>();
	}
	public String getApellido() {
		
		return this.apellido;
	}

	public void suscribirPlanDeAhorro(PlanDeAhorro plan) {
		this.planes.add(plan);
	}

	public ArrayList <PlanDeAhorro> getPlanes() {
		return this.planes;
	}
	
	public void addParticipante(Participante unParticipante) {
		this.participantes.add(unParticipante);	
	}
	
	public ArrayList<Participante> getParticipantes() {
		return this.participantes;
	}

}
