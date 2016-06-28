package tpC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestCaseStock {
	private Stock stock;
	@Mock private ModeloDeAuto fordMustang2pFull;
	@Mock private ModeloDeAuto fordFiesta2pFull;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		stock = new Stock();
		
	}

	@Test
	public void test() throws NoHayStockException {
		stock.incrementarStock(fordFiesta2pFull);
		stock.incrementarStock(fordFiesta2pFull);
		stock.incrementarStock(fordMustang2pFull);
		stock.incrementarStock(fordMustang2pFull);
		stock.decrementarStock(fordFiesta2pFull);
		System.out.println(stock.getStockDelModelo(fordFiesta2pFull));
		System.out.println(stock.getStockDelModelo(fordMustang2pFull));
		assertTrue(stock.getStockDelModelo(fordFiesta2pFull) == 1);
		assertTrue(stock.getStockDelModelo(fordMustang2pFull) == 2);
	}

}
