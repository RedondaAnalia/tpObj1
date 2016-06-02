package tpC;

public class Coord {
	private Integer coordX;
	private Integer coordY;
	
	public Coord(Integer x, Integer y){
		this.coordX = x;
		this.coordY = y;
	}

	
	public double distance(Coord secondCoord){
		Coord result = restar(this, secondCoord);
		double distance = Math.sqrt(Math.pow(result.coordX, 2) + Math.pow(result.coordY, 2));
		return distance;
	}
	
	private Coord restar(Coord firstCoord, Coord secondCoord) {
		Coord newCoord = new Coord(firstCoord.coordX-secondCoord.coordX, firstCoord.coordY - secondCoord.coordY);
		return newCoord;
	}
}
