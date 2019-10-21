package datos;

import contextoProblema.Boleta;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class GestorArchivo {
    private static Scanner scan;
    public static void crearNuevoArchivo(String path){
        if(new File(path).exists()){}
        else{
            try{
                Files.write(Paths.get(path), new String().getBytes());
            }
            catch(IOException e) {}
        }
    }

    public static void guardarBoleta(Boleta boleta, String nombreArchivo) throws IOException {
        
        try (FileWriter file = new FileWriter(nombreArchivo)) {
            file.write(boleta.getID()+","+boleta.getFecha()+","+boleta.ConsumoTostring(boleta.getConsumo())+","+boleta.getTotal());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String LeerArchivo(String nombreArchivo){
        String textoBoleta="";
        while(scan.hasNext()){
            textoBoleta= textoBoleta+scan.nextLine()+"\n";
        }
       return  textoBoleta;
    }
    public static void openFile(){
        try{
            scan = new Scanner(new File("boleta.txt"));
        }
        catch(Exception e){
            System.out.println("No se pudo encontrar le archivo");
        }
    }
    public static void readFile(){
        while(scan.hasNext()){
            System.out.print( scan.nextLine()+"\n");
        }
    }
    public static void writeatext (int sala, int precioEntrada, int combo,int n) {

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("boleta"+n+".txt"));
            out.write("                        Pelicula Sala: "+sala);
            out.close();
        } catch (IOException e) {}
    }



}