package no.hvl.lph.dat108.f06;

import java.util.Arrays;
import java.util.List;


@FunctionalInterface
interface Sammenligner<T> {
	int sammenlign(T a, T b);
}

class FornavnSammenligner implements Sammenligner<Person> {
	@Override
	public int sammenlign(Person a, Person b) {
		return a.fornavn.compareTo(b.fornavn);
	}
}

public class F06a {
	
	/** En variant av sorter som bruker a.compareTo(b) */
	private static <T extends Comparable<T>> void sorter(List<T> liste) {
		sorter(liste, (a,b) -> a.compareTo(b));
	}

	/** En variant av sorter som bruker s.sammenlign(a,b) */
	private static <T> void sorter(List<T> liste, Sammenligner<T> s) {
		
		for (int i=0; i<liste.size(); i++) {
			for (int j=1; j<liste.size(); j++) {
				T a = liste.get(j-1);
				T b = liste.get(j);
				
				if (s.sammenlign(a, b) > 0) { // <--- Her
					
					liste.set(j-1, b);
					liste.set(j, a);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		//Sortere liste av heltall. Kan implementere sort med a > b
		List<Integer> listeAvTall = Arrays.asList(4,2,7,5,9,1);
		sorter(listeAvTall);
		System.out.println(listeAvTall);
		
		//Sortere liste av strenger. Må innføre typeparameter og bruke
		//Comparable.compareTo().
		List<String> listeAvString = Arrays.asList("Aaa", "Xxx", "Bbb", "Kkk");
		sorter(listeAvString);
		System.out.println(listeAvString);
		
		//Sortere liste av personer. Implementere standard sortering i
		//Person.compareTo().
		List<Person> listeAvPersoner = Arrays.asList(
				new Person("Anne", "Persen"),
				new Person("Per", "Andersen"),
				new Person("Knut", "Svendsen"));
		sorter(listeAvPersoner);
		System.out.println(listeAvPersoner);
		
		//Ønsker å sortere på fornavn. Hva gjør vi?
		//Jo, trenger en ekstra parameter i sort som sier hvordan vi
		//vil sortere (her på fornavn).
		sorter(listeAvPersoner, new FornavnSammenligner());
		System.out.println(listeAvPersoner);
		
		//Ønsker å sortere på fødselsår. Hva gjør vi?
		//Vi kan også opprette et Sammenligner-objekt direkte via
		//en anonym klasse ...
//		sorter(listeAvPersoner, new Sammenligner<Person>() {
//			@Override
//			public int sammenlign(Person a, Person b) {
//				return a.fodselsaar - b.fodselsaar;
//			}
//		});

	}
}
