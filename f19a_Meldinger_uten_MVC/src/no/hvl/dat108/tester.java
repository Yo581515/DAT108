package no.hvl.dat108;

import java.util.ArrayList;
import java.util.List;

public class tester {

	public static void main(String[] args) {

		MeldingDAOMemory m = new MeldingDAOMemory();

		m.meldinger.stream().forEach(x -> System.out.println(x));
//		System.out.println(m.meldinger.get(0));

	}

}
