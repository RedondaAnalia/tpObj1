/**
 * @author Anita - Demian
 */

package tpC;

import org.joda.time.LocalDate;

public class ComprobanteDePago {

	LocalDate fchPago;
	private Cuota cuota;
/**
 * Propůsito: Registrar el pago de una Cuota y su fecha
 * @param unaCuota
 * @param unPart 
 */
	
	public ComprobanteDePago(Cuota unaCuota){	
		fchPago = new LocalDate();
		cuota = unaCuota;
	}
}
