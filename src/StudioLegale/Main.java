package StudioLegale;

import Cliente.Cliente;
import conciliazione.Conciliazione;
import prog.utili.Data;
import tribunale.*;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Civile c1 = new Civile(3.7, new Cliente("Marco", "Zonca"), "Risarcimento",1,new Data(), new Data("22.06.2019"), Grado_di_giudizio.APPELLO );
		Civile c2 = new Civile(5.6, new Cliente("Luca", "Rossi"), "Risarcimento",1,new Data(),new Data("22.07.2019"), Grado_di_giudizio.APPELLO );
		Civile c3 = new Civile(10.3, new Cliente("Pan", "Bauletto"), "Risarcimento",1,new Data(), new Data("25.05.2019"), Grado_di_giudizio.APPELLO );
		Penale p1 = new Penale(47,new Cliente("Vittorio", "Sgarbi"),"Diffamazioni",1,new Data(), new Data("23.10.2019"), Grado_di_giudizio.APPELLO);
		Conciliazione co1 = new Conciliazione(12.40, new Cliente("Paolo", "Brosio"), "Bestemmie in luogo pubblico", new Data(), new Data("06.06.2019"));
		Conciliazione co2 = new Conciliazione(12.40, new Cliente("Pablo", "Picasso"), "Dipinti rubati", new Data(), new Data("06.06.2019"));
		Civile c4 = new Civile(15.18, new Cliente("Luca", "Giurato"), "Mangiato troppi dolci",1,new Data(), new Data("25.05.2019"), Grado_di_giudizio.CASSAZIONE );
		c4.setArchiviata();
		
		Studio studio_del_prof_nullazzo = new Studio();
		
		studio_del_prof_nullazzo.add(c1);
		studio_del_prof_nullazzo.add(c2);
		studio_del_prof_nullazzo.add(c3);
		studio_del_prof_nullazzo.add(c4);
		studio_del_prof_nullazzo.add(p1);
		studio_del_prof_nullazzo.add(co1);
		studio_del_prof_nullazzo.add(co2);
		
		System.out.println("stampa in base al costo : ");
		studio_del_prof_nullazzo.printOrdinaCosto();
		System.out.println("ora la stampa in base alla priorità : ");
		studio_del_prof_nullazzo.printOrdinaPriority();
		System.out.println("Esistono pratiche archiviate ? ");
		studio_del_prof_nullazzo.printArchiviatebyCosto();
		System.out.println("End");
	}
}
