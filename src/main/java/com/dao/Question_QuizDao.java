package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Question;
import com.model.Quiz;

public class Question_QuizDao {
	DatabaseConnection connection = new DatabaseConnection();
	private static final String INSERT_CONNECTION = "INSERT INTO Question_Quiz"
			+ "(question, quiz_id,user_response) VALUES (?,?,?);";

	 private static final String SELECT_QUESTION_BY_QUIZ_TYPE = "select * from Questions,Quiz where type=?";
	 private static final String UPDATE_USER_RESPONSE = "Update Question_Quiz SET user_response = ? WHERE quiz_id = ? AND question = ? "; 

	Connection con = connection.loadDB();

	// insert question record in database according to quiz id
	public void insertConnection(Question question, Quiz quiz) {
		try {
			PreparedStatement prep = con.prepareStatement(INSERT_CONNECTION);
			prep.setInt(1, question.getId());
			prep.setInt(2, quiz.getId());
			prep.setString(3, null);

			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Question> selectAllQuestions(Quiz quiz){
		List<Question> questions = new ArrayList<>(); 
		try {
			PreparedStatement prep = con.prepareStatement(SELECT_QUESTION_BY_QUIZ_TYPE);
			prep.setString(1, quiz.getType());
			ResultSet rs = prep.executeQuery(); 
			
			while(rs.next()) {
				int question_id = rs.getInt("question_id"); 
				String question= rs.getString("question"); 
				String type = rs.getString("type");
				
				Question q = new Question(); 
				q.setId(question_id);
				q.setQuestion(question);
				quiz.setType(type);
				
				questions.add(q);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return questions; 
	}
	public void updateUserResponse(int quiz_id, int question_id, String response) {
		try {
			PreparedStatement prep = con.prepareStatement(UPDATE_USER_RESPONSE); 
			prep.setString(1,response);
			prep.setInt(2, quiz_id);
			prep.setInt(3,question_id);
			
			//System.out.println(UPDATE_USER_RESPONSE); 
			prep.executeUpdate(); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
