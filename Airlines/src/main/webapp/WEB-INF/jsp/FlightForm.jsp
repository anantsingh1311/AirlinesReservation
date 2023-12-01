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
		<f:form action="saveFlight" method="POST" modelAttribute="flight">
			<table>
				<tr>
					<td>Flight Id</td>
					<td><f:input path="flightId" value="${f.flightId}" /></td>
				</tr>

				<tr>
					<td>Flight Number</td>
					<td><f:input path="flightNum" value="${f.flightNum}" /></td>
				</tr>

				<tr>
					<td>Departure City</td>
					<td><f:input path="departureCity" value="${f.departureCity}" /></td>
				</tr>

				<tr>
					<td>Arrival City</td>
					<td><f:input path="arrivalCity" value="${f.arrivalCity}" /></td>
				</tr>
				<tr>
					<td>Price(in $)</td>
					<td><f:input path="ticketPrice" value="${f.ticketPrice}" /></td>
				</tr>


				<tr>
					<td>Capacity</td>
					<td><f:input path="capacity" value="${f.capacity}" /></td>
				</tr>

				<tr>
					<td>booked</td>
					<td><f:input path="booked" value="${f.booked}" /></td>
				</tr>




				<tr>
					<td><input type="submit" /></td>
				</tr>
			</table>
		</f:form>
	</div>

	<div class="container">
		<c:if test="${not empty flightList}">
			<table>
				<tr>
					<th>Flight Id</th>
					<th>Number</th>
					<th>Departure City</th>
					<th>Arrival City</th>
					<th>Price</th>
					<th>Capacity</th>
					<th>Booked</th>
				</tr>
				<c:forEach items="${flightList}" var="f">
					<tr>
						<td>${f.getFlightId()}</td>
						<td>${f.getFlightNum()}</td>
						<td>${f.getDepartureCity()}</td>
						<td>${f.getArrivalCity()}</td>
						<td>${f.getTicketPrice()}</td>
						<td>${f.getCapacity()}</td>
						<td>${f.getBooked()}</td>


					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>
