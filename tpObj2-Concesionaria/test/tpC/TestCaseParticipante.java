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
	@Mock private Cliente analiaMock;
	@Mock private PlanDeAhorro planMock;
	@Mock private CuotasPagas cuotas;
	
	@Before
	public void setUp() throws Exception {
		analiaParticipante = new Participante(analiaMock);
		MockitoAnnotations.initMocks(this);	
	}

	@Test
	public void test1CreacionDeParticipanteYPedidoNroDeOrden() {
		when(planMock.inscribirParticipante(analiaParticipante)).thenReturn(3);
		analiaParticipante.adquirirPlanDeAhorro(planMock);
		assertTrue(analiaParticipante.getNroDeOrden()== 3);
	}

	@Test
	public void test3PedidoDePorcentajeDeCuotas() {
		analiaParticipante.setCuotasPagas(cuotas);
			//forzando a hacer funcionar un test...usando setCuotasPagas como Public
		
		when(cuotas.porcentajePago()).thenReturn((float) 3);
		assertTrue(analiaParticipante.porcentajePago() == (float)3);
	}
	

}
