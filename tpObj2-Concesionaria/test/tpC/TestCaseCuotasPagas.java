package tpC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestCaseCuotasPagas {

	private CuotasPagas cuotasPagas;
	@Mock private ComprobanteDePago unaCuotaPagaMock;
	
	@Before
	public void setUp() throws Exception {
		unaCuotaPagaMock = mock(ComprobanteDePago.class);
		cuotasPagas = new CuotasPagas(100);
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void test1_Pago5CuotasYVeoElPorsentajeDeCuotasPagas() {
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		assertTrue(cuotasPagas.porcentajePago() == 5.0);
		assertFalse(cuotasPagas.porcentajePago() != 5.0);
	}
	
	@Test
	public void test2_Pago6CuotasYVeoCuantasCuotasPagasTengo() {
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		assertTrue(cuotasPagas.getCantCuotasPagas() == 6);
		assertFalse(cuotasPagas.getCantCuotasPagas() != 6);
	}
	
	@Test
	public void test3_Pago4CuotasYPidoListaDePagos() {
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		System.out.println(cuotasPagas.getComprobantesDePago());
	}	
	
}
