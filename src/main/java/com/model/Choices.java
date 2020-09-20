package com.model;

public class Choices {
	private int choiceId; 
	private int questionId; 
	private String correct; 
	private String choice;
	public Choices() {
		
	}
	public Choices(int choiceId, int questionId, String correct, String choice) {
		this.choiceId=choiceId; 
		this.questionId= questionId; 
		this.correct=correct; 
		this.choice=choice; 
		
	}
	public int getChoiceId() {
		return choiceId;
	}
	public void setChoiceId(int choiceId) {
		this.choiceId = choiceId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getCorrect() {
		return correct;
	}
	public void setCorrect(String correct) {
		this.correct = correct;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}

	
	
	

}
