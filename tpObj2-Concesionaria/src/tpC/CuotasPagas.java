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
 * Propósito: Registrar las cuotas pagas
 * @return CuotasPagas 	
 */
	public CuotasPagas(Integer cantidadDeCuotasDelPlan){
		cuotas = new ArrayList<ComprobanteDePago>();
		cantidadCuotasPagas = 0;
		cantidadDeCuotasAPagar = cantidadDeCuotasDelPlan;
	}
	
	
/**
 * Propósito: Retorna las cuotas pagas	
 * @return ArrayList<Cuota>
 */
	public ArrayList<ComprobanteDePago> getComprobantesDePago(){
		return cuotas;
	}
	
	
/**
 * Propósito: Retorna la cantidad de cuotas pagas	
 * @return Integer
 */
	public Integer getCantCuotasPagas(){
		return cantidadCuotasPagas;
	}
	

/**
 * Propósito: Retorna la cantidad de cuotas del plan	
 * @return Integer
 */
	public Integer getCantCuotasAPagar(){
		return cantidadDeCuotasAPagar;
	}
	
	
/**
 * Propósito: Retorna el porcentaje pago del plan	
 * @return double
 */
	public double porcentajePago(){
		Double cuotaspagas= new Double(this.getCantCuotasPagas());
		Double cuotasimpagas= new Double(this.getCantCuotasAPagar());
		return 100.0*(cuotaspagas/cuotasimpagas);
	}

	
/**
 * Propósito: Registra el pago de una cuota	
 * @param ComprobanteDePago
 */
	public void pagar(ComprobanteDePago unaCuotaPaga) {
		cuotas.add(unaCuotaPaga);
		cantidadCuotasPagas++;
		}
	
} 
	

