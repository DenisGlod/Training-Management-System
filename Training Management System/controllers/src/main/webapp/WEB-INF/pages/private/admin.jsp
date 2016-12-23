<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>TMS - Admin</title>
	<link rel="shortcut icon" href="image/icon.png">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="style/admin.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="admin.do" method="post" autocomplete="off">
		<div class="status_bar table-responsive">	
			<table class="table_status_bar">
				<tr>
					<td class="log_out">
						<button type="submit" class="btn btn-primary" name="log out" value="log out">
							<span class="glyphicon glyphicon-log-out"></span> Log out
						</button>
					</td>
					<td class="form_name"><h4><strong>TMS - Administrator control panel</strong></h4></td>
					<td class="full_name"><div class="myalert alert-success"><strong><c:out value="${userLogin.getFullName()}"></c:out></strong></div></td>
				</tr>
			</table>
		</div>
		<div class="content">
			<div class="table_btn">
				<button type="submit" class="btn btn-info" name="users table" value="users table">Users Table</button>
				<button type="submit" class="btn btn-info" name="courses table" value="courses table">Courses Table</button>
				<button type="submit" class="btn btn-info" name="groups table" value="groups table">Groups Table</button>
				<button type="submit" class="btn btn-info" name="data groups table" value="data groups table">Data Groups Table</button>
			</div>
			<c:if test="${tableStatus.getUsersTableStatus()}">
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
						<c:if test="${user.getErrorStatus()}">
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
			</c:if>	
			<c:if test="${tableStatus.getCoursesTableStatus()}">
				<div class="scroll">
					<div class="table-responsive">
						<table class="table table-bordered">
							<thead><tr><th>#</th><th>Course Name</th><th>Description</th><th>Status Course</th><th>Actions</th></tr></thead>
							<tbody>
								<c:set var="index" scope="session" target="${1}"/>
								<c:forEach var="course" items="${coursesTable}">
								<tr>
									<th scope="row">${index = index+1}</th>
									<td>${course.getCourseName()}</td>
									<td>${course.getDescription()}</td>
									<td>${course.getStatusCourse()}</td>
									<td>
										<button type="submit" class="btn btn-warning btn-xs" name="edit courses" value="${course.getIdCourse()}">
											<span class="glyphicon glyphicon-edit"></span> Edit
										</button>
										<button type="submit" class="btn btn-danger btn-xs" name="delete courses" value="${course.getIdCourse()}">
											<span class="glyphicon glyphicon-remove"></span> Delete
										</button>
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<button type="submit" class="btn btn-warning" name="add course" value="add course">Add Course</button><br><br>
				<div class="center">
					<div class="size_for_alert">
						<c:if test="${course.getErrorStatus()}">
							<div class="alert alert-danger alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								<c:forEach var="message" items="${course.getErrorMessage()}">
									<strong><c:out value="${message}"><br></c:out></strong>
								</c:forEach>
							</div>
						</c:if>	
						<c:if test="${course.getErrorStatus() == false}">
							<div class="alert alert-success alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								<c:forEach var="message" items="${course.getErrorMessage()}">
									<strong><c:out value="${message}"><br></c:out></strong>
								</c:forEach>
							</div>	
						</c:if>	
					</div>
					<c:if test="${addStatusCourse}">
						<label>Add New Course</label>
						<div class="form-group form-inline">
							<input type="text" class="form-control" placeholder="Course Name" name="course name"> 
							<input type="text" class="form-control" placeholder="Description" name="description">
							<select class="form-control" name="status course">
								<option disabled selected>Select the course status...</option>
							  	<option value="open">Open</option>
							  	<option value="close">Close</option>
							</select>
							<button type="submit" class="btn btn-success" name="save course" value="save course">Save</button>
						</div>
					</c:if>
					<c:if test="${editStatusCourse}">
						<label>Edit Course</label>
						<div class="form-group form-inline">
							<input type="text" class="form-control" placeholder="Course Name" name="course name" value="${editCourse.getCourseName()}"> 
							<input type="text" class="form-control" placeholder="Description" name="description" value="${editCourse.getDescription()}">
							<select class="form-control" name="status course">
								<option disabled <c:if test="${editCourse.getStatusCourse() eq null}">selected</c:if>>Select the course status...</option>
							  	<option value="open" <c:if test="${editCourse.getStatusCourse() eq 'open'}">selected</c:if>>Open</option>
							  	<option value="close" <c:if test="${editCourse.getStatusCourse() eq 'close'}">selected</c:if>>Close</option>
							</select>
							<button type="submit" class="btn btn-success" name="update course"  value="${editCourse.getIdCourse()}">Update</button>
						</div>
					</c:if>
				</div>				
			</c:if>	
			<c:if test="${tableStatus.getGroupsTableStatus()}">
				<div class="scroll">
					<div class="table-responsive">
						<table class="table table-bordered">
							<thead><tr><th>#</th><th>Group Number</th><th>Teacher</th><th>Course Name</th><th>Status Group</th><th>Actions</th></tr></thead>
							<tbody>
								<c:set var="index" scope="session" target="${1}"/>
								<c:forEach var="group" items="${groupsTable}">
								<tr>
									<th scope="row">${index = index+1}</th>
									<td>${group.getIdGroup()}</td>
									<td>${group.getTeacherName()}</td>
									<td>${group.getCourseName()}</td>
									<td>${group.getStatusGroup()}</td>
									<td>
										<button type="submit" class="btn btn-warning btn-xs" name="edit group" value="${group.getIdGroup()}">
											<span class="glyphicon glyphicon-edit"></span> Edit
										</button>
										<button type="submit" class="btn btn-danger btn-xs" name="delete group" value="${group.getIdGroup()}">
											<span class="glyphicon glyphicon-remove"></span> Delete
										</button>
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<button type="submit" class="btn btn-warning" name="add group" value="add group">Add Group</button><br><br>
				<div class="center">
					<div class="size_for_alert">
						<c:if test="${group.getErrorStatus()}">
							<div class="alert alert-danger alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								<c:forEach var="message" items="${group.getErrorMessage()}">
									<strong><c:out value="${message}"><br></c:out></strong>
								</c:forEach>
							</div>
						</c:if>	
						<c:if test="${group.getErrorStatus() == false}">
							<div class="alert alert-success alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								<c:forEach var="message" items="${group.getErrorMessage()}">
									<strong><c:out value="${message}"><br></c:out></strong>
								</c:forEach>
							</div>	
						</c:if>	
					</div>
					<c:if test="${addStatusGroup}">
						<label>Add New Group</label>
						<div class="form-group form-inline">
							<select class="form-control" name="id teacher">
								<option disabled selected>Select teachers...</option>
								<c:forEach var="i" items="${teacher}">
									<option value="${i.getIdUser()}">${i.getFullName()}</option>
								</c:forEach>
							</select>
							<select class="form-control" name="id course">
								<option disabled selected>Select course...</option>
								<c:forEach var="i" items="${course}">
									<option value="${i.getIdCourse()}">${i.getCourseName()}</option>
								</c:forEach>
							</select>
							<select class="form-control" name="status group">
								<option disabled selected>Select the group status...</option>
							  	<option value="open">Open</option>
							  	<option value="started">Started</option>
							  	<option value="close">Close</option>
							</select>
							<button type="submit" class="btn btn-success" name="save group" value="save group">Save</button>
						</div>
					</c:if>
					<c:if test="${editStatusGroup}">
						<label>Edit Group</label>
						<div class="form-group form-inline">
							<select class="form-control" name="id teacher">
								<c:forEach var="i" items="${teacher}">
									<option value="${i.getIdUser()}" <c:if test="${editGroup.getIdTeacher() == i.getIdUser()}">selected</c:if>>${i.getFullName()}</option>
								</c:forEach>
							</select>
							<select class="form-control" name="id course">
								<c:forEach var="i" items="${course}">
									<option value="${i.getIdCourse()}" <c:if test="${editGroup.getIdCourse() == i.getIdCourse()}">selected</c:if>>${i.getCourseName()}</option>
								</c:forEach>
							</select>
							<select class="form-control" name="status group">
							  	<option value="open" <c:if test="${editGroup.getStatusGroup() eq 'open'}">selected</c:if>>Open</option>
							  	<option value="started" <c:if test="${editGroup.getStatusGroup() eq 'started'}">selected</c:if>>Started</option>
							  	<option value="close" <c:if test="${editGroup.getStatusGroup() eq 'close'}">selected</c:if>>Close</option>
							</select>
							<button type="submit" class="btn btn-success" name="update group"  value="${editGroup.getIdGroup()}">Update</button>
						</div>
					</c:if>
				</div>				
			</c:if>		
			<c:if test="${tableStatus.getDataGroupsTableStatus()}">
				<div class="scroll">
					<div class="table-responsive">
						<table class="table table-bordered">
							<thead><tr><th>#</th><th>Group Number</th><th>Teacher</th><th>Course Name</th><th>Listener</th><th>Actions</th></tr></thead>
							<tbody>
								<c:set var="index" scope="session" target="${1}"/>
								<c:forEach var="group" items="${dataGroupsTable}">
								<tr>
									<th scope="row">${index = index+1}</th>
									<td>${group.getIdGroup()}</td>
									<td>${group.getTeacherName()}</td>
									<td>${group.getCourseName()}</td>
									<td>${group.getListenerName()}</td>
									<td>
										<button type="submit" class="btn btn-warning btn-xs" name="edit data group" value="${group.getIdDataGroup()}">
											<span class="glyphicon glyphicon-edit"></span> Edit
										</button>
										<button type="submit" class="btn btn-danger btn-xs" name="delete data group" value="${group.getIdDataGroup()}">
											<span class="glyphicon glyphicon-remove"></span> Delete
										</button>
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<button type="submit" class="btn btn-warning" name="add data group" value="add data group">Add a listener into a group</button><br><br>
				<div class="center">
					<div class="size_for_alert">
						<c:if test="${dataGroup.getErrorStatus()}">
							<div class="alert alert-danger alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								<c:forEach var="message" items="${dataGroup.getErrorMessage()}">
									<strong><c:out value="${message}"><br></c:out></strong>
								</c:forEach>
							</div>
						</c:if>	
						<c:if test="${dataGroup.getErrorStatus() == false}">
							<div class="alert alert-success alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								<c:forEach var="message" items="${dataGroup.getErrorMessage()}">
									<strong><c:out value="${message}"><br></c:out></strong>
								</c:forEach>
							</div>	
						</c:if>	
					</div>
					<c:if test="${addStatusDataGroup}">
						<label>Add</label>
						<div class="form-group form-inline">
							<select class="form-control" name="id group">
								<option disabled selected>Select group...</option>
								<c:forEach var="i" items="${group}">
									<option value="${i.getIdGroup()}">${i.getIdGroup()} | ${i.getCourseName()} | ${i.getTeacherName()}</option>
								</c:forEach>
							</select>
							<select class="form-control" name="id listener">
								<option disabled selected>Select listener...</option>
								<c:forEach var="i" items="${listener}">
									<option value="${i.getIdUser()}">${i.getFullName()}</option>
								</c:forEach>
							</select>
							<button type="submit" class="btn btn-success" name="save data group" value="save data group">Save</button>
						</div>
					</c:if>
					<c:if test="${editStatusDataGroup}">
						<label>Edit</label>
						<div class="form-group form-inline">
							<select class="form-control" name="id group">
								<c:forEach var="i" items="${group}">
									<option value="${i.getIdGroup()}" <c:if test="${editDataGroup.getIdGroup() == i.getIdGroup()}">selected</c:if>>${i.getIdGroup()} | ${i.getCourseName()} | ${i.getTeacherName()}</option>
								</c:forEach>
							</select>
							<select class="form-control" name="id listener">
								<c:forEach var="i" items="${listener}">
									<option value="${i.getIdUser()}" <c:if test="${editDataGroup.getIdListener() == i.getIdUser()}">selected</c:if>>${i.getFullName()}</option>
								</c:forEach>
							</select>
							<button type="submit" class="btn btn-success" name="update data group"  value="${editDataGroup.getIdDataGroup()}">Update</button>
						</div>
					</c:if>
				</div>				
			</c:if>			
		</div>
	</form>
</body>
</html>