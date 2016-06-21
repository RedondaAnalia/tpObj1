package tpC;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TestCaseFabrica {

	private Fabrica ford;
	@Mock private Planta plantaPacheco;
	@Mock private Planta plantaVarela;
	@Mock private Planta plantaPuertoMadryn;
	@Mock private ModeloDeAuto fordFiesta4pFull;
	@Mock private ModeloDeAuto fordFiesta4pBase;
	@Mock private ModeloDeAuto fordMustang2pFull;
	@Mock private ModeloDeAuto fordFiesta2pFull;
	@Mock private ModeloDeAuto fordFocus2pFull;
	@Mock private Auto fiesta4pF;
	@Mock private Auto fiesta4pF2;
	@Mock private Auto fiesta4pF3;
	@Mock private Auto mustang2pF;
	@Mock private Auto mustang2pF2;
	@Mock private Auto mustang2pF3;
	@Mock private Concesionaria los3fanaticos;
	@Mock private Stock stock;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);	
		ford = new Fabrica(stock);
		ford.agregarPlanta(plantaPacheco);
		ford.agregarPlanta(plantaVarela);
		ford.agregarPlanta(plantaPuertoMadryn);
		ford.agregarModelo(fordFiesta2pFull);
		ford.agregarModelo(fordFiesta4pBase);
		ford.agregarModelo(fordFiesta4pFull);
		ford.agregarModelo(fordFocus2pFull);
		ford.agregarModelo(fordMustang2pFull);
		

		LinkedList<Auto> theList = new LinkedList<Auto>();
		when(fiesta4pF.getModelo()).thenReturn(fordFiesta4pFull);
		when(fiesta4pF2.getModelo()).thenReturn(fordFiesta4pFull);
		when(fiesta4pF3.getModelo()).thenReturn(fordFiesta4pFull);
		when(mustang2pF.getModelo()).thenReturn(fordMustang2pFull);
		when(mustang2pF2.getModelo()).thenReturn(fordMustang2pFull);
		when(mustang2pF3.getModelo()).thenReturn(fordMustang2pFull);
		
		LinkedList<Auto> theList1 = new LinkedList<Auto>();
		theList1.add(fiesta4pF);
		theList1.add(fiesta4pF);
		LinkedList<Auto> theList2 = new LinkedList<Auto>();
		theList2.add(fiesta4pF3);
		LinkedList<Auto> theList3 = new LinkedList<Auto>();
		when(plantaPacheco.stockDelModelo(fordFiesta4pFull)).thenReturn(theList1);
		when(plantaVarela.stockDelModelo(fordFiesta4pFull)).thenReturn(theList2);
		when(plantaPuertoMadryn.stockDelModelo(fordFiesta4pFull)).thenReturn(theList3);
		when(los3fanaticos.getUbicacion()).thenReturn(new Coord(1000, 5473));
		when(plantaVarela.getUbicacion()).thenReturn(new Coord(1000, 1473));
		when(plantaPuertoMadryn.getUbicacion()).thenReturn(new Coord(3234, 1473));
		when(plantaPacheco.getUbicacion()).thenReturn(new Coord(900, 5000));
		when(plantaVarela.tieneModelo(fordMustang2pFull)).thenReturn(false);
		when(plantaPuertoMadryn.tieneModelo(fordMustang2pFull)).thenReturn(true);
		when(plantaPacheco.tieneModelo(fordMustang2pFull)).thenReturn(false);
	}

	@Test
	public void test1_buscarStockEnFabricaDeUnfordFiesta4pFull() {
		LinkedList<Auto> listaFiestas = ford.buscarStockEnFabricaDeLaPlanta(plantaPacheco, fordFiesta4pFull);
		assertEquals(listaFiestas.size(), 2);
		
	}
	
	@Test
	public void test2_distanciaEntreUnaFabricaYUnaPlanta() {
		assertTrue(ford.distanciaConcesionariaPlanta(los3fanaticos,plantaVarela)== 4000.00);
	}
	@Test
	public void test3_buscarFabricaMasCercanaQuePuedaFabricarUnModelo() {
		Planta laPlantaMasCercana = ford.plantaMasCercana(los3fanaticos, fordMustang2pFull);
		assertEquals(laPlantaMasCercana, plantaPuertoMadryn);
	}
	@Test
	public void test4_fabricarUnModeloDeAutoDeUnaPlantaCercana() {
		ford.fabricar(los3fanaticos, fordMustang2pFull);
		Mockito.verify(plantaPuertoMadryn, Mockito.times(1)).fabricarElModelo(fordMustang2pFull);
	}
	@Test
	public void test5_cambiamosElValorAUnModelo() {
		ford.cambiarPrecioModelo(fordMustang2pFull, 5000000);
		Mockito.verify(fordMustang2pFull, Mockito.times(1)).setValor(5000000);;
	}
}
