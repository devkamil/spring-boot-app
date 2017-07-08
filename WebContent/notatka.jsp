<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Notatka</title>
</head>
<body>
	<p>Zapisana notatka: </p>
	<p>Temat: ${notes.title}</p>
	<p>Treść notatki: ${notes.content}</p>
	<p>Autor: ${notes.author}</p>
	<p>Data: ${notes.date}</p>
	
	<a href="index.jsp">Powrót</a>
	

</body>
</html>