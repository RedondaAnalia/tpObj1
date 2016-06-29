package tpC;


public class Plan100x100 implements PlanDePago{

	public Integer cantDeCuotas;
	
/**
 * Propósito: Crea una instancia del plan 100x100.
 * @param cuotas
 */
	public Plan100x100 (Integer cuotas){
		this.cantDeCuotas=cuotas;
	}

/**
 * Propósito: Retorna la cantidad de cuotas del Plan
 */
	
	public Integer cantDeCuotas() {
		return cantDeCuotas;
	}
	
	
/**
 * Propósito: Retorna el valor actual de alicuota
 * @return double
 */
	
	public double valorDeCuota(ModeloDeAuto auto){
		return (auto.getValor())/cantDeCuotas ;
	}

/**
 * Propósito: Retorna el valor de cuota final. Siempre retorna 0 ya que es financiamiento 100x100.
 * @return 0.
 */
	
	public double cuotaFinal(ModeloDeAuto auto){
		return 0;
	}

}
