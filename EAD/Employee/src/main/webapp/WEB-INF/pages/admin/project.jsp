<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="project" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Description:</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td>Start Date:</td>
				<td><input type="date" name="startDate"></td>
			</tr>
			<tr>
				<td>End Date:</td>
				<td><input type="date" name="endDate"></td>
			</tr>
			<tr>
				<td>Project Logo:</td>
				<td><input type="file" name="logo"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>	
	</form>
</body>
</html>