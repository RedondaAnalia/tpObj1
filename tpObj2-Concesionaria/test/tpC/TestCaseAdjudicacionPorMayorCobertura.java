package tpC;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.*;

import org.joda.time.*;
import org.junit.Assert;
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
		laListaDeParticipantes.add(analiaMock);
		laListaDeParticipantes.add(demianMock);
		laListaDeParticipantes.add(pabloMock);

		MockitoAnnotations.initMocks(this);
	}
	
	/*
	 **** Testeo el manejo de la excepcion	
	 */
	@Test(expected=NoHayParticipantesException.class)
	public void testManejoDeExcepcionPorListaVacia() throws NoHayParticipantesException{
		when(unPlanCualquiera.getParticipantes()).thenReturn(new ArrayList<Participante>());
		adjudicacion.adjudicar(unPlanCualquiera);
	}
	
	/*
	 **** Testeo el manejo de la excepcion	
	 */
	@Test(expected= NoHayParticipantesException.class)
	public void testManejoDeExcepcionPorNoHayAQuienAdjudicar() throws NoHayParticipantesException{
		when(unPlanCualquiera.cantDeParticipantes()).thenReturn(3);
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		analiaMock= laListaDeParticipantes.get(0);
		demianMock=laListaDeParticipantes.get(1);
		pabloMock=laListaDeParticipantes.get(2);
		when(analiaMock.getCalidadDelParticipante()).thenReturn(new ParticipanteAdjudicado());
		when(demianMock.getCalidadDelParticipante()).thenReturn(new ParticipanteAdjudicado());
		when(pabloMock.getCalidadDelParticipante()).thenReturn(new ParticipanteAdjudicado());
		assertEquals(3, laListaDeParticipantes.size());
		adjudicacion.adjudicar(unPlanCualquiera);
	}

    /*
    ***Tengo un solo un participante con mayor cobertura.
    */
	@Test 
	public void testCasoUnicoMayorCobertura() throws NoHayParticipantesException {
		
		analiaMock= laListaDeParticipantes.get(0);
		demianMock=laListaDeParticipantes.get(1);
		pabloMock=laListaDeParticipantes.get(2);
		when(analiaMock.getCalidadDelParticipante()).thenReturn(new ParticipanteStd());
		when(demianMock.getCalidadDelParticipante()).thenReturn(new ParticipanteStd());
		when(pabloMock.getCalidadDelParticipante()).thenReturn(new ParticipanteStd());
		when(analiaMock.porcentajePago()).thenReturn((double) 50.0);
		when(demianMock.porcentajePago()).thenReturn((double) 60.0);
		when(pabloMock.porcentajePago()).thenReturn((double) 70.0);
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		when(unPlanCualquiera.cantDeParticipantes()).thenReturn(3);
		when(unPlanCualquiera.mayorPorcentajeDePago()).thenReturn((double)70.0);
		assertEquals(adjudicacion.adjudicar(unPlanCualquiera), pabloMock);
    }
	
	
	
	
	
	/*
	 ***Tomo dos participantes con la mayor cobertura y una con mas antigüedad 
	 ***en concesionaria.
	 */
	
	@Test
	public void testCasoMasAntiguoEnConcesionaria() throws NoHayParticipantesException {
		
		analiaMock= laListaDeParticipantes.get(0);
		demianMock=laListaDeParticipantes.get(1);
		pabloMock=laListaDeParticipantes.get(2);
		when(analiaMock.porcentajePago()).thenReturn((double) 50.0);
		when(demianMock.porcentajePago()).thenReturn((double) 70.0);
		when(pabloMock.porcentajePago()).thenReturn((double) 70.0);
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		when(unPlanCualquiera.mayorPorcentajeDePago()).thenReturn((double)70.0);
		when(unPlanCualquiera.cantDeParticipantes()).thenReturn(3);
		when(demianMock.getCliente()).thenReturn(mockCliente1);
		when(pabloMock.getCliente()).thenReturn(mockCliente2);
		when(mockCliente1.getFchIngreso()).thenReturn(fecha1);
		when(mockCliente2.getFchIngreso()).thenReturn(fecha2);
		when(analiaMock.getCalidadDelParticipante()).thenReturn(new ParticipanteStd());
		when(demianMock.getCalidadDelParticipante()).thenReturn(new ParticipanteStd());
		when(pabloMock.getCalidadDelParticipante()).thenReturn(new ParticipanteStd());
		assertEquals(adjudicacion.adjudicar(unPlanCualquiera), pabloMock);
	}
	
	
	
	
	
	/*
	 *** Tomo tres participantes con igual cobertura, dos de ellas con la misma
	 *** antiguedad en concesionaria, y una con mayor antigüedad en el plan.
	 */
	@Test
	public void testCasoMayorAntiguedadEnPlan() throws NoHayParticipantesException {
		
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
		when(unPlanCualquiera.cantDeParticipantes()).thenReturn(3);
		when(demianMock.getFchInscripcion()).thenReturn(fecha4);
		when(pabloMock.getFchInscripcion()).thenReturn(fecha3);
		when(analiaMock.getFchInscripcion()).thenReturn(fecha2);
		when(analiaMock.getCalidadDelParticipante()).thenReturn(new ParticipanteStd());
		when(demianMock.getCalidadDelParticipante()).thenReturn(new ParticipanteStd());
		when(pabloMock.getCalidadDelParticipante()).thenReturn(new ParticipanteStd());
		assertEquals(adjudicacion.adjudicar(unPlanCualquiera), analiaMock);
		
	}
}
