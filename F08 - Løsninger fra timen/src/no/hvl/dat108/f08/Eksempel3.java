package no.hvl.dat108.f08;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/*
 * I dette eksempelet skal vi se litt på metoden comparing(), og hvordan
 * denne kan brukes der det forventes en Comparator.
 */
public class Eksempel3 {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));

		//1 - Sortering på etternavn ved å gi inn en Comparator som 2. parameter
//		Collections.sort(people, (a,b) -> a.getLastName().compareTo(b.getLastName()));
		
		//2 - Ofte ser vi kode som dette
//		Collections.sort(people, comparing(Person::getLastName));

		//3 - Eller uten å bruke metodereferanse
//		Collections.sort(people, comparing(p -> p.getLastName()));

		//4 - Hvordan virker egentlig Comparator.comparing()?
		//		Kan vi forstå litt mer ved å lage en slik metode selv?
		//		F.eks. slik (sortere på alder):
		Collections.sort(people, vedAaSammenligne(Person::getAge));
		System.out.println(people);

	}
	
	/*
	 * Løsning:
	 * 
	 * T er her i vårt eksempel Person. Får altså returnert en Comparator<Person>
	 * som kan brukes i sort().
	 * 
	 * U er typen til egenskapen vi vil sortere på, f.eks. Integer eller String. 
	 * U må være Comparable<U>.
	 * 
	 * Function<T,U> tar inn et T/Person-objekt og returnerer et U/Comparable-
	 * objekt, f.eks. en String eller en Integer.
	 */
	static <T, U extends Comparable<U>> Comparator<T> vedAaSammenligne(
			Function<T, U> egenskapHenter) {
		return (a,b) -> egenskapHenter.apply(a).compareTo(egenskapHenter.apply(b));
	}
}











