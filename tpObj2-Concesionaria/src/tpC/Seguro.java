package tpC;

public class Seguro {
	private double valorSeguro;
	private String nombreCompania;
	
	public Seguro(double valor, String name){
		valorSeguro = valor;
		nombreCompania = name;
	}

	public double gastos() {
		return valorSeguro;
	}
	
	public String getNombreCompania(){
		return nombreCompania;
	}

	
}
