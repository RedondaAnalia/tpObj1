/**
 * @author Analía - Demian - Pablo
 */
//VER SETCUOTASPAGAS()
package tpC;

import org.joda.time.*;

public class Participante {

	private Cliente cliente;
	private Integer nroDeOrden;
	private PlanDeAhorro planSuscripto;
	private CuotasPagas cuotasPagas;
	private LocalDate fchInscripcion;
	private Concesionaria concesionaria;

/**
 * Propósito: Registrar la participación de un cliente en un plan de ahorro	
 * Precond: Este constructor es solo para testear, tiene 100 cuotas a pagar 
 * @param Cliente
 */
	public Participante(Cliente unCliente){
		
		cliente = unCliente;
		nroDeOrden = new Integer(0);
		cuotasPagas = new CuotasPagas(100); //este valor esta puesto solo para testear
	}
/**
 * Propósito: Registrar la participación de un cliente en un plan de ahorro		
 * @param Cliente
 * @param PlanDeAhorro
 * @param Concesionaria
 */
	public Participante(Cliente unCliente, PlanDeAhorro unPlan, Concesionaria conces) {
		cliente = unCliente;
		this.adquirirPlanDeAhorro(unPlan);
		cuotasPagas = new CuotasPagas(unPlan.cantDeCuotas());
		fchInscripcion = new LocalDate();
		concesionaria = conces;
	}
	
/**
 * Propósito: Retorna el cliente de la participación
 * @return Cliente
 */
	public Cliente getCliente() {
		return cliente;
	}
	
/**
 * Propósito: Retorna el número de orden del participante en el plan al cual pertenece	
 * @return Integer
 */
	public Integer getNroDeOrden() {
		return this.nroDeOrden;
	}
	
/**
 * Propósito: Retorna el plan de ahorro al cual está suscripto	
 * @return PlanDeAhorro
 */
	public PlanDeAhorro getPlan() {
		return this.planSuscripto;
	}
	
/**
 * Propósito: Retorna la fecha de inscripción al plan	
 * @return LocalDate
 */
	public LocalDate getFchInscripcion(){
		return fchInscripcion;
	}

/**
 * Propósito: Inscribir al participante en un plan de ahorro determinado	
 * @param PlanDeAhorro
 */
	public void adquirirPlanDeAhorro(PlanDeAhorro unPlan) {
		/*
		 * Agrega el participante a la lista de participantes
		 * del plan y este le devuelve el nro de Orden...
		 */
		this.nroDeOrden = unPlan.inscribirParticipante(this);
		this.planSuscripto = unPlan;
		this.fchInscripcion= new LocalDate();
	}

	
/**
 * Propósito: Pagar una cuota del plan
 * @param Cuota
 */
	public void pagarCuota(Cuota unaCuota) {
		cuotasPagas.pagar(concesionaria.recibirPago(unaCuota,this));
	}
	
/**
 * Propósito: Retorna la cantidad de cuotas pagas	
 * @return Integer
 */
	public Integer getCuotasPagas(){
		return cuotasPagas.getCantCuotasPagas();
	}

/**
 * Propósito: Retorna el porcentaje del plan que lleva pago	
 * @return double
 */
	public double porcentajePago() {
		return this.cuotasPagas.porcentajePago();
	}

/**
 * Propósito: Setear las cuotas del plan	
 * @param CuotasPagas //ES NECESARIO?? CUANDO SE USARIA SI TODOS LOS PLANES EMPIEZAN DE CERO??
 */
	public void setCuotasPagas(CuotasPagas cuotas) {
		this.cuotasPagas = cuotas;
	}


}
