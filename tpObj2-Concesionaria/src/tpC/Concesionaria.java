package tpC;

import java.util.*;

public class Concesionaria {

	private Fabrica fabrica;
	private ArrayList<Cliente> clientes;
	private ArrayList<PlanDeAhorro> planes;
	
	public Concesionaria(Fabrica fab){
		this.fabrica=fab;
		this.clientes= new ArrayList<Cliente>();
		this.planes= new ArrayList<PlanDeAhorro>();
	}
	
	

	public void agregarCliente(Cliente unCliente) {
		this.clientes.add(unCliente);
	}

	public ArrayList<Cliente> getClientes() {
		return this.clientes;
	}

	public void agregarPlan(PlanDeAhorro unPlan) {
		this.planes.add(unPlan);
	}

	public ArrayList<PlanDeAhorro> getPlanes() {
		return this.planes;
	}

	public ArrayList<Integer> topTenPlanesSuscriptos() {
		ArrayList<PlanDeAhorro> copia = this.planes;
		 ArrayList<Integer> ret=new ArrayList <Integer>();
Collections.sort(copia, new Comparator<PlanDeAhorro>() {
	@Override
	public int compare(PlanDeAhorro p1, PlanDeAhorro p2) {
		return new Integer(p2.cantDeParticipantes()).compareTo(new Integer(p1.cantDeParticipantes()));
	}
});
				for(int i=0; i<=10; i++){
				ret.add(copia.get(i).getGrupo());
				i++;
			}
			
		return ret;
}}


