package somepackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/skjema")
public class SkjemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/Skjema.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Skjema skjema = new Skjema(request);
		
		if (skjema.isAllInputGyldig()) {
			
			//opprette Person og lagre i database
//			Person p = skjema.lagPerson();
			//....
			
			request.getSession().removeAttribute("skjema");
			response.sendRedirect("Hurra.html");
		} else {
			
			//gjøre klart skjema med feilmeldinger ++
			skjema.settOppFeilmeldinger();
			
			request.getSession().setAttribute("skjema", skjema);
			response.sendRedirect("skjema");
		}
	}

}





