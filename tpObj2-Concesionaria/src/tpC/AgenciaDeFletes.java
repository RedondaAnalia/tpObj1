package tpC;

public class AgenciaDeFletes {
	
	
	private double precioPorKilometro;
	private Coord ubicacionFlete;
	private Integer cantidadDeCamiones;
	private Integer fletesPendientes;



	public AgenciaDeFletes(Integer numeroDeCamiones, Coord ubicacion){
		ubicacionFlete = ubicacion;
		fletesPendientes = 0;
		cantidadDeCamiones = numeroDeCamiones;
	}
	
	public Integer getCantidadDeCamiones() {
		return cantidadDeCamiones;
	}
	
	public double consultarValorDelFlete(double distancia){
		return distancia * precioPorKilometro;
	}

	/**
	 * @param precioPorKilometro the precioPorKilometro to set
	 */
	public void setPrecioPorKilometro(double precioPorKilometro) {
		this.precioPorKilometro = precioPorKilometro;
	}

	public synchronized void retirarAutoDeLaPlantaenConcesionario(Planta unaPlanta, Concesionaria destino,ModeloDeAuto modelo){
		fletesPendientes++;
		while(cantidadDeCamiones == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cantidadDeCamiones--;
		Flete flete = new Flete(this);
		flete.cargarDestinos(unaPlanta, destino, modelo);
		flete.start();
		while(fletesPendientes != 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Coord getUbicacion() {
		return ubicacionFlete;
	}

	public synchronized void volvioVehiculo() {
		cantidadDeCamiones++;
		fletesPendientes--;
		notifyAll();
		
	}
	
	
	
	
	
}
