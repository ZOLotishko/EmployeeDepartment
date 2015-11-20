<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title></title>
<style>
   <%@include file='style.css' %>
</style>
</head>
<body>
	<h1>List Employee</h1>
	<h2>Department: <c:out value="${departments_id}"/></h2>
	<table border="1">
		<thead>
			<tr>
				<th>ID:</th>
				<th>First Name:</th>
				<th>Last Name:</th>
				<th>Email:</th>
				<th>Position:</th>
				<th>Salary</th>
				<th>Born day:</th>
				<th>id Dept:</th>
				<th>Delete:</th>
				<th>Edit:</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${emp}">
				<tr>
					<td><c:out value="${emp.employees_id}" /></td>
					<td><c:out value="${emp.first_name}" /></td>
					<td><c:out value="${emp.last_name}"></c:out>
					<td><c:out value="${emp.mail}" /></td>
					<td><c:out value="${emp.position}" /></td>
					<td><c:out value="${emp.salary}"></c:out>
					<td><c:out value="${emp.dat}" /></td>
					<td><c:out value="${departments_id}" /></td>
					<td>
						<form method="POST" action="/employeesAndDepartments/deleteEmployee">
							<input type="submit" name="deleteForm" value="Delete Employee"> <input type="hidden" name="delete" value="${emp.employees_id}">
						</form>
					</td>
					<td><input type=button onClick="location.href='/employeesAndDepartments/updateEmployee?employees_id=<c:out value="${emp.employees_id}" />'" value='Update'></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type=button onClick="location.href='/employeesAndDepartments/addEmployee?departments_id=<c:out value="${departments_id}"/>'" value='Add Employee'>
</body>
</html>