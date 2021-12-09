package no.hvl.dat108.f07;

import java.util.function.Function;

public class EksempelX_ikke_brukt {

	public static void main(String[] args) {

//		List<String> tekster = Arrays.asList("Atle", "Lars", "Per");

		// Predicate<T>
		// Vi kan f.eks. lage en metode printKunDeSomErGyldige() som tar inn
		// en liste av strenger og kun printer ut de som oppfyller en betingelse.

		// Consumer<T>
		// Vi kan f.eks. lage en metode gjorNoeMedAlleTekstene() som tar inn
		// en liste av strenger og gjør noe (angitt i en lambda) med hver enkelt av dem.

		// Supplier<T>
		// Vi kan f.eks. lage en metode produserListeAvVerdier som returner en
		// en liste av produserte verdier (angitt i en lambda).

		// Function<T, R>
		// Vi kan f.eks. lage en metode finnOgPrintNoeInfoOmTekstene() som tar inn
		// en liste av strenger og finner (angitt i en lambda) og printer ut noe 
		// statistikk om hver enkelt streng.
		
		
		
		Function<Integer, Integer> f1 = i -> i*4;   // lambda
	      System.out.println(f1.apply(3));

	      Function<Integer, Integer> f2 = i -> i+4; // lambda
	      System.out.println(f2.apply(3));

	      Function<String, Integer> f3 = s -> s.length(); // lambda
	      System.out.println(f3.apply("Adithya"));

	      System.out.println(f1.andThen(f2).apply(3));
	      System.out.println(f2.andThen(f1).apply(3));

	      System.out.println(Function.identity().apply(10));
	      System.out.println(Function.identity().apply("Adithya"));
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	}

}
