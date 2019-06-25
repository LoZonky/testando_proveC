package tribunale;

import Cliente.Cliente;
import pratiche.Stato;
import prog.utili.Data;

public class Civile extends Tribunale {

	public Civile(double h, Cliente c, String d, int g, Data di, Data df, Grado_di_giudizio grad_giudizio) throws Exception {
		super(h, c, d, g, di, df, grad_giudizio);
		
	}

}
