package no.hvl.lph.dat108.f06;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Betingelse {
	boolean erOppfylt(int x);
}

public class F06c {
	
	public static List<Integer> plukkUt(List<Integer> liste, Betingelse betingelse) {
		
		List<Integer> resultat = new ArrayList<>();
		
		for (int tall : liste) {
			if (betingelse.erOppfylt(tall)) {
				resultat.add(tall);
			}
		}
		
		return resultat;
	}

	public static void main(String[] args) {
		
		List<Integer> listen = List.of(-4, 9, 2, 7, 6, 0);
		List<Integer> resultat;
		
		//Resultat skal inneholde alle partall fra listen
		resultat = plukkUt(listen, x -> x % 2 == 0); 
		System.out.println(resultat);
		
		//Alle tall større enn 0
		resultat = plukkUt(listen, x -> x > 0); 
		System.out.println(resultat);
		
		//Alle tall større enn 5
		resultat = plukkUt(listen, x -> x > 5); 
		System.out.println(resultat);

		//Alle tall større enn 7.
		//Nei, her gjentar vi oss. Vi lager heller en metode storreEnn() 
		//som returnerer et "dynamisk" lambda-uttrykk! :)
		resultat = plukkUt(listen, storreEnn(7)); 
		System.out.println(resultat);
	}
	
	public static Betingelse storreEnn(int grense) {
		return x -> x > grense;
	}
}










