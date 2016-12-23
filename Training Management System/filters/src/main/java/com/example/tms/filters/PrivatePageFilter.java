package com.example.tms.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.tms.beans.UserBean;

@WebFilter(urlPatterns = {"/admin.html", "/teacher.html", "/listener.html"})
public class PrivatePageFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		UserBean authorization = (UserBean) session.getAttribute("userLogin");
		if (authorization == null || authorization.getErrorStatus()) {
			resp.sendRedirect("index.html");
		} else {
			if (!authorization.getErrorStatus()) {
				chain.doFilter(request, response);
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
