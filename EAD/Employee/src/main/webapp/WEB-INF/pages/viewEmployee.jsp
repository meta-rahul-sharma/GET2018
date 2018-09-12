<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Employee</title>
</head>
<body>
	<h1>Employee Details</h1>
	
	<table>
		<tr>
			<td>Employee Code :</td>
			<td>${employee.employeeCode}</td>
		</tr>
		<tr>
			<td>Name :</td>
			<td>${employee.firstName} ${employee.middleName} ${employee.lastName}</td>
		</tr>
		<tr>
			<td>Date of Birth :</td>
			<td>${employee.dob}</td>
		</tr>
		<tr>
			<td>Email :</td>
			<td>${employee.email}</td>
		</tr>
		<tr>
			<td>Contact :</td>
			<td>${employee.primaryContact} ${employee.secondaryContact}</td>
		</tr>
		<tr>
			<td>Skype Id :</td>
			<td>${employee.skypeId}</td>
		</tr>
	</table>

</body>
</html>