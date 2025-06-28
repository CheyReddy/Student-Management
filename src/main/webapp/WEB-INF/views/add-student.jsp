<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Student</title>
<link rel="stylesheet" type="text/css" href="/resources/css/addStudent.css">

<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">

</head>
<body>
	<h1>Student Registration</h1>

	<div class="container">
		<form:form action="/processStudent" modelAttribute="student" method="post">
			<label for="name">Name</label>
			<form:input path="name" id="name"/>

			<label for="mobile">Mobile</label>
			<form:input path="mobile" id="mobile"/>

			<label for="country">Country</label>
			<form:input path="country" id="country"/>

			<label for="dob">Date of Birth</label>
			<form:input path="dob" id="dob" type="date" placeholder="yyyy-mm-dd"/>
			
			<label for="gender">Gender:</label>
            <form:input path="gender" id="gender" />
            
           	<label for="email">Email:</label>
            <form:input path="email" id="email"/>
            
            <label for="pmobile">Parents Mobile:</label>
            <form:input path="parentsMobile" id="pmobile"/>
			
			<input type="submit" value="Add Student">
		</form:form>
	</div>
</body>
</html>
