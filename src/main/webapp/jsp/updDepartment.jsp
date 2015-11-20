
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>

<head>
<title>Department Update Page</title>
<style>
   <%@include file='style.css' %>
</style>
</head>
<body>
	<form method="POST" name='formDepartment' action="update">
		<h2>Update department name</h2>
		<p>

			<input type="hidden" readonly name="id" id="id" value="<c:out value="${id}" />" /> 
			<label for="name">Название</label> <input type="text" name="name" id="name" value="<c:out value="${name}" />" />
			<span class="error"><c:out value="${error.name}" /></span>
			
			<label for="name">Спецификация</label> <input type="text" name="specification" id="specification" value="<c:out value="${specification}" />" />
			<span class="error"><c:out value="${error.spacification}" /></span>
			
			
		</p>
		<input type="submit" value="Изменить депортаминт">

	</form>

</body>
</html>