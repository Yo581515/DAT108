package no.hvl.dat108.f02;

public class Teller {

	private int verdi = 0;

	public  void tellOpp() {
		//Kritisk seksjon
		//Kan ha synchronized(this) på kodeblokk i stedet for på hele metoden
		verdi++; // verdi = verdi + 1
	}

	public  void tellNed() {
		//Kritisk seksjon
		//Kan ha synchronized(this) på kodeblokk i stedet for på hele metoden
		verdi--; // verdi = verdi - 1
	}

	public int getVerdi() {
		return verdi;
	}
}
