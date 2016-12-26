<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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