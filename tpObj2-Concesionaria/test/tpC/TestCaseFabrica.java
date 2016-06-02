package tpC;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
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
	
		ford = new Fabrica(stock);
		ford.agregarPlanta(plantaPacheco);
		//ford.agregarPlanta(plantaVarela);
		//ford.agregarPlanta(plantaPuertoMadryn);
		MockitoAnnotations.initMocks(this);	
		LinkedList<Auto> theList = new LinkedList<Auto>();
		when(fiesta4pF.getModelo()).thenReturn(fordFiesta4pFull);
		when(fiesta4pF2.getModelo()).thenReturn(fordFiesta4pFull);
		when(fiesta4pF3.getModelo()).thenReturn(fordFiesta4pFull);
		when(mustang2pF.getModelo()).thenReturn(fordMustang2pFull);
		when(mustang2pF2.getModelo()).thenReturn(fordMustang2pFull);
		when(mustang2pF3.getModelo()).thenReturn(fordMustang2pFull);
		LinkedList<Auto> theList1 = new LinkedList<Auto>();
		theList1.add(fiesta4pF);
		LinkedList<Auto> theList2 = new LinkedList<Auto>();
		theList2.add(fiesta4pF3);
		LinkedList<Auto> theList3 = new LinkedList<Auto>();
		when(plantaPacheco.stockDelModelo(fordFiesta4pFull)).thenReturn(theList1);
		when(plantaVarela.stockDelModelo(fordFiesta4pFull)).thenReturn(theList2);
		when(plantaPuertoMadryn.stockDelModelo(fordFiesta4pFull)).thenReturn(theList3);
		
	}

	
	@Test
	public void test1_() {
		
		LinkedList<Auto> listaDeAutos = ford.buscarStockEnFabricaDe(plantaPacheco, fordFiesta4pFull);
		assertTrue(listaDeAutos.size() == 1);
		assertTrue(listaDeAutos.get(0) == fiesta4pF);
	}
	
	@Test
	public void test2_buscarPlantaMasCercanaConModeloYFabricar() {
		
		
	}

}
