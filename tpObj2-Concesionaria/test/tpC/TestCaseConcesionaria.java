package tpC;

import static org.junit.Assert.*;
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
	@Mock private Coord ubicacion;
	@Mock private AdministracionConcesionaria adminMock;
	@Mock private Seguro unSeguro;
	
	@Before
	public void setUp() throws Exception {
			
		peugeot = mock(Fabrica.class);
		ubicacion= mock (Coord.class);
		los3Fanaticos= new Concesionaria(peugeot,ubicacion);
		pabloMock = mock(Cliente.class);
		demianMock = mock(Cliente.class);
		anitaMock = mock(Cliente.class);
		plan7030Mock = mock(PlanDeAhorro.class);
		plan100Mock = mock(PlanDeAhorro.class);
		unSeguro = mock(Seguro.class);
		MockitoAnnotations.initMocks(this);		
	}
	
	
	@Test
	public void test1_agrego3ClientesALaListaYPrueboLaCantidad(){
		los3Fanaticos.agregarCliente("Objetos","Juan Carlos",37690389,"Roque Saenz Peña 0","objetosq@juan",21,11,1989);
		assertTrue(los3Fanaticos.getClientes().size()==1);
		los3Fanaticos.agregarCliente("Objetos","Juan Carlos",37690389,"Roque Saenz Peña 0","objetosq@juan",21,11,1989);
		assertTrue(los3Fanaticos.getClientes().size()==2);
		los3Fanaticos.agregarCliente("Objetos","Juan Carlos",37690389,"Roque Saenz Peña 0","objetosq@juan",21,11,1989);
		assertTrue(los3Fanaticos.getClientes().size()==3);
	}
	
	@Test
	public void test2_agrego2PlanesDeAhorroyVerificoInsercion(){
		los3Fanaticos.agregarPlan(plan100Mock);
		los3Fanaticos.agregarPlan(plan7030Mock);
		assertTrue(los3Fanaticos.getPlanes().size()== 2);
		assertTrue(los3Fanaticos.getPlanes().contains(plan100Mock));
		assertTrue(los3Fanaticos.getPlanes().contains(plan7030Mock));
	}
	
	@Test
	public void test3_verificoLaUbicacion(){

		peugeot = mock(Fabrica.class);
		ubicacion= mock (Coord.class);
		los3Fanaticos= new Concesionaria(peugeot,ubicacion);
		assertEquals(los3Fanaticos.getUbicacion(),ubicacion);
	}
	
	@Test
	public void test4_GenerarValorDeCuota(){
		when(unSeguro.cuotaSeguro()).thenReturn(250.0);
		los3Fanaticos.cambiarSeguro(unSeguro);
		los3Fanaticos.actualizarGastosAdministrativos(150.0);
		double valorCuotaTest = los3Fanaticos.generarValorDeCuota(100); //el 100 es un valor de alicuota
			
		assertEquals(500.0, valorCuotaTest, 0.0);
	}
	
}

