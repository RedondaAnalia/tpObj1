package tpC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCaseAgenciaDeFletes {

	AgenciaDeFletes moveIT;
	
	@Before
	public void setUp() throws Exception {
		moveIT = new AgenciaDeFletes();
	}

	@Test
	public void test() {
		moveIT.setPrecioPorKilometro(75.0);
		assertEquals(7500.0, moveIT.consultarValorDelFlete(100),0);
	}

}
