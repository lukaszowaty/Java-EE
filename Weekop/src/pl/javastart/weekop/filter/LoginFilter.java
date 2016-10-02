package pl.javastart.weekop.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import pl.javastart.weekop.model.User;
import pl.javastart.weekop.service.UserService;


@WebFilter("/*")
public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		if(httpReq.getUserPrincipal() != null && httpReq.getSession().getAttribute("user") == null) {
			saveUserInSession(httpReq);
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	private void saveUserInSession(HttpServletRequest request) {
		UserService userService = new UserService();
		String username = request.getUserPrincipal().getName();
		User userByUsername = userService.getUserByUserna(username);
		request.getSession(true).setAttribute("user", userByUsername);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
