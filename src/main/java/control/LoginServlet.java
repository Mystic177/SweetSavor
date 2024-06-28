package control;

import model.User;
import model.UserDao;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
  

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        
        
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            // Verifica se email e password sono presenti
            if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/login.jsp?error=missing_credentials");
                return;
            }

            // Hash della password
            String hashedPassword = hashPassword(password);
            
            // Recupero dell'utente dal database
            User user = userDao.retrieveUser(email, password);

            // Verifica se l'utente esiste nel database
            if (user != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser", user);

                // Redirect in base al tipo di utente
                if (user.isAmministratore()) {
                    response.sendRedirect(request.getContextPath() + "/adminPage/adminPage.jsp");
                } else {
                    String checkout = request.getParameter("checkout");
                    if (checkout != null) {
                        response.sendRedirect(request.getContextPath() + "/checkout.jsp");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/home.jsp");
                    }
                }
            } else {
                // Utente non trovato nel database
                response.sendRedirect(request.getContextPath() + "/login.jsp?error=user_not_found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=exception");
        }
    }

    // Metodo per l'hashing della password (SHA-512)
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        byte[] hashedBytes = digest.digest(password.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : hashedBytes) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }
}
