package pratiche;

public enum Stato {
	
	INCORSO("In corso"), CHIUSA("Chiusa"), ARCHIVIATA("Archiviata");

	String tipoStato;
	
	
	private Stato(String s) {
		this.tipoStato=s;
	}
	
	public String getStato() {
		return this.tipoStato;
	}
}
