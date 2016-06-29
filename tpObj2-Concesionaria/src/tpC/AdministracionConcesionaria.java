/**
 * @author Demian- Anita
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
	public AdministracionConcesionaria(double gastosAdministrativos, Seguro unaAseguradora){
		gastos = gastosAdministrativos;
		aseguradora = unaAseguradora;
	}
	
/**
 * Prop�sito: Calcula el valor a pagar de la cuota  	
 * @param double
 * @return double
 */
	public double calcularCuota(Participante unParticipante){
		return ((unParticipante.getPlan().valorActualAlicuota()) + gastos + aseguradora.cuotaSeguro());
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
	public void setGastosAdmin(double cargosAdministrativos){
		gastos=cargosAdministrativos;
	} 
	
/**
 * Prop�sito: Generar la cuota determinada del plan determinado
 * @param PlanDeAhorro
 * @param Integer
 * @return Cuota
 */
	public Cuota imprimirCuota(Participante participante)throws TerminoDePagarCuotasException{
		if(participante.getCuotasPagas()== participante.getPlan().cantDeCuotas()){
			throw new TerminoDePagarCuotasException("Termino de pagar las cuotas de la financiaci�n");
		}
		double alic = participante.getPlan().valorActualAlicuota();
		
		return new Cuota(participante.getCuotasPagas()+1 , alic, aseguradora.cuotaSeguro() ,gastos, participante );
	}
	
/**
 * Prop�sito: cambiar valor del seguro
 * @param Seguro
 */
	public void recategorizarSeguro(Seguro nuevoSeguro){
		aseguradora = nuevoSeguro;
	}

	
/**
 * Prop�sito: Emite un comprobante de pago.
 * @param Cuota
 * @return Comprobante De Pago
 */
	public ComprobanteDePago recibirPago(Cuota unaCuota){
		return new ComprobanteDePago(unaCuota);
	}
}
