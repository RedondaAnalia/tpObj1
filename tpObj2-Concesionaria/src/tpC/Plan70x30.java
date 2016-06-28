package tpC;


public class Plan70x30 implements PlanDePago{

	private Integer cantDeCuotas;
	
	public Plan70x30(Integer cuotas) {
		cantDeCuotas= cuotas;
	}
	
	public Integer cantDeCuotas() {
		return cantDeCuotas;
	}
	
	public double valorDeCuota(ModeloDeAuto auto){
		return ((auto.getValor())* 0.7)/cantDeCuotas;
	}
	
	public double cuotaFinal(ModeloDeAuto auto){
		return auto.getValor()*0.3;
	}
}
