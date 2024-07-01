package control;

import model.Prodotto;
import model.ProdottoDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/productServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("nome");
        if (productName == null || productName.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/errorPage.jsp");
            return;
        }

        ProdottoDao prodottoDao = new ProdottoDao();
        Prodotto prodotto = null;

        try {
            prodotto = prodottoDao.doRetrieveByName(productName);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/errorPage.jsp");
            return;
        }

        if (prodotto == null) {
            response.sendRedirect(request.getContextPath() + "/errorPage.jsp");
            return;
        }

        request.setAttribute("prodotto", prodotto);
        request.getRequestDispatcher("/prodotto.jsp").forward(request, response);
    }
}
