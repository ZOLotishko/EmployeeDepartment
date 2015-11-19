<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>New Employee</title>

</head>
<body>
<center>
	<form method="POST" name='formEmployee' action="addEmployee">
		<h2>Add New Employee</h2>
		<table>
			<tr>
				<td><label for="first_name">First Name</label></td>
				<td>
			</tr>
			<tr>
				<td><input type="text" name="first_name" id="first_name" value="<c:out value="${first_name}" />" /> <span class="error"><c:out value="${error.first_name}" /></span></td>
			</tr>

			<tr>
				<td><label for="last_name">Last Name</label></td>
				<td>
			</tr>
			<tr>
				<td><input type="text" name="last_name" id="last_name" value="<c:out value="${last_name}" />" /> <span class="error"><c:out value="${error.last_name}" /></span></td>
			</tr>

			<tr>
				<td><label for="mail">Email</label></td>
			</tr>
			<tr>
				<td><input type="text" name="mail" id="mail" <c:out value="${mail}"/> /> <span class="error"><c:out value="${error.mail}" /></span></td>
			</tr>

			<tr>
				<td><label for="position">Position</label></td>
			</tr>
			<tr>
				<td><input type="text" name="position" id="position" <c:out value="${position}"/> /> <span class="error"><c:out value="${error.position}" /></span></td>
			</tr>

			<tr>
				<td><label for="salary">Salary</label></td>
			</tr>
			<tr>
				<td><input type="text" name="salary" id="salary" <c:out value="${salary}"/> /> <span class="error"><c:out value="${error.salary}" /></span></td>
			</tr>

			<tr>
				<td><label for="dat">BornDay: YYYY-MM-DD </label></td>
			</tr>
			<tr>
				<td><input type="text" name="dat" id="dat" <c:out value="${dat}"/> /> <span class="error"><c:out value="${error.dat}" /></span></td>
			</tr>

		</table>
		<input type="hidden" readonly name="departments_id" value="<c:out value="${dep_id}"/>" /> <br> 
		<br> <input type="submit" value="Add Employee">
	</form>
	</center>
</body>
</html>