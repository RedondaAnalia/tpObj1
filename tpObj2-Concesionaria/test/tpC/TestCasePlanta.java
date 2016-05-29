package tpC;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestCasePlanta {

private Planta myPlanta;
@Mock private ModeloDeAuto fordFiesta4pFull;
@Mock private ModeloDeAuto fordMustang2pFull;
@Mock private Auto unAuto;
@Mock private Auto otroAuto;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);	
		myPlanta = new Planta();
		myPlanta.puedeFabricarElModelo(fordMustang2pFull);
		myPlanta.puedeFabricarElModelo(fordFiesta4pFull);
		when(unAuto.getModelo()).thenReturn(fordFiesta4pFull);
		when(otroAuto.getModelo()).thenReturn(fordMustang2pFull);
		
	}

	@Test
	public void test1_ConsultoStockDeUnModelo(){

		assertTrue(myPlanta.stockDelModelo(fordFiesta4pFull).size() == 0);

	}

	@Test
	public void test2_fabricoUnAutoYConsultoStock() {
		myPlanta.autoFabricado(unAuto);
		LinkedList<Auto> stockDelAuto = myPlanta.stockDelModelo(fordFiesta4pFull);
		assertTrue(stockDelAuto.size() == 1);
	}
	@Test
	public void test3_fabrico2AutosOtros2AutosIgualesYConsultoStock(){
		myPlanta.autoFabricado(unAuto);
		myPlanta.autoFabricado(unAuto);
		LinkedList<Auto> stockDelAuto = myPlanta.stockDelModelo(fordFiesta4pFull);
		assertTrue(stockDelAuto.size() == 2);
	}
	@Test
	public void test4_fabrico2AutosOtros2AutosIgualesYOtroAutoYConsultoStock(){
		myPlanta.autoFabricado(unAuto);
		myPlanta.autoFabricado(unAuto);
		myPlanta.autoFabricado(otroAuto);
		LinkedList<Auto> stockDelAutoFiesta = myPlanta.stockDelModelo(fordFiesta4pFull);
		LinkedList<Auto> stockDelAutoMustang = myPlanta.stockDelModelo(fordMustang2pFull);
		assertTrue(stockDelAutoFiesta.size() == 2);
		assertTrue(stockDelAutoMustang.size() == 1);
	}
	@Test
	public void test5_retirarAutoFiestaConsultarStock(){
		myPlanta.autoFabricado(unAuto);
		myPlanta.autoFabricado(unAuto);
		myPlanta.autoFabricado(otroAuto);
		LinkedList<Auto> stockDelAutoFiesta = myPlanta.stockDelModelo(fordFiesta4pFull);
		LinkedList<Auto> stockDelAutoMustang = myPlanta.stockDelModelo(fordMustang2pFull);
		Auto autoRetirado = myPlanta.retirarAutoModelo(fordFiesta4pFull);
		assertTrue(stockDelAutoFiesta.size() == 1);
		assertTrue(stockDelAutoMustang.size() == 1);
		assertTrue(autoRetirado == unAuto);
	}
	
}
