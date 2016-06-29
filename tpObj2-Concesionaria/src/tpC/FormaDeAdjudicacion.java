/**
 * @author Anita - Demian
 */
package tpC;

public interface FormaDeAdjudicacion {
	/**
	 * Propósito: Adjudicar a un participante del plan dado, segun criterio.
	 * @param planDeAhorro
	 * @return Participante
	 * @throws NoHayParticipantesException
	 */
	public Participante adjudicar(PlanDeAhorro planDeAhorro) throws NoHayParticipantesException;
}
