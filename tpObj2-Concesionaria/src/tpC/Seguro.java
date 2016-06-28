/**
 * @author Demian
 */

package tpC;

public class Seguro {
	private double valorSeguro;
	
/**
 * Propósito: Registrar el valor de la cuota del seguro
 * @param double
 */
	public Seguro(double valor){
		valorSeguro = valor;
	}

/**
 * Propósito: Retorna el valor de la cuota del seguro	
 * @return double
 */
	public double cuotaSeguro() {
		return valorSeguro;
	}
	
	public void setValorSeguro(double valor){
		valorSeguro = valor;
	}

	
}
