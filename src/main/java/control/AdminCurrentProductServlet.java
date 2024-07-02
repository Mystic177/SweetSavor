package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prodotto;
import model.ProdottoDao;
import model.ProdottoDaoInterface;

@WebServlet("/admin/currentProducts")
public class AdminCurrentProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProdottoDaoInterface prodottoDao = new ProdottoDao();
        ArrayList<Prodotto> prodotti = new ArrayList<>();

        try {
            prodotti = prodottoDao.doRetrieveAll();
            request.setAttribute("prodotti", prodotti);
            request.getRequestDispatcher("/WEB-INF/currentProduct.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Si è verificato un errore durante il recupero dei prodotti.");
            request.getRequestDispatcher("/WEB-INF/currentProduct.jsp").forward(request, response);
        }
    }
}
