package tpC;

import java.util.ArrayList;

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
	
}

