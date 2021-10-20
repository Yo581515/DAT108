package no.hvl.dat108.f07;

/**
 * Her er en liten oppgave dere kan prøve selv til mandag for å se om dere 
 * har fått med dere hovedideen med lambda-uttrykk.
 * 
 * Oppgavetekst: 
 * Lag en generell metode betingetUtskrift(...) som tar inn en streng 
 * og et (false | true) lambda-uttrykk og som skriver ut strengen kun 
 * hvis uttrykket er sant.
 * Lag en main(...)-metode som tester dette ut med et par ulike input,
 * f.eks. krav om at stringen begynner på"X" eller at den er lengre 
 * enn 3 tegn.
 */

public class OppgaveBetingetUtskrift {
	
	private static void betingetUtskrift(String s, Krav krav) {
		if (krav.erOppfylt(s)) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		betingetUtskrift("XPer", s -> s.charAt(0) == 'X'); //Starter med 'X'
		betingetUtskrift("asdfghjs", s -> s.length() >= 8); // >= 8 tegn
    }
}

@FunctionalInterface
interface Krav {
	boolean erOppfylt(String s);
}







