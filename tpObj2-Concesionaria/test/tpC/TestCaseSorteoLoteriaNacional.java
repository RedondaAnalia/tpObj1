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
		assertEquals(Integer.class,sorteo.primerPremio(9).getClass());
	}

}
