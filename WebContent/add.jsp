<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Employee</title>
</head>
<body>
	<form method="post" action="EmployeeController">
		<table cellpadding="2" cellspacing = "2">
			<tr>
				<td>Id</td>
				<td>
					<input type = "text" name="id">
				</td>
			</tr>
			<tr>
				<td>First Name</td>
				<td>
					<input type = "text" name="firstName">
				</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>
					<input type = "text" name="lastName">
				</td>
			</tr>
			<tr>
				<td>Department</td>
				<td>
					<input type = "text" name="department">
				</td>
			</tr>			
			<tr>
				<td>&nbsp;</td>
				<td align="left">
					<input type="submit" value="save">
				</td>
			</tr>
		</table>
</body>
</html>