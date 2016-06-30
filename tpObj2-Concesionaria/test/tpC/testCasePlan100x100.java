package tpC;

import static org.junit.Assert.*; 
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class testCasePlan100x100 {

	@Mock ModeloDeAuto mockAuto;
	Plan100x100 plan;
	
	@Before
	public void setUp() throws Exception {
		plan= new Plan100x100(12);
		mockAuto= mock(ModeloDeAuto.class);
	}

	@Test
	public void testValorCuota() {
		when(mockAuto.getValor()).thenReturn((Integer) 120000);
		assertEquals(10000, plan.valorDeCuota(mockAuto),0);
		;
	}
	
	@Test
	public void testValorCuotaFinal(){
		assertEquals(0, plan.cuotaFinal(mockAuto),0);
	}
	
	@Test
	public void testCantDeCuotas(){
		assertEquals((Integer)12,plan.cantDeCuotas());
	}

}
