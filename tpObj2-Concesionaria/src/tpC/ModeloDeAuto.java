/**
 * @author Pablo
 */
package tpC;

import java.util.ArrayList;

public class ModeloDeAuto {
	private String denominacion;
	private Integer a�oLanzamientoAlMercado;
	private Integer cantidadDePuertas;
	private ArrayList<Accesorios> listaDeAccesiorios; 
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
		listaDeAccesiorios= new ArrayList<Accesorios>();
		listaDeAccesiorios.add(new AccesoriosBase());
		valor=precio;
	}
	
/**
 * Prop�sito: Retorna el valor actual del auto.
 * @return Integer
 */
	public Integer getValor(){

		Integer valorAccesiorios = 0;
		for (Accesorios accesorios : listaDeAccesiorios)
			valorAccesiorios = valorAccesiorios + accesorios.precioAccesorio();
		return (this.valor + valorAccesiorios);
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
 * Prop�sito: Agrega un accesorio al modelo de auto.
 */

	public void agregarAccesorio(Accesorios unAccesorio){
		listaDeAccesiorios.add(unAccesorio);
	}
	
/**
* Prop�sito: devuelve la lista de accesorios de un modelo.
* @param ArrayList<Accesorios>
 * @return 
*/

		public ArrayList<Accesorios> getListaDeAccesorios(){
			return listaDeAccesiorios;
		}

}
