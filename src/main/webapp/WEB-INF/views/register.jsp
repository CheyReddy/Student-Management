<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Love Calculator - Registration</title>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap"
	rel="stylesheet">

<link rel="stylesheet" type="text/css" href="/resources/css/register.css">
</head>
<body>
	<div class="form-container">
		<h1>Student Registration</h1>
		<form:form action="/processRegister" method="post"
			modelAttribute="register">

			<label>Name:</label>
			<form:input path="name" />
			<form:errors path="name" cssClass="error" />
			
			<label>Date of Birth:</label>
			<form:input path="dob" placeholder="dd-mm-yyyy"/>
			<form:errors path="dob" cssClass="error" />

			<label>Gender:</label>
			<div class="inline-group">
				<label><form:radiobutton path="gender" value="male" /> Male</label>
				<label><form:radiobutton path="gender" value="female" />
					Female</label>
			</div>
			<form:errors path="gender" cssClass="error" />

			<label>Mobile:</label>
			<form:input path="mobile" />
			<form:errors path="mobile" cssClass="error" />

			<label>Email:</label>
			<form:input path="email" />
			<form:errors path="email" cssClass="error" />
			
			<label>Parents Mobile:</label>
			<form:input path="pmobile" />
			<form:errors path="parentsMobile" cssClass="error" />
			
			<input type="submit" value="Register" />
		</form:form>
	</div>
</body>
</html>
