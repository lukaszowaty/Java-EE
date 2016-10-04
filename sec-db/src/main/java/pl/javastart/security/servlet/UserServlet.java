package pl.javastart.security.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.security.ejb.UserRepository;
import pl.javastart.security.entity.User;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private UserRepository userRepo;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        User user = new User(username, password, role);
        userRepo.add(user);
        response.sendRedirect(request.getContextPath());
    }
}
