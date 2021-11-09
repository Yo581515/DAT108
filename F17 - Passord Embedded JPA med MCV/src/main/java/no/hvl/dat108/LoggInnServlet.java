package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import no.hvl.dat108.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoggInnServlet")
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BrukerDAO brukerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String feilmelding = "";
		String feilkode = request.getParameter("feilkode");
		if (feilkode != null && feilkode.equals("invalidusername")) {
			feilmelding = "Ugyldig brukernavn eller passord!";
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
		out.println("<p style=\"color:red;\">" + feilmelding + "</p>");

		out.println("<form action=\"LoggInnServlet\" method=\"post\">");
		out.println("  <fieldset>");
		out.println("    <legend>Logg inn</legend>");
		out.println("    <p>Brukernavn: <input type=\"text\" name=\"brukerNavn\" /></p>");
		out.println("    <p>Passord: <input type=\"text\" name=\"PassOrd\" /></p>");
		out.println("    <p><input type=\"submit\" value=\"Logg inn\" /></p>");
		out.println("  </fieldset>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String brukerNavn = request.getParameter("brukerNavn");
		String passOrd = request.getParameter("PassOrd");

		if (Validator.erGyldigBrukerNavnOgPassOrd(brukerNavn, passOrd) && brukerDAO.hentBruker(brukerNavn) != null) {
			Bruker hentetBruker = brukerDAO.hentBruker(brukerNavn);
			Passord hellPassord = hentetBruker.getPassord();
			String salt = hellPassord.getPwd_salt();
			String hashPass = hellPassord.getPwd_hash();

			Boolean riktigInlogget = PassordUtil.validerMedSalt(passOrd, salt, hashPass);
			if (riktigInlogget) {
				response.sendRedirect("brukerliste");
				return;

			}
		}

		response.sendRedirect("LoggInnServlet" + "?feilkode=invalidusername");
	}

}
