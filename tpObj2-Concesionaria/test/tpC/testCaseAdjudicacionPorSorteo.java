package tpC;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
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
		laListaDeParticipantes = mock(ArrayList.class);
		MockitoAnnotations.initMocks(this);
		adjudicacion = new AdjudicacionPorSorteo(sorteo);
	}

	@Test
	public void test1_ArmamosListaDe3ParticipantesYGanaAnita() throws NoHayParticipantesException {
		//ESTO FUNCIONAAABAA... LLORO :'(
		//Ahora va a andar mejor :D
		//Y aparte ganaste :D :D :D
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		when(unPlanCualquiera.cantDeParticipantes()).thenReturn(3);
		when(laListaDeParticipantes.get(0)).thenReturn(analiaMock);
		when(laListaDeParticipantes.get(1)).thenReturn(demianMock);
		when(laListaDeParticipantes.get(2)).thenReturn(pabloMock);
		when(sorteo.primerPremio(3)).thenReturn(0);		
		assertEquals(analiaMock,adjudicacion.adjudicar(unPlanCualquiera));	
		}
	@Test	
	public void test2_ArmamosListaDe3ParticipantesYGanaDemian() throws NoHayParticipantesException {
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		when(unPlanCualquiera.cantDeParticipantes()).thenReturn(3);
		when(laListaDeParticipantes.get(0)).thenReturn(analiaMock);
		when(laListaDeParticipantes.get(1)).thenReturn(demianMock);
		when(laListaDeParticipantes.get(2)).thenReturn(pabloMock);
		when(sorteo.primerPremio(3)).thenReturn(1);
		assertEquals(demianMock,adjudicacion.adjudicar(unPlanCualquiera));
		}
	
	@Test
	public void test3_ArmamosListaDe3ParticipantesYGanaPablo() throws NoHayParticipantesException {
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		when(unPlanCualquiera.cantDeParticipantes()).thenReturn(3);
		when(laListaDeParticipantes.get(0)).thenReturn(analiaMock);
		when(laListaDeParticipantes.get(1)).thenReturn(demianMock);
		when(laListaDeParticipantes.get(2)).thenReturn(pabloMock);
		when(sorteo.primerPremio(3)).thenReturn(2);		
		assertEquals(pabloMock, adjudicacion.adjudicar(unPlanCualquiera));
		}
	
	@Test(expected = NoHayParticipantesException.class)
	public void test4_ArmamosListaDe3ParticipantesYGanaPablo() throws NoHayParticipantesException {
		when(unPlanCualquiera.getParticipantes()).thenReturn(new ArrayList<Participante>());	
		adjudicacion.adjudicar(unPlanCualquiera);
		}
}
