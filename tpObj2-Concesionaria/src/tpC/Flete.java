package tpC;

public class Flete extends Thread {
	private Auto carga = null;
	private ModeloDeAuto modeloARetirar;
	private AgenciaDeFletes agencia;
	private Planta destinoCargaPlanta;
	private Concesionaria destinoDescargaConcesionaria;
	private Integer velocidadPromedio;

	// CONSTRUCTORES.
		/**
		 * @param AgenciaDeFletes (para saber lugar de partida)
		 */	
	
	public Flete(AgenciaDeFletes unaAgencia) {
		agencia = unaAgencia;
		velocidadPromedio = 60;
	}

/**
* Propósito: con este metodo el flete recibe las indicaciones de donde cargar y descargar el auto.
* @param Planta
* @param Concesionaria
* @param ModeloDeAuto
*/
	
	public void cargarDestinos(Planta cargaEn, Concesionaria descargarEn, ModeloDeAuto modelo){
		destinoCargaPlanta = cargaEn;
		destinoDescargaConcesionaria = descargarEn;
		modeloARetirar = modelo;
	}
/**
* Propósito: Crea concurrencia para que mientras esperamos que el auto llegue a destino podamos seguir operando.
*/
	public void run(){
		double distanciaARecorrer = agencia.getUbicacion().distance(destinoCargaPlanta.getUbicacion());
//		viajar(distanciaARecorrer);
		try {
			carga = destinoCargaPlanta.retirarAutoModelo(modeloARetirar);
		} catch (NoHayStockException | NoExisteElModeloDelAutoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		distanciaARecorrer = destinoCargaPlanta.getUbicacion().distance(destinoDescargaConcesionaria.getUbicacion());
		viajar(distanciaARecorrer);
		destinoDescargaConcesionaria.entregarAuto(carga);
		carga =null;
		distanciaARecorrer = destinoDescargaConcesionaria.getUbicacion().distance(agencia.getUbicacion());
		viajar(distanciaARecorrer);
		agencia.volvioVehiculo();
		
	}
	/**
	 * Propósito: Simula el tiempo de viaje de una distanciaARecorrer.
	 * @param: double
	 */
	private void viajar(double distanciaARecorrer) {
		try {
			Thread.sleep((int)distanciaARecorrer/velocidadPromedio*1000);
		} catch (InterruptedException e) {
			//choco el camion... 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}

