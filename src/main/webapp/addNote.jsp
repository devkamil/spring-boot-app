<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add Note</title>
	</head>
	<body>
		<a href="/spring-boot-app">Back to main page</a><br />
		<form:form method="POST" modelAttribute="noteDto">
			<table border="1">
				<tbody>
					<tr>
						<th>Title</th>
						<td><form:input type="text" path="title" /><c:if test="${pageContext.request.method=='POST'}"><form:errors path="title" /></c:if></td>
					</tr>
					<tr>
						<th>Content</th>
						<td><form:input type="text" path="content" /><c:if test="${pageContext.request.method=='POST'}"><form:errors path="content" /></c:if></td>
					</tr>
					<tr>
						<th>Author</th>
						<td><form:input type="text" path="author" /><c:if test="${pageContext.request.method=='POST'}"><form:errors path="author" /></c:if></td>
					</tr>
			
					<tr>
						<td colspan="2" align="right"><input type="submit" value="Add Note" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<br />
		<hr />
	</body>
</html>