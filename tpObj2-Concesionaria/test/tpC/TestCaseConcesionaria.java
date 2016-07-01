package tpC;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
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
	@Mock private Participante mockParticipante;
	@Mock private Cuota mockCuota;
	@Mock private ModeloDeAuto a3Mock;
	
	@Before
	public void setUp() throws Exception {
		adminMock = mock(AdministracionConcesionaria.class);	
		peugeot = mock(Fabrica.class);
		mockCuota= mock(Cuota.class);
		ubicacion= mock (Coord.class);
		pabloMock = mock(Cliente.class);
		demianMock = mock(Cliente.class);
		anitaMock = mock(Cliente.class);
		plan7030Mock = mock(PlanDeAhorro.class);
		plan100Mock = mock(PlanDeAhorro.class);
		unSeguro = mock(Seguro.class);
		mockParticipante=mock(Participante.class);
		MockitoAnnotations.initMocks(this);		
		los3Fanaticos= new Concesionaria(peugeot, ubicacion, adminMock);
	}
	
	
	@Test
	public void test1_agrego3ClientesALaListaYPrueboLaCantidad(){
		los3Fanaticos.agregarCliente("Objetos","Juan Carlos",37690389,"Roque Saenz Peña 0","objetosq@juan",21,11,1989);
		assertEquals((int) 1, los3Fanaticos.getClientes().size());
		los3Fanaticos.agregarCliente("Objetos","Juan Carlos",37690389,"Roque Saenz Peña 0","objetosq@juan",21,11,1989);
		assertEquals((int) 2, los3Fanaticos.getClientes().size());
		los3Fanaticos.agregarCliente("Objetos","Juan Carlos",37690389,"Roque Saenz Peña 0","objetosq@juan",21,11,1989);
		assertEquals((int) 3, los3Fanaticos.getClientes().size());
	}
	
	@Test
	public void test2_agrego2PlanesDeAhorroyVerificoInsercion(){
		los3Fanaticos.agregarPlan(plan100Mock);
		los3Fanaticos.agregarPlan(plan7030Mock);
		assertEquals((int) 2, los3Fanaticos.getPlanes().size());
		assertTrue(los3Fanaticos.getPlanes().contains(plan100Mock));
		assertTrue(los3Fanaticos.getPlanes().contains(plan7030Mock));
	}
	
	@Test
	public void test3_verificoLaUbicacion(){

		assertEquals(los3Fanaticos.getUbicacion(),ubicacion);
	}
	
	@Test
	public void test4_GenerarValorDeCuota(){
		when(adminMock.calcularCuota(mockParticipante)).thenReturn(50.0);
		los3Fanaticos.generarValorDeCuota(mockParticipante);
		Mockito.verify(adminMock,Mockito.times(1)).calcularCuota(mockParticipante);
	}
	
	@Test
	public void test5_generarCuota() throws TerminoDePagarCuotasException{
		when(adminMock.imprimirCuota(mockParticipante)).thenReturn(mockCuota);
		los3Fanaticos.generarCuota(mockParticipante);
		Mockito.verify(adminMock,Mockito.times(1)).imprimirCuota(mockParticipante);
	}
	
	@Test
	public void test6_EmisionDePagos(){
		los3Fanaticos.recibirPago(mockCuota);
		Mockito.verify(adminMock,Mockito.times(1)).recibirPago(mockCuota);
	}
	
	@Test
	public void test7_distanciaAPlantaMasCercana(){
		when(peugeot.distanciaConcesionariaPlantaMasCercanaConElModelo(los3Fanaticos, a3Mock)).thenReturn(18.0);
		System.out.println(peugeot.distanciaConcesionariaPlantaMasCercanaConElModelo(los3Fanaticos, a3Mock));
		assertEquals(18.0, los3Fanaticos.distanciaAPlantaMasCercana(a3Mock), 0);
	}
	
	@Test
	public void test8_pedirAutoAFabrica() throws NoHayStockException, NoExisteElModeloDelAutoException{
		assertEquals(0,los3Fanaticos.getDeposito().size(), 0);
		los3Fanaticos.pedirAutoALaFabrica(a3Mock);
		assertEquals(1,los3Fanaticos.getDeposito().size(), 0);
	}
}

