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
	//Precond: añoDeNacimiento debe tener 4 digitos.
	public Cliente(String suApellido, String suNombre, Integer numDeDNI, String suDireccionPostal, String suMail,
			int diaDeNacimiento,int mesDeNacimiento, int añoDeNacimiento,Concesionaria laConcesionaria){
		planes= new ArrayList <PlanDeAhorro>();
		participantes = new ArrayList<Participante>();
		apellido=suApellido;
		nombre=suNombre;
		dni=numDeDNI;
		direccion= suDireccionPostal;
		mail=suMail;
		fchNacimiento= new LocalDate(añoDeNacimiento,mesDeNacimiento,diaDeNacimiento);
		fchIngreso= new LocalDate();
		concesionaria=laConcesionaria;
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
	
/**
 * Propósito: retorna el apellido del cliente.
 * @return String
 */
	public String getApellido() {	
		return apellido;
	}

/**
 * Propósito: Retorna la lista de planes de ahorro a los cuales esta suscripto el cliente
 * @return ArrayList<PlanDeAhorro>
 */
	
	public ArrayList <PlanDeAhorro> getPlanes() {
		return planes;
	}

	
//METODOS.
/**
 * Propósito: Agrega un nuevo Plan De Ahorro al cliente.
 */
	public void agregarPlanDeAhorro(PlanDeAhorro unPlanDeAhorro) {
		planes.add(unPlanDeAhorro);
		Participante nuevoParticipante = new Participante(this , unPlanDeAhorro, concesionaria);
		participantes.add(nuevoParticipante);
	}
	

}
