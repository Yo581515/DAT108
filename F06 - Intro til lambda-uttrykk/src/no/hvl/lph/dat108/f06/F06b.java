package no.hvl.lph.dat108.f06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class F06b {

	public static void main(String[] args) {

		//Skal nå se på den innebyggede Collections.sort()
		//og bruk av lambda-uttrykk til å representere parameter
		//nr 2, en Comparator.
		
		//Standard sortering bruker String.compareTo() som sorterer 
		//stigende på ASCII-verdi.
		List<String> listen = Arrays.asList("Hallo", "blabla", "knut", "Per");
		Collections.sort(listen);
		System.out.println(listen);
		
		//Sortere alfabetisk uavhengig av store og små bokstaver. Hva gjør vi?
		//Jo, vi må gi inn en ekstra parameter, en Comparator.
		Collections.sort(listen, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return a.toUpperCase().compareTo(b.toUpperCase());
			}
		});
		System.out.println(listen);
		
		//Gjøre det samme, nå med lambda-uttrykk ! :)
		Collections.sort(listen, (a, b) -> a.toUpperCase().compareTo(b.toUpperCase()));
		System.out.println(listen);
		
		//Sortere på String-lengde
		Collections.sort(listen, (a, b) -> a.length() - b.length());
		System.out.println(listen);
		
		//Sortere baklengs på lengde
		//Her ser vi at vi kan lagre et lambda-uttrykk i en variabel!
		Comparator<String> baklengsPaaLengde = (a, b) -> b.length() - a.length();
		Collections.sort(listen, baklengsPaaLengde);
		System.out.println(listen);
		
		
		

	}

}














