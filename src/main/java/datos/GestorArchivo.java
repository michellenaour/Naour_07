package datos;

import contextoProblema.Boleta;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

        String saltoLinea = System.getProperty("line.separator");


        try (FileWriter file = new FileWriter(nombreArchivo)) {
            file.write(boleta.toString());
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



}