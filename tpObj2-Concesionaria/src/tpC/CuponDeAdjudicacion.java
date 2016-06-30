package tpC;

public class CuponDeAdjudicacion {
	private Cliente cliente;
	private ModeloDeAuto auto;
	private Integer nRoDeOrden;
	private double montoParaAdjudicar;
	private boolean pago = false;
	
	public CuponDeAdjudicacion(Participante beneficiado, double montoParaAdjudicar){
		cliente = beneficiado.getCliente();
		auto = beneficiado.modeloElegido();
		nRoDeOrden = beneficiado.getNroDeOrden();
		montoParaAdjudicar = 
	}

}
