<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Note</title>
</head>
<body>
	<p>Saved note: </p>
	<p>Title: ${notes.title}</p>
	<p>Note content: ${notes.content}</p>
	<p>Author: ${notes.author}</p>
	<p>Date: ${notes.date}</p>
	
	<a href="/spring-boot-app">Back</a>
	

</body>
</html>