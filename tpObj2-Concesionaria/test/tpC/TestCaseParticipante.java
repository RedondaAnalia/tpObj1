package tpC;

import org.joda.time.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class TestCaseParticipante {
	
	private Participante analiaParticipante;
	private Participante analiaParticipante2;
	@Mock private Cliente analiaMock;
	private Cliente analiaCliente;
	@Mock private PlanDeAhorro planMock;
	@Mock private CuotasPagas cuotas; 
	@Mock private Concesionaria mockConces;
	private PlanDeAhorro plan;
	@Mock PlanDePago mockPago;
	@Mock FormaDeAdjudicacion mockAdj;
	@Mock ModeloDeAuto mockModeloDeAuto;
	
	@Before
	public void setUp() throws Exception {
		analiaCliente= new Cliente("Diaz", "Analia", 3, "calle", "dirmail", 21, 11, 1967, mockConces);
		analiaMock=mock(Cliente.class);
		planMock= mock(PlanDeAhorro.class);
		mockConces=mock(Concesionaria.class);
		mockPago=mock(PlanDePago.class);
		when(mockPago.cantDeCuotas()).thenReturn(10);
		when(planMock.cantDeCuotas()).thenReturn(10);
		plan= new PlanDeAhorro(mockPago, mockAdj, mockModeloDeAuto);
		analiaParticipante = new Participante(analiaMock, planMock, mockConces);
		analiaParticipante2= new Participante (analiaCliente,plan,mockConces);
		MockitoAnnotations.initMocks(this);	
	}

	@Test
	public void test_CreacionDeParticipanteYPedidoNroDeOrden() {
		when(planMock.inscribirParticipante(analiaParticipante)).thenReturn(3);
		analiaParticipante.adquirirPlanDeAhorro(planMock);
		assertEquals((Integer) 3, analiaParticipante.getNroDeOrden());
	}


	@Test
	public void test_PedidoDePorcentajeDeCuotas() {
		analiaParticipante.setCuotasPagas(cuotas);
		when(cuotas.porcentajePago()).thenReturn((double) 3);
		assertEquals(3, analiaParticipante.porcentajePago(), 0);
	}
	
	@Test
	public void test_getters(){
		assertEquals(analiaCliente, analiaParticipante2.getCliente());
		assertEquals(plan, analiaParticipante2.getPlan());
		LocalDate date=new LocalDate();
		assertEquals(date, analiaParticipante2.getFchInscripcion());
	}
	

}
