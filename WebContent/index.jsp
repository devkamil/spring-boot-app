<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>First Servlet</title>
</head>
<body>

<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

	<form method="post">
	
	<table border="2">
		<tr>
			<td>note ID</td>
			<td>title</td>
			<td>content</td>
			<td>author</td>
			<td>date</td>
		</tr>
		<%
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/node_app";
			String username="root";
			String password="aaaa";
			String query="select * from note";
			Connection conn=DriverManager.getConnection(url, username, password);
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
		%>		
				<tr><td><%=rs.getInt("note_id") %></td></tr>
				<tr><td><%=rs.getString("title") %></td></tr>
				<tr><td><%=rs.getString("content") %></td></tr>
				<tr><td><%=rs.getString("author") %></td></tr>
				<tr><td><%=rs.getString("date") %></td></tr>
		<%
			}
		%>
		</table>
		<%
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		%>
	
	</form>

</body>
</html>