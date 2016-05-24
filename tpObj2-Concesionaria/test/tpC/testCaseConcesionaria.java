package tpC;


import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;



public class testCaseConcesionaria {

	private Concesionaria los3Fanaticos;
	private Fabrica peugeot;
	@Mock private Cliente pabloMock;
	@Before
	public void setUp() throws Exception {
		
		
		peugeot = new Fabrica();
		los3Fanaticos= new Concesionaria(peugeot);
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void test1_agrego3ClientesALaListaYPrueboLaCantidad(){
		Cliente pablo = new Cliente();
		Cliente demian = new Cliente();
		Cliente anita = new Cliente();
		los3Fanaticos.agregarCliente(pablo);
		los3Fanaticos.agregarCliente(demian);
		los3Fanaticos.agregarCliente(anita);
		assertTrue(los3Fanaticos.getClientes().size()==3);
		
		assertTrue(true);
	}
	
	@Test
	public void test2_(){
		when(pabloMock.getApellido()).thenReturn("Sabaliauskas");
		
		assertTrue(pabloMock.getApellido()=="Sabaliauskas");
	}
}