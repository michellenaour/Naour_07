package contextoProblema;

import java.util.ArrayList;
import java.util.Calendar;

public class Boleta {
	private Calendar fecha;
	private int ID;
	private double total;
	private ArrayList<Plato> consumo;


	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Plato> getConsumo() {
		return consumo;
	}

	public String ConsumoTostring(ArrayList<Plato> consumo){
		String t="";
		for (int i=0; i<consumo.size();i++){
			t=t+consumo.get(i).getTipoPlato();;
		}
		return t;
	}
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setConsumo(ArrayList<Plato> consumo) {
		this.consumo = consumo;
	}

	public Boleta() {
		this.fecha=Calendar.getInstance();
		this.ID=0;
		this.total=0;
		this.consumo = new ArrayList<Plato>();
	}

	/**
	 * 
	 * @param fecha
	 * @param ID
	 * @param total
	 */
	public Boleta(Calendar fecha, int ID, int total, ArrayList<Plato> consumo) {
		this.fecha=fecha;
		this.ID=ID;
		this.total=total;
		this.consumo = consumo;
	}

	public String atexto(){
		String textoBoleta="";
		textoBoleta=textoBoleta+("------------Comida Rapida Doña Juanita--------- \n ");
		textoBoleta=textoBoleta+("     Av. Los Aromos 01123, Padre Las Casas.\n");
		textoBoleta=textoBoleta+( "    "+ fecha.getTime()+"\n");
		textoBoleta=textoBoleta+("         numero de Boleta:    "+ID);
		textoBoleta=textoBoleta+("\n--------------------Consumo--------------------");
		textoBoleta=textoBoleta+("\n"+consumoToString() );
		textoBoleta=textoBoleta+("\n            -------------------Total: "+total );
		return 	textoBoleta;
	}

	private String consumoToString(){
		String consumoStr="";
		Plato plato=new Plato();
		for (int i=0; i<consumo.size();i++){
			plato=consumo.get(i);
			consumoStr=consumoStr+("   "+plato.getTipoPlato().toString());
			for (int j=0; j<35-plato.getTipoPlato().toString().length();j++){
				consumoStr=consumoStr+("-");
			}
			consumoStr=consumoStr+(plato.getPrecio()+ "\n");
		}
		return consumoStr;
	}


}