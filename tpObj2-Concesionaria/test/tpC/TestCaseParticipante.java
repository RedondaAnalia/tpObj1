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
	@Mock private Cliente analiaMock;
	@Mock private PlanDeAhorro planMock;
	@Mock private CuotasPagas cuotas; 
	@Mock private Concesionaria mockConces;
	@Mock PlanDePago mockPago;
	@Mock FormaDeAdjudicacion mockAdj;
	@Mock ModeloDeAuto mockModeloDeAuto;
	@Mock Cuota mockCuota;
	@Mock ComprobanteDePago mockComprobante;
	
	@Before
	public void setUp() throws Exception {
		analiaMock=mock(Cliente.class);
		planMock= mock(PlanDeAhorro.class);
		mockConces=mock(Concesionaria.class);
		mockPago=mock(PlanDePago.class);
		mockCuota=mock(Cuota.class);
		mockComprobante=mock(ComprobanteDePago.class);
		when(mockPago.cantDeCuotas()).thenReturn(10);
		when(planMock.cantDeCuotas()).thenReturn(10);
		when(analiaMock.getConcesionaria()).thenReturn(mockConces);
		analiaParticipante = new Participante(analiaMock, planMock);
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
		analiaMock=mock(Cliente.class);
		when(analiaMock.getConcesionaria()).thenReturn(mockConces);
		analiaParticipante = new Participante(analiaMock, planMock);
		assertEquals(analiaMock, analiaParticipante.getCliente());
		assertEquals(planMock, analiaParticipante.getPlan());
		LocalDate date=new LocalDate();
		assertEquals(date, analiaParticipante.getFchInscripcion());
		assertEquals((Integer)0,analiaParticipante.getCuotasPagas());
	}
	
	@Test
	public void test_PagarCuota(){
		assertEquals((Integer)0,analiaParticipante.getCuotasPagas());
		when(mockConces.recibirPago(mockCuota)).thenReturn(mockComprobante);
		analiaParticipante.pagarCuota(mockCuota);
		assertEquals((Integer)1,analiaParticipante.getCuotasPagas());
		
	}
	
	@Test
	public void test_valorDelAuto(){
		analiaParticipante.adquirirPlanDeAhorro(planMock);
		when(mockModeloDeAuto.getValor()).thenReturn(350000);
		when(planMock.getModelo()).thenReturn(mockModeloDeAuto);
		assertEquals(analiaParticipante.getPlan().getModelo().getValor(),350000,0);
	}
	
	@Test
	public void test_estadosDelParticipante(){
		assertEquals(ParticipanteStd.class ,analiaParticipante.getCalidadDelParticipante().getClass());
		analiaParticipante.stateAdjudicado();
		assertEquals(ParticipanteAdjudicado.class ,analiaParticipante.getCalidadDelParticipante().getClass());
		analiaParticipante.stateEntregado();
		assertEquals(ParticipanteEntregado.class ,analiaParticipante.getCalidadDelParticipante().getClass());
		
	}
	

}
