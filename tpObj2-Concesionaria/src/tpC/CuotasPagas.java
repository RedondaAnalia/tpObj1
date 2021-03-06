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
 * Propůsito: Registrar las cuotas pagas
 * @return CuotasPagas 	
 */
	public CuotasPagas(Integer cantidadDeCuotasDelPlan){
		cuotas = new ArrayList<ComprobanteDePago>();
		cantidadCuotasPagas = 0;
		cantidadDeCuotasAPagar = cantidadDeCuotasDelPlan;
	}
	
	
/**
 * Propůsito: Retorna las cuotas pagas	
 * @return ArrayList<Cuota>
 */
	public ArrayList<ComprobanteDePago> getComprobantesDePago(){
		return cuotas;
	}
	
	
/**
 * Propůsito: Retorna la cantidad de cuotas pagas	
 * @return Integer
 */
	public Integer getCantCuotasPagas(){
		return cantidadCuotasPagas;
	}
	

/**
 * Propůsito: Retorna la cantidad de cuotas del plan	
 * @return Integer
 */
	public Integer getCantCuotasAPagar(){
		return cantidadDeCuotasAPagar;
	}
	
	
/**
 * Propůsito: Retorna el porcentaje pago del plan	
 * @return double
 */
	public double porcentajePago(){
		Double cuotaspagas= new Double(this.getCantCuotasPagas());
		Double cuotasimpagas= new Double(this.getCantCuotasAPagar());
		return 100.0*(cuotaspagas/cuotasimpagas);
	}

	
/**
 * Propůsito: Registra el pago de una cuota	
 * @param ComprobanteDePago
 */
	public void pagar(ComprobanteDePago unaCuotaPaga) {
		cuotas.add(unaCuotaPaga);
		cantidadCuotasPagas++;
		}
	
} 
	

