//package filter;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import entities.Employee;
//
//@WebFilter("/*")
//public class AuthenticationFilter implements Filter {
//
//	private List<String> excludedRequest;
//
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		excludedRequest = new ArrayList<String>();
//		excludedRequest.add(new String("/LoginController"));
//		excludedRequest.add(new String("/LogOutController"));
//		excludedRequest.add(new String(".css"));
//		excludedRequest.add(new String(".js"));
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse res = (HttpServletResponse) response;
//		HttpSession session = req.getSession();
//
//		Employee em = (Employee) session.getAttribute("employee");
//		
//		boolean logged = (session != null) && (em != null);
//		
//		if (logged || inValidRequest(req.getRequestURI())) {
//			chain.doFilter(req, res);
//		} else {
//			res.sendRedirect(req.getContextPath() + "/LoginController");
//		}
//
//	}
//
//	@Override
//	public void destroy() {
//	}
//
//	private boolean inValidRequest(String url) {
//		for (String string : excludedRequest) {
//			if (url.endsWith(string)) {
//				return true;
//			}
//		}
//		return false;
//	}
//}
