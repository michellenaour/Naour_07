package contextoProblema;

import java.util.*;

public class LocalDeComida {

	ArrayList<Plato> consumo=new ArrayList<>();
	ArrayList<Boleta> boletas=new ArrayList<>();

	public void llenarprecios(){}
	public void nuevaVenta() {
		agregarPlatos();
		Boleta boleta=new Boleta();
		boleta.setFecha(Calendar.getInstance());
		boleta.setTotal(calcularTotal() );
		boleta.setConsumo(consumo);
		boleta.setID(boletas.size()+1);
		boletas.add(boleta);
	}

	public void craerBoleta() {

	}
	private void agregarPlatos(){
		boolean respuesta=false;
		while (!respuesta){
			Plato plato =new Plato();
			plato.setTipoPlato(Menu.in);
			respuesta=SeguirConsumiendo();
		}

	}

	public void mostarBoleta() {

	}

	public double calcularTotal() {
		double total = 0;
		Plato plato = new Plato();
		for (int i = 0; i < consumo.size(); i++) {
			plato = consumo.get(i);
			total = total + plato.getPrecio();
		}
		return total;
	}

	public void operation() {

	}

}