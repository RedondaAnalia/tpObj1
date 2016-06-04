package tpC;

import java.util.Random;

public class SorteoLoteriaNacional {

	public Integer primerPremio(Integer entero) {
		Random rnd=new Random();
		return (int) (rnd.nextDouble() * entero);

	}
}
