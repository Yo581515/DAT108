package somepackage;

import javax.servlet.http.HttpServletRequest;

public class Skjema {
	
	private String navn;
	private String navnFeilmelding;
	private String postnr;
	private String postnrFeilmelding;
	
	public Skjema(HttpServletRequest request) {
		this.navn = request.getParameter("navn");
		this.postnr = request.getParameter("postnr");
	}
	
	public boolean isAllInputGyldig() {
		return isNavnGyldig() && isPostnrGyldig();
	}
	
	private boolean isNavnGyldig() {
		return navn.equals("Per");
	}
	
	private boolean isPostnrGyldig() {
		return postnr.equals("5000");
	}

	public void settOppFeilmeldinger() {
		
		if (!isNavnGyldig()) {
			navn = "";
			navnFeilmelding = "Ugyldig navn!";
		}
		if (!isPostnrGyldig()) {
			postnr = "";
			postnrFeilmelding = "Ugyldig postnr!";
		}
	}

	public String getNavn() {
		return navn;
	}

	public String getNavnFeilmelding() {
		return navnFeilmelding;
	}

	public String getPostnr() {
		return postnr;
	}

	public String getPostnrFeilmelding() {
		return postnrFeilmelding;
	}

	
}


