package tpC;


public class ModeloDeAuto {
	private String denominacion;
	private Integer a�oLanzamientoAlMercado;
	private Integer cantidadDePuertas;
	private Boolean full; 
	private Integer valor;
	
/**
 * Prop�sito: Crea una instancia modelo de auto. Por default, lo crea Base (SIN equipamiento full)
 * @param String
 * @param Integer (A�o de Lanzamiento al mercado)
 * @param Integer (Cantidad de puertas)
 * @param Integer (Valor actual del auto)
 */
	
	public ModeloDeAuto(String nombre, Integer anhoLanzamiento, Integer cantPuertas, Integer precio){
		denominacion=nombre;
		a�oLanzamientoAlMercado=anhoLanzamiento;
		cantidadDePuertas=cantPuertas;
		full= false;
		valor=precio;
	}
	
/**
 * Prop�sito: Retorna el valor actual del auto.
 * @return Integer
 */
	public Integer getValor(){
		return this.valor;
	}
	

/**
 * Prop�sito: Retorna el nombre del Modelo.
 * @return String
 */
	
	public String getNombre() {
		return denominacion;
	}
	
	
/**
 * Prop�sito: Setear el valor actual del auto.
 * @param Integer
 */
	public void setValor(Integer valorActual) {
		valor = valorActual;
	}
	
	
/**
 * Prop�sito: Retorna false si es Base.
 * @return Boolean
 */
	public Boolean getEquipamiento(){
		return full;
	}

	
/**
 * Prop�sito: Cambia el equipamiento del auto a full.
 */

	public void cambiarDeBaseAFull(){
		full = true;
	}

		
/**
 * Prop�sito: Cambia el equipamiento del auto a base.
 */

	public void cambiarDeFullABase(){
		full = false;
	}

}
