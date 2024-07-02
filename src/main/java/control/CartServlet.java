package control;

import model.Cart;
import model.Prodotto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupera il carrello dalla sessione
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart != null && !cart.isEmpty()) {
            ArrayList<Prodotto> listaProdotti = (ArrayList<Prodotto>) cart.getListaProdotti();

            // Passa i dati al JSP
            request.setAttribute("listaProdotti", listaProdotti);
            request.setAttribute("totalProdotti", listaProdotti.size());
            request.setAttribute("totalImporto", cart.getTotalPrize());

            request.getRequestDispatcher(request.getContextPath()+"/cart.jsp").forward(request, response);
        } else {
            // Se il carrello è vuoto, reindirizza a un messaggio di carrello vuoto
            request.setAttribute("message", "Il carrello è vuoto.");
            request.getRequestDispatcher(request.getContextPath()+"/common/cart.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupera il carrello dalla sessione
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart != null && !cart.isEmpty()) {
            // Recupera i parametri dal form
            String[] quantities = request.getParameterValues("quantity");

            if (quantities != null) {
                ArrayList<Prodotto> listaProdotti = (ArrayList<Prodotto>) cart.getListaProdotti();

                // Aggiorna la quantità dei prodotti nel carrello
                for (int i = 0; i < quantities.length; i++) {
                    int quantity = Integer.parseInt(quantities[i]);
                    listaProdotti.get(i).setDisponibility(quantity);
                }

                // Aggiorna il carrello nella sessione
                request.getSession().setAttribute("cart", cart);
            }

            // Redirect alla stessa pagina
            response.sendRedirect(request.getContextPath() + "/cart");
        } else {
            // Se il carrello è vuoto, reindirizza a un messaggio di carrello vuoto
            request.setAttribute("message", "Il carrello è vuoto.");
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
        }
    }
}
