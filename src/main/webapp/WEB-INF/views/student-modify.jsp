<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
<link rel="stylesheet" type="text/css"
	href="/resources/css/updateStudent.css">

<link
	href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
	rel="stylesheet">
</head>
<body>

	<div class="container">

		<form:form action="/getStudent" method="get" modelAttribute="student">
			<div class="searchStudent">
				<label for="id">Student Id</label>
				<form:input path="id" id="id" />
				<button type="submit">Get Details</button>
			</div>
		</form:form>

		<form:form action="/processStudentAction" modelAttribute="student"
			method="post">
			<form:hidden path="id" />
			<label for="name">Name</label>
			<form:input path="name" id="name" />

			<label for="mobile">Mobile</label>
			<form:input path="mobile" id="mobile" />

			<label for="country">Country</label>
			<form:input path="country" id="country" />

			<label for="dob">Date of Birth</label>
			<form:input path="dob" id="dob" type="date" />
			<form:errors path="dob" cssClass="error" />

			<label for="gender">Gender:</label>
			<form:input path="gender" id="gender" />

			<label for="pmobile">Parents Mobile:</label>
			<form:input path="parentsMobile" id="pmobile" />

			<label for="email">Email</label>
			<form:input path="email" id="email" />
			

			<button type="submit" name="action" value="update">Update</button>
			<button type="submit" name="action" value="delete">Delete</button>
		</form:form>
	</div>
</body>
</html>
