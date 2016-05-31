package tpC;

import static org.junit.Assert.*; 
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class testCasePlan100x100 {

	ModeloDeAuto auto;
	Plan100x100 plan;
	
	@Before
	public void setUp() throws Exception {
		plan= new Plan100x100(12);
		auto= mock(ModeloDeAuto.class);
	}

	@Test
	public void testValorCuota() {
		when(auto.getValor()).thenReturn(120000);
		assertTrue(plan.valorDeCuota(auto)== 10000);
		;
	}

}
