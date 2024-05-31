package com.example.sweetsavor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Esegui la logica di verifica delle credenziali
        boolean isValidUser = checkCredentials(username, password);

        // Invia una risposta HTML in base all'esito del login
        if (isValidUser) {
            response.setContentType("text/html");
            response.getWriter().println("<html><body><h2>Login successful</h2><p>Welcome, " + username + "!</p></body></html>");
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<html><body><h2>Login failed</h2><p>Invalid username or password.</p></body></html>");
        }
    }

    private boolean checkCredentials(String username, String password) {
        // Esegui la logica per verificare le credenziali dell'utente
        // In questo esempio, si assume che l'utente sia valido se il nome utente è "admin" e la password è "password"
        return username.equals("admin") && password.equals("password");
    }
}
