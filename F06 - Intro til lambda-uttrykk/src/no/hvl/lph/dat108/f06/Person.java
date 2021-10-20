package no.hvl.lph.dat108.f06;

public class Person implements Comparable<Person> {
	
	String fornavn;
	String etternavn;

	public Person(String fornavn, String etternavn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
	}

	@Override
	public String toString() {
		return "[" + fornavn + " " + etternavn + "]";
	}

	@Override
	public int compareTo(Person other) {
		return this.etternavn.compareTo(other.etternavn);
	}
}
