package control;

import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String username = request.getParameter("username"); // Ottieni il parametro username

        // Verifica se username è null o una stringa vuota
        if (username == null || username.isEmpty()) {
            PrintWriter out = response.getWriter();
            //script javascript in caso di errore 
            out.println("<script type=\"text/javascript\">");
            out.println("alert('L'username non può essere vuoto');");
            out.println("</script>");
            response.sendRedirect(request.getContextPath() + "/registration.jsp");
            return; // Esce dal metodo doPost
        }

        String userID = UUID.randomUUID().toString();
        User user = new User(nome, password, email, userID); // Assumi isAdmin a false
        user.setUsername(username);
        user.setAmministratore(false);

        try {
            userDao.doSave(user);
            response.sendRedirect(request.getContextPath() + "/home.jsp");
        } catch (SQLException e) {
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Registration failed');");
            out.println("</script>");
            e.printStackTrace();
        }
    }
}
