package tpC;

import org.joda.time.LocalDate;

public class ComprobanteDePago {

	Participante participante;
	Integer alicuota; //el valor de la cuota lo pasa el concecionario
	Integer gastosAdmin; //se lo pedimos a la administracion
	Integer seguroDeVida; //se lo pasa la aseguradora
	Integer nroCuota;
	LocalDate fchPago;
	
	
	public ComprobanteDePago(Integer alic, Integer curroAdmin, Integer curroSeg, Integer nroDeCuota){
		alicuota = alic;	
		gastosAdmin = curroAdmin;	
		seguroDeVida = curroSeg;	
		fchPago = new LocalDate();
		nroCuota = nroDeCuota;
	}

	public Integer getMontoAPagar() {
		return alicuota;
	}

	public LocalDate getFchVencimiento() {
		return fchPago;
	}

	public Integer getNroCuota() {
		return nroCuota;
	}

	
}
