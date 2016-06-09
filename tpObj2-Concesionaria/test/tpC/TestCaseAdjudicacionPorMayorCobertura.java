package tpC;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.*;

import org.joda.time.LocalDate;
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
	private LocalDate fecha1;
	private LocalDate fecha2;
	private LocalDate fecha3;
	private LocalDate fecha4;
	private ArrayList<Participante> laListaDeParticipantes;
	@Mock private Cliente mockCliente1;
	@Mock private Cliente mockCliente2;
	
	
	@Before
	public void setUp() throws Exception {
		analiaMock = mock(Participante.class);
		demianMock = mock(Participante.class);
		pabloMock = mock(Participante.class);
		unPlanCualquiera = mock(PlanDeAhorro.class);
		fecha1= new LocalDate(2000, 01, 01);
		fecha2=new LocalDate(1990,01,01);
		fecha3=new LocalDate(1993,01,01);
		fecha4=new LocalDate(1994,01,01);
		mockCliente1= mock(Cliente.class);
		mockCliente2= mock(Cliente.class);
		
		adjudicacion = new AdjudicacionPorMayorCobertura();
		laListaDeParticipantes = new ArrayList<Participante>();
		//laListaDeParticipantes.set(0,analiaMock);
		//laListaDeParticipantes.set(1,demianMock);
		//laListaDeParticipantes.set(2,pabloMock);
		laListaDeParticipantes.add(analiaMock);
		laListaDeParticipantes.add(demianMock);
		laListaDeParticipantes.add(pabloMock);

		MockitoAnnotations.initMocks(this);
	}
	
	

    /*
    ***Tomo solo un participante con mayor cobertura.
    */
	@Test 
	public void testCasoUnicoMayorCobertura() {
		
		analiaMock= laListaDeParticipantes.get(0);
		demianMock=laListaDeParticipantes.get(1);
		pabloMock=laListaDeParticipantes.get(2);
		when(analiaMock.porcentajePago()).thenReturn((double) 50.0);
		when(demianMock.porcentajePago()).thenReturn((double) 60.0);
		when(pabloMock.porcentajePago()).thenReturn((double) 70.0);
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		when(unPlanCualquiera.mayorPorcentajeDePago()).thenReturn((double)70.0);
		assertEquals(adjudicacion.adjudicar(unPlanCualquiera), pabloMock);
    }
	
	
	
	
	
	/*
	 ***Tomo dos participantes con la mayor cobertura y una con mas antigüedad 
	 ***en concesionaria.
	 */
	
	@Test
	public void testCasoMasAntiguoEnConcesionaria(){
		
		analiaMock= laListaDeParticipantes.get(0);
		demianMock=laListaDeParticipantes.get(1);
		pabloMock=laListaDeParticipantes.get(2);
		when(analiaMock.porcentajePago()).thenReturn((double) 50.0);
		when(demianMock.porcentajePago()).thenReturn((double) 70.0);
		when(pabloMock.porcentajePago()).thenReturn((double) 70.0);
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		when(unPlanCualquiera.mayorPorcentajeDePago()).thenReturn((double)70.0);
		when(demianMock.getCliente()).thenReturn(mockCliente1);
		when(pabloMock.getCliente()).thenReturn(mockCliente2);
		when(mockCliente1.getFchIngreso()).thenReturn(fecha1);
		when(mockCliente2.getFchIngreso()).thenReturn(fecha2);
		assertEquals(adjudicacion.adjudicar(unPlanCualquiera), pabloMock);
	}
	
	
	
	
	
	/*
	 *** Tomo tres participantes con igual cobertura, dos de ellas con la misma
	 *** antiguedad en concesionaria, y una con mayor antigüedad en el plan.
	 */
	@Test
	public void testCasoMayorAntiguedadEnPlan() {
		
		analiaMock= laListaDeParticipantes.get(0);
		demianMock=laListaDeParticipantes.get(1);
		pabloMock=laListaDeParticipantes.get(2);
		when(analiaMock.porcentajePago()).thenReturn((double) 70.0);
		when(demianMock.porcentajePago()).thenReturn((double) 70.0);
		when(pabloMock.porcentajePago()).thenReturn((double) 70.0);
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		when(unPlanCualquiera.mayorPorcentajeDePago()).thenReturn((double)70.0);
		when(demianMock.getCliente()).thenReturn(mockCliente1);
		when(pabloMock.getCliente()).thenReturn(mockCliente1);
		when(analiaMock.getCliente()).thenReturn(mockCliente1);
		when(mockCliente1.getFchIngreso()).thenReturn(fecha1);
		when(demianMock.getFchInscripcion()).thenReturn(fecha4);
		when(pabloMock.getFchInscripcion()).thenReturn(fecha3);
		when(analiaMock.getFchInscripcion()).thenReturn(fecha2);
		assertEquals(adjudicacion.adjudicar(unPlanCualquiera), analiaMock);
		
	}
}
