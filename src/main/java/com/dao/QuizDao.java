package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Quiz;
import com.model.User;

public class QuizDao {
	DatabaseConnection connection = new DatabaseConnection();

	private static final String INSERT_QUIZ = "INSERT INTO Quiz "
			+ "(quiz_id, quiz_title, quiz_type) VALUES (?,?,?);";

	private static final String SELECT_QUIZ_BY_ID = "select * from Quiz where quiz_id =?";

	private static final String SELECT_ALL_QUIZ = "select * from Quiz ";

	Connection con = connection.loadDB();

	// insert record in database
	public void insertQuiz(Quiz quiz) {
		try {
			PreparedStatement prep = con.prepareStatement(INSERT_QUIZ);
			prep.setInt(1, quiz.getId());
			prep.setString(2, quiz.getTitle());
			prep.setString(3, quiz.getType());

			prep.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// select quiz
	public Quiz selectQuiz(int id) {
		Quiz quiz = null;
		try {
			PreparedStatement prep = con.prepareStatement(SELECT_QUIZ_BY_ID);
			prep.setInt(1, id);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				int quiz_id = rs.getInt("quiz_id");
				String title = rs.getString("quiz_title");
				String type = rs.getString("quiz_type");

				quiz = new Quiz();
				quiz.setId(quiz_id);
				quiz.setTitle(title);
				quiz.setType(type);
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return quiz;
	}

	public List<Quiz> selectAllQuiz() {
		List<Quiz> quizzes = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SELECT_ALL_QUIZ);

			while (rs.next()) {
				int quiz_id = rs.getInt("quiz_id");
				String title = rs.getString("quiz_title");
				String type = rs.getString("quiz_type");

				Quiz quiz = new Quiz();
				quiz.setId(quiz_id);
				quiz.setTitle(title);
				quiz.setType(type);

				quizzes.add(quiz);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quizzes;
	}

}
