<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>EO: Employees</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="/organization/resources/assets/css/common.css">
<script type="text/javascript"
	src="/organization/resources/scripts/jquery-1.9.1.min.js"></script>
<!-- <script type="text/javascript"
	src="/organization/resources/scripts/editEmployee.js"></script> -->
</head>
<body>
	<div id="wrapper">
		<c:import url="header.jsp" charEncoding="UTF-8"></c:import>
		<div id="content" class="clearfix">
			<div id="col_1">
				<h2 align="center">Actions</h2>
				<ul id="subnav">
					<li id="edit" class="visible"><input id="edit-button"
						type="button" value="Hire New" class="button" /></li>
					<!-- <li id="save" class="invisible"><input id="save-button"
						type="submit" value="Save" class="button" /></li>
					<li id="cancel" class="invisible"><input id="cancel-button"
						type="button" value="Cancel" class="button" /></li> -->
				</ul>
			</div>
			<div id="col_2">
				<h1>Employees</h1>
				<table id="employees">
					<tr class="table-header">
						<td>First Name</td>
						<td>Last Name</td>
						<td>Manager</td>
						<td>Department</td>
						<td>Job Title</td>
						<td>Salary</td>
					</tr>
					<c:forEach var="employee" items="${employeeList}">
						<tr>
							<td>${employee.firstName}</td>
							<td>${employee.lastName}</td>
							<td>
								<%-- ${employee.managerID} --%>
							</td>
							<td>${employee.department.departmentName}</td>
							<td>${employee.jobTitle}</td>
							<td>${employee.salary}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<c:import url="footer.jsp" charEncoding="UTF-8"></c:import>
	</div>
</body>
</html>

