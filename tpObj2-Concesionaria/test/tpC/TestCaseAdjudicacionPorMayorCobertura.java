package tpC;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.*;

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
	private ArrayList<Participante> laListaDeParticipantes;
	
	@Before
	public void setUp() throws Exception {
		analiaMock = mock(Participante.class);
		demianMock = mock(Participante.class);
		pabloMock = mock(Participante.class);
		unPlanCualquiera = mock(PlanDeAhorro.class);
		
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
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		System.out.println("Esta es la lista de Participantes: " + laListaDeParticipantes);
		System.out.println("Este es el primero de la lista: " + laListaDeParticipantes.get(0));
		System.out.println("Adjudico al primero de la lista: " + adjudicacion.adjudicar(unPlanCualquiera));
		System.out.println("Codigo de Analia " + analiaMock.hashCode());
		System.out.println("Codigo de Pablo "+ pabloMock.hashCode());
		System.out.println("Codigo de Damian "+ demianMock.hashCode());
		analiaMock= laListaDeParticipantes.get(0);
		demianMock=laListaDeParticipantes.get(1);
		pabloMock=laListaDeParticipantes.get(2);
		assertEquals(adjudicacion.adjudicar(unPlanCualquiera), pabloMock);

	}

}
