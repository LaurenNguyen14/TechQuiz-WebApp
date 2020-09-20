package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Validation;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogInServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//filter if the user not 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("link.html").include(request, response);

		String name = request.getParameter("name");
		String password = request.getParameter("pass");

		if (Validation.checkUser(name, password)) {
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}
			// generate a new session
			HttpSession newSession = request.getSession(true);

			// setting session to expiry in 5 mins

			newSession.setMaxInactiveInterval(5 * 60);
			Cookie userName = new Cookie("name", request.getParameter("name"));
			response.addCookie(userName);

			out.print("<b>Login Successfully</b>");
			out.print("<br>Welcome!");
			
			 newSession.setAttribute("isUserLoggedIn",true);
			
			response.sendRedirect("quizzes.html");
		} else {
			out.print("Incorrect user name or password!");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}

}
