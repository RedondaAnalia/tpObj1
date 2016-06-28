/**
 * @author Analía - Demian - Pablo
 */

package tpC;

import java.util.*;
import java.util.HashMap;

public class Concesionaria {

	private Fabrica fabrica;
	private ArrayList<Cliente> clientes;
	private ArrayList<PlanDeAhorro> planes;
	private AdministracionConcesionaria administracion;
	private Coord ubicacion;
	private Stock stock;

/**
 * Propósito: Administrar clientes y planes de ahorro para la adquisición de autos	
 * @param fab
 * @param coordenada
 */
	public Concesionaria(Fabrica fab, Coord coordenada) {
		fabrica = fab;
		clientes = new ArrayList<Cliente>();
		planes = new ArrayList<PlanDeAhorro>();
		ubicacion = coordenada;
		stock = fab.getStock();
		administracion = new AdministracionConcesionaria(0, new Seguro(0));
	}
	
/**
 * Propósito: Retorna la ubicacion de la concesionaria
 * @return Coord
 */
	public Coord getUbicacion() {
		return ubicacion;
	}
	
/**
 * Propósito: Agregar un cliente nuevo a la concesionaria
 * @param String (para Apellido)
 * @param String (para Nombre)
 * @param Integer (para DNI)
 * @param String (para Domicilio)
 * @param String (para Mail)
 * @param localDate (dia de nacimiento)
 * @param localDate (mes de nacimiento)
 * @param localDate (año de nacimiento)
 */
	public void agregarCliente(String apell, String nombr, Integer doc, String dirPostal, String dirMail,
			Integer diaNac, Integer mesNac, Integer anioNac) {
		clientes.add(new Cliente(apell, nombr, doc, dirPostal, dirMail, diaNac, mesNac, anioNac, this));
	}
	
/**
 * Propósito: Retorna el stock que hay del modelo requerido en la fábrica
 * @param ModeloDeAuto
 * @return Integer
 */
	public Integer getStockDelModelo(ModeloDeAuto unModelo) {
		return stock.getStockDelModelo(unModelo);
	}
	
/**
 * Propósito: Retorna la lista de clientes de la concesionaria
 * @return ArrayList<Cliente>
 */
	public ArrayList<Cliente> getClientes() {
		return this.clientes;
	}
	
/**
 * Propósito: Agregar un nuevo plan de ahorro a la concesionaria
 * @param PlanDeAhorro
 */
	public void agregarPlan(PlanDeAhorro unPlan) {
		this.planes.add(unPlan);
		unPlan.setGrupo(planes.size());
	}
	
/**
 * Propósito: Retorna la lista de planes de la concesionaria
 * @return ArrayList<PlanDeAhorro>
 */
	public ArrayList<PlanDeAhorro> getPlanes() {
		return this.planes;
	}

/**
 * Propósito: Adjudicar todos los planes de ahorro 
 * @return HashMap<Participante, Integer>
 * @throws NoHayParticipantesException
 */
	public HashMap<Participante, Integer> adjudicarTodosLosPlanes() throws NoHayParticipantesException {
		HashMap<Participante, Integer> ret = new HashMap<Participante, Integer>();
		for (PlanDeAhorro p : planes) {
			ret.put(p.adjudicar(), p.getGrupo());
			return ret;
		}
		return ret;

	}
	
/**
 * Propósito: Calcular cuales son los diez planes de ahorro 
 * con mayor cantidad de participantes 
 * @return ArrayList<PlanDeAhorro>
 */
	public ArrayList<PlanDeAhorro> topTenPlanesSuscriptos() {
		ArrayList<PlanDeAhorro> ret = new ArrayList<PlanDeAhorro>();
		Collections.sort(this.planes, new Comparator<PlanDeAhorro>() {
			@Override
			public int compare(PlanDeAhorro p1, PlanDeAhorro p2) {
				return new Integer(p2.cantDeParticipantes()).compareTo(new Integer(p1.cantDeParticipantes()));
			}
		});
		for (int i = 0; i < 10; i++) {// como empiezo en cero, termino en 9.
			ret.add(this.planes.get(i));
		}

		return ret;
	}
	
/**
 * Propósito: Calcula el valor total de la cuota
 * @param double
 * @return double
 */
	public double generarValorDeCuota(double alicuota){
		return administracion.calcularCuota(alicuota);
	}
	
/**
 * Propósito: Emite una cuota para ser pagada
 * @param Participante
 * @return Cuota
 * @throws TerminoDePagarCuotasException 
 */
	public Cuota generarCuota(Participante unParticipante) throws TerminoDePagarCuotasException {
		return administracion.imprimirCuota(unParticipante);
	}

	
	public ComprobanteDePago recibirPago(Cuota unaCuota){
		return new ComprobanteDePago(unaCuota);
	}
	
	public void actualizarGastosAdministrativos(double valor){
		administracion.setGastosAdmin(valor);
	}
	
	public void cambiarSeguro(Seguro nuevoSeguro){
		administracion.recategorizarSeguro(nuevoSeguro);
	}
}
