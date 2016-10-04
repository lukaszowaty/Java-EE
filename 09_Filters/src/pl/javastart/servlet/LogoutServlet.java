package pl.javastart.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession(false) != null) {
            System.out.println("Logout");
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");
        } else {
            System.out.println("No session found");
        }
    }
}
