package tpC;

import java.util.ArrayList;

public class CuotasPagas {
	private ArrayList<Integer> cuotas;
	private Integer nroTotalDeCuotas;
	
	public CuotasPagas(){
		/******************************************************
		 * PRECONDICION                                       *
		 * nroTotalDeCuotas debe ser inicializado             *
		 * de otro modo no se podrá calcular porcentajePago() *
		 ******************************************************/
		cuotas = new ArrayList<Integer>();
		nroTotalDeCuotas = 0;
	}
	
	public ArrayList<Integer> getCuotas(){
		return cuotas;
	}
	
	public float porcentajePago(){
		return this.cuotas.size()/nroTotalDeCuotas;
	}

	public void pagar(Integer nroCuota, Integer importe) {
		//NO SE COMO MANEJAR EL TEMA DEL ARRAYLIST Y DE 
		//GUARDAR EL NRODECUOTA Y EL VALOR DE LA MISMA EN SU POSICION
	} 
	
}
