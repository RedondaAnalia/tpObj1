package tpC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class TestCasePlan70x30 {
	PlanDePago plan;
	ModeloDeAuto auto;
	
	
	@Before
	public void setUp() throws Exception {
		auto= mock(ModeloDeAuto.class);
		plan= new Plan70x30(10);
	}

	@Test
	public void testValorDeCuota() {
		when(auto.getValor()).thenReturn(100000);
		assertTrue(plan.valorDeCuota(auto)==10000);
	}

}
