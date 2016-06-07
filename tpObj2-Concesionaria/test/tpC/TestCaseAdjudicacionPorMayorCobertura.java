package tpC;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
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
	private Date fecha1;
	private Date fecha2;
	private Date fecha3;
	private Date fecha4;
	private ArrayList<Participante> laListaDeParticipantes;
	@Mock private Cliente mockCliente1;
	@Mock private Cliente mockCliente2;
	
	
	@Before
	public void setUp() throws Exception {
		analiaMock = mock(Participante.class);
		demianMock = mock(Participante.class);
		pabloMock = mock(Participante.class);
		unPlanCualquiera = mock(PlanDeAhorro.class);
		fecha1= new Date(2000, 01, 01);
		fecha2=new Date(1990,01,01);
		fecha3=new Date(1993,01,01);
		fecha4=new Date(1994,01,01);
		mockCliente1= mock(Cliente.class);
		mockCliente2= mock(Cliente.class);
		
		adjudicacion = new AdjudicacionPorMayorCobertura();
		laListaDeParticipantes = new ArrayList<Participante>();
		laListaDeParticipantes.add(analiaMock);
		laListaDeParticipantes.add(demianMock);
		laListaDeParticipantes.add(pabloMock);
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCasoUnicoMayorCobertura() {
		System.out.println(":::::::::Test Caso Mayor Cobertura solo con Eval de cobertura::::::::");		
		System.out.println("Esta es la lista de Participantes: " + laListaDeParticipantes);
		analiaMock= laListaDeParticipantes.get(0);
		demianMock=laListaDeParticipantes.get(1);
		pabloMock=laListaDeParticipantes.get(2);
		when(analiaMock.porcentajePago()).thenReturn((double) 50.0);
		when(demianMock.porcentajePago()).thenReturn((double) 60.0);
		when(pabloMock.porcentajePago()).thenReturn((double) 70.0);
		System.out.println("Codigo de Analia " + analiaMock.hashCode());
		System.out.println("Codigo de Pablo "+ pabloMock.hashCode());
		System.out.println("Codigo de Damian "+ demianMock.hashCode());
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		when(unPlanCualquiera.mayorPorcentajeDePago()).thenReturn((double)70.0);
		System.out.println("Adjudico a: " + adjudicacion.adjudicar(unPlanCualquiera));
		assertEquals(adjudicacion.adjudicar(unPlanCualquiera), pabloMock);
    }
	
	@Test
	public void testCasoMasAntiguoEnConcesionaria(){
		
		System.out.println(":::::::::Test Caso Mayor Cobertura con Eval de Antiguedad en Concesionaria::::::::");		
		System.out.println("Esta es la lista de Participantes: " + laListaDeParticipantes);
		analiaMock= laListaDeParticipantes.get(0);
		demianMock=laListaDeParticipantes.get(1);
		pabloMock=laListaDeParticipantes.get(2);
		when(analiaMock.porcentajePago()).thenReturn((double) 50.0);
		when(demianMock.porcentajePago()).thenReturn((double) 70.0);
		when(pabloMock.porcentajePago()).thenReturn((double) 70.0);
		System.out.println("Codigo de Analia " + analiaMock.hashCode());
		System.out.println("Codigo de Pablo "+ pabloMock.hashCode());
		System.out.println("Codigo de Damian "+ demianMock.hashCode());
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		when(unPlanCualquiera.mayorPorcentajeDePago()).thenReturn((double)70.0);
		when(demianMock.getCliente()).thenReturn(mockCliente1);
		when(pabloMock.getCliente()).thenReturn(mockCliente2);
		when(mockCliente1.getFchIngreso()).thenReturn(fecha1);
		when(mockCliente2.getFchIngreso()).thenReturn(fecha2);
		System.out.println("Adjudico a: " + adjudicacion.adjudicar(unPlanCualquiera));
		assertEquals(adjudicacion.adjudicar(unPlanCualquiera), pabloMock);
	}
	
	@Test
	public void testCasoMayorAntiguedadEnPlan() {
		System.out.println(":::::::::Test Caso Mayor Cobertura con Eval de Antiguedad en Plan::::::::");		
		System.out.println("Esta es la lista de Participantes: " + laListaDeParticipantes);
		analiaMock= laListaDeParticipantes.get(0);
		demianMock=laListaDeParticipantes.get(1);
		pabloMock=laListaDeParticipantes.get(2);
		when(analiaMock.porcentajePago()).thenReturn((double) 70.0);
		when(demianMock.porcentajePago()).thenReturn((double) 70.0);
		when(pabloMock.porcentajePago()).thenReturn((double) 70.0);
		System.out.println("Codigo de Analia " + analiaMock.hashCode());
		System.out.println("Codigo de Pablo "+ pabloMock.hashCode());
		System.out.println("Codigo de Damian "+ demianMock.hashCode());
		when(unPlanCualquiera.getParticipantes()).thenReturn(laListaDeParticipantes);
		when(unPlanCualquiera.mayorPorcentajeDePago()).thenReturn((double)70.0);
		when(demianMock.getCliente()).thenReturn(mockCliente1);
		when(pabloMock.getCliente()).thenReturn(mockCliente1);
		when(analiaMock.getCliente()).thenReturn(mockCliente1);
		when(mockCliente1.getFchIngreso()).thenReturn(fecha1);
		when(demianMock.getFchInscripcion()).thenReturn(fecha4);
		when(pabloMock.getFchInscripcion()).thenReturn(fecha3);
		when(analiaMock.getFchInscripcion()).thenReturn(fecha2);
		System.out.println("Adjudico a: " + adjudicacion.adjudicar(unPlanCualquiera));
		assertEquals(adjudicacion.adjudicar(unPlanCualquiera), analiaMock);
		
	}
}
