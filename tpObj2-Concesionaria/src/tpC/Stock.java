/**
 * @author Pablo
 */

package tpC;


import java.util.HashMap;

public class Stock {
	
	private HashMap<ModeloDeAuto, Integer> stock;
	
	/**
	 * Propósito: Mantiene actualizado el stock de unidades de fábrica
	 */
	public Stock(){
		stock = new HashMap<ModeloDeAuto, Integer>();
	}

	/**
	 * Propósito: Retorna la cantidad de unidades del modelo especificado
	 * @param ModeloDeAuto
	 * @return Integer
	 */
	public Integer getStockDelModelo(ModeloDeAuto unModelo) {
		return stock.get(unModelo);
	}
	
	/**
	 * Propósito: Aumenta en uno el stock del modelo
	 * @param ModeloDeAuto
	 */
	public void incrementarStock(ModeloDeAuto unModelo){
		if(!stock.containsKey(unModelo))
			this.agregarModelo(unModelo);
		stock.put(unModelo, stock.get(unModelo)+1);
	}

	/**
	 * Propósito: Decrementa en uno el stock del modelo
	 * @param ModeloDeAuto
	 * @throws NoHayStockException
	 */
	public void decrementarStock(ModeloDeAuto unModelo)throws NoHayStockException {
		if(this.stock.get(unModelo)==0){
			throw new NoHayStockException("No hay stock del modelo");
		}
		stock.put(unModelo, stock.get(unModelo)-1);
	}
	
	/**
	 * Propósito: Agrega al stock un nuevo modelo a estockear
	 * @param ModeloDeAuto
	 */
	public void agregarModelo(ModeloDeAuto unModelo){
		stock.put(unModelo,0);
	}
}

	
