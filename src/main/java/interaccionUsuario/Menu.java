package interaccionUsuario;

import contextoProblema.Boleta;
import contextoProblema.LocalDeComida;
import contextoProblema.Plato;
import contextoProblema.TipoPlato;
import datos.GestorArchivo;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
	static Scanner teclado=new Scanner(System.in);

	public static void PreMenu() throws IOException {
		GestorArchivo.crearNuevoArchivo("boletas.csv");
		EstablecerPrecios();
		menuPrincipal();
	}

	public static void menuPrincipal() throws IOException{
		mostrarMenu();

		int opcion = leerOpcion();
		seleccionMenu(opcion);
	}

	private static void mostrarMenu() {
		System.out.println("\n\n--------------Menu--------------");
		System.out.println("  ( 1 ).  Crear una nueva Boleta (nueva venta)");
		System.out.println("  ( 2 ).  Ver todas las Boletas emitidas");
		System.out.println("  ( 3 ).  Salir");
		System.out.println("  Ingrese una de las opciones anteriores:");
	}

	private static void seleccionMenu(int op) throws IOException {
		switch (op) {
			case 1:
				System.out.println("  ( 1 ).  Crear una nueva Boleta (nueva venta)");
				LocalDeComida.nuevaVenta();
				menuPrincipal();
				break;
			case 2:
				System.out.println("  ( 2 ).  Ver todas las Boletas emitidas");
				mostarBoletasHistoricas();
				menuPrincipal();
				break;
			case 3:
				System.out.println("  ( 3 ).  Salir");
				System.out.println("Que tenga un buen día.");
				break;
			default:
				menuPrincipal();
				break;
		}
	}

	public static TipoPlato ingresarTipoPlato(){
		TipoPlato[] tipos= TipoPlato.values();
		String Tplato="";
		boolean flag = false;
		while (!flag){
		    System.out.println("Ingrese el Plato");
			for(int i=0; i<tipos.length;i++){
				System.out.println("    -."+tipos[i].getTipoPlato());
			}
			Tplato=teclado.next();
			flag=validarTipoPlato(Tplato);
			if (!flag){System.out.println("Error! el plato que ingresó no se encuentra en el menú");}
		}


		for(int i=0; i<tipos.length;i++){
			if(tipos[i].getTipoPlato().equals(Tplato)){
				System.out.println(tipos[i]);
				return tipos[i];
			}
		}

		return null;
	}

	private static boolean validarTipoPlato(String tp){
		TipoPlato[] tipos= TipoPlato.values();
		for(int i=0; i<tipos.length;i++){
			if(tipos[i].getTipoPlato().equals(tp)){return true;}
		}
		return false;
	}

	private static void mostarBoletasHistoricas() {
		System.out.println(LocalDeComida.mostrarBoletas());
	}

	private static int leerOpcion(){
		int opcion=0;
		boolean flag = false;
		while (flag==false){
			opcion=leerInt(" ");
			if(opcion>=1 && opcion<=3){
				flag=true;
			}
			else{System.out.println("error! las opciones diponibles son: 1, 2 y 3");}
		}
		return opcion;
	}

	private static int leerInt(String mensaje){
		int num;
		System.out.println( mensaje);
		do{
			try{
				num=teclado.nextInt();
			}
			catch(InputMismatchException ime){
				System.out.println("error! solo puede ingresar números. \n vuelva a intentar");
				teclado.next();
				num=-1;
			}
		}
		while(num<0);
		return num;
	}

	private static double leerDouble(String txt) {
		System.out.println(txt);
		while (!teclado.hasNextDouble()) {
			System.out.println("Error! debe ingresar un número");
			teclado.nextLine();
		}
		double  number = teclado.nextDouble();
		return number;

	}

	private static void EstablecerPrecios(){
		System.out.println("Antes de empezar las ventas necesita establecer los precios de sus Productos");
		Plato.precios[0]=leerDouble("Ingrese el precio de empanadas");
		Plato.precios[1]=leerDouble("Ingrese el precio de las papas fritas");
		Plato.precios[2]=leerDouble("Ingrese el precio de churros");
		Plato.precios[3]=leerDouble("Ingrese el precio de pizza");
		Plato.precios[4]=leerDouble("Ingrese el precio de Humita");
	}

	public static boolean agregarNuevoProducto(){
	    String respuesta= leerRespuesta();
	    if(respuesta.equals("si")|| respuesta.equals("SI")||respuesta.equals("Si")){
	        return false;
        }
	    return true;
    }

    private static String leerRespuesta(){
	    String res="";
	    boolean flag=false;
	    while (!flag){
	        System.out.println("¿Agregar otro producto? Ingrese si para agregar y no para emitir la boleta. ");
	        res=teclado.next();
	        flag=validarRespuesta(res);
        }
	    return res;
    }

    private static boolean validarRespuesta(String res){
	    if(res.equals("si")||res.equals("SI")||res.equals("Si")||res.equals("NO")||res.equals("no")||res.equals("No")){return  true;}
	    System.out.println("Error! Ingrese valores validos");
	    return false;
    }

    public static void mostrarBoleta(Boleta boleta){System.out.println(boleta.atexto());}
}