package tpC;

public class AgenciaDeFletes {
	
	
	private double precioPorKilometro;

	public double consultarValorDelFlete(Coord x, Coord y){
		double distancia = x.distance(y);
		return distancia * precioPorKilometro;
	}

	/**
	 * @param precioPorKilometro the precioPorKilometro to set
	 */
	public void setPrecioPorKilometro(double precioPorKilometro) {
		this.precioPorKilometro = precioPorKilometro;
	}
	
	
	
	
	
}
