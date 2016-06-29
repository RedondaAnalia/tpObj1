package tpC;


import org.joda.time.*;;

public class Auto {
	private ModeloDeAuto modelo;
	private Integer categoria;
	
/**
 * Propósito: Crea una instancia de Auto, a partir de un ModeloDeAuto
 * @param modelo
 * @return Auto
 */
	public Auto(ModeloDeAuto unModelo){
		modelo= unModelo;
		categoria=((new LocalDate()).getYear());
	}
	

/**
 * Propósito: Devuelve el año de fabricación del auto.
 * @return Integer (Año de fabricación)
 */
	public Integer getCategoria() {
		return categoria;
	}
	
/**
 * Propósito: Devuelve el Modelo Del Auto.
 * @return ModeloDeAuto
 */
	public ModeloDeAuto getModelo() {
		return modelo;
	}

}

