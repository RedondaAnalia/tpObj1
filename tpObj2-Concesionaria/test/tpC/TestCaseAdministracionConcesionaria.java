package tpC;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestCaseAdministracionConcesionaria {

	AdministracionConcesionaria administracion;
	@Mock private Seguro seguroMock;
	@Mock private Seguro seguroMock2;
	@Mock private PlanDeAhorro planMock;
	@Mock ModeloDeAuto modeloMock;
	@Mock Participante unParticipante;
	@Mock Cuota mockCuota;
	@Mock Concesionaria unConcesionarioMock;
	@Mock AgenciaDeFletes fleteMock;
	@Mock Plan70x30 planDePagoMock;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		unConcesionarioMock = mock(Concesionaria.class);
		unParticipante = mock(Participante.class);
		mockCuota=mock(Cuota.class);
		planMock = mock(PlanDeAhorro.class);
		seguroMock = mock(Seguro.class);
		modeloMock = mock(ModeloDeAuto.class);
		administracion = new AdministracionConcesionaria(500.0, seguroMock);
		administracion.setFlete(fleteMock);
		
	}

	@Test
	public void test01_CargosDeAdministracionYSeguros() {
		when(seguroMock.cuotaSeguro()).thenReturn(250.0);
		when(unParticipante.getPlan()).thenReturn(planMock);
		when(planMock.valorActualAlicuota()).thenReturn((double)1000);
		assertEquals(administracion.calcularCuota(unParticipante), 1750.0, 0.0);
		administracion.recategorizarSeguro(seguroMock2);
		when(seguroMock2.cuotaSeguro()).thenReturn(350.0);
		assertEquals(administracion.calcularCuota(unParticipante), 1850.0, 0.0);	
	}
	
	@Test
	public void test02_ObtenerLosCargosAdminDespDeModificarlos(){
		administracion.setGastosAdmin(450);
		assertEquals(administracion.getGastos(), 450.0, 0.0);
	}
	
	@Test
	public void test03_ImprimirCuota() throws TerminoDePagarCuotasException{
		when(unParticipante.getPlan()).thenReturn(planMock);
		when(unParticipante.getCuotasPagas()).thenReturn(10);
		when(planMock.getModelo()).thenReturn(modeloMock);
		when(planMock.cantDeCuotas()).thenReturn(100);
		when(planMock.valorActualAlicuota()).thenReturn(1000.0);
		when(seguroMock.cuotaSeguro()).thenReturn(50.0);
		Cuota cuotaTest = administracion.imprimirCuota(unParticipante);
		assertEquals(Cuota.class, cuotaTest.getClass());
		assertEquals(11, cuotaTest.getNroCuota(), 0);
		assertEquals(1000, cuotaTest.getValorAlicuota(), 0);
	}
	
	@Test (expected = TerminoDePagarCuotasException.class)
	public void test04_VerificacionDeException() throws TerminoDePagarCuotasException{
		when(unParticipante.getPlan()).thenReturn(planMock);
		when(unParticipante.getCuotasPagas()).thenReturn(10);
		when(planMock.cantDeCuotas()).thenReturn(10);
		administracion.imprimirCuota(unParticipante);
	}
	
	@Test
	public void test05_EmisionDeRecibos(){
		assertEquals(ComprobanteDePago.class,administracion.recibirPago(mockCuota).getClass());
	}
	@Test
	public void test06_generoUnCuponDeAdjudicacion(){
		when(unConcesionarioMock.distanciaAPlantaMasCercana(modeloMock)).thenReturn((double) 100);
		when(fleteMock.consultarValorDelFlete(100)).thenReturn((double) 3000);
		when(planMock.getPlanDePago()).thenReturn(planDePagoMock);
		when(planDePagoMock.cuotaFinal(modeloMock)).thenReturn((double) 3500);
		when(unParticipante.getPlan()).thenReturn(planMock);
		administracion.generarCuponDeAdjudicacion(unParticipante, unConcesionarioMock);
		
	}
}

