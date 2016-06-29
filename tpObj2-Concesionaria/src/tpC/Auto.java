package tpC;


import org.joda.time.*;;

public class Auto {
	private ModeloDeAuto modelo;
	private Integer categoria;
	
/**
 * Prop�sito: Crea una instancia de Auto, a partir de un ModeloDeAuto
 * @param modelo
 * @return Auto
 */
	public Auto(ModeloDeAuto unModelo){
		modelo= unModelo;
		categoria=((new LocalDate()).getYear());
	}
	

/**
 * Prop�sito: Devuelve el a�o de fabricaci�n del auto.
 * @return Integer (A�o de fabricaci�n)
 */
	public Integer getCategoria() {
		return categoria;
	}
	
/**
 * Prop�sito: Devuelve el Modelo Del Auto.
 * @return ModeloDeAuto
 */
	public ModeloDeAuto getModelo() {
		return modelo;
	}

}

