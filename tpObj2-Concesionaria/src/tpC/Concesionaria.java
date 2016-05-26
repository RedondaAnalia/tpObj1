package tpC;

import java.util.ArrayList;
import java.util.List;

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

	public ArrayList<PlanDeAhorro> topTenPlanesSuscriptos() {
		 
		//ordenar es un metodo de ArrayList y no se si puedo meterlo y o hay alguno q
		//no encontre... tarea para el viernes
		 ArrayList<PlanDeAhorro> copia = this.planes;
		 ArrayList<PlanDeAhorro> ret;
		 copia.ordenar();
			for(int i=0; i<=10; i++){
				ret.add(copia.get(i));
				i++;
			}
			
		return ret;
	}
	
}

