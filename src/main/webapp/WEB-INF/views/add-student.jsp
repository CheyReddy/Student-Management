<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Student</title>
<link rel="stylesheet" type="text/css"
	href="/resources/css/addStudent.css">

<link
	href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
	rel="stylesheet">

</head>
<body>
	<h1>Student Registration</h1>

	<div class="container">
		<form:form action="/processStudent" modelAttribute="student"
			method="post">
			<label for="name">Name</label>
			<form:input path="name" id="name" />

			<label for="mobile">Mobile</label>
			<form:input path="mobile" id="mobile" />
			<form:errors path="mobile" cssClass="error" />

			<label for="country">Country</label>
			<form:select path="country" id="country" items="${countryList}" />

			<label for="dob">Date of Birth</label>
<<<<<<< HEAD
			<form:input path="dob" id="dob" type="date" placeholder="yyyy-mm-dd"/>
			
=======
			<form:input path="dob" id="dob" type="date" placeholder="yyyy-mm-dd" />

>>>>>>> 9bbeb68 (Updated Student Management System with admin password encryption and UI fixes)
			<label for="gender">Gender:</label>
			<form:select path="gender" id="gender">
				<form:option value="">-- Select Gender --</form:option>
				<form:option value="Male">Male</form:option>
				<form:option value="Female">Female</form:option>
				<form:option value="Other">Other</form:option>
			</form:select>


			<label for="email">Email:</label>
			<form:input path="email" id="email" />
			<form:errors path="email" cssClass="error" />

			<label for="pmobile">Parents Mobile:</label>
			<form:input path="parentsMobile" id="pmobile" />
			<form:errors path="parentsMobile" cssClass="error" />

			<input type="submit" value="Add Student" style="text-align: center;">
		</form:form>
	</div>
</body>
</html>
