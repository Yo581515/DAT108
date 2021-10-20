package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoggInnUtil {
	
	//Logge inn
	public static void loggInn(HttpServletRequest request, String username) {
		
		//Logge ut
		loggUt(request);
		
		//Logg inn
		HttpSession sesjon = request.getSession(true);
		sesjon.setMaxInactiveInterval(60); // 60 sekunder
		sesjon.setAttribute("username", username);
		sesjon.setAttribute("cart", new Cart());
		
	}

	//Sjekke om request tilhører innlogget bruker
	
	public static boolean erInnlogget(HttpServletRequest request) {
		HttpSession sesjon = request.getSession(false);
		return sesjon != null && sesjon.getAttribute("username") != null;
	}
	
	//Logge ut
	public static void loggUt(HttpServletRequest request) {
		HttpSession sesjon = request.getSession(false);
		if (sesjon != null) {
			sesjon.invalidate();
		}
	}
	
	
	//Annet ...?

}












