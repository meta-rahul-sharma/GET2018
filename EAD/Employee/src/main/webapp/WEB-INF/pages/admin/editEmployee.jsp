<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
</head>
<body>
	<h1>Edit Employee Details</h1>
	
	<form action="editEmployee" method="post">
		<table>
			<tr>
				<td>Employee Code :</td>
				<td><input type="text" name="employeeCode" value="${employee.employeeCode}"></td>
			</tr>
			<tr>
				<td>First Name :</td>
				<td><input type="text" name="firstName" value="${employee.firstName}"></td>
			</tr>
			<tr>
				<td>Middle Name :</td>
				<td><input type="text" name="middleName" value="${employee.middleName}"></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><input type="text" name="lastName" value="${employee.lastName}"></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" value="m"> Male</td>
  				<td><input type="radio" name="gender" value="f"> Female</td>
  				<td><input type="radio" name="gender" value="o"> Other</td>
			</tr>
			<tr>
				<td>Date of Birth :</td>
				<td><input type="date" name="dob" value="${employee.dob}"></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="email" name="email" value="${employee.email}"></td>
			</tr>
			<tr>
				<td>Primary Contact :</td>
				<td><input type="tel" name="primaryContact" value="${employee.primaryContact}"></td>
			</tr>
			<tr>
				<td>Secondary Contact :</td>
				<td><input type="tel" name="secondaryContact" value="${employee.secondaryContact}"></td>
			</tr>
			<tr>
				<td>Skype Id :</td>
				<td><input type="text" name="skypeId" value="${employee.skypeId}"></td>
			</tr>
			<tr>
				<td>Enabled :</td>
				<td><select name="enabled">
						<option value="${employee.enabled}">${employee.enabled}</option>
						<option value="true">true</option>
						<option value="false">false</option>
					</select></td>
			</tr>
			<tr>
				<td><input type="hidden" name="password" value="${employee.password}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form>
</body>
</html>