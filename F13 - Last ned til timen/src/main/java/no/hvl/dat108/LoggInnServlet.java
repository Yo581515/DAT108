package no.hvl.dat108;

import static no.hvl.dat108.UrlMappings.LOGIN_URL;
import static no.hvl.dat108.UrlMappings.WEBSHOP_URL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/" + LOGIN_URL)
public class LoggInnServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	/* 
	 * GET /login er forespørselen for å hente login-skjema.
	 */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
        // Inn noe kode her i forbindelse med evt. feilmeldinger?
    	String feilmelding = "";
    	String feilkode = request.getParameter("feilkode");
    	if (feilkode != null && feilkode.equals("invalidusername")) {
    		feilmelding = "Ugyldig brukernavn. Prøv igjen.";
    	} 
        
        response.setContentType("text/html; charset=ISO-8859-1");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Login</title>");
        out.println("</head>");
        out.println("<body>");
        
        // Inn noe kode her i forbindelse med evt. feilmeldinger?
        out.println(feilmelding); //evt. html for RØD !!!

        out.println("<form action=\"" + LOGIN_URL + "\" method=\"post\">");
        out.println("  <fieldset>");
        out.println("    <legend>Login</legend>");
        out.println("    <p>Navn: <input type=\"text\" name=\"username\" /></p>");
        out.println("    <p><input type=\"submit\" value=\"Logg inn\" /></p>");
        out.println("  </fieldset>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

	/* 
	 * POST /login er forespørselen for å logge inn.
	 */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    	String brukernavn = request.getParameter("username");
    	
    	// Sjekke at vi har gyldig brukernavn
    	if (!Validator.isGyldigUsername(brukernavn)) {
    		//Gå tilbake til innloggingsskjema med feilmelding
    		
    		response.sendRedirect(LOGIN_URL + "?feilkode=invalidusername");
    		
    	} else {
            // Innlogging av bruker, evt. feilhåndtering
            // Oppretting av sesjonsdata for bruker
    		LoggInnUtil.loggInn(request, brukernavn);
        	
            response.sendRedirect(WEBSHOP_URL);
    	}
    	
    	
    }
}








