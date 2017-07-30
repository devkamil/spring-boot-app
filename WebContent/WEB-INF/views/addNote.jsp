<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Note</title>

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

	<h1>Add Note!</h1>
	<form name="blank" action="	${pageContext.request.contextPath}/save-note"
		onsubmit="return validateForm()" method="post">
		<p>Title:</p>
		<input type="text" name="title" />
		<p>Note content:</p>
		<textarea rows="4" cols="20" name="content">...content...</textarea>
		<p>Author:</p>
		<input type="text" name="author" /><br /> <br /> <input
			type="submit" value="OK" />
	</form>
</body>
</html>