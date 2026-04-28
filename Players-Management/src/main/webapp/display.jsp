<%@page import="com.dcl.servlet.entity.Players"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% List<Players> players=(List)request.getAttribute("players"); %>
	<table border="1">
	<tr>
		<th>PlayerID</th>
		<th>Name</th>
		<th>Age</th>
		<th>Team</th>
		<th>Salary</th>
		<th>Nationality</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<% for(Players player: players) {%>
	<% if(player!=null) { %>
	<tr>
		<td><%= player.getId()%></td>
		<td><%= player.getTitle()%></td>
		<td><%= player.getAge()%></td>
		<td><%= player.getTeam()%></td>
		<td><%= player.getSalary()%></td>
		<td><%= player.getNationality()%></td>
  		<td><a href="find-by-id?playerId=<%= player.getId()%>">UPDATE</a></td>
  		<td><a href="delete-by-id?playerId=<%= player.getId()%>" >DELETE</a></td>
		
	</tr>
	<%} %>
<%} %>
	
	</table>
</body>
</html>