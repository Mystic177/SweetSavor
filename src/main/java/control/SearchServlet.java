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
import java.util.ArrayList;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("search-bar-input");

        ArrayList<Prodotto> risultato = new ArrayList<>();
        ProdottoDao dao = new ProdottoDao();
        ArrayList<Prodotto> prodotti;

        try {
            prodotti = dao.doRetrieveAll();
            for (Prodotto p : prodotti) {
                for (int i = 0; i < p.getNomeProdotto().length() - 1; i++) {
                    for (int j = i + 1; j <= p.getNomeProdotto().length(); j++) {
                        if (p.getNomeProdotto().substring(i, j).equalsIgnoreCase(query) && !risultato.contains(p)) {
                            risultato.add(p);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("prodotti", risultato);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
