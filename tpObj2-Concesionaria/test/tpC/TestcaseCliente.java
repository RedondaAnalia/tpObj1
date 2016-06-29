package tpC;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.joda.time.*;
public class TestcaseCliente {
	Cliente cliente;
	@Mock PlanDeAhorro mockPlan;
	@Mock PlanDeAhorro mockPlan2;
	@Mock Participante mockParticipante1;
	@Mock Participante mockParticipante2;
	@Mock Concesionaria mockConces;
	
	
	@Before
	public void setUp() throws Exception {
		mockConces= mock(Concesionaria.class);
		cliente = new Cliente("Objetos","Juan Carlos",37690389,"Roque Saenz Peña 0","objetosq@juan",21,11,1989,mockConces);
		mockPlan = mock(PlanDeAhorro.class);
		mockPlan2 = mock(PlanDeAhorro.class);
		mockParticipante1 = mock(Participante.class);
		mockParticipante2 = mock(Participante.class);
	}
	
	@Test 
	public void testInicializacionDeVariables(){
		
		assertEquals(cliente.getApellido(),"Objetos");
		assertEquals(cliente.getDireccion(), "Roque Saenz Peña 0");
		assertEquals(cliente.getDNI(),(Integer) 37690389);
		assertEquals(cliente.getFchIngreso(),new LocalDate());
		assertEquals(cliente.getFchNacimiento(), new LocalDate (1989,11,21));
		assertEquals(cliente.getMail(),"objetosq@juan");
		assertEquals(cliente.getNombre(),"Juan Carlos");		
	}
	
	@Test
	public void test01SuscribirClienteA2PlanDeAhorro() {
		cliente.agregarPlanDeAhorro (mockPlan);
		cliente.agregarPlanDeAhorro (mockPlan2);
		assertEquals ((int) 2, cliente.getPlanes().size());
		assertTrue (cliente.getPlanes().contains(mockPlan));
		assertTrue (cliente.getPlanes().contains(mockPlan2));
	}
 
		
	@Test
	public void test03SuscribirClienteA2PlanDeAhorroYPedirParticipaciones() {
		cliente.agregarPlanDeAhorro (mockPlan);
		cliente.agregarPlanDeAhorro (mockPlan2);
		assertEquals((int)2, cliente.getParticipantes().size());
	}
}
