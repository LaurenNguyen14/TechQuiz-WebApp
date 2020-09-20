package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.QuestionDao;
import com.dao.Question_QuizDao;
import com.dao.SubmissionDao;
import com.model.Quiz;

/**
 * Servlet implementation class SubmissionServlet
 */
@WebServlet("/SubmissionServlet")
public class SubmissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmissionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int score = 0; 
		QuestionDao qdao = new QuestionDao(); 
		Question_QuizDao dao = new Question_QuizDao(); 
		 HttpSession session=request.getSession(false);  
		 Quiz quiz  =(Quiz) session.getAttribute("Quiz"); 
		for(int i = 1; i<=15; i++) {
			String answer = request.getParameter(String.valueOf(i)); // value of user answer for question id (i)
			if(answer!=null) {
				//update user response
				dao.updateUserResponse(quiz.getId(),i, answer);
				String correct = qdao.selectCorrect(Integer.valueOf(answer));
				
				if(correct.equals("c")) {
					score= score+1; 
				}
			}
			
			
		}
		session = request.getSession(true);
		session.setAttribute("total", score);
		
		String name = null;
		String sessionID = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("name")){
					name = cookie.getValue();
					
				}
				if (cookie.getName().equals("JSESSIONID"))
			sessionID = cookie.getValue();
			}
		}
		//add to submission database
		SubmissionDao submission = new SubmissionDao(); 
		submission.insertSubmission(quiz, null,null, score, name);
		session.setAttribute("score", score);
		getServletConfig().getServletContext().getRequestDispatcher("/final.jsp").forward(request,response); // redirect to jsp page
	}

}
