package tpC;



public class Plan100x100 extends PlanDePago{

	public Plan100x100 (Integer cuotas){
		this.cantDeCuotas=cuotas;
	}
	
	public float valorDeCuota(ModeloDeAuto auto){
		return (auto.getValor())/cantDeCuotas ;
	}

}
