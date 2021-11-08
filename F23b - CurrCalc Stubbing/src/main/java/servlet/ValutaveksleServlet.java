package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Currency;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import solution.CurrencyConverter;

@WebServlet("/valutaveksling")
public class ValutaveksleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String amountAsString = request.getParameter("amount");
		String fromCurrency = request.getParameter("fromCurrency");
		String toCurrency = request.getParameter("toCurrency");

		double fromAmount = Double.parseDouble(amountAsString);
		
		//JUnit enhetstesting av denne!
		CurrencyConverter cc = new CurrencyConverter();
		double toAmount = cc.convertAmount(fromAmount, fromCurrency, toCurrency);

		Locale norsk = new Locale("no", "NO");
		String fromCurrencyDisplayName = Currency.getInstance(fromCurrency).getDisplayName(norsk);
		String toCurrencyDisplayName = Currency.getInstance(toCurrency).getDisplayName(norsk);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Resultat</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Valutaveksling resultat</h1>");
		out.println("<p>" + fromAmount + " " + fromCurrencyDisplayName + " blir " + toAmount + " "
				+ toCurrencyDisplayName + ".</p>");
		out.println("<a href=\"index.html\">Veksle en gang til</a>");
		out.println("</body>");
		out.println("</html>");

	}


}
