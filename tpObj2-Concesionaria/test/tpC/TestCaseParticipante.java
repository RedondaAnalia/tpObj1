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
	private 
	
	@Before
	public void setUp() throws Exception {
		analiaParticipante = new Participante(analiaMock);
		MockitoAnnotations.initMocks(this);	
	}

	@Test
	public void test1CreacionDeParticipanteYPedidoNroDeOrden() {
		when(planMock.inscribirParticipante(analiaParticipante)).thenReturn(3);
		analiaParticipante.adquirirPlanDeAhorro(planMock);
		assertEquals((Integer) 3, analiaParticipante.getNroDeOrden());
	}


	@Test
	public void test2PedidoDePorcentajeDeCuotas() {
		analiaParticipante.setCuotasPagas(cuotas);
		when(cuotas.porcentajePago()).thenReturn((double) 3);
		assertEquals((float)3, analiaParticipante.porcentajePago(), 0);
	}
	

}
