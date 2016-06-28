/**
 * @author Pablo
 */
package tpC;


public class Coord {
	private Integer coordX;
	private Integer coordY;
	
	/**
	 * Propósito: Registrar la ubicación de un lugar
	 * @param Integer
	 * @param Integer
	 */
	public Coord(Integer x, Integer y){
		this.coordX = x;
		this.coordY = y;
	}

	/**
	 * Propósito: Calcular la distancia entre dos puntos
	 * @param Coord
	 * @return double
	 */
	public double distance(Coord secondCoord){
		Coord result = restar(this, secondCoord);
		double distance = Math.sqrt(Math.pow(result.coordX, 2) + Math.pow(result.coordY, 2));
		return distance;
	}
	
	/**
	 * Propósito: Genera una nueva coordenada a partir de dos coordenadas dadas
	 * @param Coord
	 * @param Coord
	 * @return Coord
	 */
	private Coord restar(Coord firstCoord, Coord secondCoord) {
		Coord newCoord = new Coord(firstCoord.coordX-secondCoord.coordX, firstCoord.coordY - secondCoord.coordY);
		return newCoord;
	}
}
