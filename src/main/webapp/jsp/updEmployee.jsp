<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title></title>

</head>
<body >
<center>
	<form method="POST" name='formEmployee' action="updateEmployee">
		<h2>Update Employee</h2>
		<table>
			<tr>
				<td><label for="id">Employee ID: <c:out value="${emp.employees_id}" /></label></td>
			</tr>
			<tr>
				<td><input type="hidden" id="employees_id" readonly name="employees_id" value="<c:out value="${emp.employees_id}" />" /></td>
			</tr>
			<tr>
				<td><label for="departments_id">Department ID: <c:out value="${emp.departments_id}" /></label></td>
			</tr>
			<tr>
				<td><input type="hidden" id="departments_id" name="departments_id" value="<c:out value="${emp.departments_id}" />" /></td>
			</tr>

			<tr>
				<td><label for="first_name">First Name</label></td>
			</tr>
			<tr>
				<td><input type="text" name="first_name" id="first_name" value="<c:out value="${emp.first_name}" />" /><span class="error"><c:out value="${error.first_name}" /></span></td>
			</tr>
			
			<tr>
				<td><label for="last_name">Last Name</label></td>
			</tr>
			<tr>
				<td><input type="text" name="last_name" id="last_name" value="<c:out value="${emp.last_name}" />" /><span class="error"><c:out value="${error.last_name}" /></span></td>
			</tr>

			<tr>
				<td><label for="mail">Email</label></td>
			</tr>
			<tr>
				<td><input type="text" name="mail" id="mail" value="<c:out value="${emp.mail}" />" /><span class="error"><c:out value="${error.email}" /></span></td>
			</tr>

			<tr>
				<td><label for="position">Position</label>
			</tr>

			<tr>
				<td><input type="text" name="position" id="position" value="<c:out value="${emp.position}" />" /><span class="error"><c:out value="${error.position}" /></span></td>
			</tr>
			
			<tr>
				<td><label for="salary">Salary</label></td>
			</tr>
			<tr>
				<td><input type="text" name="salary" id="salary" value="<c:out value="${emp.salary}" />" /><span class="error"><c:out value="${error.salary}" /></span></td>
			</tr>

			<tr>
				<td><label for="dat">Day: YYYY-MM-DD </label></td>
			</tr>
			<tr>
				<td><input type="text"  name="dat" id="dat" value="<c:out value="${emp.dat.toString()}" />" /> <span class="error"><c:out value="${error.dat}" /></span></td>
			</tr>


		</table>
		<br> <br> <input type="submit" value="Update">
	</form>
	</center>
</body>
</html>