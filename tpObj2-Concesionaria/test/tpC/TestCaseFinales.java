package tpC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TestCaseFinales {

	private Concesionaria concesionaria;
	private Fabrica fabrica;
	private Participante parti1;
	private Participante parti2;
	private Participante parti3;
	private Participante parti4;
	private Participante parti5;
	private Participante parti6;
	private Participante parti7;
	private Participante parti8;
	private Participante parti9;
	private Participante parti10;
	private PlanDeAhorro plan1;
	private PlanDeAhorro plan2;
	private PlanDeAhorro plan3;
	private PlanDeAhorro plan4;
	private PlanDeAhorro plan5;
	private PlanDeAhorro plan6;
	private PlanDeAhorro plan7;
	private PlanDeAhorro plan8;
	private PlanDeAhorro plan9;
	private PlanDeAhorro plan10;
	private PlanDeAhorro plan11;
	private Plan100x100 pago1;
	

	@Before
	public void setUp() throws Exception {
		fabrica= mock (Fabrica.class);
		concesionaria= new Concesionaria(fabrica, new Coord(1,1) );
		parti1= mock(Participante.class);
		parti2= mock(Participante.class);
		parti3= mock(Participante.class);
		parti4= mock(Participante.class);
		parti5= mock(Participante.class);
		parti6= mock(Participante.class);
		parti7= mock(Participante.class);
		parti8= mock(Participante.class);
		parti9= mock(Participante.class);
		parti10= mock(Participante.class);
		pago1= new Plan100x100(6);
		plan1= new PlanDeAhorro(pago1);
		plan2= new PlanDeAhorro(pago1);
		plan3= new PlanDeAhorro(pago1);
		plan4= new PlanDeAhorro(pago1);
		plan5= new PlanDeAhorro(pago1);
		plan6= new PlanDeAhorro(pago1);
		plan7= new PlanDeAhorro(pago1);
		plan8= new PlanDeAhorro(pago1);
		plan9= new PlanDeAhorro(pago1);
		plan10= new PlanDeAhorro(pago1);
		plan11= new PlanDeAhorro(pago1);
		
	}

	@Test
	public void test01ConocerLos10PlanesConMayorCantidadDeSuscriptosDeMayorAMenor() {
		concesionaria.agregarPlan(plan1);
		concesionaria.agregarPlan(plan2);
		concesionaria.agregarPlan(plan3);
		concesionaria.agregarPlan(plan4);
		concesionaria.agregarPlan(plan5);
		concesionaria.agregarPlan(plan6);
		concesionaria.agregarPlan(plan7);
		concesionaria.agregarPlan(plan8);
		concesionaria.agregarPlan(plan9);
		concesionaria.agregarPlan(plan10);
		concesionaria.agregarPlan(plan11);
		//Agrego 10 participantes al plan 1
		plan1.inscribirParticipante(parti1);
		plan1.inscribirParticipante(parti2);
		plan1.inscribirParticipante(parti3);
		plan1.inscribirParticipante(parti4);
		plan1.inscribirParticipante(parti5);
		plan1.inscribirParticipante(parti6);
		plan1.inscribirParticipante(parti7);
		plan1.inscribirParticipante(parti8);
		plan1.inscribirParticipante(parti9);
		plan1.inscribirParticipante(parti10);
		//agrego 9 participantes al plan 2
		plan2.inscribirParticipante(parti1);
		plan2.inscribirParticipante(parti2);
		plan2.inscribirParticipante(parti3);
		plan2.inscribirParticipante(parti4);
		plan2.inscribirParticipante(parti5);
		plan2.inscribirParticipante(parti6);
		plan2.inscribirParticipante(parti7);
		plan2.inscribirParticipante(parti8);
		plan2.inscribirParticipante(parti9);
		//Agrego 8 participantes al plan 4
		plan4.inscribirParticipante(parti1);
		plan4.inscribirParticipante(parti2);
		plan4.inscribirParticipante(parti3);
		plan4.inscribirParticipante(parti4);
		plan4.inscribirParticipante(parti5);
		plan4.inscribirParticipante(parti6);
		plan4.inscribirParticipante(parti7);
		plan4.inscribirParticipante(parti8);
		//Agreso 7 participantes al plan 3
		plan3.inscribirParticipante(parti1);
		plan3.inscribirParticipante(parti2);
		plan3.inscribirParticipante(parti3);
		plan3.inscribirParticipante(parti4);
		plan3.inscribirParticipante(parti5);
		plan3.inscribirParticipante(parti6);
		plan3.inscribirParticipante(parti7);
		//Agrego 6 participantes al plan 6
		plan6.inscribirParticipante(parti1);
		plan6.inscribirParticipante(parti2);
		plan6.inscribirParticipante(parti3);
		plan6.inscribirParticipante(parti4);
		plan6.inscribirParticipante(parti5);
		plan6.inscribirParticipante(parti6);
		//Agrego 5 participantes al plan 5
		plan5.inscribirParticipante(parti1);
		plan5.inscribirParticipante(parti2);
		plan5.inscribirParticipante(parti3);
		plan5.inscribirParticipante(parti4);
		plan5.inscribirParticipante(parti5);
		//Agrego 4 participantes al plan 7
		plan7.inscribirParticipante(parti1);
		plan7.inscribirParticipante(parti2);
		plan7.inscribirParticipante(parti3);
		plan7.inscribirParticipante(parti4);
		//Agrego 3 participantes al plan 8
		plan8.inscribirParticipante(parti1);
		plan8.inscribirParticipante(parti2);
		plan8.inscribirParticipante(parti3);
		//Agrego 2 participantes al plan 9
		plan9.inscribirParticipante(parti10);
		plan9.inscribirParticipante(parti3);
		//Agrego 1 participante al plan 11
		plan11.inscribirParticipante(parti7);
		assertEquals(concesionaria.topTenPlanesSuscriptos().get(0), plan1);
		assertEquals(concesionaria.topTenPlanesSuscriptos().get(1), plan2);
		assertEquals(concesionaria.topTenPlanesSuscriptos().get(2), plan4);
		assertEquals(concesionaria.topTenPlanesSuscriptos().get(3), plan3);
		assertEquals(concesionaria.topTenPlanesSuscriptos().get(4), plan6);
		assertEquals(concesionaria.topTenPlanesSuscriptos().get(5), plan5);
		assertEquals(concesionaria.topTenPlanesSuscriptos().get(6), plan7);
		assertEquals(concesionaria.topTenPlanesSuscriptos().get(7), plan8);
		assertEquals(concesionaria.topTenPlanesSuscriptos().get(8), plan9);
		assertEquals(concesionaria.topTenPlanesSuscriptos().get(9), plan11);
	}
	
/*	@Test
	public void test02EjecutarAdjudicaciones() {
		fail("Not yet implemented");
	}

	@Test
	public void test03AsegurarStockLocalDeModelosCoincideConStockDePlantas() {
		fail("Not yet implemented");
	}
*/
}

