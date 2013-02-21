<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>EO: Hire New</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="/organization/resources/assets/css/common.css">
<script type="text/javascript"
	src="/organization/resources/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="/organization/resources/scripts/addNewEmployee.js"></script>
</head>
<body>
	<div id="wrapper">
		<c:import url="header.jsp" charEncoding="UTF-8"></c:import>
		<div id="content" class="clearfix">
			<spring:url value="/app/actions/addNewEmployee" var="url" />
			<form:form action="${url}" method="post" commandName="employee">
				<div id="col_1">
					<h2 align="center">Actions</h2>
					<ul id="subnav">
						<li id="hire" class="visible"><input id="hire-button"
							type="submit" value="Hire" class="button" /></li>
						<li id="error">Error: Employee with such First name and Last
							Name is already present.</li>
					</ul>
				</div>
				<div id="col_2">
					<h1>Hire New Employee</h1>
					<c:import url="employeeDetailsTable.jsp" charEncoding="UTF-8"></c:import>
				</div>
			</form:form>
		</div>
		<c:import url="footer.jsp" charEncoding="UTF-8"></c:import>
	</div>
</body>
</html>

