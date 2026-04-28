<%@page import="com.dcl.servlet.entity.Players"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Players p=(Players) request.getAttribute("player"); %>
	<form action="updateplayer" method="post">
	<input type="number" value="<%= p.getId() %>" readonly="readonly" name="id"><br><br>
	<input type="text" value="<%= p.getTitle() %>" name="title"><br><br>
	<input type="number" value="<%= p.getAge() %>" name="age"><br><br>
	<input type="text" value="<%= p.getTeam() %>" name="team"><br><br>
	<input type="number" value="<%= p.getSalary() %>" name="sal"><br><br>
	<input type="text" value="<%= p.getNationality()%>" name="nlity"><br><br>
	<input type="submit">
	</form>
</body>
</html>