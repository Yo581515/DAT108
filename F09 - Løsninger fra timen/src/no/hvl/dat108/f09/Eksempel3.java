package no.hvl.dat108.f09;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Eksempel3 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);
		
		//Alle forbokstavene i fornavnene i en streng - reduce "CLTCM"
		String forbokstavene = people.stream()
				.map(p -> "" + p.getFirstName().charAt(0))
				.reduce("", (s, f) -> s + f);
		System.out.println(forbokstavene);
		
		//Antall personer over 50 år - count
		long antallOver50 = people.stream()
				.filter(p -> p.getAge() > 50)
				.count();
		System.out.println(antallOver50);
		
		//Om vi har data som matcher - anyMatch, allMatch, noneMatch
		
		//Er alle over 30 år?
		boolean erAlleOver30 = people.stream()
				.allMatch(p -> p.getAge() > 30);
		System.out.println(erAlleOver30);
		
		//Er noen over 60 år?
		boolean erNoenOver60 = people.stream()
				.anyMatch(p -> p.getAge() > 60);
		System.out.println(erNoenOver60);

		//Summen av alle tall f.o.m. 1 t.o.m. 100, altså i [1,100]
		System.out.println(IntStream.rangeClosed(1,100).sum());
		
		//Det minste tallet i streamen ...
		System.out.println(IntStream.rangeClosed(1,100).min());
		System.out.println(IntStream.rangeClosed(1,100).min().orElse(-1));
				
		//Finn en som er 30 eller yngre
		Optional<Person> optP = people.stream()
				.filter(p -> p.getAge() <= 30)
				.findAny();
		System.out.println(optP);
		optP.ifPresent(System.out::println);

		
	}

}
