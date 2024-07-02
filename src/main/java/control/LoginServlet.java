package control;

import model.User;
import model.UserDao;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validazione base (opzionale)
        if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/common/login.jsp?error=emptyfields");
            return;
        }

        try {
            // Creazione DAO e recupero utente
            UserDao userDao = new UserDao();
            User user = userDao.retrieveUser(email, hashPassword(password));

            if (user != null && validatePassword(password, user.getPassword())) {
                // Verifica se l'utente è amministratore
                if (user.isAmministratore()) {
                    // Autenticazione riuscita per l'amministratore
                    HttpSession session = request.getSession(true);
                    session.setAttribute("currentSessionUser", user);
                    response.sendRedirect(request.getContextPath() + "/adminPage/adminPage.jsp");
                } else {
                    // Autenticazione riuscita per l'utente normale
                    HttpSession session = request.getSession(true);
                    session.setAttribute("currentSessionUser", user);
                    response.sendRedirect(request.getContextPath() + "/common/home.jsp");
                }
            } else {
                // Credenziali errate
                response.sendRedirect(request.getContextPath() + "/common/login.jsp?error=invalid");
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            // Errore database
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/common/login.jsp?error=db");
        }
    }

    private boolean validatePassword(String enteredPassword, String storedHashedPassword) throws NoSuchAlgorithmException {
        String enteredPasswordHash = hashPassword(enteredPassword);
        return enteredPasswordHash.equals(storedHashedPassword);
    }

    private String hashPassword(String password) {
        String hashString = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            hashString = hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashString;
    }
}
