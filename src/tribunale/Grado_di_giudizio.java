package tribunale;

public enum Grado_di_giudizio {

	PRIMO(1), APPELLO(2), CASSAZIONE(3);
	
	private int tipo_grado;
	
	private Grado_di_giudizio(int g) {
		this.tipo_grado=g;
	}
	
	protected int getGrado() {
		return tipo_grado;
	}
	
}
