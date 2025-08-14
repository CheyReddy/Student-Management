<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Admin</title>
<link rel="stylesheet" type="text/css"
	href="/resources/css/updateStudent.css">

<link
	href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
	rel="stylesheet">
</head>
<body>

	<div class="container">

		<form:form action="/getAdmin" method="get" modelAttribute="admin">

			<div class="searchStudent">
				<label for="adminId">Admin Id</label>
				<form:input path="adminId" id="adminId" />
				<button type="submit">Get Details</button>
			</div>
			<c:if test="${not empty error}">
				<div class="error" style="text-align: center;">${error}</div>
			</c:if>


		</form:form>

		<form:form action="/processAdminAction" modelAttribute="admin"
			method="post">
			<form:hidden path="adminId" />
			<label for="name">Name</label>
			<form:input path="adminName" id="name" />

			<label for="email">Email</label>
			<form:input path="adminEmail" id="email" />
			<form:errors path="adminEmail" cssClass="error" />

			<label for="password">Password</label>
			<form:input path="adminPassword" id="password" />
			<form:errors path="adminPassword" cssClass="error" />

			<label for="newPassword">New Password</label>
			<form:password path="newPassword" id="newPassword" />
			<form:errors path="newPassword" cssClass="error" />

			<button type="submit" name="action" value="update">Update</button>
			<button type="submit" name="action" value="delete">Delete</button>
		</form:form>
	</div>
</body>
</html>
