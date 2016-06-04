package tpC;


import java.util.*;
import java.util.HashMap;

public class Concesionaria {

	private Fabrica fabrica;
	private ArrayList<Cliente> clientes;
	private ArrayList<PlanDeAhorro> planes;
	private Coord ubicacion;
	private Stock stock;
	
	public Concesionaria(Fabrica fab){
		this.fabrica=fab;
		this.clientes= new ArrayList<Cliente>();
		this.planes= new ArrayList<PlanDeAhorro>();
	}
	
	public Coord getUbicacion(){
		return ubicacion;
	}
	
	public void agregarCliente(Cliente unCliente) {
		this.clientes.add(unCliente);
	}

	public Integer getStockDelModelo(ModeloDeAuto unModelo){
		return stock.getStockDelModelo(unModelo);
	}
	
	public ArrayList<Cliente> getClientes() {
		return this.clientes;
	}

	public void agregarPlan(PlanDeAhorro unPlan) {
		this.planes.add(unPlan);
		unPlan.setGrupo(planes.size());
	}

	public ArrayList<PlanDeAhorro> getPlanes() {
		return this.planes;
	}
	
	public HashMap<Participante, Integer> adjudicarTodosLosPlanes(){
		HashMap<Participante, Integer> ret= new HashMap<Participante,Integer>();
		for (PlanDeAhorro p:planes){
			ret.put(p.adjudicar(), p.getGrupo());
			return ret;
		}
		return ret;
		
	}

	public ArrayList<Integer> topTenPlanesSuscriptos() {
		 ArrayList<Integer> ret=new ArrayList <Integer>();
		 Collections.sort(this.planes, new Comparator<PlanDeAhorro>() {
			 @Override
			 public int compare(PlanDeAhorro p1, PlanDeAhorro p2) {
				 return new Integer(p2.cantDeParticipantes()).compareTo(new Integer(p1.cantDeParticipantes()));
	}
});
				for(int i=0; i<10; i++){//si empiezo en cero, termino en 9.
				ret.add(this.planes.get(i).getGrupo());
			}
			
		return ret;
}
}



