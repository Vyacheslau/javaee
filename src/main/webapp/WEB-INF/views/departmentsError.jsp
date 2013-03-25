<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>EO: Departments</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="/organization/resources/assets/css/common.css">
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
						<spring:url value="/app/actions/addNew" var="hireNew" />
						<form:form action="${hireNew}" method="get">
							<li id="add-new" class="visible"><input id="add-new-button"
								type="submit" value="Add New" class="button" /></li>
						</form:form>
					</ul>
				</c:if>
			</div>
			<div id="col_2">
				<h1>Departments</h1>
				<h4 id="errorMessage">
					Error: Department with assigned Employees cannot be deleted. Please
					assign employees from
					<c:out value="${departmentWithEmployees.departmentName}" />
					to other Departments.
				</h4>
				<c:import url="departmentsTable.jsp" charEncoding="UTF-8"></c:import>
			</div>
		</div>
		<c:import url="footer.jsp" charEncoding="UTF-8"></c:import>
	</div>
</body>
</html>