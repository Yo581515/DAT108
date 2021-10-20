package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registrer")
public class RegistrerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        String fornavn = request.getParameter("fornavn");
        String etternavn = request.getParameter("etternavn");
        
        String timestamp = LocalDateTime.now().format(
        		DateTimeFormatter.ofPattern("dd. MMM yyyy 'kl.'HH:mm"));
        
        response.setContentType("text/html; charset=ISO-8859-1");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Kvittering</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Hei, " + fornavn + " " + etternavn +"</p>");
        out.println("<p>Din registrering er mottatt " + timestamp + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
