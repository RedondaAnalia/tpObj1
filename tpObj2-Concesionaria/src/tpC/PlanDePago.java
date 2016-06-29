/**
 * @author Demian
 */

package tpC;


public interface PlanDePago {

	public Integer cantDeCuotas();
	public double valorDeCuota(ModeloDeAuto auto);
	public double cuotaFinal(ModeloDeAuto auto);

}

