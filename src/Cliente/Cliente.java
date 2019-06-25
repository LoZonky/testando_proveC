package Cliente;

public class Cliente {

	public String name, surname;
	
	public Cliente (String n, String s) {
		this.name = n;
		this.surname=s;
	}
	
	public String toString() {
		return this.name+" "+this.surname;
	}
}
