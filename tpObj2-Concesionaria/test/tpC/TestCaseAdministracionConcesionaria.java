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
	@Mock private PlanDeAhorro planMock;
	@Mock ModeloDeAuto modeloMock;
	@Mock Participante unParticipante;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		unParticipante = mock(Participante.class);
		planMock = mock(PlanDeAhorro.class);
		seguroMock = mock(Seguro.class);
		modeloMock = mock(ModeloDeAuto.class);
		administracion = new AdministracionConcesionaria(500.0, seguroMock);
	}

	@Test
	public void test01_CargosDeAdministracionYSeguros() {
		when(seguroMock.cuotaSeguro()).thenReturn(250.0);
		assertEquals(administracion.calcularCuota(1000.0), 1750.0, 0.0);
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

}

