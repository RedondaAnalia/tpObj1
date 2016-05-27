package tpC;
//ya esta corregido el error de los mock.
//todo lo que necesito para "instanciar y mockear" los declare en la clase y lo inicialice en el setup (vi cosas inicializadas en los metodos de test)


import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;


public class TestCaseConcesionaria {

	private Concesionaria los3Fanaticos;
	@Mock private Fabrica peugeot;
	@Mock private Cliente pabloMock;
	@Mock private Cliente anitaMock;
	@Mock private Cliente demianMock;
	@Mock private PlanDeAhorro plan7030Mock;
	@Mock private PlanDeAhorro plan100Mock;
	
	@Before
	public void setUp() throws Exception {
		
		
		peugeot = mock(Fabrica.class);
		los3Fanaticos= new Concesionaria(peugeot);
		pabloMock = mock(Cliente.class);
		demianMock = mock(Cliente.class);
		anitaMock = mock(Cliente.class);
		plan7030Mock = mock(PlanDeAhorro.class);
		plan100Mock = mock(PlanDeAhorro.class);
		
		MockitoAnnotations.initMocks(this); //chicos... que es estoo???
		
	}
	
	@Test
	public void test1_agrego3ClientesALaListaYPrueboLaCantidad(){
		los3Fanaticos.agregarCliente(pabloMock);
		los3Fanaticos.agregarCliente(demianMock);
		los3Fanaticos.agregarCliente(anitaMock);
		assertTrue(los3Fanaticos.getClientes().size()==3);
		assertTrue(los3Fanaticos.getClientes().contains(pabloMock));
		assertTrue(los3Fanaticos.getClientes().contains(demianMock));
		assertTrue(los3Fanaticos.getClientes().contains(anitaMock));
	}
	
	@Test
	public void test2_agrego2PlanesDeAhorroyVerificoInsercion(){
		los3Fanaticos.agregarPlan(plan100Mock);
		los3Fanaticos.agregarPlan(plan7030Mock);
		assertTrue(los3Fanaticos.getPlanes().size()== 2);
		assertTrue(los3Fanaticos.getPlanes().contains(plan100Mock));
		assertTrue(los3Fanaticos.getPlanes().contains(plan7030Mock));
	}
	
}

