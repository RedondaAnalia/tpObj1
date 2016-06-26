/**
 * @author Demian
 */

package tpC;

import java.util.ArrayList;

public class CuotasPagas {
	private ArrayList<ComprobanteDePago> cuotas;
	private Integer cantidadCuotasPagas;
	private Integer cantidadDeCuotasAPagar;
	
/**
 * Prop�sito: Registrar las cuotas pagas 	
 */
	public CuotasPagas(Integer cantDeCtsAPagar){
		cuotas = new ArrayList<ComprobanteDePago>();
		cantidadCuotasPagas = 0;
		cantidadDeCuotasAPagar = cantDeCtsAPagar;
	}
	
/**
 * Prop�sito: Retorna las cuotas pagas	
 * @return ArrayList<Cuota>
 */
	public ArrayList<ComprobanteDePago> getComprobantesDePago(){
		return cuotas;
	}
	
/**
 * Prop�sito: Retorna la cantidad de cuotas pagas	
 * @return Integer
 */
	public Integer getCantCuotasPagas(){
		return cantidadCuotasPagas;
	}
	
	/**
	 * Prop�sito: Retorna la cantidad de cuotas del plan	
	 * @return Integer
	 */
		public Integer getCantCuotasAPagar(){
			return cantidadDeCuotasAPagar;
		}
	
/**
 * Prop�sito: Retorna el porcentaje pago del plan	
 * @return double
 */
	public double porcentajePago(){
		Double c= new Double(this.getCantCuotasPagas());
		Double d= new Double(this.getCantCuotasAPagar());
		return 100.0*(c/d);
	}

/**
 * Prop�sito: Regitra el pago de una cuota	
 * @param ComprobanteDePago
 */
	public void pagar(ComprobanteDePago unaCuotaPaga) {
		cuotas.add(unaCuotaPaga);
		cantidadCuotasPagas++;
		}
	
} 
	

