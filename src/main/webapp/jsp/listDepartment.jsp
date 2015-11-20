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
	<h1 align="center">Список депортаментов</h1>
	<table border="1">
		<thead>
			<tr>
				<th>ID:</th>
				<th>Name:</th>
				<th>Specification</th>
				<th>Edit:</th>
				<th>Delete:</th>
				<th>List Employee</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dep" items="${dep}">
				<tr>
					<td><c:out value="${dep.id}" /></td>
					<td><c:out value="${dep.name}" /></td>
					<td><c:out value="${dep.specification}" /></td>

					<td><input type=button onClick="location.href='/employeesAndDepartments/updateDepartment?id=<c:out value="${dep.id}"/>'" value='Edit'></td>
					<td>
						<form method="POST" action="/employeesAndDepartments/deleteDepartment">
							<input type="submit" name="deleteForm" value="Delete"> <input type="hidden" name="delete" value="${dep.id}">
						</form>
					</td>

					<td><input type=button onClick="location.href='/employeesAndDepartments/listEmployee?departments_id=<c:out value="${dep.id}"/>'" value='List Employee'></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type=button onClick="location.href='/employeesAndDepartments/addDepartment'" value='Add Department'>
</body>
</html>