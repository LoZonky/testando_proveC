package conciliazione;

import Cliente.Cliente;
import pratiche.Pratiche;
import pratiche.Stato;
import prog.utili.Data;

public class Conciliazione extends Pratiche{

	// COSTRUTTORI
	
	public Conciliazione(double h, Cliente c, String d, Data di, Data df) throws Exception {
		super(h, c, d, di, df);
	}

	// METODI

	public double getCosto() {
		return 120.00*this.num_ore;
	}
	
}
