package interaccionUsuario;

import contextoProblema.LocalDeComida;
import contextoProblema.TipoPlato;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
	static Scanner teclado=new Scanner(System.in);

	public void menuPrincipal() {
		EstablecerPrecios();
		mostrarMenu();
		int opcion = leerOpcion();
		seleccionMenu(opcion);
	}

	public void mostrarMenu() {

	}

	public void IngresarPrecios() {

	}

	public void seleccionMenu(int op) {
		switch (op) {
			case 1:

				menuPrincipal();
				break;
			case 2:

				menuPrincipal();
				break;
			case 3:

				menuPrincipal();
				break;
			case 4:
				System.out.println("Que tenga un buen día.");
				break;
			default:
				menuPrincipal();
				break;
		}
	}

	public void nuevaVenta() {

	}

	public String  ingresarTipoPlato(){

	}

	public void mostarBoletasHistoricas() {
		for( int i=0; i< LocalDeComida.boletas.size();i++){
			String path = "boleta"+ i+".csv";

		}
	}

	private static int leerOpcion(){
		int opcion=0;
		boolean flag = false;

		while (flag==false){
			opcion=leerInt(" ");
			if(opcion>=1 && opcion<=4){
				flag=true;
			}
			else{System.out.println("error! las opciones diponibles son: 1, 2, 3 y 4");}
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
	private static double[] EstablecerPrecios(){
		double[] precios = new double[5];
		System.out.println("Antes de empezar las ventas necesita establecer los precios de sus Productos");
		precios[0]=leerDouble("Ingrese el precio de empanadas");
		precios[1]=leerDouble("Ingrese el precio de papas fritas");
		precios[2]=leerDouble("Ingrese el precio de churros ");
		precios[3]=leerDouble("Ingrese el precio de pizza");
		precios[4]=leerDouble("Ingrese el precio de humitas");

		return EstablecerPrecios();
	}
}