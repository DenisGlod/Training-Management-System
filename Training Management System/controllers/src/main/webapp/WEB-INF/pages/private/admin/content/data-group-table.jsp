<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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