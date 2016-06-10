package tpC;


import java.util.Date;
import org.joda.time.*;;

public class Auto {
	private ModeloDeAuto modelo;
	private LocalDate categoria;
	
	public Auto(ModeloDeAuto modelo){
		this.setModelo(modelo);
		this.setCategoria(new LocalDate());
	}

	public LocalDate getCategoria() {
		return categoria;
	}

	public void setCategoria(LocalDate categoria) {
		this.categoria = categoria;
	}

	public ModeloDeAuto getModelo() {
		return modelo;
	}

	public void setModelo(ModeloDeAuto modelo) {
		this.modelo = modelo;
	}
}

