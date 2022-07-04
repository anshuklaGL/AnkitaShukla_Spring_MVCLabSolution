<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1 {text-align: center;}
div {text-align: center;}

th, td {
  background-color: #96D4D4;
}
th, td {
  padding: 15px;
}
th, td {
  padding-top: 10px;
  padding-bottom: 20px;
  padding-left: 30px;
  padding-right: 40px;
}

</style>
<meta charset="UTF-8">
<title>Student Details System - students</title>
</head>
<body>

<h1>Register new Student</h1>
<div>
<a href="addNewStudent">Click her to add New Student</a>
</div>
<h1>List of Existing Students</h1>
<table style="border:1px solid black;margin-left:auto;margin-right:auto;">
<thead>
	<tr>
		<th>Name</th>
		<th>Department</th>
		<th>Country</th>
		<th>Action</th>
	</tr>
</thead>
<c:forEach items="${students}" var="studentObj">
	<tr>
		<td>${studentObj.name}</td>
		<td>${studentObj.department}</td>
		<td>${studentObj.country}</td>
		<td><a href="updateStudent?id=${studentObj.id}">Update</a>
			<a href="deleteStudent?id=${studentObj.id}">Delete</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>