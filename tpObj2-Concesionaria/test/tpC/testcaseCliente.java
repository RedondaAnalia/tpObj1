package tpC;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class testcaseCliente {
	Cliente cliente;
	PlanDeAhorro mockPlan;
	PlanDeAhorro mockPlan2;

	@Before
	public void setUp() throws Exception {
		cliente=new Cliente();
		mockPlan = mock(PlanDeAhorro.class);
		mockPlan2= mock(PlanDeAhorro.class);
	}

	@Test
	public void testSuscribirPlanDeAhorro() {
		cliente.suscribirPlanDeAhorro (mockPlan);
		assertTrue (cliente.getPlanes().size() == 1);
		cliente.suscribirPlanDeAhorro (mockPlan2);
		assertTrue (cliente.getPlanes().size()==2);
		
	}

}
