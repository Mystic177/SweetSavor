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

    public void init() throws ServletException {
        userDao = new UserDao(); // Inizializzazione del DAO all'avvio della servlet
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Verifica che email e password non siano vuoti
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/common/login.jsp?error=empty");
            return;
        }

        try {
            // Verifica le credenziali dell'utente nel database
            User user = userDao.retrieveUser(email, password);

            if (user != null) {
                // Imposta l'utente nella sessione
                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser", user);
                response.sendRedirect(request.getContextPath() + "/common/home.jsp");
            } else {
                // Credenziali non valide, reindirizza alla pagina di login con un messaggio di errore
                response.sendRedirect(request.getContextPath() + "/common/login.jsp?error=invalid");
            }
        } catch (SQLException e) {
            // Gestione dell'errore del database
            System.out.println("Database error: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/common/login.jsp?error=db");
        } finally {
            // Chiudi le risorse, se necessario (lasciato al UserDao se implementa AutoCloseable)
        }
    }
}

