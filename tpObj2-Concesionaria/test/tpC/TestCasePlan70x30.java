package tpC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class TestCasePlan70x30 {
	Plan70x30 plan;
	@Mock ModeloDeAuto mockAuto;
	
	
	@Before
	public void setUp() throws Exception {
		mockAuto= mock(ModeloDeAuto.class);
		plan= new Plan70x30(10);
	}

	@Test
	public void testValorDeCuota() {
		when(mockAuto.getValor()).thenReturn((Integer) 100000);
		assertEquals(7000,plan.valorDeCuota(mockAuto),0);
	}
	
	@Test
	public void testValorCuotaFinal(){
		when(mockAuto.getValor()).thenReturn((Integer) 100000);
		assertEquals(30000,plan.cuotaFinal(mockAuto),0);
	}

	@Test
	public void testCantidadDeCuotas(){
		assertEquals((Integer)10, plan.cantDeCuotas());
	}
}
