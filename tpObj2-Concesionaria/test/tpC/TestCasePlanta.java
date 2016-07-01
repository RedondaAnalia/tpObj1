package tpC;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TestCasePlanta {

private Planta myPlanta;
@Mock private ModeloDeAuto fordFiesta4pFull;
@Mock private ModeloDeAuto fordMustang2pFull;
@Mock private Auto unAuto;
@Mock private Auto otroAuto;
@Mock private Stock observerStock;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		myPlanta = new Planta(new Coord(10,10), observerStock);
		when(unAuto.getModelo()).thenReturn(fordFiesta4pFull);
		when(otroAuto.getModelo()).thenReturn(fordMustang2pFull);
		
	}

	@Test
	public void test1_ConsultarDistanciaAOtroPunto(){
		Coord newCoord = new Coord(10,20);
		assertEquals(10, myPlanta.getUbicacion().distance(newCoord),0);
	}
	
	@Test
	public void test2_agregarModeloYpreguntarSiPuedeFabricar(){
		myPlanta = new Planta(new Coord(10,10), observerStock);
		assertFalse(myPlanta.tieneModelo(fordMustang2pFull));
		assertTrue(myPlanta.tieneModelo(fordFiesta4pFull));
	}
	
	@Test
	public void test3_fabricarUnAuto(){
		myPlanta.puedeFabricarElModelo(fordFiesta4pFull);
		myPlanta.fabricarElModelo(fordFiesta4pFull);
		Mockito.verify(observerStock, Mockito.times(1)).incrementarStock(fordFiesta4pFull);
		 
	}
	
	@Test(expected= NoExisteElModeloDelAutoException.class)
	public void test4_testeoDeCapturaDeExcepcion() throws NoExisteElModeloDelAutoException,NoHayStockException{
		myPlanta.puedeFabricarElModelo(fordFiesta4pFull);
		myPlanta.retirarAutoModelo(fordFiesta4pFull);
	}
	 
	@Test
	public void test5_retirarAuto()throws NoHayStockException,NoExisteElModeloDelAutoException{
		myPlanta.puedeFabricarElModelo(fordFiesta4pFull);
		myPlanta.fabricarElModelo(fordFiesta4pFull);
		myPlanta.fabricarElModelo(fordFiesta4pFull);
		myPlanta.retirarAutoModelo(fordFiesta4pFull);
		assertEquals((Integer)1,myPlanta.cantDeAutosDelModelo(fordFiesta4pFull));
		
	}
}
