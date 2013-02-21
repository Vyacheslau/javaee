<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<table id="employeeDetails">
	<form:input path="id" type="hidden" value="${employee.id}" />
	<%-- <form:input path="user.id" type="hidden" value="{$employee.user.id}" /> --%>
	<tr>
		<td><form:label path="firstName">First Name: </form:label></td>
		<td><form:input id="firstName" cssClass="input-disable"
				path="firstName" type="text" value="${employee.firstName}" /></td>
	</tr>
	<tr>
		<td><form:label path="lastName">Last Name: </form:label></td>
		<td><form:input id="lastName" cssClass="input-disable"
				path="lastName" type="text" value="${employee.lastName}" /></td>
	</tr>
	<tr>
		<td><form:label path="birthDate">Birth Date: </form:label></td>
		<td><form:input id="birthDate" cssClass="input-disable"
				path="birthDate" type="text" value="${employee.birthDate}" /></td>
	</tr>
	<tr>
		<td><form:label path="managerID">Manager: </form:label></td>
		<%-- <td><form:input id="managerID" cssClass="input-disable"
									path="managerID" type="text" value="${employee.managerID}" /></td> --%>
	</tr>
	<tr>
		<td><form:label path="department.departmentName">Department:</form:label></td>
		<td><form:input id="department" cssClass="input-disable"
				path="department.departmentName" type="text"
				value="${employee.department.departmentName}" /> <form:select
				cssClass="input-enable" cssStyle="display:none"
				id="department-select" path="department.id">

				<form:option value="${employee.department.id}"
					label="Select Department..."></form:option>
				<form:options items="${departmentList}" itemValue="id"
					itemLabel="departmentName" />
				<c:forEach var="department" items="${departmentList}">
					<form:option value="${department}">${department.departmentName}</form:option>
				</c:forEach>
			</form:select></td>
	</tr>
	<tr>
		<td><form:label path="jobTitle">Job Title: </form:label></td>
		<td><form:input id="jobTitle" cssClass="input-disable"
				path="jobTitle" type="text" value="${employee.jobTitle}" /></td>
	</tr>
	<c:if test="${user.userRole eq 'ADMIN' || user.userRole eq 'MANAGER' || user.employee.id eq employee.id}">
	<tr>
		<td><form:label path="salary">Salary: </form:label></td>
		<td><form:input id="salary" cssClass="input-disable"
				path="salary" type="text" value="${employee.salary}" /></td>
	</tr>
	</c:if>
	<c:if test="${user.employee.id eq employee.id}">
		<tr>
			<td><form:label path="user.password">Password: </form:label></td>
			<td><form:input id="password" cssClass="input-disable"
					path="user.password" type="password"
					value="${employee.user.password}" /></td>
		</tr>
	</c:if>
</table>