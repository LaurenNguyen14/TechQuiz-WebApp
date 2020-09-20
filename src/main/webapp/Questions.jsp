<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.dao.DatabaseConnection"%>
<%@ page import="com.dao.QuizDao"%>
<%@ page import="com.model.Quiz"%>
<%@page import="com.model.Question"%>
<%@ page import="com.dao.Question_QuizDao"%>
<%@page import="com.dao.QuestionDao"%>
<%@ page import="com.model.Choices"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Quiz Home</title>
</head>
<body>
	<form action=./SubmissionServlet method="post">

		<div id="car01" class="carousel slide" data-ride="carousel"
			data-wrap="false" data-interval="false" data-keyboard="true">
			<ol class="carousel-indicators">
				<%
		List<Question> questionList = new ArrayList<>();
		questionList = (List<Question>) request.getSession().getAttribute("questionList");
		QuestionDao dao = new QuestionDao(); 
		if (questionList == null) {
			out.println("list is null, Why is the list null?");
		} else {
			//int i = 0;
			for(int i = 0 ; i < questionList.size(); i++) {
		%>
				<li data-target="#carousel-example-generic"
					data-slide-to=<%=i%> class="active"</li>
			</ol>
			<%
				}
			%>

			<div class="carousel-inner" role="listbox">
				<%
					for(int i = 0;i<questionList.size(); i++){
						List<Choices> choices = dao.selectAllChoices(questionList.get(i));
				%>
				<div class="item active">
					<div class="col-md-2 col-xs-2"></div>
					<div class="col-md-8 col-xs-8">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4></h4>
							</div>
							<div class="panel-body">
								<p>
									<%=questionList.get(i).getQuestion()%>
								</p>
				<%	for(int j = 0; j<choices.size(); j++){ %>
								<div
									class="radio>
								
			 	<label for=<%=choices.get(j).getChoiceId()%>>
			 	<input type="radio"  id=<%=choices.get(j).getChoiceId()%> name = <%=questionList.get(i).getId()%> value = <%=choices.get(j).getChoiceId()%>>
			 		<%=choices.get(j).getChoice() %>
			 	</label>
			 	<%}} //end 2 loops %>
</div> !radio
</div> !panelbody
</div> !panel primary
</div> !col-md-8
</div> !item 


<!-- Controls -->
  <a class="left carousel-control" href="#car01" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#car01" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<input type="submit" value="Submit">
</form>
	
</body>
</html>