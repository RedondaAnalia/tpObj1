package tpC;

import java.util.ArrayList;

public class Participante {

	private Cliente cliente;
	private Integer nroDeOrden;
	private PlanDeAhorro planSuscripto;
	private CuotasPagas cuotasPagas;

	public Participante(Cliente unCliente) {
		this.cliente = unCliente;
		this.nroDeOrden = new Integer(0);
		this.planSuscripto = new PlanDeAhorro();
		this.cuotasPagas = new CuotasPagas();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void adquirirPlanDeAhorro(PlanDeAhorro unPlan) {
		/*
		 * Genialidad de parte de DER agrega el participante a la lista de participantes
		 * del plan y este le devuelve el nro de Orden... a veces me sorprendo a mi mismo
		 * creo q me tendría q dedicar a esto =D
		 */
		this.nroDeOrden = unPlan.inscribirParticipante(this);
		this.planSuscripto = unPlan;
	}

	public Integer getNroDeOrden() {
		return this.nroDeOrden;
	}

	public PlanDeAhorro getPlan() {
		return this.planSuscripto;
	}

	public void pagarCuota(Integer nroCuota, Integer importe) {
		this.cuotasPagas.pagar(nroCuota, importe);	
	}

	public Float porcentajePago() {
		return this.cuotasPagas.porcentajePago();
	}


	

}
