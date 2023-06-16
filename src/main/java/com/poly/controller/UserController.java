package com.poly.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.poly.constant.SessionAttr;
import com.poly.entity.User;
import com.poly.service.UserService;
import com.poly.service.impl.UserServiceImpl;

@WebServlet({ "/login", "/logout", "/register", "/changepass" })
public class UserController extends HttpServlet {
	UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String uri = req.getRequestURI();
		if (uri.contains("login")) {
			getLogin(req, resp);
		} else if (uri.contains("register")) {
			getRegister(req, resp);
		} else if (uri.contains("logout")) {
			getLogout(session, req, resp);
		} else {
			getChangePass(session, req, resp);
		} 
	}

	private void getChangePass(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String id = req.getParameter("id");
//		User user = userService.findbyId(Integer.valueOf(id));
//		req.setAttribute("user", user);
		req.getRequestDispatcher("/view/user/html/change_password.jsp").forward(req, resp);
	}

	private void postChangePass(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newid = req.getParameter("id");
		String oldpassword = req.getParameter("oldpassword");
		String newpassword = req.getParameter("newpassword");
		
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		if (user.getPassword().equalsIgnoreCase(oldpassword)) {
			User users = userService.findbyId(Integer.valueOf(newid));
			users.setPassword(newpassword);
			userService.update(users);
			resp.sendRedirect("/Web_Xem_Phim/index");
		} else {
			req.setAttribute("message", "Old password is not correct");
			req.getRequestDispatcher("/view/user/html/change_password.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		HttpSession session = req.getSession();
		if (uri.contains("login")) {
			postLogin(req, resp);
		} else if (uri.contains("register")) {
			postRegister(req, resp);
		}else {
			postChangePass(session, req, resp);
		}
	}

	private void getLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/user/html/login.jsp").forward(req, resp);
	}

	private void getRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/user/html/register.jsp").forward(req, resp);
	}

	// Login
	private void postLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		User user = userService.login(username, password);

		boolean hassError = false;
		if (username == null || "".equals(username)) {
			req.setAttribute("error_username", "Username must be not blank");
			hassError = true;
			req.getRequestDispatcher("/view/user/html/login.jsp").forward(req, resp);
		}
		if (password == null || "".equals(password)) {
			req.setAttribute("error_password", "Password must be not blank");
			hassError = true;
			req.getRequestDispatcher("/view/user/html/login.jsp").forward(req, resp);
		} else if (user != null && user.getIsAdmin() == false) {
			session.setAttribute(SessionAttr.CURRENT_USER, user);
			resp.sendRedirect("index");
		} else if (user != null && user.getIsAdmin() == true) {
			session.setAttribute(SessionAttr.CURRENT_USER, user);
			resp.sendRedirect("admin");
		}else {
			req.setAttribute("message", "Username or Password is incorrect");
			req.getRequestDispatcher("/view/user/html/login.jsp").forward(req, resp);
		}
	}

	// Register
	private void postRegister(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String confirmpassword = req.getParameter("confirmpassword");
		String email = req.getParameter("email");

		User user = userService.add(username, password, email);
		
		boolean hassError = false;
		if (username == null || "".equals(username)) {
			req.setAttribute("error_username", "Username must be not blank");
			hassError = true;
			req.getRequestDispatcher("/view/user/html/register.jsp").forward(req, resp);
		}
		if (password == null || "".equals(password)) {
			req.setAttribute("error_password", "Password must be not blank");
			hassError = true;
			req.getRequestDispatcher("/view/user/html/register.jsp").forward(req, resp);
		}
		if(!confirmpassword.equalsIgnoreCase(password) ){
			req.setAttribute("message_confirm", "Incorrect password");
			hassError = true;
			req.getRequestDispatcher("/view/user/html/register.jsp").forward(req, resp);
		}
		if (email == null || "".equals(email)) {
			req.setAttribute("error_email", "Email must be not blank");
			hassError = true;
			req.getRequestDispatcher("/view/user/html/register.jsp").forward(req, resp);
		}
		else if (user != null ) {
			session.setAttribute(SessionAttr.CURRENT_USER, user);
			resp.sendRedirect("index");
		} else {
			req.setAttribute("message", "Account registration failed");
			resp.sendRedirect("register");
		}
	}

	// Logout
	private void getLogout(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		session.removeAttribute(SessionAttr.CURRENT_USER);
		resp.sendRedirect("index");
	}
}
