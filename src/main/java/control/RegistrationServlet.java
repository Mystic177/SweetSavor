package control;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    //private UserDAO userDAO;

    public void init() {
        //userDAO = new UserDAO();
    }
    
    //public boolean validatePassword(){}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      
    }
}
