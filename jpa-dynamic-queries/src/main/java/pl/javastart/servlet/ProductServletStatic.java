package pl.javastart.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.model.Product;

@WebServlet("/static")
public class ProductServletStatic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@PersistenceUnit(name = "myPersistenceUnit")
	private EntityManagerFactory emf; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Product> query = em.createNamedQuery("Product.findAllOrderByPrice", Product.class);
		List<Product> resultList = query.getResultList();
		request.setAttribute("products", resultList);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
