/**
 * @author Pablo
 */
package tpC;


import java.util.LinkedList;
import java.util.HashMap;

public class Planta {
	private HashMap<ModeloDeAuto, LinkedList<Auto>> deposito;
	private Coord ubicacion;
	private Stock observerStock;
	
	/**
	 * Prop�sito: Fabricar autos
	 * @param Coord
	 * @param Stock
	 */
	public Planta(Coord aUbicacion, Stock aStockObserver){
		this.deposito = new HashMap<ModeloDeAuto, LinkedList<Auto> >();
		this.ubicacion = aUbicacion;
		this.observerStock = aStockObserver;
	}
	
	/**
	 * Prop�sito: Retorna ubicaci�n de la planta
	 * @return Coord
	 */
	public Coord getUbicacion(){
		return ubicacion;
	}

	/**
	 * Prop�sito: Retorna la lista de autos de la planta
	 * @param ModeloDeAuto
	 * @return LinkedList<Auto>
	 */
	public LinkedList<Auto> lstDeAutosDelModelo(ModeloDeAuto unModelo) {
		return this.deposito.get(unModelo);
	}
	
	/**
	 * Prop�sito: Retorna la cantidad de autos del modelo requerido
	 * @param ModeloDeAuto
	 * @return Integer
	 */
	public Integer cantDeAutosDelModelo(ModeloDeAuto unModelo) {
		return this.deposito.get(unModelo).size();
	}

	/**
	 * Prop�sito: Agrega un auto al dep�sito de la planta
	 * @param Auto
	 */
	private void autoFabricado(Auto unAuto) {
		LinkedList<Auto> listaDeAutos = this.deposito.get(unAuto.getModelo());
		listaDeAutos.add(unAuto);
		this.observerStock.incrementarStock(unAuto.getModelo());
	}

	/**
	 * Prop�sito: Autorizar a la planta a fabricar el modelo especif�cado
	 * @param ModeloDeAuto
	 */
	public void puedeFabricarElModelo(ModeloDeAuto fordFiesta4pFull) {
		this.deposito.put(fordFiesta4pFull, new LinkedList<Auto>());
	}

	/**
	 * Prop�sito: Retirar el auto de la planta
	 * @param ModeloDeAuto
	 * @return Auto
	 * @throws NoHayStockException
	 * @throws NoExisteElModeloDelAutoException
	 */
	public Auto retirarAutoModelo(ModeloDeAuto unModelo) throws NoHayStockException, NoExisteElModeloDelAutoException{
		if (!this.tieneStockModelo(unModelo)){
			throw new NoExisteElModeloDelAutoException ("El modelo de ese auto no tiene stock");
		}
		LinkedList<Auto> listaDeAutos = this.deposito.get(unModelo);
		this.observerStock.decrementarStock(unModelo);
		Auto autoARetirar = listaDeAutos.pop();
		return autoARetirar;
	}

	/**
	 * Prop�sito: Evalua si hay stockk del modelo
	 * @param unModelo
	 * @return boolean
	 */
	public boolean tieneStockModelo(ModeloDeAuto unModelo) {
		return !this.lstDeAutosDelModelo(unModelo).isEmpty();
	}
	
	/**
	 * Prop�sito: Evalua si la planta puede fabricar el modelo
	 * @param ModeloDeAuto
	 * @return boolean
	 */
	public boolean tieneModelo(ModeloDeAuto unModelo){
		return this.deposito.containsKey(unModelo);		
	}

	/**
	 * Prop�sito: Fabrica una unidad del modelo especificado
	 * @param ModeloDeAuto
	 */
	public void fabricarElModelo(ModeloDeAuto unModelo) {
		Auto nuevoAuto = new Auto(unModelo);
		this.autoFabricado(nuevoAuto);
		
	}

}
