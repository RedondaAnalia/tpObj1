package tpC;

import java.util.ArrayList;

public class CuotasPagas {
	private Integer[] cuotas;
	private Integer cantidadTotalDeCuotas;
	//INV REP el length() de cuotas == cantidadTotalDeCuotas
	
	public CuotasPagas(Integer nroDeCuotas){
		cuotas = new Integer[nroDeCuotas];
		cantidadTotalDeCuotas = nroDeCuotas;
	}
	
	public Integer[] getCuotas(){
		return cuotas;
	}
	
	public float porcentajePago(){
		return this.cuotas.length/cantidadTotalDeCuotas;
	}

	public void pagar(Integer nroCuota, Integer importe) {
		cuotas[nroCuota] = importe;
	} 
	
}
