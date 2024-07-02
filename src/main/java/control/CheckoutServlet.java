package control;

import model.Ordine;
import model.OrdineDAO;
import model.Cart;
import model.Prodotto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/processCheckout")
public class CheckoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrdineDAO ordineDAO;

    public void init() {
        ordineDAO = new OrdineDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("first-name");
        String cognome = request.getParameter("last-name");
        String email = request.getParameter("email");
        String indirizzo = request.getParameter("address");
        String citta = request.getParameter("city");
        String cap = request.getParameter("postal-code");
        String paese = request.getParameter("country");
        String nomeCarta = request.getParameter("card-name");
        String numeroCarta = request.getParameter("card-number");
        String dataScadenza = request.getParameter("expiry-date");
        String cvv = request.getParameter("cvv");

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            request.setAttribute("errorMessage", "Il carrello è vuoto.");
            request.getRequestDispatcher("/checkout.jsp").forward(request, response);
            return;
        }

        List<Prodotto> listaProdotti = cart.getListaProdotti();
        double totale = cart.getTotalPrize();
        boolean stato = true; // assuming 'true' means the order is completed successfully
        String dataOrdine = new java.sql.Date(System.currentTimeMillis()).toString();

        String orderID = generateOrderID(); // Implement this method to generate a unique order ID

        Ordine ordine = new Ordine(orderID, dataOrdine, nome, cognome, cap, indirizzo, totale, stato);

        try {
            ordineDAO.insertOrdine(ordine);
            request.getSession().removeAttribute("cart");
            request.setAttribute("successMessage", "Ordine completato con successo!");
            request.getRequestDispatcher("/orderConfirmation.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Si è verificato un errore durante il processamento dell'ordine.");
            request.getRequestDispatcher("/checkout.jsp").forward(request, response);
        }
    }

    private String generateOrderID() {
        // Implement your logic to generate a unique order ID
        return "ORD-" + System.currentTimeMillis();
    }
}
