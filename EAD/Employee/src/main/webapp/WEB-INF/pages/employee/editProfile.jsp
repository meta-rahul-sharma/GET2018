<%@page import="com.metacube.training.model.Skill"%>
<%@page import="java.util.List"%>
<%@page import="com.metacube.training.service.SkillServiceImpl"%>
<%@page import="com.metacube.training.service.SkillService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile</title>
</head>
<body>
	
	<h1>Edit Profile</h1>

	<%  
		SkillService skillService = SkillServiceImpl.getInstance();
		List<Skill> listOfSkills = skillService.getAllSkills();
	%>
	<form action="editProfile" method="post">
		<table>
			<tr>
				<td>Employee Code :</td>
				<td><input type="text" name="employeeCode" value="${employee.employeeCode}"></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName" value="${employee.firstName}"></td>
			</tr>
			<tr>
				<td>Middle Name:</td>
				<td><input type="text" name="middleName" value="${employee.middleName}"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName" value="${employee.lastName}"></td>
			</tr>
			<tr>
				<td>Date Of Birth:</td>
				<td><input type="date" name="dob"></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" value="m"> Male</td>
  				<td><input type="radio" name="gender" value="f"> Female</td>
  				<td><input type="radio" name="gender" value="o"> Other</td>
			</tr>
			<tr>
				<td>Primary Contact:</td>
				<td><input type="tel" name="primaryContact" value="${employee.primaryContact}"></td>
			</tr>
			<tr>
				<td>Secondary Contact:</td>
				<td><input type="tel" name="secondaryContact" value="${employee.secondaryContact}"></td>
			</tr>
			<tr>
				<td>Skype ID:</td>
				<td><input type="text" name="skypeId" value="${employee.skypeId}"></td>
			</tr>
			<tr>
				<td>Skills(Press ctrl to select multiple):</td>
				<td><select name="skills" multiple="multiple">
						<option value="n/a" selected="selected">N/A</option>
						<% for(Skill skill: listOfSkills) 
							{
						%>
						<option value="<%= skill.getName() %>" ><%=skill.getName() %></option>
						<%	}
						%>
					</select></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td>Change Password:</td>
				<td><input type="hidden" name="oldPassword" value="${employee.password}"></td>
			</tr>
			<tr>
				<td>New Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input type="password" name="confirmPassword"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="enabled" value="${employee.enabled}"></td>
				<td><input type="hidden" name="email" value="${employee.email}"></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>	
	</form>
</body>
</html>