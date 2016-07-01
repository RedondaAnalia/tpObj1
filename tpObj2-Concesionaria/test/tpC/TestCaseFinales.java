package tpC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TestCaseFinales {

	private FormaDeAdjudicacion adjudicacion;
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
	private ModeloDeAuto unModeloDeAuto;
	private ModeloDeAuto modeloTroncomovil;
	private Seguro unSeguro;
	private AdministracionConcesionaria admin;
	private SorteoLoteriaNacional unSorteo;
	private Stock stock;
	private Cliente cliente1;
	private Cliente cliente2;
	private Cliente cliente3;
	private Cliente cliente4;
	private Cliente cliente5;
	private Cliente cliente6;
	private Cliente cliente7;
	private Cliente cliente8;
	private Cliente cliente9;
	private Cliente cliente10;
	private Planta plantaPacheko;
	private Planta plantaPilar;
	private Planta plantaRodrigues;
	private AgenciaDeFletes teloLlevoFletes;
	
	@Before
	public void setUp() throws Exception {
		stock = new Stock();
		fabrica= new Fabrica(stock);
		
		unSeguro= new Seguro(500);
		unSorteo= new SorteoLoteriaNacional();
		
		admin= new AdministracionConcesionaria(350.0, unSeguro);
		adjudicacion= new AdjudicacionPorSorteo(unSorteo);
		pago1= new Plan100x100(6);
		
		unModeloDeAuto= new ModeloDeAuto("fordFiesta", 2016,3,100000);
		modeloTroncomovil = new ModeloDeAuto("unaMierdaDeAuto", 1050, 0, 50);
		
		concesionaria= new Concesionaria(fabrica, new Coord(1,1),admin);
		cliente1= new Cliente("Torres", "Diego", 1234567, "R S Peña 352", "diego.torres@unq.edu.ar ", 7, 1, 1990, concesionaria);
		cliente2= new Cliente("Cano", "Diego", 2345678, "R S Peña 352", "diego.cano@mail.com", 1, 2, 1990, concesionaria);
		cliente3= new Cliente("Vidal", "Nacho", 3456789, "R S Peña 352", "magovidal@gmail.com ", 1, 1, 1990, concesionaria);
		cliente4= new Cliente("Sosa", "Juan", 3456789, "R S Peña 352", "magovidal@gmail.com ", 1, 1, 1990, concesionaria);
		cliente5= new Cliente("Diaz", "Nicolas", 3456789, "R S Peña 352", "magovidal@gmail.com ", 1, 1, 1990, concesionaria);
		cliente6= new Cliente("Balcarce", "Pablo", 3456789, "R S Peña 352", "magovidal@gmail.com ", 1, 1, 1990, concesionaria);
		cliente7= new Cliente("Gonzalez", "Gustavo", 3456789, "R S Peña 352", "magovidal@gmail.com ", 1, 1, 1990, concesionaria);
		cliente8= new Cliente("Perez", "Gabriel", 3456789, "R S Peña 352", "magovidal@gmail.com ", 1, 1, 1990, concesionaria);
		cliente9= new Cliente("Hanks", "Alejandro", 3456789, "R S Peña 352", "magovidal@gmail.com ", 1, 1, 1990, concesionaria);
		cliente10= new Cliente("Perez", "Alfredo", 3456789, "R S Peña 352", "magovidal@gmail.com ", 1, 1, 1990, concesionaria);
		plan1= new PlanDeAhorro(pago1,adjudicacion,unModeloDeAuto);
		plan2= new PlanDeAhorro(pago1,adjudicacion,unModeloDeAuto);
		plan3= new PlanDeAhorro(pago1,adjudicacion,unModeloDeAuto);
		plan4= new PlanDeAhorro(pago1,adjudicacion,unModeloDeAuto);
		plan5= new PlanDeAhorro(pago1,adjudicacion,unModeloDeAuto);
		plan6= new PlanDeAhorro(pago1,adjudicacion,unModeloDeAuto);
		plan7= new PlanDeAhorro(pago1,adjudicacion,unModeloDeAuto);
		plan8= new PlanDeAhorro(pago1,adjudicacion,unModeloDeAuto);
		plan9= new PlanDeAhorro(pago1,adjudicacion,unModeloDeAuto);
		plan10= new PlanDeAhorro(pago1,adjudicacion,unModeloDeAuto);
		plan11= new PlanDeAhorro(pago1,adjudicacion,unModeloDeAuto);
		
		plantaPacheko = new Planta(new Coord(10,10), stock);
		plantaPacheko.puedeFabricarElModelo(unModeloDeAuto);
		plantaPilar = new Planta(new Coord(10,50), stock);
		plantaPilar.puedeFabricarElModelo(unModeloDeAuto);
		plantaPilar.puedeFabricarElModelo(modeloTroncomovil);
		plantaRodrigues = new Planta(new Coord(10,70), stock);
		plantaRodrigues.puedeFabricarElModelo(unModeloDeAuto);
		plantaRodrigues.puedeFabricarElModelo(modeloTroncomovil);
		
		fabrica.agregarPlanta(plantaPacheko);
		fabrica.agregarPlanta(plantaPilar);
		fabrica.agregarPlanta(plantaRodrigues);
		
		teloLlevoFletes = new AgenciaDeFletes(2, new Coord(10, 1));
		
		admin.setFlete(teloLlevoFletes);
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
		concesionaria.agregarClienteAlPlan(cliente1, plan1);
		concesionaria.agregarClienteAlPlan(cliente2, plan1);
		concesionaria.agregarClienteAlPlan(cliente3, plan1);
		concesionaria.agregarClienteAlPlan(cliente4, plan1);
		concesionaria.agregarClienteAlPlan(cliente5, plan1);
		concesionaria.agregarClienteAlPlan(cliente6, plan1);
		concesionaria.agregarClienteAlPlan(cliente7, plan1);
		concesionaria.agregarClienteAlPlan(cliente8, plan1);
		concesionaria.agregarClienteAlPlan(cliente9, plan1);
		concesionaria.agregarClienteAlPlan(cliente10, plan1);
		//Agrego 9 participantes al plan 2
		concesionaria.agregarClienteAlPlan(cliente1, plan2);
		concesionaria.agregarClienteAlPlan(cliente2, plan2);
		concesionaria.agregarClienteAlPlan(cliente3, plan2);
		concesionaria.agregarClienteAlPlan(cliente4, plan2);
		concesionaria.agregarClienteAlPlan(cliente5, plan2);
		concesionaria.agregarClienteAlPlan(cliente6, plan2);
		concesionaria.agregarClienteAlPlan(cliente7, plan2);
		concesionaria.agregarClienteAlPlan(cliente8, plan2);
		concesionaria.agregarClienteAlPlan(cliente9, plan2);
		//Agrego 8 participantes al plan 4
		concesionaria.agregarClienteAlPlan(cliente1, plan4);
		concesionaria.agregarClienteAlPlan(cliente2, plan4);
		concesionaria.agregarClienteAlPlan(cliente3, plan4);
		concesionaria.agregarClienteAlPlan(cliente4, plan4);
		concesionaria.agregarClienteAlPlan(cliente5, plan4);
		concesionaria.agregarClienteAlPlan(cliente6, plan4);
		concesionaria.agregarClienteAlPlan(cliente7, plan4);
		concesionaria.agregarClienteAlPlan(cliente8, plan4);
		//Agrego 7 participantes al plan 3
		concesionaria.agregarClienteAlPlan(cliente1, plan3);
		concesionaria.agregarClienteAlPlan(cliente2, plan3);
		concesionaria.agregarClienteAlPlan(cliente3, plan3);
		concesionaria.agregarClienteAlPlan(cliente4, plan3);
		concesionaria.agregarClienteAlPlan(cliente5, plan3);
		concesionaria.agregarClienteAlPlan(cliente6, plan3);
		concesionaria.agregarClienteAlPlan(cliente7, plan3);
		//Agrego 6 participantes al plan 6
		concesionaria.agregarClienteAlPlan(cliente1, plan6);
		concesionaria.agregarClienteAlPlan(cliente2, plan6);
		concesionaria.agregarClienteAlPlan(cliente3, plan6);
		concesionaria.agregarClienteAlPlan(cliente4, plan6);
		concesionaria.agregarClienteAlPlan(cliente5, plan6);
		concesionaria.agregarClienteAlPlan(cliente6, plan6);
		//Agrego 5 participantes al plan 5
		concesionaria.agregarClienteAlPlan(cliente1, plan5);
		concesionaria.agregarClienteAlPlan(cliente2, plan5);
		concesionaria.agregarClienteAlPlan(cliente3, plan5);
		concesionaria.agregarClienteAlPlan(cliente4, plan5);
		concesionaria.agregarClienteAlPlan(cliente5, plan5);
		//Agrego 4 participantes al plan 7
		concesionaria.agregarClienteAlPlan(cliente1, plan7);
		concesionaria.agregarClienteAlPlan(cliente2, plan7);
		concesionaria.agregarClienteAlPlan(cliente3, plan7);
		concesionaria.agregarClienteAlPlan(cliente4, plan7);
		//Agrego 3 participantes al plan 8
		concesionaria.agregarClienteAlPlan(cliente1, plan8);
		concesionaria.agregarClienteAlPlan(cliente2, plan8);
		concesionaria.agregarClienteAlPlan(cliente3, plan8);
		//Agrego 2 participantes al plan 9
		concesionaria.agregarClienteAlPlan(cliente1, plan9);
		concesionaria.agregarClienteAlPlan(cliente2, plan9);
		//Agrego 1 participante al plan 11
		concesionaria.agregarClienteAlPlan(cliente1, plan11);
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
	
	@Test
	public void test02EjecutarAdjudicaciones() throws NoHayParticipantesException {
		concesionaria.agregarPlan(plan1);
		concesionaria.agregarClienteAlPlan(cliente1, plan1);
		concesionaria.agregarClienteAlPlan(cliente2, plan1);
		concesionaria.agregarClienteAlPlan(cliente3, plan1);
		concesionaria.agregarClienteAlPlan(cliente4, plan1);
		concesionaria.agregarClienteAlPlan(cliente5, plan1);
		concesionaria.agregarClienteAlPlan(cliente6, plan1);
		concesionaria.agregarClienteAlPlan(cliente7, plan1);
		concesionaria.agregarClienteAlPlan(cliente8, plan1);
		concesionaria.agregarClienteAlPlan(cliente9, plan1);
		concesionaria.agregarClienteAlPlan(cliente10, plan1);
		concesionaria.adjudicar(plan1);
		
	}

	@Test
	public void test03InformacionDeStockLocal_vs_Plantas() {
		plantaPacheko.fabricarElModelo(unModeloDeAuto); 	//1
		plantaPacheko.fabricarElModelo(unModeloDeAuto);		//2
		plantaPacheko.fabricarElModelo(unModeloDeAuto);		//3
		plantaPilar.fabricarElModelo(unModeloDeAuto);		//4
		plantaPilar.fabricarElModelo(unModeloDeAuto);		//5
		plantaPilar.fabricarElModelo(modeloTroncomovil);		//a
		plantaPilar.fabricarElModelo(unModeloDeAuto);		//6
		plantaPilar.fabricarElModelo(unModeloDeAuto);		//7
		plantaPilar.fabricarElModelo(unModeloDeAuto);		//8
		plantaPilar.fabricarElModelo(modeloTroncomovil);		//b
		plantaPilar.fabricarElModelo(unModeloDeAuto);		//9
		plantaRodrigues.fabricarElModelo(unModeloDeAuto);	//10
		plantaRodrigues.fabricarElModelo(modeloTroncomovil); //c
		assertEquals(concesionaria.getStockDelModelo(unModeloDeAuto),(Integer) 10);
		assertEquals(concesionaria.getStockDelModelo(modeloTroncomovil),(Integer) 3);

	}
	/*
	@Test
	public void test04EfectuarPagosDeCuotas() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void test05RegistrarCuponesDeAdjudicacion() {
		fail("Not yet implemented");
	}
}
