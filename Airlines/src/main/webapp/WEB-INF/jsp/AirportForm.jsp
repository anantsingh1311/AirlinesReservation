<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Airport Form</title>
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
    <h1>Airport Form</h1>
    <f:form action="saveAirport" method="POST" modelAttribute="airport">
        <table>
            <tr>
                <td>Airport Id</td>
                <td><f:input path="airportId" value="${a.airportId}" /></td>
            </tr>

            <tr>
                <td>City</td>
                <td><f:input path="airportCity" value="${a.airportCity}" /></td>
            </tr>

            <tr>
                <td>Code</td>
                <td><f:input path="airportCode" value="${a.airportCode}" /></td>
            </tr>
            <tr>
                <td><input type="submit" /></td>
            </tr>
        </table>
    </f:form>
</div>

<div class="container">
    <c:if test="${not empty airports}">
        <table>
            <tr>
                <th>Airport Id</th>
                <th>City</th>
                <th>Code</th>
            </tr>
            <c:forEach items="${airports}" var="a">
                <tr>
                    <td>${a.getAirportId()}</td>
                    <td>${a.getAirportCity()}</td>
                    <td>${a.getAirportCode()}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>

