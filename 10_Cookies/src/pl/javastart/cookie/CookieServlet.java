package pl.javastart.cookie;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String option = request.getParameter("cookie");
		if("create".equals(option)) {
			Cookie cookie = createCookie();
			response.addCookie(cookie);
			request.getRequestDispatcher("cookieinfo.jsp").forward(request, response);
		} else if("print".equals(option)) {
			request.getRequestDispatcher("cookieinfo.jsp").forward(request, response);
		} else if("remove".equals(option)) {
			removeCookies(request, response);
			request.getRequestDispatcher("nocookie.jsp").forward(request, response);
		}
	}
	
	private Cookie createCookie() {
		Random r = new Random();
		String cookieName = "cookie"+r.nextInt(100);
		String cookieValue = ""+r.nextInt(1000);
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setMaxAge(1*60*60);
		return cookie;
	}
	
	private void removeCookies(HttpServletRequest req, HttpServletResponse resp) {
		Cookie[] cookies = req.getCookies();
		for(Cookie c: cookies) {
			c.setMaxAge(0);
			resp.addCookie(c);
		}
	}

}
