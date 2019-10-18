package main;

import contextoProblema.Boleta;
import contextoProblema.Plato;
import contextoProblema.TipoPlato;

import java.util.ArrayList;
import java.util.Calendar;

public class Main {
    public static void main(String[]args){
        Plato plato1=new Plato(TipoPlato.PIZZA,2000);
        Plato plato2=new Plato(TipoPlato.EMPANADA,1000);
        ArrayList<Plato> cons= new ArrayList<>();
        cons.add(plato1);
        cons.add(plato2 );
        Boleta boleta=new Boleta();
        boleta.setTotal(3000);
        boleta.setFecha(Calendar.getInstance());
        boleta.setConsumo(cons);
        boleta.setID(1);
        System.out.println(boleta.atexto());


    }
}