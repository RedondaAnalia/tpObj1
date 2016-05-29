package tpC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class TestCaseFabrica {

	private Fabrica ford;
	@Mock private Planta plantaPacheco;
	@Mock private Planta plantaVarela;
	@Mock private Planta plantaPuertoMadryn;

	@Before
	public void setUp() throws Exception {
		ford = new Fabrica();
		ford.agregarPlanta(plantaPacheco);
		ford.agregarPlanta(plantaVarela);
		ford.agregarPlanta(plantaPuertoMadryn);
	}

	@Test
	public void test1_() {
		
		assertTrue(stockDelAutoMustang.size() == 1);
		
	}

}
