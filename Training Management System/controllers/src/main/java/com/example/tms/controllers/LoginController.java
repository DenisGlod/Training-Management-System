package com.example.tms.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.example.tms.beans.UserBean;
import com.example.tms.services.UsersService;
import com.example.tms.services.factory.ServiceFactory;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		UserBean userBean = new UserBean();
		if (StringUtils.isNoneEmpty(login, password)) {
			userBean.setLogin(login);
			userBean.setPassword(password);
			UsersService usersService = ServiceFactory.getFactory().getUserService();
			userBean = usersService.authorization(userBean);
			if (!userBean.getErrorStatus()) {
				switch (userBean.getRole()) {
				case "admin":
					session.setAttribute("userLogin", userBean);
					session.setAttribute("firstInput", true);
					response.sendRedirect("admin.do");
					break;
				case "teacher":
					session.setAttribute("userLogin", userBean);
					response.sendRedirect("teacher.html");
					break;
				case "listener":
					session.setAttribute("userLogin", userBean);
					response.sendRedirect("listener.html");
					break;
				} 
				
			} else {
				userBean.setErrorMessage("Error! Wrong login or password.");
				session.setAttribute("userLogin", userBean);
				response.sendRedirect("index.html");
			}
		} else {
			userBean.setErrorStatus(true);
			userBean.setErrorMessage("Error! Wrong login or password.");
			session.setAttribute("userLogin", userBean);
			response.sendRedirect("index.html");
		}
	}

}
