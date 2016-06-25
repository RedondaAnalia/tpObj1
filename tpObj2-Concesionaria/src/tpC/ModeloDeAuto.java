package tpC;


import java.util.Date;

public class ModeloDeAuto {
	private String nombre;
	private Date añoLanzamientoAlMercado;
	private Integer cantidadDePuertas;
	private AccesorioEquipamiento tipoAccesorio;
	private Integer valor;
	
	public Integer getValor(){
		return this.valor;
	}

	public void setValor(int i) {
		valor = i;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
