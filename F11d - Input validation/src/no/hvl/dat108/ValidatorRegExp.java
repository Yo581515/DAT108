package no.hvl.dat108;

/* Sjekk ut http://regexone.com  */
public class ValidatorRegExp {

	public boolean isValidStudentId(String s) {
		return s != null && s.matches("^h\\d{6}$");
	}
}
