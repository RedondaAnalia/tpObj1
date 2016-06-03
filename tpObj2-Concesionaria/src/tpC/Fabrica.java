package tpC;

import java.util.LinkedList;

public class Fabrica {

	private LinkedList<Planta> plantas = new LinkedList<Planta>() ;
	
	public void agregarPlanta(Planta planta) {
		this.plantas.add(planta);
	}
	
	public LinkedList<Auto> buscarStockEnFabricaDe(Planta aPlanta, ModeloDeAuto aModelo) {
			return aPlanta.stockDelModelo(aModelo);
	}
	
	public double distanciaConcesionariaPlanta(Concesionaria aConcesionaria, Planta aPlanta){
		return aConcesionaria.getUbicacion().distance(aPlanta.getUbicacion());
	}
	public void fabricar(Concesionaria los3fanaticos, ModeloDeAuto unModelo){
		Planta plantaSeleccionada = this.plantaMasCercana(los3fanaticos, unModelo);
		plantaSeleccionada.fabricarElModelo(unModelo);
		
	}
	
	private Planta plantaMasCercana(Concesionaria los3fanaticos, ModeloDeAuto unModelo) {
		//PRECOND = No funciona para plantas interplanetarias
		Planta plantaMasCercana= null;
		double mejorDistancia= 10000;
		for(int i=0; i < this.plantas.size(); i++){
			double distanciaDePlanta = distanciaConcesionariaPlanta(los3fanaticos, this.plantas.get(i));
			
			if (distanciaDePlanta < mejorDistancia && this.plantas.get(i).tieneModelo(unModelo) ){
				mejorDistancia = distanciaDePlanta;
				plantaMasCercana = this.plantas.get(i);
			}
		}
		return plantaMasCercana;
	}
}
