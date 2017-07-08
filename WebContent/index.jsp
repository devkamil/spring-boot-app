<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>First Servlet</title>
</head>
<body>
	
	<h1>My First Servlet!</h1>
	<form action="FirstServlet.do" method="post">
		<p>Temat:</p>
		<input type="text" name="title" />
		<p>Treść notatki:</p>
		<textarea rows="4" cols="20" name="content">Treść notatki...</textarea>
		<p>Autor:</p>
		<input type="text" name="author" /><br /><br />
		<input type="submit" value="OK" />
	</form>
</body>
</html>