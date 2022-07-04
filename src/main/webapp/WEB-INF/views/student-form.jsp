<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details System - Student Form</title>
</head>
<style>
 label {
        display: inline-block;
        width: 150px;
      }

 input[type="submit"] {
   transform: translate(2.2%);
   padding: 3px;
   margin-top: 0.6rem;
   font-weight: bold;
  }
</style>
<body>
	<h1>Enter Student details</h1>

	<form action="save" method="post">
		<input type="hidden" name="id" value="${studentObj.id}">
		<label for="name">Name:</label>
		<input type="text" name="name" value="${studentObj.name}">
		<br>
		<label for="department">Department:</label>
		<input type="text" name="department" value="${studentObj.department}">
		<br>
		<label for="country">Country:</label>
		<input type="text" name="country" value="${studentObj.country}">
		<br>
		<input type="submit" value="Save Student" >
	</form>
	<br>
	<div>
	<a href="list">Back to list of students</a>
	</div>
</body>
</html>
