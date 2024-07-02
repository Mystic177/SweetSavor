package control;

import model.Ordine;
import model.OrdineDAO;
import model.Prodotto;
import model.ProdottoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/processCheckout")
public class CheckoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrdineDAO ordineDAO;
    private ProdottoDao prodottoDAO;

    public void init() {
        ordineDAO = new OrdineDAO();
        prodottoDAO = new ProdottoDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupera i parametri dal form di checkout
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

        // Recupera il carrello dalla sessione
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            request.setAttribute("errorMessage", "Il carrello è vuoto.");
            request.getRequestDispatcher("/checkout.jsp").forward(request, response);
        }

        // Recupera i prodotti e il totale del carrello
        List<Prodotto> listaProdotti = cart.getListaProdotti();
        double totale = cart.getTotalPrize();
        boolean stato = true; // assuming 'true' means the order is completed successfully
        String dataOrdine = new java.sql.Date(System.currentTimeMillis()).toString();

        // Genera un ID ordine unico
        String orderID = generateOrderID();

        // Crea un oggetto Ordine
        Ordine ordine = new Ordine(orderID, dataOrdine, nome, cognome, cap, indirizzo, totale, stato);

        try {
            // Inserisci l'ordine nel database
            ordineDAO.insertOrdine(ordine);

            // Aggiorna le quantità dei prodotti nel database
            for (Prodotto prodotto : listaProdotti) {
                int nuovaDisponibilita = prodotto.getDisponibility() - prodotto.getDisponibility();
                prodottoDAO.doUpdateQnt(prodotto.getNomeProdotto(), nuovaDisponibilita);
            }

            // Rimuovi il carrello dalla sessione
            request.getSession().removeAttribute("cart");

            // Invia un messaggio di successo e reindirizza alla pagina di conferma ordine
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
