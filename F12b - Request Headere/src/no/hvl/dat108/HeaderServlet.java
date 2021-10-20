package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HeaderServlet")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		Enumeration<String> headernavn = req.getHeaderNames();
		
		resp.setContentType("text/plain");
		
		PrintWriter out = resp.getWriter();
		
		while(headernavn.hasMoreElements()) {
			String navn = headernavn.nextElement();
			out.println(navn + " = " + req.getHeader(navn));
		}
	}

}






