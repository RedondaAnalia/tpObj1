package tpC;

import java.util.ArrayList;

public class CuotasPagas {
	private Integer[] cuotas;
	Integer cantidadCuotasPagas;
	//INV REP el valor de cantidadCuotasPagas es igual a la cantidad de cuotas 
	//cuyo valor es distinto de 0. 
	
	public CuotasPagas(Integer nroDeCuotas){
		cuotas = new Integer[nroDeCuotas];
		cantidadCuotasPagas =0;
		//Inicializacion del Array con 0 para verificacion de cuotas pagas
		for (int i=nroDeCuotas; i!=0; i--){
				cuotas[i-1]=0;
		}
	}
	
	public Integer[] getCuotas(){
		return cuotas;
	}
	
	public float porcentajePago(){
		return 100*(this.cantidadCuotasPagas/cuotas.length);
	}

	public void pagar(Integer nroCuota, Integer importe) {
		if (cuotas[nroCuota]!=0){
			cuotas[nroCuota-1] = importe;
			cantidadCuotasPagas++;
		}
	} 
	
}
