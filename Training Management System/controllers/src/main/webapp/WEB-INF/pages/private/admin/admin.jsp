<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>TMS - Admin</title>
	<link rel="shortcut icon" href="/image/icon.png">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="/style/admin.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="/script/admin.js"></script>
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
					<td class="full_name"><div class="myalert alert-success"><strong><c:out value="${userLogin.getFullName()}"/></strong></div></td>
				</tr>
			</table>
		</div>
		<div class="content">
			<div class="table_btn">
				<button type="button" class="btn btn-info" onclick="showTable(1)">Users Table</button>
				<button type="button" class="btn btn-info" onclick="showTable(2)">Courses Table</button>
				<button type="button" class="btn btn-info" onclick="showTable(3)">Groups Table</button>
				<button type="button" class="btn btn-info" onclick="showTable(4)">Data Groups Table</button>
			</div>
			<div id="users-table">
				<jsp:include page="/WEB-INF/pages/private/admin/content/user-table.jsp"/>
			</div>
			<div id="courses-table" hidden="true">
				<jsp:include page="/WEB-INF/pages/private/admin/content/course-table.jsp"/>
			</div>
			<div id="groups-table" hidden="true">
				<jsp:include page="/WEB-INF/pages/private/admin/content/group-table.jsp"/>
			</div>
			<div id="data-groups-table" hidden="true">
				<jsp:include page="/WEB-INF/pages/private/admin/content/data-group-table.jsp"/>
			</div>				
		</div>
	</form>
</body>
</html>