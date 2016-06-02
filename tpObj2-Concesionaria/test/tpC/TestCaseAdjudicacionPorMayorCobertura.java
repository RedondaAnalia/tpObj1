package tpC;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestCaseAdjudicacionPorMayorCobertura {

	private AdjudicacionPorMayorCobertura adjudicacion;
	@Mock private Participante analiaMock;
	@Mock private Participante demianMock;
	@Mock private Participante pabloMock;
	@Mock private PlanDeAhorro unPlanCualquiera;
	@Mock private ArrayList<Participante> laListaDeParticipantes;
	
	@Before
	public void setUp() throws Exception {
		adjudicacion = new AdjudicacionPorMayorCobertura();
		laListaDeParticipantes = new ArrayList<Participante>();
		laListaDeParticipantes.add(analiaMock);
		laListaDeParticipantes.add(demianMock);
		laListaDeParticipantes.add(pabloMock);
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {
		when(analiaMock.porcentajePago()).thenReturn((double) 50.0);
		when(demianMock.porcentajePago()).thenReturn((double) 60.0);
		when(pabloMock.porcentajePago()).thenReturn((double) 70.0);
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		when(analiaMock.getNroDeOrden()).thenReturn(1);
		when(demianMock.getNroDeOrden()).thenReturn(2);
		when(pabloMock.getNroDeOrden()).thenReturn(3);
		when(unPlanCualquiera.getParticipantes().get(0)).thenReturn(analiaMock);
		assertEquals(adjudicacion.adjudicar(unPlanCualquiera), pabloMock);

	}

}
