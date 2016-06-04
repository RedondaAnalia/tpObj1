package tpC;


import java.util.ArrayList;

public class CuotasPagas {
	private Integer[] cuotas;
	private Integer cantidadCuotasPagas;
	//INV REP el valor de cantidadCuotasPagas es igual a la cantidad de cuotas 
	//cuyo valor es distinto de 0. 
	
	public CuotasPagas(Integer nroDeCuotas){
		cuotas = new Integer[nroDeCuotas];
		cantidadCuotasPagas = 0;
		//Inicializacion del Array con 0 para verificacion de cuotas pagas
		for (int i=nroDeCuotas; i!=0; i--){
				cuotas[i-1]=0;
		}
	}
	
	public Integer[] getCuotas(){
		return cuotas;
	}
	
	public Integer getCantCuotasPagas(){
		return cantidadCuotasPagas;
	}
	
	public double porcentajePago(){
		Double c= new Double(this.cantidadCuotasPagas);
		Double d= new Double(cuotas.length);
		return 100.0*(c/d);
	}

	public void pagar(Integer nroCuota, Integer importe) {
		if (cuotas[nroCuota]==0){
			cuotas[nroCuota-1] = importe;
			cantidadCuotasPagas= cantidadCuotasPagas +1;
		}
	} 
	
}
