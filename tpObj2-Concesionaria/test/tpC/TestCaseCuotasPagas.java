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
		assertEquals(5, cuotasPagas.porcentajePago(),0);
	}
	
	@Test
	public void test2_Pago6CuotasYVeoCuantasCuotasPagasTengo() {
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		assertEquals(6,cuotasPagas.getCantCuotasPagas(),0);
	}
	
	@Test
	public void test3_Pago4CuotasYPidoListaDePagos() {
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		cuotasPagas.pagar(unaCuotaPagaMock);
		assertEquals(4,cuotasPagas.getComprobantesDePago().size());
	}	
	
}
