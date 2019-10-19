package contextoProblema;

import datos.GestorArchivo;
import interaccionUsuario.Menu;

import java.io.IOException;
import java.util.*;

public class LocalDeComida {

	private ArrayList<Plato> consumo=new ArrayList<>();
	public static ArrayList<Boleta> boletas=new ArrayList<>();

	public void llenarprecios(){}

	public void nuevaVenta() throws IOException {
		agregarPlatos();
		Boleta boleta=new Boleta();
		boleta.setFecha(Calendar.getInstance());
		boleta.setTotal(calcularTotal() );
		boleta.setConsumo(consumo);
		boleta.setID(boletas.size()+1);
		boletas.add(boleta);
		GestorArchivo.crearNuevoArchivo(boleta.getArchivo());
		GestorArchivo.guardarBoleta(boleta,boleta.getArchivo());
	}

	private void agregarPlatos(){
		boolean respuesta=false;
		while (!respuesta){
			Plato plato =new Plato();
			plato.setTipoPlato(Menu.ingresarTipoPlatp());
			respuesta=SeguirConsumiendo();
		}

	}

	public String mostarBoleta(String path) {
		return GestorArchivo.LeerArchivo(path);
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

	public void mostrarBoletas(){

		for( int i=0; i< LocalDeComida.boletas.size();i++){
			String path = "boleta"+ (i+1)+".csv";
			GestorArchivo.LeerArchivo(path);
		}
	}

}