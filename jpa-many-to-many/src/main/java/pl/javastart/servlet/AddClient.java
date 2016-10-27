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
 
import pl.javastart.model.Client;
 
@WebServlet("/addclient")
public class AddClient extends HttpServlet {
    private static final long serialVersionUID = 1L;
     
    @PersistenceUnit(name = "myPersistenceUnit")
    private EntityManagerFactory emf;
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Client client = new Client();
        client.setFirstName(request.getParameter("firstName"));
        client.setLastName(request.getParameter("lastName"));
        client.setAddress(request.getParameter("address"));
         
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
         
        tx.begin();
        em.persist(client);
        tx.commit();
        em.close();
         
        response.sendRedirect(request.getContextPath());
    }
}