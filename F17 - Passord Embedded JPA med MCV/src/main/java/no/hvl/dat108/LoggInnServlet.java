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

		String loginMessage = "";

		if (request.getParameter("requiresLogin") != null) {
			loginMessage = "Forespoorselen din krever paalogging. " + "(Du kan ha blitt logget ut automatisk)";

		} else if (request.getParameter("invalidUsername") != null) {
			loginMessage = "Manglende eller ugyldig brukernavn";
		}

		request.setAttribute("loginMessage", loginMessage);

		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String brukerNavn = request.getParameter("brukerNavn");
		String passOrd = request.getParameter("passOrd");

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

		response.sendRedirect("LoggInnServlet" + "?invalidUsername");
	}

}
