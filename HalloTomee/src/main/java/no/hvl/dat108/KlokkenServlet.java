package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/klokken")
public class KlokkenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String navn = request.getParameter("navn");
		String fag = request.getParameter("fag");
		
		response.setContentType("text/plain; charset=ISO-8859-1");
		
		PrintWriter out = response.getWriter();
		
		out.println("Klokken er " + LocalTime.now());
		out.println("Hallo " + navn);
		out.println(fag + " er gøy !!!");
	}
	
}
