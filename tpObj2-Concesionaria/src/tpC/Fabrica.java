package tpC;

import java.util.LinkedList;

public class Fabrica {

	private LinkedList<Planta> plantas;
	
	
	public void agregarPlanta(Planta planta) {
		this.plantas.add(planta);
	}	
	
	public LinkedList<Auto> buscarStock(ModeloDeAuto modelo){
		LinkedList<Auto> stockDeModelo = new LinkedList<Auto>();
		for (int i = 0; i < this.plantas.size(); i++)
		{
			stockDeModelo.addAll(this.plantas.get(i).stockDelModelo(modelo));
		}
		return stockDeModelo;
	}
}
