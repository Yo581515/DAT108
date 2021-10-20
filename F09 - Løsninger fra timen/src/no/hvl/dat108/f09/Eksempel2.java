package no.hvl.dat108.f09;

import java.util.Optional;
import java.util.Random;

public class Eksempel2 {
	
	public static void main(String[] args) {
		
//		Integer tall = muligensEtTall();
//		
//		if (tall != null) {
//			System.out.println(tall.hashCode());
//		} else {
		   
		
		Optional<Integer> tall = Optional.ofNullable(muligensEtTall());
		
		System.out.println(tall.hashCode());
		System.out.println(tall.orElse(-1));

	}
	
	private static Integer muligensEtTall() {
		int r = new Random().nextInt();
		return r % 2 == 0 ? r : null;
	}
}
