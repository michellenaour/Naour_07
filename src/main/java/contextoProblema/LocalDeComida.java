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
		guardarBoletaEnArchivo(boleta.getArchivo(),boleta);
		mostarBoleta(boleta.getArchivo());
	}

	public static String mostrarBoletas(){
		String textoBoletas="";
		for( int i=0; i< boletas.size();i++){
			Boleta bolet= boletas.get(i);
			textoBoletas= textoBoletas+ mostarBoleta(bolet.getArchivo()+"\n");
		}
		return textoBoletas;
	}

	private Boleta crearNuevaBoleta(ArrayList<Plato> consumo){
		Boleta boleta=new Boleta();
		boleta.setID(boletas.size()+1);
		boleta.setFecha(Calendar.getInstance());
		boleta.setConsumo(consumo);
		boleta.setTotal(calcularTotal(consumo) );
		boleta.setArchivo(crearNuevoPath(boleta.getID()));
		boletas.add(boleta);
		return boleta;
	}

	private void guardarBoletaEnArchivo(String path, Boleta boleta) throws IOException {
		GestorArchivo.crearNuevoArchivo(boleta.getArchivo());
		GestorArchivo.guardarBoleta(boleta,boleta.getArchivo());
	}

	private String crearNuevoPath(int ID){
		return "boleta"+ID+".csv";
	}

	private ArrayList<Plato> agregarPlatos(){
		ArrayList<Plato> consumo=new ArrayList<>();
		boolean respuesta=false;
		while (!respuesta){
			Plato plato =new Plato();
			plato.setTipoPlato(Menu.ingresarTipoPlatp());
			plato.setPrecio(hacerAlgoAca);
			respuesta=SeguirConsumiendo();
		}
		return consumo;
	}

	private static String mostarBoleta(String path) {
		return GestorArchivo.LeerArchivo(path);
	}

	private double calcularTotal(ArrayList<Plato> consumo) {
		double total = 0;
		Plato plato = new Plato();
		for (int i = 0; i < consumo.size(); i++) {
			plato = consumo.get(i);
			total = total + plato.getPrecio();
		}
		return total;
	}



}