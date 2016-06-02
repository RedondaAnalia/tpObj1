package tpC;

import java.util.LinkedList;

public class Fabrica {

	private LinkedList<Planta> plantas = new LinkedList<Planta>() ;
	private Stock stock;
	
	public Fabrica(Stock stock){
		this.stock = stock;
	}
	
	public void agregarPlanta(Planta planta) {
		this.plantas.add(planta);
	}
	
	public LinkedList<Auto> buscarStockEnFabricaDe(Planta aPlanta, ModeloDeAuto aModelo) {
			return aPlanta.stockDelModelo(aModelo);
	}
	public Integer distanciaConcesionariaPlanta(Concesionaria aConcesionaria, Planta aPlanta){
		return 100;
	}
	public void fabricar(ModeloDeAuto unModelo){
		fabrica un modelo en la fabrica mas cercana!!! :D
	}
	
	public Planta plantaMasCercanaConStockModelo(Concesionaria los3fanaticos, ModeloDeAuto unModelo) {
		int distanciaPlantaMasCercana=100000;
		for(int i = 0; i < plantas.size(); i++){
			distanciaPlantaMasCercana<plantas.get(i).getUbicacion().distance(los3fanaticos.getUbicacion
			if( plantas.get(i).tieneStockModelo(unModelo)&& )){
				
			}
				
				
				
		}
		return null;
	}
}
