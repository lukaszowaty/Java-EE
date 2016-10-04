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

import pl.javastart.model.User;
import pl.javastart.model.UserDetails;


@WebServlet("/create")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@PersistenceUnit(name = "myPersistenceUnit")
	private EntityManagerFactory emf;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails details = new UserDetails();
		details.setFirstName(request.getParameter("firstname"));
		details.setLastName(request.getParameter("lastname"));
		details.setAddress(request.getParameter("address"));
		
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setDetails(details);
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(details);
		em.persist(user);
		tx.commit();
		em.close();
		response.sendRedirect(request.getContextPath());
	}

}
