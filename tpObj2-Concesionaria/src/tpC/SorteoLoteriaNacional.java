/**
 * @author Anita	
 */

package tpC;

import java.util.Random;

public class SorteoLoteriaNacional {

/**
 * Propósito: Retorna un número Random, siempre dentro del rango de la cantidad 
 * 			  de participantes listos para adjudicar.
 * @param Integer
 * @return Integer
 */
	public Integer primerPremio(Integer entero) {
		Random rnd=new Random();
		return (int) (rnd.nextDouble() * entero);

	}

}