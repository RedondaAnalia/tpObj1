package tpC;


public class Plan70x30 implements PlanDePago{

	private Integer cantDeCuotas;

/**
 * Propůsito: Crea una instancia de plan 70/30
 * @param cuotas
 */
	public Plan70x30(Integer cuotas) {
		cantDeCuotas= cuotas;
	}

/**
 * Propůsito: Retorna la cantidad de cuotas del Plan
 */
	
	public Integer cantDeCuotas() {
		return cantDeCuotas;
	}
	
/**
 * Propůsito: Retorna el valor actual de alicuota
 * @return double
 */
	
	public double valorDeCuota(ModeloDeAuto auto){
		return ((auto.getValor())* 0.7)/cantDeCuotas;
	}
	
/**
 * Propůsito: Retorna el 30% del valor actual del automovil.
 * @return double
 */
	public double cuotaFinal(ModeloDeAuto auto){
		return auto.getValor()*0.3;
	}
}
