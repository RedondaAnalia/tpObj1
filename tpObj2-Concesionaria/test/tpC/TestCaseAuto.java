package tpC;

import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class TestCaseAuto {

	private Auto auto;
	@Mock ModeloDeAuto mockModelo;
	
	@Before
	public void setUp() throws Exception {
		auto=new Auto(mockModelo);
	}

	@Test
	public void test_GetModelo() {
		assertEquals((Integer) 2016, auto.getCategoria());
	}

}
