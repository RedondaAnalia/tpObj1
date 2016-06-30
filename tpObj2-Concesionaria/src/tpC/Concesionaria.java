/**
 * @author Anal�a - Demian - Pablo
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
 * Prop�sito: Administrar clientes y planes de ahorro para la adquisici�n de autos	
 * @param unaFabrica
 * @param unaUbicacion
 * @param unaAdministracion
 */
	public Concesionaria(Fabrica unaFabrica, Coord unaUbicacion, AdministracionConcesionaria unaAdministracion) {
		fabrica = unaFabrica;
		clientes = new ArrayList<Cliente>();
		planes = new ArrayList<PlanDeAhorro>();
		ubicacion = unaUbicacion;
		stock = fabrica.getStock();
		administracion = unaAdministracion;
	}
	
/**
 * Prop�sito: Retorna la ubicacion de la concesionaria
 * @return Coord
 */
	public Coord getUbicacion() {
		return ubicacion;
	}
	
/**
 * Prop�sito: Agregar un cliente nuevo a la concesionaria
 * @param String (para Apellido)
 * @param String (para Nombre)
 * @param Integer (para DNI)
 * @param String (para Domicilio)
 * @param String (para Mail)
 * @param localDate (dia de nacimiento)
 * @param localDate (mes de nacimiento)
 * @param localDate (a�o de nacimiento)
 */
	public void agregarCliente(String suApellido, String suNombre, int numDeDNI, String suDireccionPostal, String suMail,int diaDeNacimiento,int mesDeNacimiento, int a�oDeNacimiento) {
		clientes.add(new Cliente(suApellido, suNombre, numDeDNI, suDireccionPostal, suMail, diaDeNacimiento, mesDeNacimiento, a�oDeNacimiento, this));
	}
	
	
/**
 * Prop�sito: Retorna el stock que hay del modelo requerido en la f�brica
 * @param ModeloDeAuto
 * @return Integer
 */
	public Integer getStockDelModelo(ModeloDeAuto unModelo) {
		return stock.getStockDelModelo(unModelo);
	}
	
	
/**
 * Prop�sito: Retorna la lista de clientes de la concesionaria
 * @return ArrayList<Cliente>
 */
	public ArrayList<Cliente> getClientes() {
		return this.clientes;
	}
	
/**
 * Prop�sito: Agregar un nuevo plan de ahorro a la concesionaria
 * @param PlanDeAhorro
 */
	public void agregarPlan(PlanDeAhorro unPlanDeAhorro) {
		this.planes.add(unPlanDeAhorro);
		unPlanDeAhorro.setGrupo(planes.size());
	}
	
/**
 * Prop�sito: Retorna la lista de planes de la concesionaria
 * @return ArrayList<PlanDeAhorro>
 */
	public ArrayList<PlanDeAhorro> getPlanes() {
		return this.planes;
	}

/**
 * Prop�sito: Calcular cuales son los diez planes de ahorro 
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
 * Prop�sito: Calcula el valor total de la cuota
 * @param double
 * @return double
 */
	public double generarValorDeCuota(Participante unParticipante){
		return administracion.calcularCuota(unParticipante);
	}
	
/**
 * Prop�sito: Emite una cuota para ser pagada
 * @param Participante
 * @return Cuota
 * @throws TerminoDePagarCuotasException 
 */
	public Cuota generarCuota(Participante unParticipante) throws TerminoDePagarCuotasException {
		return administracion.imprimirCuota(unParticipante);
	}


/**
 * Prop�sito: Emite un comprobante de pago.
 * @param Cuota
 * @return Comprobante De Pago
 */

		
	public ComprobanteDePago recibirPago(Cuota unaCuota){
		return administracion.recibirPago(unaCuota);
	}	
}
