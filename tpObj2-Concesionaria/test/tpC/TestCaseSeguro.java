package tpC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCaseSeguro {

	
	private Seguro contraTodoRiesgo;

	@Before
	public void setUp() throws Exception {
		contraTodoRiesgo = new Seguro(1800,"Rivadavia Seguros");
	}

	@Test
	public void test() {
		assertTrue(contraTodoRiesgo.gastos() == 1800);
		assertTrue(contraTodoRiesgo.getNombreCompania() == "Rivadavia Seguros");
	}

}
