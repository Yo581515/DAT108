package no.hvl.dat108;

public class tester {
	public static void main(String[] args) {
		
		final String LETTERS = "[A-Za-z]*";
		
		
		String a = "asdassSSDAdaSA";
		String b="bBssxcdAAfaVDFssdfa";
		
		
		System.out.println(a.matches("^" + LETTERS + "$"));
		System.out.println(b.matches("^" + LETTERS + "$"));
		
		
	}

	
	
	
}
