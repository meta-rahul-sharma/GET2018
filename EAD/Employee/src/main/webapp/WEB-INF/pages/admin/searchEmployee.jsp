<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
	<form action="searchEmployee" method="post">
		<table>
			<tr>
				<td>Search criteria:</td>
				<td><select name="criteria">
						<option value="name">Name</option>
						<option value="project">Project</option>
						<option value="skill">Skill</option>
						<option value="experience">Total Experience</option>
					</select></td>
			</tr>
			<tr>
				<td>Enter search keyword:</td>
				<td><input type="text" name="keyword"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Search" /></td>
			</tr>
		</table>	
	</form>
</body>
</html>