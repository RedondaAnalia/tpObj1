package tpC;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class testCaseConcesionaria {

	private Concesionaria los3Fanaticos;
	private Fabrica peugeot;
	
	@Before	
	public void setUp() throws Exception {
		peugeot = new Fabrica();
		los3Fanaticos= new Concesionaria(peugeot);
	}

	@Test
	public void test() {
		
		
		
	}
	
}
