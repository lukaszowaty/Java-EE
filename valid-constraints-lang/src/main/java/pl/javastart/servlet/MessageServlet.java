package pl.javastart.servlet;

import java.io.IOException;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import pl.javastart.model.Message;

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource
    private Validator validator;
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String message = request.getParameter("message");
        Message msg = new Message(title, message);
        Set<ConstraintViolation<Message>> violations = validator.validate(msg);
        for (ConstraintViolation<Message> v : violations) {
            System.out.printf("%s - %s (%s)\n", 
                    v.getPropertyPath(),
                    v.getInvalidValue(),
                    v.getMessage());
        }
        response.sendRedirect(request.getContextPath());
    }
}

