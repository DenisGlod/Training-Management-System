<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				<div class="scroll">
					<div class="table-responsive">
						<table class="table table-bordered">
							<thead><tr><th>#</th><th>Login</th><th>Password</th><th>Role</th><th>Last Name</th><th>First Name</th><th>Middle Name</th><th>Actions</th></tr></thead>
							<tbody>
								<c:set var="index" scope="session" target="${1}"/>
								<c:forEach var="user" items="${userTable}">
								<tr> 
									<th scope="row">${index = index+1}</th>
									<td>${user.getLogin()}</td>
									<td>${user.getPassword()}</td>
									<td>${user.getRole()}</td>
									<td>${user.getLastName()}</td>
									<td>${user.getFirstName()}</td>
									<td>${user.getMiddleName()}</td>
									<td>
										<button type="submit" class="btn btn-warning btn-xs" name="edit users" value="${user.getIdUser()}">
											<span class="glyphicon glyphicon-edit"></span> Edit
										</button>
										<button type="submit" class="btn btn-danger btn-xs" name="delete users" value="${user.getIdUser()}">
											<span class="glyphicon glyphicon-remove"></span> Delete
										</button>
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<button type="submit" class="btn btn-warning" name="add user" value="add user">Add User</button><br><br>
				<div class="center">
					<div class="size_for_alert">
						<c:if test="${user.getErrorStatus() == true}">
							<div class="alert alert-danger alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								<c:forEach var="message" items="${user.getErrorMessage()}">
									<strong><c:out value="${message}"><br></c:out></strong>
								</c:forEach>
							</div>
						</c:if>	
						<c:if test="${user.getErrorStatus() == false}">
							<div class="alert alert-success alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								<c:forEach var="message" items="${user.getErrorMessage()}">
									<strong><c:out value="${message}"><br></c:out></strong>
								</c:forEach>
							</div>	
						</c:if>	
					</div>
					<c:if test="${addStatus}">
						<label>Add New User</label>
						<div class="form-group form-inline">
							<input type="text" class="form-control" placeholder="Login" name="login"> 
							<input type="text" class="form-control" placeholder="Password" name="password">
							<select class="form-control" name="role">
								<option disabled selected>Select role...</option>
							  	<option value="listener">Listener</option>
							  	<option value="admin">Admin</option>
							 	<option value="teacher">Teacher</option>
							</select>
							<input type="text" class="form-control" placeholder="Last Name" name="lastName">
							<input type="text" class="form-control" placeholder="First Name" name="firstName">
							<input type="text" class="form-control" placeholder="Middle Name" name="middleName">
							<button type="submit" class="btn btn-success" name="save user" value="save user">Save</button>
						</div>
					</c:if>
					<c:if test="${editStatus}">
						<label>Edit User</label>
						<div class="form-group form-inline">
							<input type="text" class="form-control" placeholder="Login" name="login" value="${editUser.getLogin()}"> 
							<input type="text" class="form-control" placeholder="Password" name="password" value="${editUser.getPassword()}">
							<select class="form-control" name="role">
								<option disabled <c:if test="${editUser.getRole() eq null}">selected</c:if>>Select role...</option>
							  	<option value="listener" <c:if test="${editUser.getRole() eq 'listener'}">selected</c:if>>Listener</option>
							  	<option value="admin" <c:if test="${editUser.getRole() eq 'admin'}">selected</c:if>>Admin</option>
							 	<option value="teacher" <c:if test="${editUser.getRole() eq 'teacher'}">selected</c:if>>Teacher</option>
							</select>
							<input type="text" class="form-control" placeholder="Last Name" name="lastName" value="${editUser.getLastName()}">
							<input type="text" class="form-control" placeholder="First Name" name="firstName" value="${editUser.getFirstName()}">
							<input type="text" class="form-control" placeholder="Middle Name" name="middleName" value="${editUser.getMiddleName()}">
							<button type="submit" class="btn btn-success" name="update user"  value="${editUser.getIdUser()}">Update</button>
						</div>
					</c:if>
				</div>