/**
 * @author Anal�a
 */
package tpC;


public class Plan70x30 implements PlanDePago{

	private Integer cantDeCuotas;

/**
 * Prop�sito: Crea una instancia de plan 70/30
 * @param cuotas
 */
	public Plan70x30(Integer cuotas) {
		cantDeCuotas= cuotas;
	}

/**
 * Prop�sito: Retorna la cantidad de cuotas del Plan
 */
	
	public Integer cantDeCuotas() {
		return cantDeCuotas;
	}
	
/**
 * Prop�sito: Retorna el valor actual de alicuota
 * @return double
 */
	
	public double valorDeCuota(ModeloDeAuto auto){
		return ((auto.getValor())* 0.7)/cantDeCuotas;
	}
	
/**
 * Prop�sito: Retorna el 30% del valor actual del automovil.
 * @return double
 */
	public double cuotaFinal(ModeloDeAuto auto){
		return auto.getValor()*0.3;
	}
}
