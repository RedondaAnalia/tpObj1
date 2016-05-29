package tpC;

import java.util.ArrayList;
import java.util.HashMap;

public class Fabrica {

	private HashMap<ModeloDeAuto, Planta> modelosPorPlanta;
	
	public void agregarModeloAPlanta(ModeloDeAuto modelo, Planta planta) {
		this.modelosPorPlanta.put(modelo, planta);
	}	
	
	public Auto pedirModelo(ModeloDeAuto modelo){
		Planta planta = this.modelosPorPlanta.get(modelo);
		return planta.retirarAutoModelo(modelo);
	}
	public Planta pedirPlantaConElModelo()
}
