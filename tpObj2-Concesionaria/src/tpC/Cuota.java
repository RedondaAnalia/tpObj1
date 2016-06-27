package tpC;
// me parece que cuota deberia conocer al participante al que se le genera la cuota...
// y quizas hasta a la concesionaria a la cual se le va a acreditar ese pago...
public class Cuota {
	private Integer nroCuota;
	private double valorAlicuota;
	private double cargoSeguro;
	private double cargoAdministrativo;
	
	/**
	 * 
	 * @param Integer (número de la Cuota)
	 * @param double (valor de la alicuota)
	 * @param double (valor del seguro)
	 * @param double (valor del cargo administrativo)
	 */
	
	public Cuota(Integer nroCta, double alic, double seg, double admin){
		nroCuota = nroCta;
		valorAlicuota = alic;
		cargoAdministrativo = admin;
		cargoSeguro = seg;
	}

	/**
	 * Propósito: Retorna el numero de cuota
	 * @return Integer
	 */
	public Integer getNroCuota() {
		return nroCuota;
	}

	/**
	 * Propósito: Retorna el valor de la alicuota del auto
	 * @return double
	 */
	public double getValorAlicuota() {
		return valorAlicuota;
	}

	/**
	 * Propósito: Retorna el valor del costo del seguro
	 * @return double
	 */
	public double getCargoSeguro() {
		return cargoSeguro;
	}

	/**
	 * Propósito: Retorna el valor del costo administrativo
	 * @return double
	 */
	public double getCargoAdministrativo() {
		return cargoAdministrativo;
	}
	
	
}
