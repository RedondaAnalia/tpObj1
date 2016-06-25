package tpC;


import java.util.Date;

public class ModeloDeAuto {
	private String nombre;
	private Date añoLanzamientoAlMercado;
	private Integer cantidadDePuertas;
	private Boolean full=false; // en falso es base, en verdadero es full
	private Integer valor;
	
	public Integer getValor(){
		return this.valor;
	}

	public void setValor(int i) {
		valor = i;
	}

	public void cambiarDeBaseAFull(){
		full = true;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
