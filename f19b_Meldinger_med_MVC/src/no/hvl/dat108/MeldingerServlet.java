package no.hvl.dat108;

import static no.hvl.dat108.CookieUtil.setAvsenderCookie;
import static no.hvl.dat108.CookieUtil.getAvsenderCookie;
import static org.apache.commons.text.StringEscapeUtils.escapeHtml4;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MeldingerServlet", urlPatterns = "/meldinger")
public class MeldingerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Traadsikker bruk: Gis kun verdi i init().
	private int visningsantall;

	@EJB
	private MeldingDAOMemory meldingEAO;
	
	@Override
	public void init() {
		visningsantall = Integer.parseInt(getServletConfig().getInitParameter(
				"visningsantall"));
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Databehandling her!
		System.out.println(visningsantall);
		List<Melding> meldinger = meldingEAO.henteNSisteMeldinger(visningsantall);

		// Ta vare paa i requesten til JSP-en
		request.setAttribute("meldinger", meldinger);
		
		request.setAttribute("avsender", escapeHtml4(getAvsenderCookie(request)));
		
		// Gjaar et forward-kall internt paa serveren til JSP-side for visning
		request.getRequestDispatcher("WEB-INF/Meldinger.jsp")
				.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String mottattAvsender = request.getParameter("avsender");
		if (mottattAvsender == null || mottattAvsender.equals("")) {
			mottattAvsender = "Anonym";
		}

		String mottattMelding = request.getParameter("melding");
		if (mottattMelding == null || mottattMelding.equals("")) {
			mottattMelding = "[Ingenting]";
		}

		long tidsstempel = currentTimeMillisToNearestSecond();
		meldingEAO.lagreNyMelding(tidsstempel, mottattAvsender, mottattMelding);

		setAvsenderCookie(response, mottattAvsender);

		response.sendRedirect("meldinger");
	}

	private long currentTimeMillisToNearestSecond() {
		return System.currentTimeMillis() / 1000 * 1000;
	}
}
