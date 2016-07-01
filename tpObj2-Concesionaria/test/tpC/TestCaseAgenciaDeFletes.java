package tpC;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TestCaseAgenciaDeFletes {

	AgenciaDeFletes moveIT;
	@Mock Planta plantaMadrynMock;
	@Mock ModeloDeAuto unModeloMock;
	@Mock Auto lamborginiMock;
	@Mock Concesionaria concesionariaMock;
	
	@Before
	public void setUp() throws Exception {
		moveIT = new AgenciaDeFletes(2, new Coord(23, 234));
		plantaMadrynMock = mock(Planta.class);
		unModeloMock = mock(ModeloDeAuto.class);
		lamborginiMock = mock(Auto.class);
		concesionariaMock = mock(Concesionaria.class);
		
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test1_precioDelViaje() {
		moveIT.setPrecioPorKilometro(75.0);
		assertEquals(7500.0, moveIT.consultarValorDelFlete(100),0);
	}
	@Test
	public synchronized void test2_retirarAutoDeLaPlanta() throws NoHayStockException, NoExisteElModeloDelAutoException{
		when(plantaMadrynMock.getUbicacion()).thenReturn(new Coord(23, 50));
		when(concesionariaMock.getUbicacion()).thenReturn(new Coord(23, 100));
		when(plantaMadrynMock.retirarAutoModelo(unModeloMock)).thenReturn(lamborginiMock);
		
		moveIT.retirarAutoDeLaPlantaenConcesionario(plantaMadrynMock,concesionariaMock, unModeloMock);
		Mockito.verify(concesionariaMock, Mockito.times(1)).entregarAuto(lamborginiMock);
	}
	@Test
	public void test3_retirarAutoDeLaPlanta() throws NoHayStockException, NoExisteElModeloDelAutoException{
		when(plantaMadrynMock.getUbicacion()).thenReturn(new Coord(23, 50));
		when(concesionariaMock.getUbicacion()).thenReturn(new Coord(23, 100));
		when(plantaMadrynMock.retirarAutoModelo(unModeloMock)).thenReturn(lamborginiMock);
		
		moveIT.retirarAutoDeLaPlantaenConcesionario(plantaMadrynMock,concesionariaMock, unModeloMock);
		moveIT.retirarAutoDeLaPlantaenConcesionario(plantaMadrynMock,concesionariaMock, unModeloMock);
		moveIT.retirarAutoDeLaPlantaenConcesionario(plantaMadrynMock,concesionariaMock, unModeloMock);
		moveIT.retirarAutoDeLaPlantaenConcesionario(plantaMadrynMock,concesionariaMock, unModeloMock);
		moveIT.retirarAutoDeLaPlantaenConcesionario(plantaMadrynMock,concesionariaMock, unModeloMock);
		Mockito.verify(concesionariaMock, Mockito.times(5)).entregarAuto(lamborginiMock);
	}
}
