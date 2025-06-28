<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
<link rel="stylesheet" type="text/css" href="/resources/css/updateStudent.css">

<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">

</head>
<body>
	<h1>Update Student Details</h1>

	<div class="container">
		<form:form action="/processUpdate" modelAttribute="student" method="post">
			<form:hidden path="id" />

			<label for="name">Name</label>
			<form:input path="name" id="name" />

			<label for="mobile">Mobile</label>
			<form:input path="mobile" id="mobile" />

			<label for="country">Country</label>
			<form:input path="country" id="country" />

			<input type="submit" value="Update Student">
		</form:form>
	</div>
</body>
</html>
