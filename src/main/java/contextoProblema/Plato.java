package contextoProblema;

import java.util.ArrayList;

public class Plato {

	private TipoPlato tipoPlato;
	private double precio;
	private double[] precios = {0,0,0,0,0};

	public Plato(){
	}

	public Plato(TipoPlato tipoPlato){
		this.tipoPlato = tipoPlato;
		this.precio =precio;

	}

	public TipoPlato getTipoPlato() {
		return tipoPlato;
	}

	public void setTipoPlato(TipoPlato tipoPlato) {
		this.tipoPlato = tipoPlato;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}



}