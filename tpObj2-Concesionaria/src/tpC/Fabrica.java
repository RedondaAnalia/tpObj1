/**
 * @author Pablo
 */
package tpC;

import java.util.LinkedList;
import java.util.List;

public class Fabrica {

	//Colaboradores internos//
	private List<Planta> plantas;
	private List<ModeloDeAuto> modelos ;
	private Stock stock;
	
	
/**
 * Prop�sito: Crea una instancia de Fabrica, a partir de un Stock dado
 * @param Stock
 * @return Fabrica
 */
	public Fabrica(Stock stockInicial){
		plantas = new LinkedList<Planta>();
		modelos = new LinkedList<ModeloDeAuto>();
		stock = stockInicial;
	}

/**
 * Prop�sito: Agrega una planta a la f�brica.
 * @param planta
 */
	
	public void agregarPlanta(Planta planta) {
		plantas.add(planta);
		}

/**
 * Prop�sito: Agrega un modelo de Auto a la f�brica.	
 * @param nuevoModelo
 */
	public void agregarModelo(ModeloDeAuto nuevoModelo) {
		modelos.add(nuevoModelo);
	}	

/**
 * Prop�sito: Devuelve el stock completo de la f�brica. 
 * @return Stock
 */	
	public Stock getStock(){
		return stock;
	}

	
/**
 * Prop�sito:Devuelve el stock de un modelo especifico, en una planta especifica
 * @param Planta
 * @param ModeloDeAuto
 * @return LinkedList<Auto>
 */
	
	public LinkedList<Auto> buscarStockEnFabricaDeLaPlanta(Planta unaPlanta, ModeloDeAuto unModeloDeAuto) {
			return unaPlanta.lstDeAutosDelModelo(unModeloDeAuto);
	}

	public double distanciaConcesionariaPlantaMasCercanaConElModelo(Concesionaria concesionario, ModeloDeAuto unModelo){
		Planta planta = plantaMasCercana(concesionario,unModelo);
		return distanciaConcesionariaPlanta(concesionario, planta);
	}
/**
 * Prop�sito: Determina la distancia entre una concesionaria y una planta.
 * @param Concesionaria
 * @param Planta
 * @return double
 */
	 
	public double distanciaConcesionariaPlanta(Concesionaria unaConcesionaria, Planta unaPlanta){
		double distancia = unaConcesionaria.getUbicacion().distance(unaPlanta.getUbicacion());
		return distancia;
	}
	
/**
 * Prop�sito: Fabrica un auto del modelo indicado, en la planta mas cercana que produzca ese modelo.
 * @param los3fanaticos
 * @param unModelo
 */
	
	public void fabricar(Concesionaria los3fanaticos, ModeloDeAuto unModelo){
		Planta plantaSeleccionada = this.plantaMasCercana(los3fanaticos, unModelo);
		plantaSeleccionada.fabricarElModelo(unModelo);
	}
	
/**
 * Porp�sito: Modifica el valor actual del modelo de un automovil.
 * @param unModelo
 * @param nuevoValor
 */
	public void cambiarPrecioModelo(ModeloDeAuto unModelo,Integer nuevoValor){
		unModelo.setValor(nuevoValor);
	}
	
/**
 * Prop�sito: Determina la planta mas cercana que produce un modelo de automovil.
 * @param los3fanaticos
 * @param unModelo
 * @return Planta
 */
	public Planta plantaMasCercana(Concesionaria los3fanaticos, ModeloDeAuto unModelo) {
		//PRECOND = No funciona para plantas interplanetarias
		Planta plantaMasCercana= null;
		double mejorDistancia= 20038.00;
		for(int i=0; i < plantas.size(); i++){
			double distanciaDePlanta = distanciaConcesionariaPlanta(los3fanaticos, plantas.get(i));
			if (distanciaDePlanta < mejorDistancia && plantas.get(i).tieneModelo(unModelo) ){
				mejorDistancia = distanciaDePlanta;
				plantaMasCercana = plantas.get(i);
			}
		}
		return plantaMasCercana; 
	}
}
  