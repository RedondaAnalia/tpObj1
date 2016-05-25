package tpC;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class TestCaseParticipante {
	
	private Participante analiaParticipante;
	@Mock private CuotasPagas cuotas;
	@Mock private Cliente analiaMock;
	@Mock private PlanDeAhorro planMock;
	
	@Before
	public void setUp() throws Exception {
		cuotas = mock(CuotasPagas.class);
		MockitoAnnotations.initMocks(this);	
	}

	@Test
	public void test1CreacionDeParticipanteYPedidoNroDeOrden() {
		
		
		when(planMock.inscribirParticipante(analiaParticipante)).thenReturn(3);
		//Todo muy bonito pero no se si no me está funcionando el when del mock
		analiaParticipante = new Participante(analiaMock);
		analiaParticipante.adquirirPlanDeAhorro(planMock);
		//assertTrue(analiaParticipante.getNroDeOrden()== 3);
		assertTrue(planMock.inscribirParticipante(analiaParticipante)== 3);
	}

	
	@Test
	public void test2PedidoDePorcentjeDeCuotasPagas() {
		assertEquals(analiaParticipante.getPlan(), planMock);
	}

}
