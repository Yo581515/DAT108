package flgjdflg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bestilling")
public class BestillingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String vare = (String) request.getSession().getAttribute("vare");
		
		//Gi kvittering tilbake til bruker
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.println("Bestilling av " + vare + " er mottatt!");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String vare = request.getParameter("vare");
		
		//Validering ...
		
		//Gjøre bestillingen, dvs. lagre i database ++
		System.out.println("Det blir bestilt en " + vare);
		
		request.getSession().setAttribute("vare", vare);
		
		response.sendRedirect("bestilling");
		
	}

}
