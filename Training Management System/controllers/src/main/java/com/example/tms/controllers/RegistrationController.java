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

@WebServlet("/registration.do")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		UserBean userBean = new UserBean();
		userBean.setLogin(login);
		userBean.setPassword(password);
		userBean.setLastName(lastName);
		userBean.setFirstName(firstName);
		userBean.setMiddleName(middleName);
		if (StringUtils.isNoneEmpty(login, password, lastName, firstName, middleName)) {
			UsersService userService = ServiceFactory.getFactory().getUserService();
			userBean = userService.addUser(userBean);
			session.setAttribute("userRegistration", userBean);
			response.sendRedirect("registration.html");
		} else {
			userBean.setErrorStatus(true);
			userBean.setErrorMessage("Error! Some fields are not filled.");
			session.setAttribute("userRegistration", userBean);
			response.sendRedirect("registration.html");
		}
	}

}
