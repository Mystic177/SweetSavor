package control;

import model.Prodotto;
import model.ProdottoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addProduct")
public class AdminAddProductServlet extends HttpServlet {

    private ProdottoDao prodottoDao;

    @Override
    public void init() throws ServletException {
        super.init();
        prodottoDao = new ProdottoDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Mostra il form per aggiungere un nuovo prodotto
        request.getRequestDispatcher("/adminProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParts() != null && request.getParts().size() > 0) {
            String nome = request.getParameter("nome");
            String descrizione = request.getParameter("descrizione");
            double prezzo = Double.parseDouble(request.getParameter("prezzo"));
            int disponibilita = Integer.parseInt(request.getParameter("disponibilita"));
            boolean disponibile = Boolean.parseBoolean(request.getParameter("disponibile"));
            String categoria = request.getParameter("categoria");
            byte[] img = request.getParameter("imgUrl").getBytes();

            Prodotto prodotto = new Prodotto(nome, descrizione, prezzo, disponibilita, disponibile, categoria, img);

            try {
                prodottoDao.doSave(prodotto);
                response.sendRedirect(request.getContextPath() + "/admin/dashboard");
            } catch (SQLException e) {
                throw new ServletException("Errore durante l'aggiunta del prodotto", e);
            }
        }
    }
}
