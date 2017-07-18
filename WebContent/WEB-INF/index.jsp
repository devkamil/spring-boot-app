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



	<form action="FirstServlet" method="post">

		<table>
			<caption>Spring Boot App</caption>
			<tr>
				<th>Note ID</th>
				<th>Title</th>
				<th>View</th>
			</tr>

			<c:forEach items="${notes}" var="note" varStatus="loop">
				<tr>
					<td><c:out value="${loop.count}" /></td>
					<td><c:out value="${note.title }" /></td>
					<td><a href="${pageContext.request.contextPath}/index.jsp?action=show&id=${note.id}">Zobacz</a>
				</tr>
			</c:forEach>
		</table>
		
	</form>
	
	




</body>
</html>