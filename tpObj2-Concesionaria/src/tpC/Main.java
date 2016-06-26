package tpC;

public class Main {

	private static Concesionaria generalMotors;
	private static Fabrica ford;
	private static Stock stock;
	private static Planta plantaPacheco;
	private static Planta plantaAlpargatas;
	private static Planta plantaPuertoMadryn;
	private static ModeloDeAuto fordFiesta4puertas;

	public static void main(String[] args) {
		stock = new Stock();
		ford = new Fabrica(stock);
		generalMotors = new Concesionaria(ford, new Coord(3, 10));
		plantaPacheco = new Planta(new Coord(34, 3), stock);
		plantaAlpargatas = new Planta(new Coord(0, 7), stock);
		plantaPuertoMadryn = new Planta(new Coord(200, 160), stock);
		ford.agregarPlanta(plantaAlpargatas);
		ford.agregarPlanta(plantaPacheco);
		ford.agregarPlanta(plantaPuertoMadryn);
		fordFiesta4puertas = new ModeloDeAuto();
		fordFiesta4puertas.setValor(200);
		
		

	}

}
