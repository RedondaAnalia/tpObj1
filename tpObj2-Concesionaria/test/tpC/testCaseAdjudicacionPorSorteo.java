package tpC;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class testCaseAdjudicacionPorSorteo {
	
	private AdjudicacionPorSorteo adjudicacion;
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
		adjudicacion = new AdjudicacionPorSorteo();
		laListaDeParticipantes = new ArrayList<Participante>();
		laListaDeParticipantes.add(analiaMock);
		laListaDeParticipantes.add(demianMock);
		laListaDeParticipantes.add(pabloMock);
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {
		System.out.println("::::::::TEST Adjudicacion Por Sorteo::::::::::");
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		analiaMock= laListaDeParticipantes.get(0);
		demianMock=laListaDeParticipantes.get(1);
		pabloMock=laListaDeParticipantes.get(2);
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		when(unPlanCualquiera.cantDeParticipantes()).thenReturn(laListaDeParticipantes.size());
		Participante par= adjudicacion.adjudicar(unPlanCualquiera);
		System.out.println("Resultado primer adjudicacion: ");
		if(par==analiaMock){
			System.out.println("Se adjudico a Analia");
		}
		if(par==demianMock){
			System.out.println("Se adjudico a Damian");
		}
		if (par==pabloMock){
			System.out.println("Se adjudicó a Pablo");
		}
		Participante par2= adjudicacion.adjudicar(unPlanCualquiera);
		System.out.println("Resultado segunda adjudicacion: ");
		if(par2==analiaMock){
			System.out.println("Se adjudico a Analia");
		}
		if(par2==demianMock){
			System.out.println("Se adjudico a Damian");
		}
		if (par2==pabloMock){
			System.out.println("Se adjudicó a Pablo");
		}
	}

}
