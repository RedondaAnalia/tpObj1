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
	
/**
 * Propósito: Setear un nuevo valor en costos de seguro
 * @param valor
 */
	
	public void setValorSeguro(double valor){
		valorSeguro = valor;
	}

	
}
