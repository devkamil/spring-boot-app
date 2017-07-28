<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Deleting note</title>
</head>
<body>
	<p>Deleting note: </p>
	<p>Title: ${notesDelete.title}</p>
	<p>Note content: ${notesDelete.content}</p>
	<p>Author: ${notesDelete.author}</p>
	<p>Date: ${notesDelete.date}</p> <br />
	
	<a href="index.jsp">Back</a> &nbsp;&nbsp;&nbsp; <a href="index.jsp?action=remove&id=${notesDelete.id }">Delete</a> 
	

</body>
</html>