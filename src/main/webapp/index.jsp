<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>First Servlet</title>


</head>

<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
	text-align: center;
}
</style>
<body>



	<form action="NoteController" method="post">

		<table>
			<caption>Note App</caption>
			<tr>
				<th>Note ID</th>
				<th>Title</th>
				<th>View</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<c:forEach items="${notes}" var="note" varStatus="loop">
				<tr>
					<td><c:out value="${loop.count}" /></td>
					<td><c:out value="${note.title }" /></td>
					<td><a
						href="${pageContext.request.contextPath}/show-page/${note.id}">Show</a></td>
					<td><a 
						href="${pageContext.request.contextPath}/edit-note/${note.id}">Edit ${loop.count}</a></td>
					<td><a
						href="${pageContext.request.contextPath}/delete-page/${note.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>

	<form action="${pageContext.request.contextPath}/add-note">
		<br />
		<button type="submit" name="addNote" value="addNote">Add Note</button>
	</form>




</body>
</html>