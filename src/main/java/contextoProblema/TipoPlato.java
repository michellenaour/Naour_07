package contextoProblema;

public enum TipoPlato {
	EMPANADA("Empanada"),
	PAPAS("Papas fritas"),
	CHURROS("Churros"),
	PIZZA("Pizza"),
	HUMITA("Humita");

	private final String tipoPlato;

	TipoPlato(String tipoPlato){this.tipoPlato=tipoPlato;}

	public String getTipoPlato(){return tipoPlato;}
}