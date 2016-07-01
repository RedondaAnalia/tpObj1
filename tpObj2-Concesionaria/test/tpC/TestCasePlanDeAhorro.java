package tpC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

public class TestCasePlanDeAhorro {
	
	PlanDeAhorro planDeAhorro;
	@Mock PlanDePago mockPago;
	@Mock FormaDeAdjudicacion mockAdj;
	@Mock ModeloDeAuto mockModelo;
	@Mock Participante participante;
	@Mock Participante participante2;

	@Before
	public void setUp() throws Exception {
		mockAdj= mock(FormaDeAdjudicacion.class);
		mockModelo= mock(ModeloDeAuto.class);
		mockPago= mock(PlanDePago.class);
		participante=mock(Participante.class);
		participante2= mock(Participante.class);
		planDeAhorro= new PlanDeAhorro(mockPago, mockAdj, mockModelo);
	}

	@Test
	public void test_InscribirParticipante() {
		assertEquals((Integer) 1, planDeAhorro.inscribirParticipante(participante));
		assertEquals((Integer) 2, planDeAhorro.inscribirParticipante(participante));
		assertEquals((Integer) 2, planDeAhorro.cantDeParticipantes());
	}
	
	@Test
	public void test_CantDeCuotas(){
		when(mockPago.cantDeCuotas()).thenReturn(12);
		assertEquals((Integer) 12, planDeAhorro.cantDeCuotas());
	}
	
	@Test
	public void test_GetSetGrupo(){
		assertEquals((Integer)0, planDeAhorro.getGrupo());
		planDeAhorro.setGrupo(20);
		assertEquals((Integer)20, planDeAhorro.getGrupo());
	}
	
	@Test
	public void test_GetModeloDeAuto(){
		assertEquals(mockModelo,planDeAhorro.getModelo());
	}
	
	@Test
	public void test_GetValorAlicuota(){
		when(mockPago.valorDeCuota(mockModelo)).thenReturn((double)10);
		assertEquals(10, planDeAhorro.valorActualAlicuota(),0);
	}
	
	@Test
	public void test_mayorPorcentajeDePago() throws NoHayParticipantesException{
		when(participante.porcentajePago()).thenReturn(10.0);
		when(participante2.porcentajePago()).thenReturn(50.0);
		planDeAhorro.inscribirParticipante(participante);
		planDeAhorro.inscribirParticipante(participante2);
		assertEquals(50.0, planDeAhorro.mayorPorcentajeDePago(),0);
		
	}
	
	@Test(expected= NoHayParticipantesException.class)
	public void test_ExcepcionEnMayorPorcentaje() throws NoHayParticipantesException{
		planDeAhorro.mayorPorcentajeDePago();
	}
	
	@Test
	public void test_adjudicar() throws NoHayParticipantesException{
		planDeAhorro.adjudicar();
		Mockito.verify(mockAdj,Mockito.times(1)).adjudicar(planDeAhorro);
	}
	
	@Test
	public void test_getParticipantes_getPlanes(){
		assertEquals(mockPago, planDeAhorro.getPlanDePago());
		assertEquals(ArrayList.class, planDeAhorro.getParticipantes().getClass());
	}
	
	
}
