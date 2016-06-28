/**
 * @author Anal�a (en su gran mayor�a) 
 *         Demian (alg�n metodo necesario para otra clases)
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
 * Prop�sito: Determinar el modelo de auto a adquirir, 
 * 			  su forma de pago y adjudicaci�n del mismo	
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
 * Prop�sito: Retorna la cantidad de participantes inscriptos al plan 	
 * @param Participante
 * @return Integer
 */
	public Integer inscribirParticipante(Participante unParticipante) {
		this.participantes.add(unParticipante);
		return this.participantes.size();
	}
	
/**
 * Prop�sito: Retorna la lista de participantes inscriptos en el plan	
 * @return ArrayList<Participante>
 */
	public  ArrayList<Participante> getParticipantes(){
		return this.participantes;
	}
	
/**
 * Prop�sito: Retorna el n�mero de grupo del plan	
 * @return Integer
 */
	public Integer getGrupo(){
		return this.nroGrupo;
	}

/**
 * Prop�sito: Retorna la cantidad de cuotas a pagar del plan	
 * @return Integer
 */
	public Integer cantDeCuotas() {
		return planDePago.cantDeCuotas();
	}
		
/**
 * Prop�sito: Retorna la cantidad de participantes suscriptos al plan	
 * @return Integer
 */
	public Integer cantDeParticipantes(){
		return participantes.size();
	}
	
/**
 * Prop�sito: Realizar la adjudicaci�n del auto a un participante del plan	
 * @return Participante
 * @throws NoHayParticipantesException
 */
	public Participante adjudicar() throws NoHayParticipantesException{
		return adjudicacion.adjudicar(this);
	}

/**
 * Prop�sito: Setea el n�mero de grupo	
 * @param Integer
 */
	public void setGrupo(Integer size) {
		nroGrupo=size;
		
	}
	
/**
 * Prop�sito: Determina el mayor porcentaje de pago de 
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
		//Ana y/o Pablo. No deber�a devolver "aux" solamente
		//No estar�a entendiendo el fin del m�todo
	}
	
/**
 * Prop�sito: Retorna el modelo del auto que financia el plan	
 * @return ModeloDeAuto
 */
	public ModeloDeAuto getModelo(){
		return modeloAuto;
	}
	
/**
 * Prop�sito: Retorna valor de alicuota
 * @return double
 */
	public double valorActualAlicuota(){
		return planDePago.valorDeCuota(modeloAuto);
	}

}

