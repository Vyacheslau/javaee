<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>EO: ${department.departmentName}</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="/organization/resources/assets/css/common.css">
<script type="text/javascript"
	src="/organization/resources/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="/organization/resources/scripts/editDepartment.js"></script>
</head>
<body>
	<div id="wrapper">
		<c:import url="header.jsp" charEncoding="UTF-8"></c:import>
		<div id="content" class="clearfix">
			<spring:url value="/app/departmentDetails/update" var="url">
				<spring:param name="departmentID" value="${department.id}"></spring:param>
			</spring:url>
			<form:form action="${url}" method="post" commandName="department">
				<div id="col_1">
					<h2 align="center">Actions</h2>
					<c:if
						test="${user.userRole eq 'ADMIN' || user.userRole eq 'MANAGER'}">
						<ul id="subnav">
							<li id="edit" class="visible"><input id="edit-button"
								type="button" value="Edit" class="button" /></li>
							<li id="save" class="invisible"><input id="save-button"
								type="submit" value="Save" class="button" /></li>
							<li id="cancel" class="invisible"><input id="cancel-button"
								type="button" value="Cancel" class="button" /></li>
						</ul>
					</c:if>
				</div>
				<div id="col_2">
					<h1>Department: ${department.departmentName}</h1>

					<c:import url="departmentDetailsTable.jsp" charEncoding="UTF-8"></c:import>
				</div>
			</form:form>
		</div>
		<c:import url="footer.jsp" charEncoding="UTF-8"></c:import>
	</div>
</body>
</html>

