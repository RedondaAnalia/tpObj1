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
	public Cuota imprimirCuota(Participante part)throws TerminoDePagarCuotasException{
		if(part.getCuotasPagas()== part.getPlan().cantDeCuotas()){
			throw new TerminoDePagarCuotasException("Termino de pagar las cuotas de la financiaci�n");
		}
		double alic = part.getPlan().valorActualAlicuota();
		
		return new Cuota(part.getCuotasPagas()+1 , alic, aseguradora.cuotaSeguro() ,gastos, part );
	}
	
	/**
	 * Prop�sito: cambiar valor del seguro
	 * @param Seguro
	 */
	public void recategorizarSeguro(Seguro nuevoSeguro){
		aseguradora = nuevoSeguro;
	}
}
