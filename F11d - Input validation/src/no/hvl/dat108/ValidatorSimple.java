package no.hvl.dat108;

public class ValidatorSimple {
	
	public boolean isValidStudentId(String s) {
		
		if (s == null) {
			return false;
		}
		if (s.length() != 7) {
			return false;
		}
		if (s.charAt(0) != 'h') {
			return false;
		}
		if (!containsOnlyDigits(s.substring(1))) {
			return false;
		}
		
		return true;
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
