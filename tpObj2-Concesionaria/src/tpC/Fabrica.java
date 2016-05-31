package tpC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Fabrica {

	private LinkedList<Planta> plantas;
	
	
	public void agregarPlanta(Planta planta) {
		this.plantas.add(planta);
	}	
	
	public Planta buscarStock(ModeloDeAuto modelo){
		for (int i = 0; i < this.plantas.size(); i++)
		{
			this.plantas.get(i);
		}
		
	}
}
