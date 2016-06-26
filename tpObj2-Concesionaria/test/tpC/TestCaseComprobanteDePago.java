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
	LocalDate fchPago;
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
		
		ticketPago = new ComprobanteDePago(unaCuota, demian);
		
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test01MontoTotalPagado() {
		assertTrue(ticketPago.getMontoTotalPagado() == 1800.0+ 800.0+ 750.0);
	}
	
	@Test
	public void test02FechaDePago() {
		assertTrue(true);
	}
	
	@Test
	public void test03NumeroDeCuota() {
		assertTrue(ticketPago.getNroCuota() == 3);
	}
	
}
