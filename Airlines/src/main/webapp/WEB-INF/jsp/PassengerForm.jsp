<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Form</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	margin: 0;
	padding: 0;
}

div.container {
	text-align: center;
	margin: 20px auto;
	max-width: 800px;
	background-color: #fff;
	padding: 20px;
	border: 1px solid #ddd;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
	color: #333;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

table, th, td {
	border: 1px solid #ddd;
}

th, td {
	padding: 10px;
	text-align: left;
}

th {
	background-color: #333;
	color: #fff;
}

input[type="text"] {
	width: 100%;
	padding: 8px;
	margin: 5px 0;
}

input[type="submit"] {
	background-color: #333;
	color: #fff;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Flight Form</h1>
		<f:form action="savePassenger" method="POST"
			modelAttribute="passenger">
			<table>
				<tr>
					<td>Passenger Id</td>
					<td><f:input path="passengerId" value="${p.passengerId}" /></td>
				</tr>

				<tr>
					<td>First Name</td>
					<td><f:input path="fname" value="${p.fname}" /></td>
				</tr>

				<tr>
					<td>Last Name</td>
					<td><f:input path="lname" value="${p.lname}" /></td>
				</tr>

				<tr>
					<td>Email Id</td>
					<td><f:input path="email" value="${p.email}" /></td>
				</tr>
				<tr>
					<td>P.h. No.:</td>
					<td><f:input path="phone" value="${p.phone}" /></td>
				</tr>


				<tr>
					<td>Gender</td>
					<td><f:radiobutton path="gender" class="Passenger" value="M" />Male<f:radiobutton
							path="gender" class="Passenger" value="F" />Female<f:radiobutton
							path="gender" class="Passenger" value="Others" />Others</td>
				</tr>

				<tr>
					<td>DOB:<f:input type="date" path="dateOfBirth"
							class='Passenger' value="${p.dateOfBirth} }" /></td>
				</tr>
				<tr>
					<td><input type="submit" /></td>
				</tr>
			</table>
		</f:form>
	</div>
	<c:forEach items="${Passengers}" var="p">
	</c:forEach>
</body>
</html>
