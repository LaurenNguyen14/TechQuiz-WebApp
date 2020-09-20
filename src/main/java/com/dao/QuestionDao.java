package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Choices;
import com.model.Question;
import com.model.Quiz;

public class QuestionDao {
	DatabaseConnection connection = new DatabaseConnection();

	private static final String INSERT_QUESTION = "INSERT IGNORE INTO Questions"
			+ "(question_id, question,type) VALUES (?,?,?);";

	// private static final String SELECT_QUIZ_BY_ID = "select * from Quiz where
	// quiz_id =?";
	private static final String INSERT_CHOICE = "INSERT IGNORE INTO QuestionChoices(choice_id,question_id,correct_ans,choice) VALUES (?,?,?,?)";
	private static final String SELECT_ALL_CHOICES = "SELECT * FROM QuestionChoices WHERE question_id = ?"; 
	private static final String SELECT_CORRECT = "SELECT correct_ans from QuestionChoices WHERE choice_id= ? "; 
	Connection con = connection.loadDB();

	// insert question record in database according to quiz id
	public void insertQuestion(Question question) {
		try {
			PreparedStatement prep = con.prepareStatement(INSERT_QUESTION);
			prep.setInt(1, question.getId());
			prep.setString(2, question.getQuestion());
			prep.setString(3, question.getType());

			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void insertChoice(Question question,Choices choice) {
		try {
			PreparedStatement prep = con.prepareStatement(INSERT_CHOICE);
			prep.setInt(1, choice.getChoiceId());
			prep.setInt(2, choice.getQuestionId());
			prep.setString(3, choice.getCorrect());
			prep.setString(4, choice.getChoice());

			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Choices> selectAllChoices(Question question){
		List<Choices> choices = new ArrayList<>();
		try {
			PreparedStatement pr = con.prepareStatement(SELECT_ALL_CHOICES); 
			pr.setInt(1, question.getId());
			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				int choice_id = rs.getInt("choice_id");
				int question_id = rs.getInt("question_id"); 
				String correct = rs.getString("correct_ans");
				String choice= rs.getString("choice");

				
				Choices newChoice = new Choices(); 
				newChoice.setChoice(choice);
				newChoice.setChoiceId(choice_id);
				newChoice.setCorrect(correct);
				newChoice.setQuestionId(question_id);
		
				
				choices.add(newChoice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return choices;
	}
	public String selectCorrect(int user_response) {
		String str = ""; 
		try {
			PreparedStatement pr = con.prepareStatement(SELECT_CORRECT); 
			pr.setInt(1, user_response);
			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				str = rs.getString("correct_ans"); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

}
