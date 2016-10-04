package pl.javastart.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Auth filter");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		//użytkownik posiada aktywną sesję i jest zalogowany
		if(session != null && session.getAttribute("username") !=null) {
			System.out.println("Session + user valid");
			chain.doFilter(httpRequest, response);
		} else {
			System.out.println("Session or user not valid");
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("login.jsp");
		}
	}

	@Override
	public void destroy() {
		
	}
	
}
