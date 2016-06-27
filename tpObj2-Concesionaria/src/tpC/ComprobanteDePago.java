/**
 * @author Demian
 */

package tpC;

import org.joda.time.LocalDate;
// No se pueden encapsular los colaboradores internos iguales a los de cuota, 
//en un objeto de tipo cuota???

public class ComprobanteDePago {

	Participante participante;
	double alicuota;
	double gastosAdmin; 
	double seguroDeVida; 
	Integer nroCuota;
	LocalDate fchPago;
/**
 * Prop�sito: Registrar el pago de una Cuota y su fecha
 * @param unaCuota
 * @param unPart 
 */
	
	public ComprobanteDePago(Cuota unaCuota, Participante unPart){
		participante = unPart;
		alicuota = unaCuota.getValorAlicuota();	
		gastosAdmin = unaCuota.getCargoAdministrativo();	
		seguroDeVida = unaCuota.getCargoSeguro();	
		fchPago = new LocalDate();
		nroCuota = unaCuota.getNroCuota();
	}

/**
 * Prop�sito: Retorna el monto total de la cuota.
 * @return double
 */
	public double getMontoTotalPagado() {
		return alicuota+gastosAdmin+seguroDeVida;
	}

/**
 * Prop�sito: Retorna la fecha de pago.
 * @return LocalDate
 */
	public LocalDate getFchDePago() {
		return fchPago;
	}

/**
 * Prop�sito: Retorna el n�mero de la cuota pagada.
 * @return Integer
 */	
	public Integer getNroCuota() {
		return nroCuota;
	}

	
}
