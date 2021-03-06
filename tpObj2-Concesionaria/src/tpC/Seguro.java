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
/**
 * Propůsito: Cotiar el seguro para un paricipante y un modelo de auto del que participa
 * @param double
 * @param integer
 * @return double
 */
	public double cotizarSeguroPara(double valorTotalPorPagar, Integer edadParticipante){
		return 50 + this.segEdad(edadParticipante) + this.segAuto(valorTotalPorPagar);
	}
	
/**
 * Propůsito: Calcula el seguro por el vlor adeudado del auto
 * @param double
 * @return double
 */
	private double segAuto(double valorTotalPorPagar) {
		double cot = 0.05* valorTotalPorPagar;
		return cot;
	}

/**
 * 	Propůsito: Calcula el seguro por la edad del participante
 * @param Integer
 * @return double
 */
	private double segEdad(Integer edadParticipante) {
		double ret = 0;
		if(edadParticipante>50)
			ret = (edadParticipante - 50)*10;
		return ret;
	}
	
}
