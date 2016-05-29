package tpC;

import java.util.Date;

public class Auto {
	private ModeloDeAuto modelo;
	private Date categoria;
	
	public Auto(ModeloDeAuto modelo){
		this.setModelo(modelo);
		this.setCategoria(new Date());
	}

	public Date getCategoria() {
		return categoria;
	}

	public void setCategoria(Date categoria) {
		this.categoria = categoria;
	}

	public ModeloDeAuto getModelo() {
		return modelo;
	}

	public void setModelo(ModeloDeAuto modelo) {
		this.modelo = modelo;
	}
}

