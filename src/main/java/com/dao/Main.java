package com.dao;

import java.util.Arrays;

import com.model.Choices;
import com.model.Question;
import com.model.Quiz;
import com.model.User;

public class Main {
	public static void main(String args[]) {
		UserDao userDao = new UserDao();
		
		/*User  user1 = new User(); 
		user1.setName("test1");
		user1.setDob("1999-11-10");
		user1.setEmail("test1@gmail.com");
		user1.setPass("123456");
		user1.setPhone("0987654321");
		
		 
		userDao.insertUser(user1);
		*/
		/*User user2 = new User(); 
		user2.setName("test2");
		user2.setDob("1999-11-10");
		user2.setEmail("test1@gmail.com");
		user2.setPass("123456");
		user2.setPhone("0987654321");
		
		
		userDao.insertUser(user2);
		*/
		
		/*User user3 = new User(); 
		user3.setName("test3");
		user3.setDob("1999-11-10");
		user3.setEmail("test3@gmail.com");
		user3.setPass("123456");
		user3.setPhone("0987654321");
		
		
		userDao.insertUser(user3);*/
		/*
		QuizDao quizdao = new QuizDao(); 
		Quiz quiz1= new Quiz(); 
		
		quiz1.setId(1);
		quiz1.setTitle("Java Basics");
		quiz1.setType("Java");
		
		quizdao.insertQuiz(quiz1);
		
		/*Quiz quiz2 = new Quiz(); 
		quiz2.setId(2);
		quiz2.setTitle("Database");
		quiz2.setType("multiple choice");
		
		quizdao.insertQuiz(quiz2); 
		*/
		
		/*QuestionDao quesdao = new QuestionDao(); 
		
		Question q1 = new Question(); 
		Question q2 = new Question(); 
		Question q3 = new Question(); 
		Question q4 = new Question(); 
		Question q5 = new Question(); 
		Question q6 = new Question(); 
		Question q7 = new Question(); 
		Question q8 = new Question(); 
		Question q9 = new Question(); 
		Question q10 = new Question(); 
		Question q11 = new Question(); 
		Question q12 = new Question(); 
		Question q13 = new Question(); 
		Question q14 = new Question(); 
		Question q15 = new Question(); 
		
		Choices a1 = new Choices(); 
		Choices b1 = new Choices(); 
		Choices c1 = new Choices(); 
		Choices d1 = new Choices(); 
		
		q1.setId(1);
		q1.setQuestion(" Which of the following option leads to the portability and security of Java?");
		q1.setType("Java");
		
		a1.setChoice("Bytecode is executed by JVM");
		a1.setChoiceId(1);
		a1.setCorrect("c");
		a1.setQuestionId(q1.getId());
		a1.setValue("a");

		b1.setChoice("The applet makes the Java code secure and portable");
		b1.setChoiceId(2);
		b1.setCorrect("i");
		b1.setQuestionId(q1.getId());
		b1.setValue("b");
		
		c1.setChoice(" Use of exception handling");
		c1.setChoiceId(3);
		c1.setCorrect("i");
		c1.setQuestionId(q1.getId());
		c1.setValue("c");
		
		d1.setChoice("Dynamic binding between objects");
		d1.setChoiceId(4);
		d1.setCorrect("i");
		d1.setQuestionId(q1.getId());
		d1.setValue("d");
		
		quesdao.insertChoice(q1, a1);
		quesdao.insertChoice(q1, b1);
		quesdao.insertChoice(q1, c1);
		quesdao.insertChoice(q1, d1);
		
		Choices a2 = new Choices(); 
		Choices b2 = new Choices(); 
		Choices c2 = new Choices(); 
		Choices d2 = new Choices();
	
		q2.setId(2);
		q2.setQuestion(" Which of the following is not a Java features?");
		q2.setType("Java");
		
		a2.setChoice("Dynamic");
		a2.setChoiceId(5);
		a2.setCorrect("i");
		a2.setQuestionId(q2.getId());
		a2.setValue("a");
		
		b2.setChoice("Architecture Neutral");
		b2.setChoiceId(6);
		b2.setCorrect("i");
		b2.setQuestionId(q2.getId());
		b2.setValue("b");
		
		c2.setChoice("Use of pointers");
		c2.setChoiceId(7);
		c2.setCorrect("c");
		c2.setQuestionId(q2.getId());
		c2.setValue("c");
		
		d2.setChoice("Object-oriented");
		d2.setChoiceId(8);
		d2.setCorrect("i");
		d2.setQuestionId(q2.getId());
		d2.setValue("d");
		
		
		quesdao.insertChoice(q2, a2);
		quesdao.insertChoice(q2, b2);
		quesdao.insertChoice(q2, c2);
		quesdao.insertChoice(q2, d2);
		
		//int choiceId, int questionId, String correct, String choice, String value
		
		q3.setId(3);
		q3.setQuestion(" _____ is used to find and fix bugs in the Java programs.");
		q3.setType("Java");
		
		Choices a3 = new Choices(9,q3.getId(), "i", "JVM", "a"); 
		Choices b3 = new Choices(10,q3.getId(),"i", "JRE", "b"); 
		Choices c3 = new Choices(11,q3.getId(),"i", "JDK", "c"); 
		Choices d3 = new Choices(12,q3.getId(),"c", "JDB", "d"); 
		
		quesdao.insertChoice(q3, a3);
		quesdao.insertChoice(q3, b3);
		quesdao.insertChoice(q3, c3);
		quesdao.insertChoice(q3, d3);
	
		q4.setId(4);
		q4.setQuestion("What is the return type of the hashCode() method in the Object class?");
		q4.setType("Java");
		
		Choices a4 = new Choices(13, q4.getId(), "i", "Object", "a"); 
		Choices b4 = new Choices(14, q4.getId(), "c", "int", "b"); 
		Choices c4 = new Choices(15, q4.getId(), "i", "long", "c"); 
		Choices d4 = new Choices(16, q4.getId(), "i", "void", "d"); 
		
		quesdao.insertChoice(q4, a4);
		quesdao.insertChoice(q4, b4);
		quesdao.insertChoice(q4, c4);
		quesdao.insertChoice(q4, d4);
		
		
		q5.setId(5);
		q5.setQuestion("Which of the following for loop declaration is not valid?");
		q5.setType("Java");
		
		Choices a5 = new Choices(17, q5.getId(),"c ","for ( int i = 99; i >= 0; i / 9 )", "a");
		Choices b5 = new Choices(18, q5.getId(),"i", "for ( int i = 7; i <= 77; i += 7 )", "b"); 
		Choices c5 = new Choices(19, q5.getId(), "i", "for ( int i = 20; i >= 2; - -i )", "c"); 
		Choices d5 = new Choices(20, q5.getId(),"i", "for ( int i = 2; i <= 20; i = 2* i )", "d"); 
		
		quesdao.insertChoice(q5, a5);
		quesdao.insertChoice(q5, b5);
		quesdao.insertChoice(q5, c5);
		quesdao.insertChoice(q5, d5);
		
		
		
		q6.setId(6);
		q6.setQuestion("Which package contains the Random class?");
		q6.setType("Java");
		/* java.util package
			java.lang package
			java.awt package
			java.io package
		 * 
		 */
		
		/*q7.setId(7);
		q7.setQuestion("Which option is false about the final keyword?");
		q7.setType("Java");
		/*
		 * A final method cannot be overridden in its subclasses.
			A final class cannot be extended.
			A final class cannot extend other classes.
			A final method can be inherited.
		 */
		/*q8.setId(8);
		q8.setQuestion("What do you mean by chained exceptions in Java?");
		q8.setType("Java");
		/*
		 * Exceptions occurred by the VirtualMachineError
			An exception caused by other exceptions
			Exceptions occur in chains with discarding the debugging information
			None of the above
		 */
		/*
		q9.setId(9);
		q9.setQuestion("In which memory a String is stored, when we create a string using new operator?");
		q9.setType("Java");
		/*
		 * Stack
			String memory
		Heap memory
		Random storage space
		 */
		
		/*q10.setId(10);
		q10.setQuestion("Which keyword is used for accessing the features of a package?");
		q10.setType("Java");	
		/*package
		 import
		 extends
		 export
		 * 
		 */
		/*
		q11.setId(11);
		q11.setQuestion("Which of the given methods are of Object class?");
		q11.setType("Java");
		/*
		 * notify(), wait( long msecs ), and synchronized()
			wait( long msecs ), interrupt(), and notifyAll()
			notify(), notifyAll(), and wait()
			sleep( long msecs ), wait(), and notify()
		 */
		/*
		q12.setId(12);
		q12.setQuestion("Which of the following is a mutable class in java?");
		q12.setType("Java");
		/*
		 * java.lang.String
			java.lang.Byte
			java.lang.Short
			java.lang.StringBuilder
		 */
		/*
		q13.setId(13);
		q13.setQuestion("How many threads can be executed at a time?");
		q13.setType("Java");
		/*
		 * Only one thread
			Multiple threads
			Only main (main() method) thread
			Two threads
		 */
		/*
		q14.setId(14);
		q14.setQuestion("If a thread goes to sleep");
		q14.setType("Java");
		/*
		 * It releases all the locks it has.
			It does not release any locks.
			It releases half of its locks.
			It releases all of its lock except one.
		 */
		/*q15.setId(15);
		q15.setQuestion("Which index is the last element in an array called nums at?");
		q15.setType("Java");
		/*
		 *  nums.length
 			nums.length - 1
 			nums[nums.length]
 			nums[nums.length-1] 
		 */
		
		/*quesdao.insertQuestion(q1);
		quesdao.insertQuestion(q2);
		quesdao.insertQuestion(q3);
		quesdao.insertQuestion(q4);
		quesdao.insertQuestion(q5); 
		quesdao.insertQuestion(q6); 
		quesdao.insertQuestion(q7); 
		quesdao.insertQuestion(q8); 
		quesdao.insertQuestion(q9); 
		quesdao.insertQuestion(q10);
		quesdao.insertQuestion(q11); 
		quesdao.insertQuestion(q12); 
		quesdao.insertQuestion(q13); 
		quesdao.insertQuestion(q14); 
		quesdao.insertQuestion(q15); 
		
	*/
		
		Question q1_2 = new Question(); 
		q1_2.setId(16);
		q1_2.setQuestion("An attribute is an _______");
		q1_2.setType("Database");
		 /*
		  * aColumn of a table  B )   Two dimensional table  C )   Row of a table  D )   Key of a table
		  */
		
		Choices a_2 = new Choices(21, q1_2.getId(), "c", "Column of a table  "); 
		Choices b_2 = new Choices(22, q1_2.getId(), "i", "Two dimensional table "); 
		Choices c_2 = new Choices(23, q1_2.getId(), "i", "Row of a table "); 
		Choices d_2 = new Choices(24, q1_2.getId(), "i", "Key of a table"); 
		
		QuestionDao qDao = new QuestionDao(); 
		qDao.insertQuestion(q1_2);
		qDao.insertChoice(q1_2, a_2);
		qDao.insertChoice(q1_2, b_2);
		qDao.insertChoice(q1_2, c_2);
		qDao.insertChoice(q1_2, d_2);
		
	}
}
