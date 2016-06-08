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
	private Concesionaria concesionaria;
	
	//anioN 4 digitos.
	public Cliente(String apell, String nombr, Integer doc, String direcc,String dirmail,Integer diaNac,Integer mesNac, Integer anioNac,Concesionaria conces){
		planes= new ArrayList <PlanDeAhorro>();
		participantes = new ArrayList<Participante>();
		apellido=apell;
		nombre=nombr;
		dni=doc;
		direccion= direcc;
		mail= dirmail;
		fchNacimiento= new Date(anioNac, mesNac, diaNac);
		Date dia= new Date();
		concesionaria=conces;
	}
	
	public Date getFchIngreso(){
		return fchIngreso;
	}
	
	public String getApellido() {	
		return this.apellido;
	}

	public void agregarPlanDeAhorro(PlanDeAhorro unPlan) {
		this.planes.add(unPlan);
		Participante nuevoParticipante = new Participante(this , unPlan, concesionaria);
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
