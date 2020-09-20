<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import=" com.model.Quiz" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
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
	
	  
	 Quiz quiz  =(Quiz) session.getAttribute("Quiz");
	 int score = (Integer)session.getAttribute("score");  
	 String result =""; 
	 if(score>= 6){
		 result = "pass"; 
	 }
	 else if(score<6){
		 result = "fail"; 
	 }
	 
	%>
	
	<h3>Your Result</h3>
	
	<h4><%=name%></h4>
	
	Quiz: <%= quiz.getTitle() %> <br>
	Score: <%= score %><br>
	Pass/Fail: <%= result %><br>
	
	<br>
	<br>
	<form action="LogOutServlet" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>