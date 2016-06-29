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
	
	@Test
	public void test_Valores(){
		assertEquals((Integer)100000, modelo.getValor());
		modelo.setValor(50000);
		assertEquals((Integer)50000, modelo.getValor());
	}
	
	@Test
	public void test_getNombre(){
		assertEquals("March",modelo.getNombre());
	}
	
	@Test
	public void test_cambiarEquipamiento(){
		assertEquals(modelo.getEquipamiento(), false);
		modelo.cambiarDeBaseAFull();
		assertEquals(modelo.getEquipamiento(),true);
		modelo.cambiarDeFullABase();
		assertEquals(modelo.getEquipamiento(),false);
		
	}

}
