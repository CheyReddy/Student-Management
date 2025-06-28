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

	<span class="pageNav">
		<a href="/addStudent">Add Student</a>
	</span>

	<div class="container">
		<table>
			<thead>
				<tr>
					<th>Sl.No</th>
					<th>Name</th>
					<th>Mobile</th>
					<th>Country</th>
					<th colspan="2">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${students}">
					<tr>
						<td data-label="Sl.No">${student.id}</td>
						<td data-label="Name">${student.name}</td>
						<td data-label="Mobile">${student.mobile}</td>
						<td data-label="Country">${student.country}</td>
						<td data-label="modify">
							<a class="update-link" href="/modifyStudent?id=${student.id}">Modify</a>
						</td>
						
						<!--  
						<td data-label="Update">
							<a class="update-link" href="/updateStudent?studentId=${student.id}">Update</a>
						</td>
						<td data-label="Delete">
							<a class="delete-link" href="/removeStudent?studentId=${student.id}"
								onclick="return confirm('Are you sure you want to delete this student?')">Delete</a>
						</td>
						-->
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
