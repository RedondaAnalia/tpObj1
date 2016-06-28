package tpC;


import java.util.HashMap;

public class Stock {
	
	private HashMap<ModeloDeAuto, Integer> stock;
	
	public Stock(){
		stock = new HashMap<ModeloDeAuto, Integer>();
	}

	public Integer getStockDelModelo(ModeloDeAuto aModelo) {
		return stock.get(aModelo);
	}
	
	public void incrementarStock(ModeloDeAuto aModelo){
		if(!stock.containsKey(aModelo))
			this.agregarModelo(aModelo);
		stock.put(aModelo, stock.get(aModelo)+1);
	}

	public void decrementarStock(ModeloDeAuto aModelo)throws NoHayStockException {
		if(this.stock.get(aModelo)==0){
			throw new NoHayStockException("No hay stock del modelo");
		}
		stock.put(aModelo, stock.get(aModelo)-1);
	}
	
	public void agregarModelo(ModeloDeAuto unModelo){
		stock.put(unModelo,0);
	}
}

	
