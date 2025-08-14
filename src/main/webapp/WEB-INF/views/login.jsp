<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/resources/css/login.css">
</head>
<body>

    <div class="form-container">
        <h1>Login</h1>
        <form:form action="/processLogin" modelAttribute="admin" method="post">
            <label>Email:</label>
            <form:input path="adminEmail" />
            <form:errors path="adminEmail" cssClass="error" />

            <label>Password:</label>
            <form:password path="adminPassword" />
            <form:errors path="adminPassword" cssClass="error" />

            <div class="actions">
                <a href="#">Forgot Password?</a>
            </div>

            <div class="footer-links">
                <span><a href="#" class="disabled-link" style="display:none;">Register</a></span> 
                <span><input type="submit" value="Login"/></span>
            </div>
        </form:form>
    </div>

</body>
</html>
