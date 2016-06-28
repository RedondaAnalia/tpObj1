package tpC;


public class Plan100x100 implements PlanDePago{

	public Integer cantDeCuotas;
	
	public Plan100x100 (Integer cuotas){
		this.cantDeCuotas=cuotas;
	}
	
	public Integer cantDeCuotas() {
		return cantDeCuotas;
	}
	
	public double valorDeCuota(ModeloDeAuto auto){
		return (auto.getValor())/cantDeCuotas ;
	}
	
	public double cuotaFinal(ModeloDeAuto auto){
		return 0;
	}

}
