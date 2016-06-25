package tpC;

public class CuotasPagas {
	private Cuota[] cuotas;
	private Integer cantidadCuotasPagas;
	
	
	public CuotasPagas(Integer nroDeCuotas){
		cuotas = new Cuota[nroDeCuotas];
		cantidadCuotasPagas = 0;
	}
	
	
	public Cuota[] getComprobantesDePago(){
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

	public void pagar(Integer nroCuota, Integer valor) {
		
		cuotas[nroCuota] = new Cuota(nroCuota, valor);
		cantidadCuotasPagas++;
		}
	
} 
	

