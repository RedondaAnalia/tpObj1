package tpC;

import java.util.ArrayList;
import java.util.Date;

public class Participante {

	private Cliente cliente;
	private Integer nroDeOrden;
	private PlanDeAhorro planSuscripto;
	private CuotasPagas cuotasPagas;
	private Date fchInscripcion;

	public Participante(Cliente unCliente ){
		cliente = unCliente;
		nroDeOrden = new Integer(0);
		cuotasPagas = new CuotasPagas(100);//este 100 es solo de prueba en 
		//el siguiente constructor lo sacamos del plan elegido
		fchInscripcion = new Date();
	}
	
	public Participante(Cliente unCliente, PlanDeAhorro unPlan) {
		cliente = unCliente;
		this.adquirirPlanDeAhorro(unPlan);
		cuotasPagas = new CuotasPagas(unPlan.cantDeCuotas());
		fchInscripcion = new Date(); //confirmar que esto genere algo similar a today()
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void adquirirPlanDeAhorro(PlanDeAhorro unPlan) {
		/*
		 * Agrega el participante a la lista de participantes
		 * del plan y este le devuelve el nro de Orden...
		 */
		this.nroDeOrden = unPlan.inscribirParticipante(this);
		this.planSuscripto = unPlan;
		this.fchInscripcion= new Date();
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

	public double porcentajePago() {
		return this.cuotasPagas.porcentajePago();
	}

	public void setCuotasPagas(CuotasPagas cuota){
		this.cuotasPagas = cuota;
	}
	
	public Date getFchInscripcion(){
		return fchInscripcion;
	}

}
