package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Question_QuizDao;
import com.dao.QuizDao;
import com.model.Question;
import com.model.Quiz;

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionServlet() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//HttpSession session = request.getSession(true);
		request.getRequestDispatcher("quizzes.html").include(request, response);
		String quizName = request.getParameter("quiz");
		System.out.println("name: " + quizName); 
		
		Quiz newQuiz = new Quiz();
		Random rand= new Random() ;
		newQuiz.setId(rand.nextInt(1000)+1  & Integer.MAX_VALUE);
		newQuiz.setTitle(quizName);
		newQuiz.setType("Java");
		
		QuizDao dao = new QuizDao(); 
		dao.insertQuiz(newQuiz);
		
		
		out.print(quizName);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("Quiz", newQuiz);
		// random all the questions that user will get
		Question_QuizDao connect = new Question_QuizDao(); 
		List<Question> allQuestions = connect.selectAllQuestions(newQuiz); 
		boolean[] visited = new boolean[allQuestions.size()]; 
		List<Question> result = new ArrayList<>(); 
		int i = 0; 
		while(i<10) {
			int random = (int)(Math.random()* 15)+1; 
			if(visited[random-1]==false) {
				Question toAdd = allQuestions.get(random-1); 
				result.add(toAdd); 
				i++;
				visited[random-1] = true; 
			}
		}
		for(int j = 0 ; j<result.size();j++) {
			connect.insertConnection(result.get(j), newQuiz);
		}
		session.setAttribute("questionList",result);
		getServletConfig().getServletContext().getRequestDispatcher("/Questions.jsp").forward(request,response); // redirect to jsp page
	}

}
