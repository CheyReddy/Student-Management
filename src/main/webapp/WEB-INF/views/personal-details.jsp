<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/resources/css/personalDetails.css">
</head>
<body>
    <div class="form-container">
        <h1>Profile</h1>
        <form:form action="/processProfileUpdate" method="post" modelAttribute="profile">

            <label for="name">Name:</label>
            <form:input path="name" id="name" readonly="true"/>

            <label for="dob">DOB:</label>
            <form:password path="dob" id="dob" readonly="true"/>

            <label for="gender">Gender:</label>
            <form:input path="gender" id="gender" readonly="true"/>

            <label for="mobile">Mobile:</label>
            <form:input path="mobile" id="mobile"/>

            <label for="email">Email:</label>
            <form:input path="email" id="email"/>
            
            <label for="password">Password: </label>
            <form:password path="password"/>

			<label for="pmobile">Parents Mobile:</label>
            <form:input path="parentsMobile" id="pmobile" readonly="true"/>
			
            <input type="submit" value="Update"/>
        </form:form>
    </div>
</body>
</html>
