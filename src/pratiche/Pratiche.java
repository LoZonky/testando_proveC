package pratiche;

import java.util.Random;

import Cliente.Cliente;
import conciliazione.Conciliazione;
import prog.utili.Data;
import prog.utili.Sequenza;
import prog.utili.SequenzaOrdinata;
import tribunale.Tribunale;

public class Pratiche implements Comparable<Pratiche>{
	// impostazione di una stringa contenente l'alfebeto + numeri da utilizzare per la creazione di un ID univoco
	private static final String char_list="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	// imposto la lunghezza dell'ID di 10 elementi
	private static final int ID_length=10;
	// forse random a non serve...
	//Random a= new Random();
	protected static  Sequenza<String> list_ID = new Sequenza<String>();
	
	
	// CAMPI 
	private String ID;
	protected double num_ore;
	protected Cliente client;
	protected String description;
	protected Data date_udienza;   // Ovvero la data di fine 
	protected Stato state;
	protected int priority;  // Data_inizio - Data_fine 
	
	
	// COSTRUTTORI 
	public Pratiche () {}
	
	protected Pratiche (double h, Cliente c, String d, Data di, Data df) throws Exception {
		// Per ottenere una stringa ID univoca randomica
		StringBuffer randomString = new StringBuffer();
		for(int i=0; i<ID_length;i++) {
			int n= getRandomNumber();
			char ch=char_list.charAt(n);
			randomString.append(ch);
		}
		this.ID=randomString.toString();
		if (list_ID.isEmpty()) list_ID.add(this.ID);
		else if (list_ID.contains(this.ID)) throw new Exception("ID già presente");  // Errore: NullPointerException
		else list_ID.add(this.ID);
		
		this.num_ore=h;
		this.client=c;
		this.description=d;
		this.date_udienza=df;
			// Quando viene creata una pratica in automatico va messa a stato = IN CORSO
		this.state=Stato.INCORSO;  
			// Calcolo la priorità della pratica
		int X = di.quantoManca(df);
		if(X<0) this.priority=0;
		else this.priority = X;
		// TODO stato e data 
		
	}
	
	
	// METODI 
	
		// Per ottenere un numero variabile per selezionare una lettera dell'alfabeto + numeri
	private int getRandomNumber() {
		int n=0;
		Random randomGenerator=new Random();
		n = randomGenerator.nextInt(char_list.length());
		if(n-1==-1) {
			return n;
		}else {
			return n-1;
		}
	}

		// Comparatore tra pratiche
	public int compareTo(Pratiche p) {
		if (this.priority>p.priority) return 1;
		else if (this.priority<p.priority) return -1;
		else return 0;
	}

	public double getCosto() throws Exception {
		// Verifico che l'elemento che richieda il costo sia di tipo:
		// Tribunale(Civile e Penale) oppure Conciliazione
		if (this instanceof Tribunale) {
			Tribunale t= (Tribunale)this;
			return ((double)t.getGradoGiudizio())*(100.00*t.num_ore);
			
		}else if(this instanceof Conciliazione) {
			Conciliazione c = (Conciliazione)this;
			return 120.00*c.num_ore;
		}else {
			throw new Exception("Pratica non conforme! ");
		}
	}
	
	public String toString() {
		try {
			return "ID: "+this.ID+" | Cliente: "+this.client.toString()+" - prezzo: "+this.getCosto()+" - priorità: "+this.priority;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ID;
	}
	
	public boolean isArchiviata() {
		return this.state==Stato.ARCHIVIATA;
	}
		// Metodi per cambiare lo stato della pratica in:
		// > Archiviata
	public void setArchiviata() {
		this.state=Stato.ARCHIVIATA;
		this.priority=1000;
	}
		// > Chiusa
	public void setChiusa() {
		this.state=Stato.CHIUSA;
		this.priority=1000;
	}
		// > In corso (richiedo una nuova data d'inizio e di fine, così da ricalcolare la priorità)
	public void setInCorso(Data di, Data df) {
		this.state=Stato.INCORSO;
		resetPriority(di, df);
	}
	
	private void resetPriority(Data di, Data df) {
		this.priority=di.quantoManca(df);
	}
	
	public String getID() {
		return this.ID;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public Stato getState() {
		return this.state;
	}
	
}// END CLASS PRATICHE
