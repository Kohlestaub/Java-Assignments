package hausaufgaben_02;

public class Goldtagespreis {
	public String datum;
	public double preis;
	
	public Goldtagespreis(String datum, double preis) {
		this.datum = datum;
		this.preis = preis;
	}
	public String toString() {
		return String.format("Am %s lag der Goldpreis bei %d", datum, preis);
	}
}
