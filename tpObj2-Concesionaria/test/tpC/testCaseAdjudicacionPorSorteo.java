package tpC;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;

public class testCaseAdjudicacionPorSorteo {
	
	private AdjudicacionPorSorteo adjudicacion;
	@Mock private Participante analiaMock;
	@Mock private Participante demianMock;
	@Mock private Participante pabloMock;
	@Mock private PlanDeAhorro unPlanCualquiera;
	private ArrayList<Participante> laListaDeParticipantes;
	@Mock private SorteoLoteriaNacional sorteo;

	@Before
	public void setUp() throws Exception {
		analiaMock = mock(Participante.class);
		demianMock = mock(Participante.class);
		pabloMock = mock(Participante.class);
		sorteo= mock(SorteoLoteriaNacional.class);
		unPlanCualquiera = mock(PlanDeAhorro.class);
		adjudicacion = new AdjudicacionPorSorteo();
		laListaDeParticipantes = new ArrayList<Participante>();
		laListaDeParticipantes.add(analiaMock);
		laListaDeParticipantes.add(demianMock);
		laListaDeParticipantes.add(pabloMock);
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() throws NoHayParticipantesException {
		
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		analiaMock= laListaDeParticipantes.get(0);
		demianMock=laListaDeParticipantes.get(1);
		pabloMock=laListaDeParticipantes.get(2);
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		when(unPlanCualquiera.cantDeParticipantes()).thenReturn(laListaDeParticipantes.size());
		when(sorteo.primerPremio(3)).thenReturn(0);		
		assertEquals(adjudicacion.adjudicar(unPlanCualquiera,sorteo),analiaMock);
		when(sorteo.primerPremio(3)).thenReturn(1);		
		assertEquals(adjudicacion.adjudicar(unPlanCualquiera,sorteo),demianMock);
		when(sorteo.primerPremio(3)).thenReturn(2);		
		assertEquals(adjudicacion.adjudicar(unPlanCualquiera,sorteo),pabloMock);
		}

}
