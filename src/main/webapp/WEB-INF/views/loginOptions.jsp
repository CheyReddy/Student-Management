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
        <a href="/login?loginType=admin">Admin</a>
        <a href="/login?loginType=student">Student</a>
        <a href="/login?loginType=parent">Parent</a>
    </div>

</body>
</html>
