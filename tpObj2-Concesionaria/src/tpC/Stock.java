package tpC;


import java.util.HashMap;

public class Stock {
	
	private HashMap<ModeloDeAuto, Integer> stock;

	public Integer getStockDelModelo(ModeloDeAuto aModelo) {
		return stock.get(aModelo);
	}
	
	public void incrementarStock(ModeloDeAuto aModelo){
		stock.put(aModelo, stock.get(aModelo)+1);
	}
	public void decrementarStock(ModeloDeAuto aModelo){
		stock.put(aModelo, stock.get(aModelo)-1);
	}
}

	
