/**
 * @author Demian
 */

package tpC;

public class AdministracionConcesionaria {

	private double gastos;
	private Seguro aseguradora;

/**
 * Propósito: Calcular los costos de las cuotas y generarlas
 * @param double (gastos de administracion)
 * @param double (gastos de aseguradora)
 */
	public AdministracionConcesionaria(double gastosAdmin, Seguro unaAseguradora){
		gastos = gastosAdmin;
		aseguradora = unaAseguradora;
	}
	
/**
 * Propósito: Calcula el valor a pasgar de la cuota  	
 * @param double
 * @return double
 */
	public double calcularCuota(double alicuota){
		return alicuota + this.gastos + this.aseguradora.cuotaSeguro();
	}
	
/**
 * Propósito: Retorna el valor total de los gastos adminstrativos
 * @return double
 */
	public double gastos() {
		return gastos;
	}
	
/**
 * Propósito: Modificar el valor de los gastos administrativos	
 * @param double
 */
	public void setGastosAdmin(double cargo){
		gastos=cargo;
	}
	
/**
 * Propósito: Generar la cuota determinada del plan determinado
 * @param PlanDeAhorro
 * @param Integer
 * @return Cuota
 */
	public Cuota imprimirCuota(PlanDeAhorro unPlan, Integer nroCuota){
		double alic = unPlan.getModelo().getValor();
		
		return new Cuota(nroCuota, alic, this.aseguradora.cuotaSeguro() ,this.gastos );
	}
}
