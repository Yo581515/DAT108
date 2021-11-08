package no.hvl.dat108;

public class MyValidator {

    public static final String ANY_LETTER_SPACE_OR_HYPHEN = "[a-zA-ZæøåÆØÅ -]";
    public static final String ANY_LETTER_OR_HYPHEN = "[a-zA-ZæøåÆØÅ-]";
    public static final String ANY_CAPITAL_LETTER = "[A-ZÆØÅ]";
    public static final String ANY_DIGIT = "[0-9]";

    public static final String ZERO_OR_MORE_TIMES = "*";
    public static final String ONE_TO_NINETEEN_TIMES = "{1,19}";
    public static final String EIGHT_TIMES = "{8}";

    /**
     * 
     * @param mobil Mobilnummeret som skal valideres
     * @return Om mobilnummeret er gyldig eller ikke
     * 
     *         Mobil skal være eksakt 8 siffer, ingenting annet. Et tilleggskrav
     *         ved påmelding er at mobilnummeret IKKE må tilhøre en allerede
     *         påmeldt deltager. Alle mobilnumre i deltagerlisten skal være
     *         unike.
     */
    public static boolean isValidMobil(String mobil) {
        return mobil != null 
        		&& mobil.matches("^" + ANY_DIGIT + EIGHT_TIMES + "$");
    }

    /**
     * @param fornavn
     * @return
     */
    public static boolean isValidFornavn(String fornavn) {
        return fornavn != null 
        		&& fornavn.matches("^" + ANY_CAPITAL_LETTER
                + ANY_LETTER_SPACE_OR_HYPHEN + ONE_TO_NINETEEN_TIMES + "$");
    }

    /**
     * @param etternavn
     * @return
     */
    public static boolean isValidEtternavn(String etternavn) {
        return etternavn != null 
        		&& etternavn.matches("^" + ANY_CAPITAL_LETTER
                + ANY_LETTER_OR_HYPHEN + ONE_TO_NINETEEN_TIMES + "$");
    }

    /**
     * @param kjonn
     * @return
     */
    public static boolean isValidKjonn(String kjonn) {
        return kjonn != null 
        		&& (kjonn.equals("mann") || kjonn.equals("kvinne"));
    }

	public static boolean isValidPassord(String passord) {
		return passord != null && passord.length() >= 4; //Ikke helt bra, men ...
	}
    
 }
