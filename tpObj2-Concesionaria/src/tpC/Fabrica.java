package tpC;

import java.util.LinkedList;
import java.util.List;

public class Fabrica {

	//Colaboradores internos//
	private List<Planta> plantas;
	private List<ModeloDeAuto> modelos ;
	private Stock stock;
	
	
	//Metodos//
	public Fabrica(Stock st){
		plantas = new LinkedList<Planta>();
		modelos = new LinkedList<ModeloDeAuto>();
		stock = st;
	}
	
	public void agregarPlanta(Planta planta) {
		plantas.add(planta);
		}
	public void agregarModelo(ModeloDeAuto nuevoModelo) {
		modelos.add(nuevoModelo);
	}	
	
	public Stock getStock(){
		return stock;
	}
	
	
	public LinkedList<Auto> buscarStockEnFabricaDeLaPlanta(Planta aPlanta, ModeloDeAuto aModelo) {
			return aPlanta.stockDelModelo(aModelo);
	}
	 
	public double distanciaConcesionariaPlanta(Concesionaria aConcesionaria, Planta aPlanta){
		double distancia = aConcesionaria.getUbicacion().distance(aPlanta.getUbicacion());
		return distancia;
	}
	
	public void fabricar(Concesionaria los3fanaticos, ModeloDeAuto unModelo){
		Planta plantaSeleccionada = this.plantaMasCercana(los3fanaticos, unModelo);
		plantaSeleccionada.fabricarElModelo(unModelo);
	}
	
	public void cambiarPrecioModelo(ModeloDeAuto unModelo,Integer nuevoValor){
		unModelo.setValor(nuevoValor);
	}
	
	public Planta plantaMasCercana(Concesionaria los3fanaticos, ModeloDeAuto unModelo) {
		//PRECOND = No funciona para plantas interplanetarias
		Planta plantaMasCercana= null;
		double mejorDistancia= 10000.00;
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
  