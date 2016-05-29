package tpC;

import java.util.LinkedList;
import java.util.HashMap;

public class Planta {
	private HashMap<ModeloDeAuto, LinkedList<Auto>> stock;
	
	public Planta(){
		this.stock = new HashMap<ModeloDeAuto, LinkedList<Auto> >();
	}


	public LinkedList<Auto> stockDelModelo(ModeloDeAuto unAuto) {
		return this.stock.get(unAuto);
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


}
