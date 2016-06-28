/**
 * @author Analía (en su gran mayoría) 
 *         Demian (algún metodo necesario para otra clases)
 */

package tpC;


import java.util.ArrayList;

public class PlanDeAhorro {

	
	private Integer nroGrupo;
	private PlanDePago planDePago;
	private FormaDeAdjudicacion adjudicacion;
	private ArrayList<Participante> participantes;
	private ModeloDeAuto modeloAuto;
	
/**
 * Propósito: Determinar el modelo de auto a adquirir, 
 * 			  su forma de pago y adjudicación del mismo	
 * @param PlanDePago
 */
	public PlanDeAhorro(PlanDePago p){
		participantes = new ArrayList<Participante>();
		nroGrupo = new Integer(0);
		planDePago = p;
		//adjudicacion = new FormaDeAdjudicacion();
		modeloAuto = new ModeloDeAuto();
	}
	
/**
 * Propósito: Retorna la cantidad de participantes inscriptos al plan 	
 * @param Participante
 * @return Integer
 */
	public Integer inscribirParticipante(Participante unParticipante) {
		this.participantes.add(unParticipante);
		return this.participantes.size();
	}
	
/**
 * Propósito: Retorna la lista de participantes inscriptos en el plan	
 * @return ArrayList<Participante>
 */
	public  ArrayList<Participante> getParticipantes(){
		return this.participantes;
	}
	
/**
 * Propósito: Retorna el número de grupo del plan	
 * @return Integer
 */
	public Integer getGrupo(){
		return this.nroGrupo;
	}

/**
 * Propósito: Retorna la cantidad de cuotas a pagar del plan	
 * @return Integer
 */
	public Integer cantDeCuotas() {
		return planDePago.cantDeCuotas();
	}
		
/**
 * Propósito: Retorna la cantidad de participantes suscriptos al plan	
 * @return Integer
 */
	public Integer cantDeParticipantes(){
		return participantes.size();
	}
	
/**
 * Propósito: Realizar la adjudicación del auto a un participante del plan	
 * @return Participante
 * @throws NoHayParticipantesException
 */
	public Participante adjudicar() throws NoHayParticipantesException{
		return adjudicacion.adjudicar(this);
	}

/**
 * Propósito: Setea el número de grupo	
 * @param Integer
 */
	public void setGrupo(Integer size) {
		nroGrupo=size;
		
	}
	
/**
 * Propósito: Determina el mayor porcentaje de pago de 
 *            todos los participantes del plan	
 * @return Double
 * @throws NoHayParticipantesException
 */
	public double mayorPorcentajeDePago() throws NoHayParticipantesException{
		if (participantes.isEmpty()){
			throw new NoHayParticipantesException("No hay participantes");
		}
		Participante aux= participantes.get(0);
		for (Participante p:participantes){
			if (p.porcentajePago() > aux.porcentajePago()){
				aux=p;
			}
		}
		return aux.porcentajePago();
		//Ana y/o Pablo. No debería devolver "aux" solamente
		//No estaría entendiendo el fin del método
	}
	
/**
 * Propósito: Retorna el modelo del auto que financia el plan	
 * @return ModeloDeAuto
 */
	public ModeloDeAuto getModelo(){
		return modeloAuto;
	}
	
/**
 * Propósito: Retorna valor de alicuota
 * @return double
 */
	public double valorActualAlicuota(){
		return planDePago.valorDeCuota(modeloAuto);
	}

}

