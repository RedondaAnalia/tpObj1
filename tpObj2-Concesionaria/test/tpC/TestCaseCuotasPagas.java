package tpC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCaseCuotasPagas {

	CuotasPagas cuotasPagas;
	
	
	@Before
	public void setUp() throws Exception {
	cuotasPagas = new CuotasPagas(100);
	}

	@Test
	public void test1_Pago5CuotasYVeoElPorsentajeDeCuotasPagas() {
		cuotasPagas.pagar(1, 100);
		cuotasPagas.pagar(2, 100);
		cuotasPagas.pagar(3, 100);
		cuotasPagas.pagar(4, 100);
		cuotasPagas.pagar(5, 100);
		assertTrue(cuotasPagas.porcentajePago() == 5.0);
	}
	
	@Test
	public void test2_Pago5CuotasYVeoCuantasCuotasPagasTengo() {
		cuotasPagas.pagar(1, 100);
		cuotasPagas.pagar(2, 100);
		cuotasPagas.pagar(3, 100);
		cuotasPagas.pagar(4, 100);
		cuotasPagas.pagar(5, 100);
		assertTrue(cuotasPagas.getCantCuotasPagas() == 5);
	}
	/* No segui trabajando... me dijeron que hay que cambiar toda la clase :'(
	@Test
	public void test3_Pago5CuotasYVeoCuantosComprobantesDePagoTengo() {
		cuotasPagas.pagar(1, 100);
		cuotasPagas.pagar(2, 100);
		cuotasPagas.pagar(3, 100);
		cuotasPagas.pagar(4, 100);
		cuotasPagas.pagar(5, 100);
		System.out.println(cuotasPagas.getComprobantesDePago());
		Cuota[] listaDeComprobantes = cuotasPagas.getComprobantesDePago();
		for comprobante in listaDeComprobantes
		assertTrue( == 5);
	}	
	*/
}
