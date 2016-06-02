package tpC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCaseCuotasPagas {

	CuotasPagas cuotasPagas;
	
	
	@Before
	public void setUp() throws Exception {
	cuotasPagas = new CuotasPagas(100);
	}

	@Test
	public void test() {
		cuotasPagas.pagar(1, 100);
		cuotasPagas.pagar(2, 100);
		cuotasPagas.pagar(3, 100);
		cuotasPagas.pagar(4, 100);
		cuotasPagas.pagar(5, 100);
		assertTrue(cuotasPagas.porcentajePago()== 5.0);
	}

}
