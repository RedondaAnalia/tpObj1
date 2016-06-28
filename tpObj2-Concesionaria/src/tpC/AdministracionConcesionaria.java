/**
 * @author Demian
 */

package tpC;

public class AdministracionConcesionaria {

	private double gastos;
	private Seguro aseguradora;

/**
 * Prop�sito: Calcular los costos de las cuotas y generarlas
 * @param double (gastos de administracion)
 * @param double (gastos de aseguradora)
 */
	public AdministracionConcesionaria(double gastosAdmin, Seguro unaAseguradora){
		gastos = gastosAdmin;
		aseguradora = unaAseguradora;
	}
	
/**
 * Prop�sito: Calcula el valor a pasgar de la cuota  	
 * @param double
 * @return double
 */
	public double calcularCuota(double alicuota){
		return (alicuota + gastos + aseguradora.cuotaSeguro());
	}
	
/**
 * Prop�sito: Retorna el valor total de los gastos adminstrativos
 * @return double
 */
	public double getGastos() {
		return gastos;
	}
	
/**
 * Prop�sito: Modificar el valor de los gastos administrativos	
 * @param double
 */
	public void setGastosAdmin(double cargo){
		gastos=cargo;
	}
	
/**
 * Prop�sito: Generar la cuota determinada del plan determinado
 * @param PlanDeAhorro
 * @param Integer
 * @return Cuota
 */
	public Cuota imprimirCuota(PlanDeAhorro unPlan, Integer nroCuota){
		double alic = unPlan.getModelo().getValor();
		
		return new Cuota(nroCuota, alic, this.aseguradora.cuotaSeguro() ,this.gastos );
	}
	
	public void recategorizarSeguro(Seguro nuevoSeguro){
		aseguradora = nuevoSeguro;
	}
}
