<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>New Department</title>
<style>
   <%@include file='style.css' %>
</style>
</head>

<body>
	<center>
		<form method="POST" name='formDepartment' action="addDepartment">
			<h2>Добавить новый депортаминт</h2>
			<table>
				<tr>
					<td><input type="hidden" readonly name="id" id="id" value="<c:out value="${id}" />" /></td>
				</tr>
				<tr>
					<td><label for="name">Название</label></td>
				</tr>
				<tr>
					<td><input type="text" name="name" id="name" value="<c:out value="${name}" />" />
					<span class="error"><c:out value="${error.name}" /></span></td>
				</tr>
				<tr>
					<td><label for="specification">Спeцификация</label></td>
					</tr>
					<tr>
					<td><input type="text" name="specification" id="specification" value="<c:out value="${specification}"/>" />
					<span class="error"><c:out value="${error.specification}" /></span></td>
				</tr>
			</table>
			<input type="submit" value="Добавить депортаминт">

		</form>
	</center>
</body>
</html>