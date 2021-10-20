package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cookieverdi = CookieUtil.getCookieFromRequest(request, "sistbesokt");
		
		CookieUtil.addCookieToResponse(response, "sistbesokt", LocalDateTime.now().toString());
		
		PrintWriter out = response.getWriter();
		if (cookieverdi != null) {
			out.println("Velkommen tilbake. Du var her sist " + cookieverdi);
		} else {
			out.println("Hei. Det var en ukjent kar.");
		}
		
	}

}
