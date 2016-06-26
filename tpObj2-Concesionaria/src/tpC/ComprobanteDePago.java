/**
 * @author Demian
 */

package tpC;

import org.joda.time.LocalDate;

public class ComprobanteDePago {

	Participante participante;
	double alicuota;
	double gastosAdmin; 
	double seguroDeVida; 
	Integer nroCuota;
	LocalDate fchPago;
/**
 * Propósito: Registrar el pago de una Cuota y su fecha
 * @param unaCuota
 */
	
	public ComprobanteDePago(Cuota unaCuota){
		alicuota = unaCuota.getValorAlicuota();	
		gastosAdmin = unaCuota.getCargoAdministrativo();	
		seguroDeVida = unaCuota.getCargoSeguro();	
		fchPago = new LocalDate();
		nroCuota = unaCuota.getNroCuota();
	}

/**
 * Propósito: Retorna el monto total de la cuota.
 * @return double
 */
	public double getMontoTotalPagado() {
		return alicuota+gastosAdmin+seguroDeVida;
	}

/**
 * Propósito: Retorna la fecha de pago.
 * @return LocalDate
 */
	public LocalDate getFchDePago() {
		return fchPago;
	}

/**
 * Propósito: Retorna el número de la cuota pagada.
 * @return Integer
 */	
	public Integer getNroCuota() {
		return nroCuota;
	}

	
}
