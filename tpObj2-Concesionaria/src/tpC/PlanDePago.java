package tpC;


public interface PlanDePago {

	public Integer cantDeCuotas();
	public double valorDeCuota(ModeloDeAuto auto);
	public double cuotaFinal(ModeloDeAuto auto);
	
	public double gastosAdministrativos(AdministracionConcesionaria admin);	
	
	public double gastosSeguros(Seguro seg);

}

