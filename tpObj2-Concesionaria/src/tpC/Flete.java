package tpC;

public class Flete extends Thread {
	private Auto carga = null;
	private ModeloDeAuto modeloARetirar;
	private AgenciaDeFletes agencia;
	private Planta destinoCargaPlanta;
	private Concesionaria destinoDescargaConcesionaria;
	private Integer velocidadPromedio;
		
	public Flete(AgenciaDeFletes unaAgencia) {
		agencia = unaAgencia;
		velocidadPromedio = 60;
	}

	public void cargarDestinos(Planta cargaEn, Concesionaria descargarEn, ModeloDeAuto modelo){
		destinoCargaPlanta = cargaEn;
		destinoDescargaConcesionaria = descargarEn;
		modeloARetirar = modelo;
	}
	
	public void run(){
		double distanciaARecorrer = agencia.getUbicacion().distance(destinoCargaPlanta.getUbicacion());
		System.out.println(distanciaARecorrer);
//		viajar(distanciaARecorrer);
		try {
			carga = destinoCargaPlanta.retirarAutoModelo(modeloARetirar);
		} catch (NoHayStockException | NoExisteElModeloDelAutoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		distanciaARecorrer = destinoCargaPlanta.getUbicacion().distance(destinoDescargaConcesionaria.getUbicacion());
		viajar(distanciaARecorrer);
		System.out.println(carga);
		destinoDescargaConcesionaria.entregarAuto(carga);
		carga =null;
		distanciaARecorrer = destinoDescargaConcesionaria.getUbicacion().distance(agencia.getUbicacion());
		System.out.println("llegoElCamion");
		agencia.volvioVehiculo();
		
	}

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

