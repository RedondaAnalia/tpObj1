package tpC;

public class Plan70x30 extends PlanDePago{

	public Plan70x30(Integer cuotas) {
		cantDeCuotas= cuotas;
	}
	
	public float valorDeCuota(ModeloDeAuto auto){
		return ((auto.getValor())* 0.7)/cantDeCuotas;
	}
	
	public float valorDe30(ModeloDeAuto auto){
		return auto.getValor()*0.3;
	}

}
