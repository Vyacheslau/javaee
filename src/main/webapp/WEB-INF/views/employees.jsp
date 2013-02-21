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
</head>
<body>
	<div id="wrapper">
		<c:import url="header.jsp" charEncoding="UTF-8"></c:import>
		<div id="content" class="clearfix">
			<div id="col_1">
				<h2 align="center">Actions</h2>
				<c:if
					test="${user.userRole eq 'ADMIN' || user.userRole eq 'MANAGER'}">
					<ul id="subnav">
						<spring:url value="/app/actions/hireNew" var="hireNew" />
						<form:form action="${hireNew}" method="get">
							<li id="hire-new" class="visible"><input
								id="hire-new-button" type="submit" value="Hire New"
								class="button" /></li>
						</form:form>
					</ul>
				</c:if>
			</div>
			<div id="col_2">
				<h1>Employees</h1>
				<table id="employees">
					<tr class="table-header">
						<td>ID</td>
						<td>First Name</td>
						<td>Last Name</td>
						<td>Manager</td>
						<td>Department</td>
						<td>Job Title</td>
						<td></td>
					</tr>
					<c:forEach var="employee" items="${employeeList}">
						<spring:url value="/app/employeeDetails/" var="url">
							<spring:param name="employeeID" value="${employee.id}"></spring:param>
						</spring:url>
						<spring:url value="/app/actions/dismiss" var="urlDismiss">
							<spring:param name="employeeID" value="${employee.id}"></spring:param>
						</spring:url>
						<tr>
							<td><a href="${url}">${employee.id}</a></td>
							<td>${employee.firstName}</td>
							<td>${employee.lastName}</td>
							<td>
								<%-- ${employee.managerID} --%>
							</td>
							<td>${employee.department.departmentName}</td>
							<td>${employee.jobTitle}</td>
							<c:if
								test="${user.userRole eq 'ADMIN' || user.userRole eq 'MANAGER'}">
								<td><a href="${urlDismiss}">Dismiss</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<c:import url="footer.jsp" charEncoding="UTF-8"></c:import>
	</div>
</body>
</html>

