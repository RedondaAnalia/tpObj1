package tpC;

import java.util.Random;

public class SorteoLoteriaNacional {

	public Integer primerPremio(Integer entero) {
		Random rnd=new Random();
		return (int) (rnd.nextDouble() * entero);

	}


public static void main (String[] args){
	SorteoLoteriaNacional sorteo= new SorteoLoteriaNacional();
	System.out.println(sorteo.primerPremio(3));
	}
}