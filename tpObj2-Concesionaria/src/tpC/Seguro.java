/**
 * @author Demian
 */

package tpC;

public class Seguro {
	private double valorSeguro;
	
/**
 * Propůsito: Registrar el valor de la cuota del seguro
 * @param double
 */
	public Seguro(double valor){
		valorSeguro = valor;
	}

/**
 * Propůsito: Retorna el valor de la cuota del seguro	
 * @return double
 */
	public double cuotaSeguro() {
		return valorSeguro;
	}
	
/**
 * Propůsito: Setear un nuevo valor en costos de seguro
 * @param valor
 */
	
	public void setValorSeguro(double valor){
		valorSeguro = valor;
	}

	
}
