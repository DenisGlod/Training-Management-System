<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<c:if test="${userRegistration.getErrorStatus() == false}"><meta http-equiv="refresh" content="5; url=login.html"></c:if>
	<title>TMS - Registration</title>
	<link rel="shortcut icon" href="image/icon.png">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="style/login.css">
	<link rel="stylesheet" href="style/registration.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>
				<div class="border">
					<form action="registration.do" method="post"  class="form-horizontal">
						<div class="font">Registration</div>
						<hr>
						<c:if test="${userRegistration.getErrorStatus()}">
							<div class="alert alert-danger alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								<c:forEach var="message" items="${userRegistration.getErrorMessage()}">
									<strong><c:out value="${message}"><br></c:out></strong>
								</c:forEach>
							</div>
						</c:if>
						<c:if test="${userRegistration.getErrorStatus() == false}">
							<div class="alert alert-success alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								<strong>Registration successfully completed.<br>Redirecting to login form in 5 seconds.</strong>
							</div>
						</c:if>
						<div class="form-group">
							<label class="col-sm-4 control-label">Login</label>
							<div class="col-sm-7">
								<input name="login" type="text" class="form-control" id="login" placeholder="Login" <c:if test="${userRegistration.getErrorStatus()}">value="${userRegistration.getLogin()}"</c:if>>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">Password</label>
							<div class="col-sm-7">
								<input name="password" type="password" class="form-control" id="password" placeholder="Password" <c:if test="${userRegistration.getErrorStatus()}">value="${userRegistration.getPassword()}"</c:if>>
							</div>
						</div>
						<hr>
						<div class="form-group">
							<label class="col-sm-4 control-label">Last name</label>
							<div class="col-sm-7">
								<input name="lastName" type="text" class="form-control" id="lastName" placeholder="Last name" <c:if test="${userRegistration.getErrorStatus()}">value="${userRegistration.getLastName()}"</c:if>>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">First name</label>
							<div class="col-sm-7">
								<input name="firstName" type="text" class="form-control" id="firstName" placeholder="First name" <c:if test="${userRegistration.getErrorStatus()}">value="${userRegistration.getFirstName()}"</c:if>>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">Middle name</label>
							<div class="col-sm-7">
								<input name="middleName" type="text" class="form-control" id="middleName" placeholder="Middle name" <c:if test="${userRegistration.getErrorStatus()}">value="${userRegistration.getMiddleName()}"</c:if>>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-10">
								<button type="submit" name="registration" class="btn btn-primary">Registration</button>
							</div>
						</div>
						<c:remove var="userRegistration"/>
					</form>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>