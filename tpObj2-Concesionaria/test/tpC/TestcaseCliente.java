package tpC;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class TestcaseCliente {
	Cliente cliente;
	PlanDeAhorro mockPlan;
	PlanDeAhorro mockPlan2;
	Participante mockParticipante1;
	Participante mockParticipante2;
	
	@Before
	public void setUp() throws Exception {
		cliente = new Cliente();
		mockPlan = mock(PlanDeAhorro.class);
		mockPlan2 = mock(PlanDeAhorro.class);
		mockParticipante1 = mock(Participante.class);
		mockParticipante2 = mock(Participante.class);
	}

	@Test
	public void test01SuscribirClienteA2PlanDeAhorro() {
		cliente.suscribirPlanDeAhorro (mockPlan);
		cliente.suscribirPlanDeAhorro (mockPlan2);
		assertTrue (cliente.getPlanes().size()==2);
		assertTrue (cliente.getPlanes().contains(mockPlan) &&
				    cliente.getPlanes().contains(mockPlan2));
	}

	@Test
	public void test02AgregarParticipantesAlCliente() {
		cliente.addParticipante(mockParticipante1);
		cliente.addParticipante(mockParticipante2);
		assertTrue (cliente.getParticipantes().size()==2);
		assertTrue (cliente.getParticipantes().contains(mockParticipante1) &&
				    cliente.getParticipantes().contains(mockParticipante2));
	}
	
}
