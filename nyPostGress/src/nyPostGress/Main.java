package nyPostGress;

public class Main {

	public static void main(String[] args) {
		
		
		Brukere.printBrukereNavn();
		
		
		String sqlQuiry = "DROP SCHEMA IF EXISTS fesaha CASCADE;"
				+ "CREATE SCHEMA fesaha;"
				+ "SET search_path = fesaha;"
				
				+ "CREATE TABLE dekiFish "
				+ "("
				+ "   brukernavn CHARACTER VARYING (20),"
				+ "   pwd_hash CHARACTER (64),"
				+ "   pwd_salt CHARACTER (32),"
				+ "   PRIMARY KEY (brukernavn)"
				+ "); ";
		
		
		Quiry.executeQuiry(sqlQuiry);
		
	}

}
