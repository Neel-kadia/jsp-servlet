<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
			<h2>Employees</h2>
			<div class="container">
				<h2 align="right">
					<a href="<%= request.getContextPath() %>/new"><button type="submit" class="btn btn-primary">AddNewUser</button></a>
				</h2> 
				<h2 align="left">
					<a href="<%= request.getContextPath() %>/list"><button type="submit" class="btn btn-primary">List employees</button></a>
				</h2>
			</div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>FirstName</th>
						<th>LatName</th>
						<th>Username</th>
						<th>Password</th>
						<th>Address</th>
						<th>ContactNumber</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var= "emp" items="${listEmployee}">
					<tr>
						<td>
							<c:out value="${emp.id}"/>
						</td>
						<td>
							<c:out value="${emp.firstName}"/>
						</td>
						<td>
							<c:out value="${emp.lastName}"/>
						</td>
						<td>
							<c:out value="${emp.username}"/>
						</td>
						<td>
							<c:out value="${emp.password}"/>
						</td>
						<td>
							<c:out value="${emp.address}"/>
						</td>
						<td>
							<c:out value="${emp.contactNumber}"/>
						</td>
						<td>
							<a href="edit?id=<c:out value='${emp.id }'/>"><button type="button" class="btn btn-info">Edit</button></a>
							<a href="delete?id=<c:out value='${emp.id}'/>"><button type="button" class="btn btn-danger">Delete</button></a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>