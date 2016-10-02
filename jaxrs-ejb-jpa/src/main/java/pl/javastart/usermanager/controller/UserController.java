package pl.javastart.usermanager.controller;
 
import java.io.IOException;
import java.util.List;
 
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 
import pl.javastart.usermanager.data.UserRepository;
import pl.javastart.usermanager.model.User;
 
@WebServlet("/users")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
     
    @Inject
    private UserRepository users;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> userList = users.getAll();
        request.setAttribute("users", userList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}