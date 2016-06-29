package tpC;


public class ModeloDeAuto {
	private String denominacion;
	private Integer añoLanzamientoAlMercado;
	private Integer cantidadDePuertas;
	private Boolean full; 
	private Integer valor;
	
/**
 * Propósito: Crea una instancia modelo de auto. Por default, lo crea Base (SIN equipamiento full)
 * @param String
 * @param Integer (Año de Lanzamiento al mercado)
 * @param Integer (Cantidad de puertas)
 * @param Integer (Valor actual del auto)
 */
	
	public ModeloDeAuto(String nombre, Integer anhoLanzamiento, Integer cantPuertas, Integer precio){
		denominacion=nombre;
		añoLanzamientoAlMercado=anhoLanzamiento;
		cantidadDePuertas=cantPuertas;
		full= false;
		valor=precio;
	}
	
/**
 * Propósito: Retorna el valor actual del auto.
 * @return Integer
 */
	public Integer getValor(){
		return this.valor;
	}
	

/**
 * Propósito: Retorna el nombre del Modelo.
 * @return String
 */
	
	public String getNombre() {
		return denominacion;
	}
	
	
/**
 * Propósito: Setear el valor actual del auto.
 * @param Integer
 */
	public void setValor(Integer valorActual) {
		valor = valorActual;
	}
	
	
/**
 * Propósito: Retorna false si es Base.
 * @return Boolean
 */
	public Boolean getEquipamiento(){
		return full;
	}

	
/**
 * Propósito: Cambia el equipamiento del auto a full.
 */

	public void cambiarDeBaseAFull(){
		full = true;
	}

		
/**
 * Propósito: Cambia el equipamiento del auto a base.
 */

	public void cambiarDeFullABase(){
		full = false;
	}

}
