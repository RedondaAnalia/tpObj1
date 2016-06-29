/**
 * @author Pablo
 */
package tpC;


public class Coord {
	private Integer coordX;
	private Integer coordY;
	
	/**
	 * Prop�sito: Registrar la ubicaci�n de un lugar
	 * @param Integer
	 * @param Integer
	 */
	public Coord(Integer ejeX, Integer ejeY){
		this.coordX = ejeX;
		this.coordY = ejeY;
	}

	/**
	 * Prop�sito: Calcular la distancia entre dos puntos
	 * @param Coord
	 * @return double
	 */
	public double distance(Coord segundaCoord){
		Coord result = restar(this, segundaCoord);
		double distance = Math.sqrt(Math.pow(result.coordX, 2) + Math.pow(result.coordY, 2));
		return distance;
	}
	
	/**
	 * Prop�sito: Genera una nueva coordenada a partir de dos coordenadas dadas
	 * @param Coord
	 * @param Coord
	 * @return Coord
	 */
	private Coord restar(Coord primeraCoord, Coord segundaCoord) {
		Coord nuevaCoord = new Coord(primeraCoord.coordX-segundaCoord.coordX, primeraCoord.coordY - segundaCoord.coordY);
		return nuevaCoord;
	}
}
