package tpC;

public class Cuota {
	private Participante participante;
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
 * @param Participante 
 * @return Cuota
 */
	
	public Cuota(Integer numeroDeCuota, double alicuota, double valorSeguro, double gastosAdministrativos, Participante unParticipante){
		nroCuota = numeroDeCuota;
		valorAlicuota = alicuota;
		cargoAdministrativo = gastosAdministrativos;
		cargoSeguro = valorSeguro;
		participante = unParticipante;		
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

/**
 * Propósito: calcula el monto a pagar de la cuota
 * @return double
 */
	public double montoAPagar() {
		return cargoAdministrativo + cargoSeguro + valorAlicuota;
	}
	
	
}
