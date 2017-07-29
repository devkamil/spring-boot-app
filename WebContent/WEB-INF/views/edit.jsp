<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit note</title>

<script>
	function validateForm() {
		var x = document.forms["blank"]["title"].value;
		var y = document.forms["blank"]["content"].value;
		var z = document.forms["blank"]["author"].value;
		if (x == "" || y == "" || z == "") {
			alert("Fill all fields!");
			return false;
		}

	}
</script>
</head>
<body>

	<h1>Edit Note!</h1>
	<form name="blank" action="${pageContext.request.contextPath}/edited/${notes.id}"
		onsubmit="return validateForm()" method="post">
		<input type="hidden" name="id" value="${notes.id }" />
		<p>Title:</p>
		<input type="text" name="title" value="${notes.title }" /> 
		<p>Note content:</p>
		<textarea rows="4" cols="20" name="content">${notes.content }</textarea>
		<p>Author:</p>
		<input type="text" name="author" value="${notes.author }" /><br /> <br /> 
		<p>Note creation date: ${notes.date } </p>
		
		<input type="submit" value="OK" name="editButton"/>
	</form>
</body>
</html>