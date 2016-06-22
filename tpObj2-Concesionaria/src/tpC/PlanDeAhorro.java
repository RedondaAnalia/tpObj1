package tpC;


import java.util.ArrayList;

public class PlanDeAhorro {

	
	private Integer nroGrupo;
	private PlanDePago planDePago;
	private FormaDeAdjudicacion adjudicacion;
	private ArrayList<Participante> participantes;
	private ModeloDeAuto modeloAuto;
	
	public PlanDeAhorro(PlanDePago p){
		participantes = new ArrayList<Participante>();
		nroGrupo = new Integer(0);
		planDePago = p;
		//adjudicacion = new FormaDeAdjudicacion();
		modeloAuto = new ModeloDeAuto();
	}
	
	public Integer inscribirParticipante(Participante unParticipante) {
		this.participantes.add(unParticipante);
		return this.participantes.size();
	}
	
	public  ArrayList<Participante> getParticipantes(){
		return this.participantes;
	}
	
	public Integer getGrupo(){
		return this.nroGrupo;
	}

	public Integer cantDeCuotas() {
		return planDePago.cantDeCuotas();
	}
		
	public Integer cantDeParticipantes(){
		return participantes.size();
	}
	
	public Participante adjudicar() throws NoHayParticipantesException{
		return adjudicacion.adjudicar(this);
	}

	public void setGrupo(int size) {
		nroGrupo=size;
		
	}
	
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
	}
}