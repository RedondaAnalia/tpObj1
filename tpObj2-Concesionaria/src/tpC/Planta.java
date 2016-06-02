package tpC;

import java.util.LinkedList;
import java.util.HashMap;

public class Planta {
	private HashMap<ModeloDeAuto, LinkedList<Auto>> stock;
	private Coord ubicacion;
	
	public Planta(Coord aUbicacion){
		this.stock = new HashMap<ModeloDeAuto, LinkedList<Auto> >();
		this.ubicacion = aUbicacion;
	}
	
	public Coord getUbicacion(){
		return ubicacion;
	}

	public LinkedList<Auto> stockDelModelo(ModeloDeAuto unModelo) {
		return this.stock.get(unModelo);
	}


	public void autoFabricado(Auto unAuto) {
		LinkedList<Auto> listaDeAutos = this.stock.get(unAuto.getModelo());
		listaDeAutos.add(unAuto);
	}


	public void puedeFabricarElModelo(ModeloDeAuto fordFiesta4pFull) {
		this.stock.put(fordFiesta4pFull, new LinkedList<Auto>());
	}


	public Auto retirarAutoModelo(ModeloDeAuto unModelo) {
		// PRECOND: debe existir el modelo del auto
		LinkedList<Auto> listaDeAutos = this.stock.get(unModelo);
		Auto autoARetirar = listaDeAutos.pop();
		return autoARetirar;
	}


	public boolean tieneStockModelo(ModeloDeAuto unModelo) {
		return !this.stockDelModelo(unModelo).isEmpty();
	}


}
