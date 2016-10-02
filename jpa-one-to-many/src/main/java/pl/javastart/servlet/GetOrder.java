package pl.javastart.servlet;
 
import java.io.IOException;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import pl.javastart.model.Order;
 
@WebServlet("/getorder")
public class GetOrder extends HttpServlet {
    private static final long serialVersionUID = 1L;
     
    @PersistenceUnit(name = "myPersistenceUnit")
    private EntityManagerFactory emf;
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long orderId = Long.parseLong(request.getParameter("orderId"));
         
        EntityManager em = emf.createEntityManager();
        Order order = em.find(Order.class, orderId);
        em.close();
         
        response.getWriter().println(order);
    }
}