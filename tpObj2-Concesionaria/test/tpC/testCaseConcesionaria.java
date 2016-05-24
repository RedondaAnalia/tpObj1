package tpC;
//ya esta corregido el error de los mock.
//todo lo que necesito para "instanciar y mockear" los declare en la clase y lo inicialice en el setup (vi cosas inicializadas en los metodos de test)


import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;



public class testCaseConcesionaria {

	private Concesionaria los3Fanaticos;
	@Mock private Fabrica peugeot;
	@Mock private Cliente pabloMock;
	@Mock private Cliente pablo;
	@Mock private Cliente anita;
	@Mock private Cliente demian;

	@Before
	public void setUp() throws Exception {
		
		
		peugeot = mock(Fabrica.class);
		los3Fanaticos= new Concesionaria(peugeot);
		pablo = mock(Cliente.class);
		demian = mock(Cliente.class);
		anita = mock(Cliente.class);
		MockitoAnnotations.initMocks(this); //chicos... que es estoo???
		
	}
	
	@Test
	public void test1_agrego3ClientesALaListaYPrueboLaCantidad(){
		los3Fanaticos.agregarCliente(pablo);
		los3Fanaticos.agregarCliente(demian);
		los3Fanaticos.agregarCliente(anita);
		assertTrue(los3Fanaticos.getClientes().size()==3);
	}
	
}

