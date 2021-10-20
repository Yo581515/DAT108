package no.hvl.dat108;

public class ValidatorBetter {
	
	public boolean isValidStudentId(String s) {
		
		return s != null 
				&& s.length() == 7 
				&& s.startsWith("h") 
				&& containsOnlyDigits(s.substring(1));
	}

	private boolean containsOnlyDigits(String s) {
		boolean result = true;
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) < '0' || s.charAt(i) > '9') {
				result = false;
				break;
			}
		}
		return result;
	}
}
