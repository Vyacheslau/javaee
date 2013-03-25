<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<table id="departments">
	<tr class="table-header">
		<td>ID</td>
		<td>Department Name</td>
		<td colspan="2">Manager</td>
		<td>Description</td>
		<td></td>
	</tr>
	<c:forEach var="department" items="${departmentList}">
		<spring:url value="/app/departmentDetails/" var="url">
			<spring:param name="departmentID" value="${department.id}"></spring:param>
		</spring:url>
		<spring:url value="/app/actions/deleteDepartment" var="urlDelete">
			<spring:param name="departmentID" value="${department.id}"></spring:param>
		</spring:url>
		<tr>
			<td><a href="${url}">${department.id}</a></td>
			<td>${department.departmentName}</td>
			<td>${department.manager.firstName} ${department.manager.lastName}</td>
			<td>${department.manager.jobTitle}</td>
			<td>${department.description}</td>
			<c:if
				test="${user.userRole eq 'ADMIN' || user.userRole eq 'MANAGER'}">
				<td><a href="${urlDelete}">Delete</a></td>
			</c:if>
		</tr>
	</c:forEach>
</table>