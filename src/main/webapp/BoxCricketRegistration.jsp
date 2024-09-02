<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String playerNameError = (String)request.getAttribute("playerNameError");
	String playerTypeError = (String)request.getAttribute("playerTypeError");
%>



<h2>BoxCricketRegistration</h2>
<form action="BoxCricketRegistrationServlet" method="post">

	PlayerName:<input type="text" name="playerName"/>
	<%= playerNameError==null?"":playerNameError%>
	<br><br>
	
	PlayerType:<select name="playerType">
			   <option value="">Please select your skill</option>
			   <option value="batsMan">BatsMan</option>
			   <option value="bowler">Bowler</option>
			   <option value="AllRounder">AllRounder</option>
			   </select>
			   <%= playerTypeError==null?"":playerTypeError%>
	<br><br>
	
	<input type="submit" value="Register"/>
</form>
</body>
</html>