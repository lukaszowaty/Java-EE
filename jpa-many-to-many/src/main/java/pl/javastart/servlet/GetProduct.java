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
 
import pl.javastart.model.Product;
 
@WebServlet("/getproduct")
public class GetProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;
     
    @PersistenceUnit(name = "myPersistenceUnit")
    private EntityManagerFactory emf;
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long productId = Long.parseLong(request.getParameter("productId"));
         
        EntityManager em = emf.createEntityManager();
        Product product = em.find(Product.class, productId);
        product.getOrders().size();
        em.close();
         
        response.getWriter().println(product);
    }
}