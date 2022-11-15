<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<div class="container mt-3">
			<h2>
				<c:if test="${user != null }">Edit Employee</c:if>
				<c:if test="${user == null }">Add New Employee</c:if>
			</h2>
			<c:if test="${user != null }">
			<form action="update" method="post">
			</c:if>
			<c:if test="${user == null }">
			<form action="insert" method="post">
			</c:if>
				<div class="mb-3 mt-3">
					<c:if test="${user != null }">
						<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
					</c:if>
				</div>
				<div class="mb-3 mt-3">
					<label>FirstName :</label>
					<input type="text" class="form-control"  value="<c:out value='${user.firstName }' />" name="firstname">
				</div>
				<div class="mb-3 mt-3">
					<label>LastName :</label>
					<input type="text" class="form-control"  value="<c:out value='${user.lastName }' />" name="lastname">
				</div>
				<div class="mb-3 mt-3">
					<label>Username :</label>
					<input type="text" class="form-control"  value="<c:out value='${user.username }' />" name="username">
				</div>
				<div class="mb-3 mt-3">
					<label>Password :</label>
					<input type="password" class="form-control"  value="<c:out value='${user.password }' />" name="password">
				</div>
				<div class="mb-3 mt-3">
					<label>Address :</label>
					<input type="text" class="form-control"  value="<c:out value='${user.address }' />" name="address">
				</div>
				<div class="mb-3 mt-3">
					<label>ContactNumber :</label>
					<input type="number" class="form-control"  value="<c:out value='${user.contactNumber }' />" name="contactnumber">
				</div>
				<div class="mb-3 mt-3">
					<button type="submit" class="btn btn-primary">Save</button>
				</div>	
			</form>
		</div>
	</body>
</html>