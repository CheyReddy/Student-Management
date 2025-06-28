<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard | Student Management System</title>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="/resources/css/adminHome.css">
</head>
<body>

	<div class="form-container">
		<div class="top-bar">
			<a class="logout-link" href="/login">Logout</a>
		</div>
			<h1>Dashboard</h1>
		<div class="button-group">
			<a class="dashboard-btn" href="/addStudent"> <img alt=""
				src="/resources/images/student.png"> <span>Add Student</span>
			</a> <a class="dashboard-btn" href="/modifyStudent"> <img alt=""
				src="/resources/images/modify-student.png"> <span>Modify
					Student</span>
			</a> <a class="dashboard-btn" href="/showStudent"> <img alt=""
				src="/resources/images/multiple-students.png"> <span>Show
					Students</span>
			</a> <a class="dashboard-btn" href="/addAdmin"> <img alt=""
				src="/resources/images/admin.png"> <span>Add Admin</span>
			</a> <a class="dashboard-btn" href="/modifyAdmin"> <img alt=""
				src="/resources/images/modify-admin.png"> <span>Modify
					Admin</span>
			</a> <a class="dashboard-btn" href="/showAdmins"> <img alt=""
				src="/resources/images/multiple-admins.png"> <span>Show
					Admins</span>
			</a>
		</div>

	</div>
</body>
</html>
