package tpC;

public class CuponDeAdjudicacion {
	private Participante participante;
	private double montoParaAdjudicar;

	
	public CuponDeAdjudicacion(Participante beneficiado, double unMontoParaAdjudicar){
		participante = beneficiado;
		montoParaAdjudicar = unMontoParaAdjudicar;
	}
	
	public Participante getParticipante() {
		return participante;
	}
	
	public double getMontoParaAdjudicar() {
		return montoParaAdjudicar;
	}
}
