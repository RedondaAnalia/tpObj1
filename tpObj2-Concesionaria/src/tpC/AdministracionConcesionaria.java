package tpC;

public class AdministracionConcesionaria {

	private double gastos;
	
	public AdministracionConcesionaria(double gastosAdmin){
		gastos = gastosAdmin;
	}

	public double gastos() {
		return gastos;
	}
	
	public void setGastosAdmin(double cargo){
		gastos=cargo;
	}

}
