package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserDao;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("errorMessage", "Completare tutti i campi");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        try {
            // Recupero dell'utente dal database
            User user = userDao.retrieveUser(email, password);

            if (user != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser", user);

                if (user.isAmministratore()) {
                    response.sendRedirect(request.getContextPath() + "/adminPage/adminPage.jsp");
                } else {
                    String checkout = request.getParameter("checkout");
                    if ("true".equals(checkout)) {
                        response.sendRedirect(request.getContextPath() + "/common/checkout.jsp");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/common/home.jsp");
                    }
                }
            } else {
                request.setAttribute("errorMessage", "Email o password non valide");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Errore durante il login");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}