package pl.javastart.security.servlet;
 
import java.io.IOException;
import java.security.Principal;
 
import javax.ejb.EJBAccessException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import pl.javastart.security.ejb.SecuredBean;
 
@WebServlet("/secret")
@ServletSecurity(
        @HttpConstraint(rolesAllowed = {"user", "admin"})
)
public class SecuredServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
     
    @Inject
    private SecuredBean bean;
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Principal principal = request.getUserPrincipal();
        String name = principal.getName();
         
        response.getWriter().println("This is secured area, welcome " + name);
        try {
            String message = bean.getMessage();
            response.getWriter().println(message);
        } catch(EJBAccessException e) {
            response.getWriter().println("Sorry, you are not allowed to show secret message");
        }
    }
}