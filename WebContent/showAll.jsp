<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="EmployeeController?action=add"> Add New Employee</a>
	<br>
	<table cellpadding="2" cellspacing = "2" border="1">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Department</th>
			<th>Option</th>
		</tr>
		<c:forEach var="e" items="${employeeList}">
			<tr>
				<td><c:out value = "${e.id}"/> </td>
				<td><c:out value = "${e.firstName}"/></td>
				<td><c:out value = "${e.lastName}"/></td>
				<td><c:out value = "${e.department}"/></td>
				<td>
					<a href="EmployeeController?action=delete&id=${e.id}" onclick="return confirm('Are you sure?')">Delete</a>
					<a href="EmployeeController?action=update&id=${e.id}">Update</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br><br>	
	<p>Directly SQL Manner</p>
	<a href="EmployeeController?action=add"> Add New Employee</a>
	<br>	
	<table cellpadding="2" cellspacing = "2" border="1">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Department</th>
			<th>Option</th>
		</tr>
		<c:forEach var="e" items="${employeeList}">
			<tr>
				<td><c:out value = "${e.id}"/> </td>
				<td><c:out value = "${e.firstName}"/></td>
				<td><c:out value = "${e.lastName}"/></td>
				<td><c:out value = "${e.department}"/></td>
				<td>
					<a href="EmployeeController?action=delete&id=${e.id}" onclick="return confirm('Are you sure?')">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>		
</body>
</html>