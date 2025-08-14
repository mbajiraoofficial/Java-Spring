<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
	 prefix="c" %>

<html>
	<head>
		<title>User Login</title>
	</head>
	<body>
		
		<form method="post" action="/login">
			UserId:
			<input type="text" name="userid"/>
			<br/>
			Password:
			<input type="password" name="password"/>
			<br/>
			<button type="reset">Reset</button>
			<button type="submit">Submit</button>
		</form>
		
		<c:if test="${not empty error}">
			<p style="color:red">${error}</p>
		</c:if>
	</body>

</html>