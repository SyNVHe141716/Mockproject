package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Employee;
import request.UserRoleRequestWrapper;
import utils.AppUtils;
import utils.SecurityUtils;

@WebFilter("/*")
public class SecurityFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String servletPath = request.getServletPath();

		// Thông tin người dùng đã được lưu trong Session
		// (Sau khi đăng nhập thành công).
		HttpSession ses = request.getSession();
		Employee loginedUser = (Employee) ses.getAttribute("employee");

		if (servletPath.equals("/LoginController")) {
			chain.doFilter(request, response);
			return;
		}
		HttpServletRequest wrapRequest = request;

		if (loginedUser != null) {
			// User Name
			String userName = loginedUser.getEmployeeName();

			// Các vai trò (Role).
			String role = loginedUser.getRole()==true?"MANAGER":"EMPLOYEE";

			// Gói request cũ bởi một Request mới với các thông tin userName và Roles.
			wrapRequest = new UserRoleRequestWrapper(userName, role, request);
		}

		// Các trang bắt buộc phải đăng nhập.
		if (SecurityUtils.isSecurityPage(request)) {

			// Nếu người dùng chưa đăng nhập,
			// Redirect (chuyển hướng) tới trang đăng nhập.
			if (loginedUser == null) {

				String requestUri = request.getRequestURI();

				// Lưu trữ trang hiện tại để redirect đến sau khi đăng nhập thành công.
				int redirectId = AppUtils.storeRedirectAfterLoginUrl(request.getSession(), requestUri);

				response.sendRedirect(wrapRequest.getContextPath() + "/LoginController?redirectId=" + redirectId);
				return;
			}

			// Kiểm tra người dùng có vai trò hợp lệ hay không?
			boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
			if (!hasPermission) {

				RequestDispatcher dispatcher
						= request.getServletContext().getRequestDispatcher("/views/main/accessDeniedView.jsp");

				dispatcher.forward(request, response);
				
				return;
			}
		}

		chain.doFilter(wrapRequest, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
