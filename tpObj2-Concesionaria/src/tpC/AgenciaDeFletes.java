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
	
	/**
	 * Prop�sito: entrega el valor del flete para una distancia.
	 * @param: double	 
	 * @return: double
	 */
	public double consultarValorDelFlete(double distancia){
		return distancia * precioPorKilometro;
	}

	/**
	 * @param precioPorKilometro the precioPorKilometro to set
	 */
	public void setPrecioPorKilometro(double precioPorKilometro) {
		this.precioPorKilometro = precioPorKilometro;
	}
	/**
	 * Prop�sito: simula la accion de buscar un flete en una planta y entregarla
	 * 			  en una concesionaria un Auto de un modelo.
	 * @param: Planta
	 * @param: Concesionaria
	 * @param: ModeloDeAuto
	 */
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
	/**
	 * Prop�sito: entregar coordenadas de la agencia.
	 * @return: Coord
	 */
	public Coord getUbicacion() {
		return ubicacionFlete;
	}
	/**
	 * Prop�sito: notificar regreso del flete.
	 */
	public synchronized void volvioVehiculo() {
		cantidadDeCamiones++;
		fletesPendientes--;
		notify();
		
	}
	
	
	
	
	
}
