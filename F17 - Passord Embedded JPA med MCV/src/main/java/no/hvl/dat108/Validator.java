package no.hvl.dat108;

public class Validator {

	public static final String ANY_LETTER = "[A-Za-zæøåÆØÅ]";
	public static final String ANY_LETTER_OR_DIGIT = "[A-Za-zæøåÆØÅ\\d]";
	public static final String THREE_OR_MORE_TIMES = "{2,}";

	public static boolean erGyldigBrukerNavnOgPassOrd(String username, String passord) {

		if (username == null || passord == null) {
			return false;
		}
		return username.matches("^" + ANY_LETTER + ANY_LETTER_OR_DIGIT + THREE_OR_MORE_TIMES + "$")
				&& passord.matches("^" + ANY_LETTER + ANY_LETTER_OR_DIGIT + THREE_OR_MORE_TIMES + "$");
	}

}
