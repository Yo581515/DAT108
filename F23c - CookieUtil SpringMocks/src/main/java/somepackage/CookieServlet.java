package somepackage;

import java.io.IOException;
import java.io.PrintWriter;

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

		// Sjekk om cookie er med i request
		String besokCookie = CookieUtil.getCookieFromRequest(request, "besokt");

		// Sende med cookie uansett om den finnes eller ikke
		CookieUtil.addCookieToResponse(response, "besokt", "dggdfgjfjfj");

		PrintWriter out = response.getWriter();

		if (besokCookie != null) {
			out.println("Velkommen tilbake. Du har vært på siden tidligere!");

		} else {
			out.println("Hei du ukjente bruker!");
		}
	}

}
