/**
 * @author Anita
 */
package tpC;


import java.util.*;
import org.joda.*;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class Cliente {

	private ArrayList<PlanDeAhorro> planes ;
	private ArrayList<Participante> participantes;
	private String apellido;
	private String nombre;
	private Integer dni;
	private String direccion;
	private String mail;
	private LocalDate fchNacimiento;
	private LocalDate fchIngreso;
	private Concesionaria concesionaria;

// CONSTRUCTORES.
	/**
	 * 
	 * @param String (para Apellido)
	 * @param String (para Nombre)
	 * @param Integer (para DNI)
	 * @param String (para Direccion)
	 * @param String (para mail)
	 * @param Integer (dia de nacimiento)
	 * @param Integer (mes de nacimiento)
	 * @param Integer (año de nacimiento)
	 * @param Concesionaria
	 */
	//Precond: anioNac debe tener 4 digitos.
	public Cliente(String apell, String nombr, Integer doc, String direcc,String dirmail,int diaNac,int mesNac, int anioNac,Concesionaria conces){
		planes= new ArrayList <PlanDeAhorro>();
		participantes = new ArrayList<Participante>();
		apellido=apell;
		nombre=nombr;
		dni=doc;
		direccion= direcc;
		mail= dirmail;
		fchNacimiento= new LocalDate(anioNac,mesNac,diaNac);
		fchIngreso= new LocalDate();
		concesionaria=conces;
	}
	
//GETTERS.
	
	public LocalDate getFchIngreso(){
		return fchIngreso;
	}
	
	public String getMail(){
		return mail;
	}
	
	public Integer getDNI(){
		return dni;
	}
	
	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}
	
	public String getDireccion(){
		return direccion;
	}
	public LocalDate getFchNacimiento(){
		return fchNacimiento;
	}
	
	public String getNombre(){
		return nombre;
	}
	public String getApellido() {	
		return apellido;
	}
	
	public ArrayList <PlanDeAhorro> getPlanes() {
		return planes;
	}

	
//METODOS.
	public void agregarPlanDeAhorro(PlanDeAhorro unPlan) {
		planes.add(unPlan);
		Participante nuevoParticipante = new Participante(this , unPlan, concesionaria);
		participantes.add(nuevoParticipante);
	}

	
	public void addParticipante(Participante unParticipante) {
		participantes.add(unParticipante);	
	}
	
	

}
