package tpC;


import java.util.*;
import java.util.Date; 

public class Cliente {

	private ArrayList<PlanDeAhorro> planes ;
	private ArrayList<Participante> participantes;
	private String apellido;
	private String nombre;
	private Integer dni;
	private String direccion;
	private String mail;
	private Date fchNacimiento;
	private Date fchIngreso;
	
	public Cliente(){
		this.planes= new ArrayList <PlanDeAhorro>();
		this.participantes = new ArrayList<Participante>();
	}
	
	public String getApellido() {	
		return this.apellido;
	}

	public void agregarPlanDeAhorro(PlanDeAhorro unPlan) {
		this.planes.add(unPlan);
		Participante nuevoParticipante = new Participante(this , unPlan);
		this.participantes.add(nuevoParticipante);
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
