package no.hvl.dat108;

import static org.apache.commons.text.StringEscapeUtils.escapeHtml4;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MeldingerServlet", urlPatterns = "/meldinger")
public class MeldingerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Trådsikker bruk: Gis kun verdi i init()
	private int visningsantall;

	// Trådsikker: Ny EntityManager og transaksjon blir injected ved bruk
	@EJB
	private MeldingDAOMemory meldingDAO;

	@Override
	public void init() {
		visningsantall = Integer.parseInt(getServletConfig()
				.getInitParameter("visningsantall"));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Databehandling før skriving av respons!!!
		List<Melding> meldinger = meldingDAO.henteNSisteMeldinger(visningsantall);

		// Da har vi det vi trenger, og kan begynne å lage HTML!!!
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Meldinger</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Meldinger</h2>");

		//escapeHtml4 sørger for ufarliggjøring av brukerinput
		for (Melding m : meldinger) {
			out.println("<p><b>(#" + m.getId() + ") " + m.getFormatertTidsstempel() 
					+ " skrev "	+ escapeHtml4(m.getAvsender()) + ":</b></p>");
			out.println("<blockquote><i>" + escapeHtml4(m.getTekst()) 
					+ "</i></blockquote>");
		}
		out.println("<form method=\"post\">");
		out.println("<fieldset><legend>Ny melding</legend>");
		out.println("<p>Skriv melding:<br />");
		out.println("<textarea name=\"melding\" rows=\"2\" cols=\"45\">" + "</textarea></p>");
		out.println("<p>Avsender:<br />");
		out.println("<input type=\"text\" name=\"avsender\" " + "value =\"" 
				+ escapeHtml4(getAvsenderCookie(request)) + "\" />");
		out.println("<input type=\"submit\" value=\"Send melding\" />");
		out.println("<input type=\"reset\" value=\"Nullstill\" /></p>");
		out.println("</fieldset>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mottattAvsender = request.getParameter("avsender");
		if (mottattAvsender == null || mottattAvsender.equals("")) {
			mottattAvsender = "Anonym";
		}

		String mottattMelding = request.getParameter("melding");
		if (mottattMelding == null || mottattMelding.equals("")) {
			mottattMelding = "[Ingenting]";
		}

		long tidsstempel = currentTimeMillisToNearestSecond();
		meldingDAO.lagreNyMelding(tidsstempel, mottattAvsender, mottattMelding);

		setAvsenderCookie(response, mottattAvsender);

		response.sendRedirect("meldinger");
	}

	private long currentTimeMillisToNearestSecond() {
		return System.currentTimeMillis() / 1000 * 1000;
	}

	private String getAvsenderCookie(HttpServletRequest request) 
			throws UnsupportedEncodingException {

		String avsender = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("avsender")) {
					avsender = cookie.getValue();
					avsender = URLDecoder.decode(avsender, "ISO-8859-1");
				}
			}
		}
		return avsender;
	}

	private void setAvsenderCookie(HttpServletResponse response, 
			String mottattAvsender)	throws UnsupportedEncodingException {

		String cookieverdi = URLEncoder.encode(mottattAvsender, "ISO-8859-1");
		Cookie cookie = new Cookie("avsender", cookieverdi);
		cookie.setMaxAge(60 * 60 * 24 * 365);
		response.addCookie(cookie);
	}
}
