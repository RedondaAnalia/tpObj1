package tpC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class TestCaseStockConcesionaria {
	
	private Stock stock;
	@Mock private Fabrica fabrica;
	private Concesionaria carOne;
	private Planta planta1;
	private Planta planta2;
	@Mock private ModeloDeAuto fordMustang2pFull;
	@Mock private ModeloDeAuto fordFiesta2pFull;
	int stockDeFordFiesta = 0;
	int stockDeFordMustang = 0;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		stockDeFordFiesta = 0;
		stockDeFordMustang = 0;
		stock = new Stock();
		fabrica = mock(Fabrica.class);
		when(fabrica.getStock()).thenReturn(stock);
		carOne = new Concesionaria(fabrica, new Coord(1, 1));
		planta1 = new Planta(new Coord(1,2), stock);
		planta2 = new Planta(new Coord(2,1), stock);
	}

	@Test
	public void test() {
		planta1.puedeFabricarElModelo(fordFiesta2pFull);
		planta1.puedeFabricarElModelo(fordMustang2pFull);
		planta2.puedeFabricarElModelo(fordFiesta2pFull);
		planta2.puedeFabricarElModelo(fordMustang2pFull);
		planta1.fabricarElModelo(fordFiesta2pFull);
		planta1.fabricarElModelo(fordFiesta2pFull);
		planta2.fabricarElModelo(fordMustang2pFull);
		planta2.fabricarElModelo(fordFiesta2pFull);
		stockDeFordFiesta = planta1.stockDelModelo(fordFiesta2pFull).size() + planta2.stockDelModelo(fordFiesta2pFull).size();
		stockDeFordMustang = planta1.stockDelModelo(fordMustang2pFull).size() + planta2.stockDelModelo(fordMustang2pFull).size();
		assertTrue(carOne.getStockDelModelo(fordFiesta2pFull)== stockDeFordFiesta);
		assertTrue(carOne.getStockDelModelo(fordMustang2pFull)== stockDeFordMustang);
	}

}
