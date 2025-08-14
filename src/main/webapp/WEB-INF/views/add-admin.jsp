<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Admin</title>
<link rel="stylesheet" type="text/css"
	href="/resources/css/addStudent.css">

<link
	href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
	rel="stylesheet">

</head>
<body>
	<h1>Admin Registration</h1>

	<div class="container">
		<form:form action="/processAdmin" modelAttribute="admin" method="post">
			<label for="name">Name</label>
			<form:input path="adminName" id="name" />

			<label for="email">Email:</label>
			<form:input path="adminEmail" id="email"/>
			<form:errors path="adminEmail" cssClass="error" />


			<label for="password">Password</label>
			<form:password path="adminPassword" id="password" />
			<form:errors path="adminPassword" cssClass="error" />

			<input type="submit" value="Add Admin" style="text-align: center;">
		</form:form>
	</div>
</body>
</html>
