<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User HomePage</title>
<link rel="stylesheet" type="text/css" href="/resources/css/studentsList.css">

<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>
<body>
	
	<nav>
		<ul>
			<li><a class="backbtn" href="/adminHome">Back</a></li>
		</ul>
	</nav>

	<h1>Students Management</h1>
	<div class="container">
		<table>
			<thead>
				<tr>
					<th>Admin Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Password</th>
					<th colspan="2">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="admin" items="${admins}">
					<tr>
						<td data-label="Admin Id">${admin.adminId}</td>
						<td data-label="Admin Name">${admin.adminName}</td>
						<td data-label="Admin Email">${admin.adminEmail}</td>
						<td data-label="Admin Password">${admin.adminPassword}</td>
						<td data-label="modify">
							<a class="update-link" href="/modifyAdmin?adminId=${admin.adminId}">Modify</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
