<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>TMS - Login</title>
	<link rel="shortcut icon" href="image/icon.png">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="style/login.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>
				<form action="login.do" method="post" class="form-horizontal">
					<div class="border">
						<div class="font"><a href="login.html" style="text-decoration: none">Training Management System</a></div>
						<hr>
						<c:if test="${userLogin.getErrorStatus()}">
							<div class="alert alert-danger alert-dismissible" role="alert" id="errorMesssage">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								<c:forEach var="message" items="${userLogin.getErrorMessage()}">
									<strong><c:out value="${message}"><br></c:out></strong>
								</c:forEach>
							</div>
							<c:remove var="userLogin"/>
						</c:if>
						<div class="form-group">
							<label class="col-sm-3 control-label">Login</label>
							<div class="col-sm-9">
								<input name="login" type="text" class="form-control" id="login" placeholder="Login">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">Password</label>
							<div class="col-sm-9">
								<input name="password" type="password" class="form-control" id="password" placeholder="Password">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-10">
								<button type="submit" name="sign-in" class="btn btn-success">Sign in</button>
								<a href="registration.html" class="btn btn-default">Registration</a>
							</div>
						</div>
					</div>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>