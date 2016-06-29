package tpC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCaseSeguro {
	private Seguro leMeridian;
	
	@Before
	public void setUp() throws Exception {
	leMeridian = new Seguro(850.0);
	}

	@Test
	public void test1() {
		assertEquals(leMeridian.cuotaSeguro(), 850, 0.0);
	}
	
	@Test
	public void test2_ModificarValorDelSeguro() {
		leMeridian.setValorSeguro(250.0);
		assertEquals(leMeridian.cuotaSeguro(), 250, 0.0);
	}

}
