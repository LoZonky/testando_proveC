package StudioLegale;

import java.util.ArrayList;
import java.util.Arrays;

import Cliente.Cliente;
import pratiche.Pratiche;
import pratiche.Stato;
import prog.utili.Data;
import prog.utili.SequenzaOrdinata;
import tribunale.Penale;

public class Studio {
	
	ArrayList<Pratiche> lista_pratiche=new ArrayList<Pratiche>();
	static final int MAX_PRIORITA = 1000;
	
	
	
	// METODI
	
	
	// INSERIMENTO
	
	public void add(Pratiche p) throws Exception{
			// Controllo che nella lista delle pratiche non ci sia una con l'identico ID
		for(Pratiche x: lista_pratiche) {
			if((p.getID().equals(x.getID()))) {
					// Se trovo una pratica con lo stesso ID lancio una eccezione
				throw new Exception("Errore: pratica già esistente!"); 
			}
		}
		lista_pratiche.add(p); // inserimento della pratica nella lista
	}
	
	
	// I VARI PRINT 
	
	// print in base al costo
	public void printOrdinaCosto()throws Exception {
		
		ArrayList<Pratiche> X= new ArrayList<Pratiche>();
		X=this.lista_pratiche;
		Pratiche[] a = X.toArray(new Pratiche[X.size()]);
		pintBubble(a, true);
	}
	
	// print in base alla priorità
	public void printOrdinaPriority() throws Exception {
		
		ArrayList<Pratiche> X= new ArrayList<Pratiche>();
		X=this.lista_pratiche;
		Pratiche[] a = X.toArray(new Pratiche[X.size()]);
		pintBubble(a, false);
	}

	public void printArchiviatebyCosto() throws Exception {
		ArrayList<Pratiche> X= new ArrayList<Pratiche>();
		X=this.lista_pratiche;
		// rimuove glie elementi che verificano la condizione : (n.getState() !=Stato.ARCHIVIATA)
		// Ovvero le pratiche che non sono ARCHIVIATE
		X.removeIf(n -> (n.getState() !=Stato.ARCHIVIATA));

		Pratiche[] a = X.toArray(new Pratiche[X.size()]);
		pintBubble(a, true);
	}
	
	// print per solo le Pratiche Archiviate
	
	/*
	 * @param b, indica per scegliere se stampare con priorità oppure in base al costo
	 * 			 di base si stampa in base alla priorità della pratica, altrimenti mi interesso 
	 * 			 del loro costo
	 */
	private void pintBubble(Pratiche []X, boolean b) throws Exception {
		boolean scambiato = false;
		Pratiche temp;
		do {
			scambiato=false;
			// b ? ordinamento in base al costo  :  ordinamento in base alla priorità 
			for(int i=0; i<X.length-1; i++) {
				if (b ? X[i].getCosto()>X[i+1].getCosto() :  X[i].getPriority()>X[i+1].getPriority()) {
					temp=X[i];
					X[i]=X[i+1];
					X[i+1]=temp;
					scambiato=true;
				}
			}
		}while(scambiato);
		for(int i=0; i<X.length;i++) {
		System.out.println(X[i].toString());
		}
	}
	
}
