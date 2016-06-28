package tpC;


import java.util.LinkedList;
import java.util.HashMap;

public class Planta {
	private HashMap<ModeloDeAuto, LinkedList<Auto>> deposito;
	private Coord ubicacion;
	private Stock observerStock;
	
	public Planta(Coord aUbicacion, Stock aStockObserver){
		this.deposito = new HashMap<ModeloDeAuto, LinkedList<Auto> >();
		this.ubicacion = aUbicacion;
		this.observerStock = aStockObserver;
	}
	
	public Coord getUbicacion(){
		return ubicacion;
	}

	public LinkedList<Auto> stockDelModelo(ModeloDeAuto unModelo) {
		return this.deposito.get(unModelo);
	}


	private void autoFabricado(Auto unAuto) {
		LinkedList<Auto> listaDeAutos = this.deposito.get(unAuto.getModelo());
		listaDeAutos.add(unAuto);
		this.observerStock.incrementarStock(unAuto.getModelo());
	}


	public void puedeFabricarElModelo(ModeloDeAuto fordFiesta4pFull) {
		this.deposito.put(fordFiesta4pFull, new LinkedList<Auto>());
	}


	public Auto retirarAutoModelo(ModeloDeAuto unModelo) throws NoHayStockException, NoExisteElModeloDelAutoException{
		if (!this.tieneStockModelo(unModelo)){
			throw new NoExisteElModeloDelAutoException ("El modelo de ese auto no tiene stock");
		}
		LinkedList<Auto> listaDeAutos = this.deposito.get(unModelo);
		this.observerStock.decrementarStock(unModelo);
		Auto autoARetirar = listaDeAutos.pop();
		return autoARetirar;
	}


	public boolean tieneStockModelo(ModeloDeAuto unModelo) {
		return !this.stockDelModelo(unModelo).isEmpty();
	}
	
	public boolean tieneModelo(ModeloDeAuto unModelo){
		return this.deposito.containsKey(unModelo);
		
	}

	public void fabricarElModelo(ModeloDeAuto unModelo) {
		Auto nuevoAuto = new Auto(unModelo);
		this.autoFabricado(nuevoAuto);
		
	}

}
