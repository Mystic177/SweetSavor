package control;

import model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);
        boolean isLoggedIn = session != null && session.getAttribute("currentSessionUser") != null;

        if (isLoggedIn) {
            User user = (User) session.getAttribute("currentSessionUser");
            if (user.isAmministratore()) {
                // L'utente è un amministratore, permetti l'accesso alla pagina di login
                chain.doFilter(request, response);
            } else {
                // L'utente non è un amministratore, reindirizza a un'altra pagina (es. home normale)
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/common/home.jsp");
            }
        } else {
            // Nessun utente loggato, reindirizza alla pagina di login
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/common/login.jsp");
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
        // Inizializzazione del filtro
    }

    public void destroy() {
        // Cleanup
    }
}
