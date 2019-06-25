package tribunale;

import Cliente.Cliente;
import pratiche.*;
import prog.utili.Data;

public class Tribunale extends Pratiche{
	
	// CAMPI
	
	public Grado_di_giudizio grad_giudizio;  
	
	//COSTRUTTORI
	
	/*
	    public praticheTribunale(cliente c, double o, int p,String dI,String dF, String g) throws Exception{
		super(c,o,p,dI,dF); 
		this.gradoGiudizio=grado_giudizio.valueOf(g);
	 */
	
	protected Tribunale(double h, Cliente c, String d, int g, Data di, Data df, Grado_di_giudizio grade) throws Exception {
		super(h, c, d, di, df);
		this.grad_giudizio=grade;
	}
	
	
	// METODI
	
	public int getGradoGiudizio() {
		return grad_giudizio.getGrado();
	}
	
	public double getCosto() {
		return (100.00*(double)grad_giudizio.getGrado())*this.num_ore;
	}
}
