package tpC;

import java.util.*;

public class Cliente {

	private ArrayList<PlanDeAhorro> planes ;
	private String apellido;

	public Cliente(){
		this.planes= new ArrayList <PlanDeAhorro>();
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

}
