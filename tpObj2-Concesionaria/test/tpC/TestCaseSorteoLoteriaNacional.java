package tpC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCaseSorteoLoteriaNacional {
	SorteoLoteriaNacional sorteo;

	@Before
	public void setUp() throws Exception {
		sorteo=new SorteoLoteriaNacional();
	}

	@Test
	public void test() {
		assertTrue(0 <= sorteo.primerPremio(10));
		assertTrue(sorteo.primerPremio(10)<=10);
		
	}

}
