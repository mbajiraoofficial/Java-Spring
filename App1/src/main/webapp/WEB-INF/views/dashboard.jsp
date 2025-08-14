
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
	 prefix="c" %>

<html>
	<head>
		<title>Users List</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

	</head>
	<body>
		<table class="table table-responsive table-bordered table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>City</th>
					<th>Mobile</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.city}</td>
						<td>${user.mobile}</td>
						<td>
							<a href="/users/edit/${user.id}" class="btn btn-warning">Edit</a>
							<a href="/users/delete/${user.id}" class="btn btn-danger">Delete</a>
						</td>
					</tr>
				</c:forEach>	
			</tbody>
		</table>
	</body>
</html>