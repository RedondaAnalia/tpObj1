package tpC;

public class Participante {

	private Cliente cliente;
	private Integer nroDeOrden;
	private PlanDeAhorro planSuscripto;
	private CuotasPagas cuotasPagas;

	public Participante(Cliente unParticipante) {
		this.cliente = unParticipante;
		this.planSuscripto = null;
		this.cuotasPagas = null;
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


	

}
