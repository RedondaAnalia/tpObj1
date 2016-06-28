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
	
/**
 * Propósito: Retorna la fecha en la que el cliente comienza a ser cliente de la concesionaria.
 * @return LocalDate
 */
	
	public LocalDate getFchIngreso(){
		return fchIngreso;
	}
/**
 * Propósito:Retorna la direccion de mail del cliente.	
 * @return String
 */
	
	public String getMail(){
		return mail;
	}
	
/**
 * Propósito: Retorna el número de DNI del cliente.	
 * @return Integer
 */
	public Integer getDNI(){
		return dni;
	}

/**
 * Propósito: Retorna las participaciones del cliente en la concesionaria.
 * @return ArrayList <Participante>
 */
	
	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}
	
/**
 * Propósito: Retorna la dirección postal del cliente.
 * @return String
 */
	
	public String getDireccion(){
		return direccion;
	}

/**
 * Propósito: Retorna la fecha de nacimiento del cliente.
 * @return LocalDate
 */
	public LocalDate getFchNacimiento(){
		return fchNacimiento;
	}

/**
 * Propósito: retorna el nombre del cliente.
 * @return String
 */
	
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
