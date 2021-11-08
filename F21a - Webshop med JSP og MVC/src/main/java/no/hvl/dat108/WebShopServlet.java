package no.hvl.dat108;

import static no.hvl.dat108.UrlMappings.LOGIN_URL;
import static no.hvl.dat108.UrlMappings.LOGOUT_URL;
import static no.hvl.dat108.UrlMappings.WEBSHOP_URL;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/" + WEBSHOP_URL)
public class WebShopServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesjon = request.getSession(false);

        if (sesjon == null || sesjon.getAttribute("username") == null) {
            response.sendRedirect(LOGIN_URL + "?requiresLogin");
        } else {
        	request.setAttribute("WEBSHOP_URL", WEBSHOP_URL);
        	request.setAttribute("LOGOUT_URL", LOGOUT_URL);
            request.getRequestDispatcher("WEB-INF/webshop.jsp")
            		.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesjon = request.getSession(false);

        if (sesjon == null || sesjon.getAttribute("username") == null) {
            response.sendRedirect(LOGIN_URL + "?requiresLogin");
        } else {
            Cart cart = (Cart) sesjon.getAttribute("cart");

            if (request.getParameter("bukse") != null) {
                cart.addItem(new CartItem("Bukse", 699.0));
            }
            if (request.getParameter("genser") != null) {
                cart.addItem(new CartItem("Genser", 399.0));
            }

            response.sendRedirect(WEBSHOP_URL);
        }
    }
}
