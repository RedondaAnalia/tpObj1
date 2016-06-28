package tpC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class TestCaseCuota {

	Cuota cuota;
	@Mock Participante mockP;
	
	@Before
	public void setUp() throws Exception {
		mockP= mock(Participante.class);
		cuota= new Cuota(2,10,10,10,mockP);
	}

	@Test
	public void test1_ConstructorYGetters() {
		assertEquals((Integer)2,cuota.getNroCuota());
		assertEquals(10, cuota.getCargoAdministrativo(),0);
		assertEquals(10, cuota.getCargoSeguro(),0);
		assertEquals(10, cuota.getValorAlicuota(),0);
	}
	
	@Test
	public void test2_MontoAPagar(){
		assertEquals(30, cuota.montoAPagar(),0);
	}

}
