/**
 * @author Anal�a - Demian - Pablo
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
 * Prop�sito: Registrar la participaci�n de un cliente en un plan de ahorro		
 * @param Cliente
 * @param PlanDeAhorro
 * @param Concesionaria
 */
	public Participante(Cliente unCliente, PlanDeAhorro unPlanDeAhorro, Concesionaria unaConcesionaria) {
		cliente = unCliente;
		this.adquirirPlanDeAhorro(unPlanDeAhorro);
		cuotasPagas = new CuotasPagas(unPlanDeAhorro.cantDeCuotas());
		fchInscripcion = new LocalDate();
		concesionaria = unaConcesionaria;
	}
	
/**
 * Prop�sito: Retorna el cliente de la participaci�n
 * @return Cliente
 */
	public Cliente getCliente() {
		return cliente;
	}
	
/**
 * Prop�sito: Retorna el n�mero de orden del participante en el plan al cual pertenece	
 * @return Integer
 */
	public Integer getNroDeOrden() {
		return this.nroDeOrden;
	}
	
/**
 * Prop�sito: Retorna el plan de ahorro al cual est� suscripto	
 * @return PlanDeAhorro
 */
	public PlanDeAhorro getPlan() {
		return this.planSuscripto;
	}
	
/**
 * Prop�sito: Retorna la fecha de inscripci�n al plan	
 * @return LocalDate
 */
	public LocalDate getFchInscripcion(){
		return fchInscripcion;
	}

/**
 * Prop�sito: Inscribir al participante en un plan de ahorro determinado	
 * @param PlanDeAhorro
 */
	public void adquirirPlanDeAhorro(PlanDeAhorro unPlanDeAhorro) {
		/*
		 * Agrega el participante a la lista de participantes
		 * del plan y este le devuelve el nro de Orden...
		 */
		this.nroDeOrden = unPlanDeAhorro.inscribirParticipante(this);
		this.planSuscripto = unPlanDeAhorro;
		this.fchInscripcion= new LocalDate();
	}

	
/**
 * Prop�sito: Pagar una cuota del plan
 * @param Cuota
 */
	public void pagarCuota(Cuota unaCuota) {
		cuotasPagas.pagar(concesionaria.recibirPago(unaCuota));
	}
	
/**
 * Prop�sito: Retorna la cantidad de cuotas pagas	
 * @return Integer
 */
	public Integer getCuotasPagas(){
		return cuotasPagas.getCantCuotasPagas();
	}

/**
 * Prop�sito: Retorna el porcentaje del plan que lleva pago	
 * @return double
 */
	public double porcentajePago() {
		return this.cuotasPagas.porcentajePago();
	}

/**
 * Prop�sito: Setear las cuotas del plan	
 * @param CuotasPagas //ES NECESARIO?? CUANDO SE USARIA SI TODOS LOS PLANES EMPIEZAN DE CERO??
 */
	public void setCuotasPagas(CuotasPagas cuotas) {
		this.cuotasPagas = cuotas;
	}


}
