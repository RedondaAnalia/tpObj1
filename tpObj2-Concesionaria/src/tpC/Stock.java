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
			stock.put(aModelo,0);
		stock.put(aModelo, stock.get(aModelo)+1);
		
	}
	public void decrementarStock(ModeloDeAuto aModelo){
		//PRECOND: El stock del modelo debe ser mayor a 0
		stock.put(aModelo, stock.get(aModelo)-1);
	}
}

	
