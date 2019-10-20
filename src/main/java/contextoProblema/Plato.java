package contextoProblema;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Plato {

	private TipoPlato tipoPlato;
	private double precio;
	public static double[] precios = {0,0,0,0,0};

	public Plato(){
		this.tipoPlato = ;
		this.precio=0;
	}

	public Plato(TipoPlato tipoPlato,double precio){
		this.tipoPlato = tipoPlato;
		if(tipoPlato==TipoPlato.EMPANADA){this.precio=precios[0];}
		if(tipoPlato==TipoPlato.PAPAS){this.precio=precios[1];}
		if(tipoPlato==TipoPlato.CHURROS){this.precio=precios[2];}
		if(tipoPlato==TipoPlato.PIZZA){this.precio=precios[3];}
		if(tipoPlato==TipoPlato.HUMITA){this.precio=precios[4];}
		else {this.precio=0;}
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