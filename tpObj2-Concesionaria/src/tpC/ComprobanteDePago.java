/**
 * @author Anita - Demian
 */

package tpC;

import org.joda.time.LocalDate;

public class ComprobanteDePago {

	LocalDate fchPago;
	private Cuota cuota;

	
	
/**
 * Propósito: Crear una instancia para el registro del pago de una Cuota y su fecha
 * @param Cuota 
 */
	
	public ComprobanteDePago(Cuota unaCuota){	
		fchPago = new LocalDate();
		cuota = unaCuota;
	}
}
