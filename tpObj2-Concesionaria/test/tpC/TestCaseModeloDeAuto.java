package tpC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCaseModeloDeAuto {
	
	ModeloDeAuto modelo;

	@Before
	public void setUp() throws Exception {
		modelo= new ModeloDeAuto("March", 2016, 3, 100000);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test_Valores_modelosBase(){
		assertEquals (modelo.getValor() , (Integer)100000 );
		modelo.setValor(50000);
		assertEquals((Integer)50000 , modelo.getValor());
	}
	
	@Test
	public void test_getNombre(){
		assertEquals("March",modelo.getNombre());
	}
	
	@Test
	public void test_agregarEquipamiento(){
		modelo.agregarAccesorio(new AccesoriosDireccionHidraulica());
		assertEquals(modelo.getListaDeAccesorios().size(), 2);
		
		
	}
	@Test
	public void test_pedirValorAlModeloFull(){
		modelo.agregarAccesorio(new AccesoriosDireccionHidraulica());
		modelo.agregarAccesorio(new AccesosoriosLevantaVidrios());
		modelo.agregarAccesorio(new AccesoriosAireAcondicionado());
		assertEquals(modelo.getValor() , (Integer)106000);
		
		
	}
}
