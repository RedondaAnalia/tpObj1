/**
 * @author Demian- Anita
 */

package tpC;

import java.util.ArrayList;

import org.junit.Test;

public class AdministracionConcesionaria {

	private double gastos;
	private Seguro aseguradora;
	private AgenciaDeFletes flete;
	private ArrayList<CuponDeAdjudicacion> talonarioDeCuponesDeAdjudicacion;

/**
 * Propósito: Calcular los costos de las cuotas y generarlas
 * @param double (gastos de administracion)
 * @param double (gastos de aseguradora)
 */
	public AdministracionConcesionaria(double gastosAdministrativos, Seguro unaAseguradora){
		gastos = gastosAdministrativos;
		aseguradora = unaAseguradora;
		talonarioDeCuponesDeAdjudicacion = new ArrayList<CuponDeAdjudicacion>();
	}
/**
* Propósito: Cambia la agencia de Fletes
* @param AgenciaDeFletes
*/
	public void setFlete(AgenciaDeFletes flete) {
		this.flete = flete;
	}
	
/**
 * Propósito: Calcula el valor a pagar de la cuota  	
 * @param double
 * @return double
 */
	public double calcularCuota(Participante unParticipante){
		return ((unParticipante.getPlan().valorActualAlicuota()) + gastos + aseguradora.cuotaSeguro());
	}
	
/**
 * Propósito: Retorna el valor total de los gastos adminstrativos
 * @return double
 */
	public double getGastos() {
		return gastos;
	}
	
/**
 * Propósito: Modificar el valor de los gastos administrativos	
 * @param double
 */
	public void setGastosAdmin(double cargosAdministrativos){
		gastos=cargosAdministrativos;
	} 
	
/**
 * Propósito: Generar la cuota determinada del plan determinado
 * @param PlanDeAhorro
 * @param Integer
 * @return Cuota
 */
	public Cuota imprimirCuota(Participante participante)throws TerminoDePagarCuotasException{
		if(participante.getCuotasPagas()== participante.getPlan().cantDeCuotas()){
			throw new TerminoDePagarCuotasException("Termino de pagar las cuotas de la financiación");
		}
		double alic = participante.getPlan().valorActualAlicuota();
		
		return new Cuota(participante.getCuotasPagas()+1 , alic, aseguradora.cotizarSeguroPara(participante.valorDelAutoSuscripto(),participante.edadCliente()) ,gastos, participante );
	}
	
/**
 * Propósito: cambiar valor del seguro
 * @param Seguro
 */
	public void recategorizarSeguro(Seguro nuevoSeguro){
		aseguradora = nuevoSeguro;
	}

	
/**
 * Propósito: Emite un comprobante de pago.
 * @param Cuota
 * @return ComprobanteDePago
 */
	public ComprobanteDePago recibirPago(Cuota unaCuota){ 
		return new ComprobanteDePago(unaCuota);
	}
	
	public void generarCuponDeAdjudicacion(Participante adjudicado,Concesionaria concesionario){
		CuponDeAdjudicacion cupon = new CuponDeAdjudicacion(adjudicado, calcularMontodeAdjudicacion(adjudicado,concesionario)); 
		talonarioDeCuponesDeAdjudicacion.add(cupon);
	}

	public double calcularMontodeAdjudicacion(Participante adjudicado,Concesionaria concesionario) {
		ModeloDeAuto modeloAdjudicado = adjudicado.getPlan().getModelo();
		double valorUltimaCuota = adjudicado.getPlan().getPlanDePago().cuotaFinal(modeloAdjudicado);
		double valorDelFlete = flete.consultarValorDelFlete(concesionario.distanciaAPlantaMasCercana(modeloAdjudicado));
		return (valorUltimaCuota + valorDelFlete);
	}
	public CuponDeAdjudicacion obtenerCuponDelParticipante(Participante adjudicado)throws NoHayCuponException{
		CuponDeAdjudicacion cuponDelParticipante = null;
		for (CuponDeAdjudicacion cupon : talonarioDeCuponesDeAdjudicacion)
			if (cupon.getParticipante() == adjudicado){
				cuponDelParticipante = cupon;
			}
		if (cuponDelParticipante == null){
			throw new NoHayCuponException("No hay cupon para participante");
		}

		return cuponDelParticipante;
	}


}
