package tpC;


import java.util.HashMap;

public class Stock {
	
	private HashMap<ModeloDeAuto, Integer> stock;
	
	public Stock(){
		stock = new HashMap<ModeloDeAuto, Integer>();
	}

	public Integer getStockDelModelo(ModeloDeAuto unModelo) {
		return stock.get(unModelo);
	}
	
	public void incrementarStock(ModeloDeAuto unModelo){
		if(!stock.containsKey(unModelo))
			this.agregarModelo(unModelo);
		stock.put(unModelo, stock.get(unModelo)+1);
	}

	public void decrementarStock(ModeloDeAuto unModelo)throws NoHayStockException {
		if(this.stock.get(unModelo)==0){
			throw new NoHayStockException("No hay stock del modelo");
		}
		stock.put(unModelo, stock.get(unModelo)-1);
	}
	
	public void agregarModelo(ModeloDeAuto unModelo){
		stock.put(unModelo,0);
	}
}

	
