package contextoProblema;

import datos.GestorArchivo;
import interaccionUsuario.Menu;

import java.io.IOException;
import java.util.*;

public class LocalDeComida {

	public static ArrayList<Boleta> boletas=new ArrayList<>();

	public static void nuevaVenta() throws IOException {
		ArrayList<Plato> consumo= agregarPlatos();
		Boleta boleta=crearNuevaBoleta(consumo);
		guardarBoletaEnArchivo("boletas.csv",boleta);
		Menu.mostrarBoleta(boleta);
	}

	public static String mostrarBoletas(){
		String textoBoletas="";
		for( int i=0; i< boletas.size();i++){
			Boleta bolet= boletas.get(i);
			textoBoletas= textoBoletas+ bolet.atexto()+"\n";
		}
		return textoBoletas;
	}

	private static Boleta crearNuevaBoleta(ArrayList<Plato> consumo){
		Boleta boleta=new Boleta();
		boleta.setID(boletas.size()+1);
		boleta.setFecha(Calendar.getInstance());
		boleta.setConsumo(consumo);
		boleta.setTotal(calcularTotal(consumo) );
		boletas.add(boleta);
		return boleta;
	}

	private static void guardarBoletaEnArchivo(String path, Boleta boleta) throws IOException {
		GestorArchivo.guardarBoleta(boleta,"boletas.csv");
	}

	private static ArrayList<Plato> agregarPlatos(){
		ArrayList<Plato> consumo=new ArrayList<>();
		boolean respuesta=false;
		while (!respuesta){
			Plato plato =new Plato(Menu.ingresarTipoPlato());
			consumo.add(plato);
			respuesta=Menu.agregarNuevoProducto();
		}
		return consumo;
	}

	private static double calcularTotal(ArrayList<Plato> consumo) {
		double total = 0;
		Plato plato = new Plato();
		for (int i = 0; i < consumo.size(); i++) {
			plato = consumo.get(i);
			total = total + plato.getPrecio();
		}
		return total;
	}



}