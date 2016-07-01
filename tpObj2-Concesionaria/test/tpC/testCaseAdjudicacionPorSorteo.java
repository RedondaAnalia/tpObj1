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
		laListaDeParticipantes = new ArrayList<Participante>();
		MockitoAnnotations.initMocks(this);
		adjudicacion = new AdjudicacionPorSorteo(sorteo);
		laListaDeParticipantes.add(analiaMock);
		laListaDeParticipantes.add(demianMock);
		laListaDeParticipantes.add(pabloMock);
	}

	@Test
	public void test1_ArmamosListaDe3ParticipantesYGanaAnita() throws NoHayParticipantesException {
		//ESTO FUNCIONAAABAA... LLORO :'(
		//Ahora va a andar mejor :D
		//Y aparte ganaste :D :D :D
		when(unPlanCualquiera.cantDeParticipantes()).thenReturn(3);
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		
		
		when(analiaMock.getCalidadDelParticipante()).thenReturn(new ParticipanteAdjudicado());
		when(pabloMock.getCalidadDelParticipante()).thenReturn(new ParticipanteStd());
		when(demianMock.getCalidadDelParticipante()).thenReturn(new ParticipanteStd());
		when(sorteo.primerPremio(3)).thenReturn(0);		
		assertEquals(demianMock,adjudicacion.adjudicar(unPlanCualquiera));	
		}
	
	@Test	
	public void test2_ArmamosListaDe3ParticipantesYGanaDemian() throws NoHayParticipantesException {
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		when(unPlanCualquiera.cantDeParticipantes()).thenReturn(3);
		when(sorteo.primerPremio(3)).thenReturn(1);
		when(analiaMock.getCalidadDelParticipante()).thenReturn(new ParticipanteAdjudicado());
		when(pabloMock.getCalidadDelParticipante()).thenReturn(new ParticipanteStd());
		when(demianMock.getCalidadDelParticipante()).thenReturn(new ParticipanteStd());
		assertEquals(demianMock,adjudicacion.adjudicar(unPlanCualquiera));
		
		}
	
	@Test
	public void test3_ArmamosListaDe3ParticipantesYGanaDemian() throws NoHayParticipantesException {
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		
		when(analiaMock.getCalidadDelParticipante()).thenReturn(new ParticipanteAdjudicado());
		when(pabloMock.getCalidadDelParticipante()).thenReturn(new ParticipanteStd());
		when(demianMock.getCalidadDelParticipante()).thenReturn(new ParticipanteStd());
		when(unPlanCualquiera.cantDeParticipantes()).thenReturn(3);
		
		when(sorteo.primerPremio(3)).thenReturn(2);		
		assertEquals(demianMock, adjudicacion.adjudicar(unPlanCualquiera));
		}
	
	@Test(expected = NoHayParticipantesException.class)
	public void test4_ArmamosListaDe3ParticipantesYNoHayParticipantes() throws NoHayParticipantesException {
		when(unPlanCualquiera.getParticipantes()).thenReturn(new ArrayList<Participante>());
		
		adjudicacion.adjudicar(unPlanCualquiera);
		}
	
	@Test(expected= NoHayParticipantesException.class)
	public void test5_NoHayParticipantesSinAdjudicar() throws NoHayParticipantesException {
		when(unPlanCualquiera.cantDeParticipantes()).thenReturn(3);
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);	
		
		when(analiaMock.getCalidadDelParticipante()).thenReturn(new ParticipanteAdjudicado());
		when(pabloMock.getCalidadDelParticipante()).thenReturn(new ParticipanteAdjudicado());
		when(demianMock.getCalidadDelParticipante()).thenReturn(new ParticipanteEntregado());
		
		when(sorteo.primerPremio(3)).thenReturn(0);		
		
		assertEquals(demianMock,adjudicacion.adjudicar(unPlanCualquiera));	
	}
}
