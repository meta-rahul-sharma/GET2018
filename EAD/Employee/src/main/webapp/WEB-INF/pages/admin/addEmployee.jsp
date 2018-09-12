<%@page import="com.metacube.training.model.Project"%>
<%@page import="com.metacube.training.service.ProjectServiceImpl"%>
<%@page import="com.metacube.training.service.ProjectService"%>
<%@page import="com.metacube.training.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.metacube.training.service.EmployeeServiceImpl"%>
<%@page import="com.metacube.training.service.EmployeeService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pre-Signup</title>
</head>
<body>
	
	<h1>Pre-Signup</h1>
	
	<%  
		EmployeeService employeeService = EmployeeServiceImpl.getInstance();
		List<Employee> listOfEmployees = employeeService.getAllEmployees();
		
		ProjectService projectService = ProjectServiceImpl.getInstance();
		List<Project> listOfProjects = projectService.getAllProjects();
	%>
	
	<form action="addEmployee" method="post">
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="fname"></td>
			</tr>
			<tr>
				<td>Middle Name:</td>
				<td><input type="text" name="mname"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lname"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email"></td>
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
				<td>Date Of Joining:</td>
				<td><input type="date" name="doj"></td>
			</tr>
			<tr>
				<td>Reporting Manager:</td>
				<td><select name="reportingMgr">
						<option value="n/a">N/A</option>
						<% for(Employee employee: listOfEmployees) 
							{
						%>
						<option value="<%= employee.getEmployeeCode() %>" ><%=employee.getEmployeeCode() %></option>
						<%	}
						%>
					</select></td>
			</tr>
			<tr>
				<td>Team Lead:</td>
				<td><select name="teamLead">
						<option value="n/a">N/A</option>
						<% for(Employee employee: listOfEmployees) 
							{
						%>
						<option value="<%= employee.getEmployeeCode() %>" ><%=employee.getEmployeeCode() %></option>
						<%	} 
						%>
					</select></td>
			</tr>	
			<tr>
				<td>Project Id:</td>
				<td><select name="projectId">
						<option value=0 >N/A</option>
						<% for(Project project: listOfProjects)
							{
						%>
						<option value=<%= project.getProjectId()%>><%= project.getProjectId()%></option>
						<%	}
						%>
					</select></td>
			</tr>		
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>	
	</form>
</body>
</html>