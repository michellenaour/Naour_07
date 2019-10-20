package contextoProblema;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Plato {

	private TipoPlato tipoPlato;
	private double precio;

	public Plato(){
	}

	public Plato(TipoPlato tipoPlato,double precio){
		this.tipoPlato = tipoPlato;
		this.precio=precio;
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