package no.hvl.dat108.f09;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Eksempel1 {
	
	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60), 
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), 
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));
		
		// Summen av aldre
		
//		int sumAlder = people.stream()
//				.map(p -> p.getAge())
//				.reduce(0, (sum, alder) -> sum + alder);
		
//		int sumAlder = people.stream()
//				.map(p -> p.getAge())
//				.reduce(0, (sum, alder) -> Integer.sum(sum, alder));
		
//		int sumAlder = people.stream()
//				.map(p -> p.getAge())
//				.reduce(0, Integer::sum);
		
		int sumAlder = people.stream()
				.mapToInt(p -> p.getAge())
				.sum();
		
		System.out.println(sumAlder);
		
		
		// En streng med alle initialene, "CD LC TC CB MA"
		
//		String initialer = people.stream()
//				.map(p -> "" + p.getFirstName().charAt(0) + p.getLastName().charAt(0))
//				.reduce("", (s, p) -> s + " " + p)
//				.trim();
		
		String initialer = people.stream()
				.map(p -> "" + p.getFirstName().charAt(0) + p.getLastName().charAt(0))
				.collect(Collectors.joining(" "));
		
		System.out.println("|" + initialer + "|");
		
	}	

}
