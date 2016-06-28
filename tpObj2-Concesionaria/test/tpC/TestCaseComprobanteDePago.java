package tpC;

import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class TestCaseComprobanteDePago {

	ComprobanteDePago ticketPago;
	@Mock Participante demian;
	@Mock Cuota unaCuota;

	@Before
	public void setUp() throws Exception {
		
		demian = mock(Participante.class);
		unaCuota = mock(Cuota.class);
		when(unaCuota.getNroCuota()).thenReturn(3);
		when(unaCuota.getValorAlicuota()).thenReturn(1800.0);
		when(unaCuota.getCargoAdministrativo()).thenReturn(800.0);
		when(unaCuota.getCargoSeguro()).thenReturn(750.0);
		
		ticketPago = new ComprobanteDePago(unaCuota);
		
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
	public void test01FechaDePago() {
		assertEquals(LocalDate.class, ticketPago.fchPago.getClass());
	}
	
}
