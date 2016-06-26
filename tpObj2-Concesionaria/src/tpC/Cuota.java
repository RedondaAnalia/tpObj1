package tpC;

public class Cuota {
	private Integer nroCuota;
	private double valorAlicuota;
	private double cargoSeguro;
	private double cargoAdministrativo;
	
	public Cuota(Integer nroCta, double alic, double seg, double admin){
		nroCuota = nroCta;
		valorAlicuota = alic;
		cargoAdministrativo = admin;
		cargoSeguro = seg;
	}

	/**
	 * @return the nroCuota
	 */
	public Integer getNroCuota() {
		return nroCuota;
	}

	/**
	 * @return the valorAlicuota
	 */
	public double getValorAlicuota() {
		return valorAlicuota;
	}

	/**
	 * @return the cargoSeguro
	 */
	public double getCargoSeguro() {
		return cargoSeguro;
	}

	/**
	 * @return the cargoAdministrativo
	 */
	public double getCargoAdministrativo() {
		return cargoAdministrativo;
	}
	
	
}
