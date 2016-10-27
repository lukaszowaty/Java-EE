package pl.javastart.servlet;
 
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.model.Order;
import pl.javastart.model.Product;
 
@WebServlet("/addproduct-order")
public class AddProductOrder extends HttpServlet {
    private static final long serialVersionUID = 1L;
     
    @PersistenceUnit(name = "myPersistenceUnit")
    private EntityManagerFactory emf;
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	long orderId = Long.parseLong(request.getParameter("orderId"));
        long productId = Long.parseLong(request.getParameter("productId"));
         
        EntityManager em = emf.createEntityManager();
        Order order = em.find(Order.class, orderId);
        Product product = em.find(Product.class, productId);
         
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        order.getProducts().add(product);
        tx.commit();
        em.close();
         
        response.sendRedirect(request.getContextPath());
    }
}