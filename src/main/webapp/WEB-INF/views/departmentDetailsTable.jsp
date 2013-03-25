<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<table id="departmentDetails">
	<form:input path="id" type="hidden" value="${department.id}" />
	<tr>
		<td><form:label path="departmentName">Department Name: </form:label></td>
		<td><form:input id="departmentName" cssClass="input-disable"
				path="departmentName" type="text"
				value="${department.departmentName}" /></td>
	</tr>
	<tr>
		<td><form:label path="manager.user.login">Manager: </form:label></td>
		<td><form:input id="manager" cssClass="input-disable"
				path="manager.user.login" type="text"
				value="${department.manager.user.login}" />
		<form:select cssClass="input-enable" cssStyle="display:none"
				id="manager-select" path="manager.id">
				<form:option label="Select Manager..." value="1"></form:option>
				<c:forEach items="${employeeList}" var="empl" begin="1">
					<form:option label="${empl.user.login}" value="${empl.id}"></form:option>
				</c:forEach>
			</form:select></td>
	</tr>
	<tr>
		<td><form:label path="description">Description: </form:label></td>
		<td><form:textarea id="description" cssClass="input-disable"
				path="description" type="text" value="${department.description}" /></td>
	</tr>
</table>