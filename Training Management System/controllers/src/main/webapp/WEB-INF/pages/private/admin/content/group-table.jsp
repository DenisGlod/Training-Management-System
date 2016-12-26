<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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