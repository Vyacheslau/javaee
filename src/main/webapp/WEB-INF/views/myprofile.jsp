<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>EO: My Prfile</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="/organization/resources/assets/css/common.css">
<script type="text/javascript"
	src="/organization/resources/scripts/editEmployee.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id="header"></div>
		<ul id="nav">
			<li><a href="http://web-mastery.info/">My Profile</a></li>
			<li><a href="http://web-mastery.info/">Summary</a></li>
			<li><a href="http://web-mastery.info/">Departments</a></li>
			<li><a href="http://web-mastery.info/">Employees</a></li>
			<li><a href="../logout">Logout</a></li>
		</ul>
		<div id="content" class="clearfix">
			<spring:url value="/myprofile/update" var="url" />
			<form:form action="${url}" method="post" commandName="employee">
				<div id="col_1">
					<h2>Actions</h2>
					<ul id="subnav">
						<li><input id="button" type="button" value="Edit" /></li>
						<li><input id="button" type="button" value="Save" /></li>
						<li><input id="c" type="button" value="Save" /></li>
					</ul>
				</div>
				<div id="col_2">
					<!-- <p class="floatright alignright">
					<b>Page 1</b><br /> [ 1, <a href="http://web-mastery.info/">2</a>,
					<a href="http://web-mastery.info/">3</a>, <a
						href="http://web-mastery.info/">4</a> ]
				</p> -->
					<h1>My profile</h1>

					<table>
						<tr>
							<td><form:label path="firstName">First Name: </form:label></td>
							<td><form:input id="firstName" path="firstName"
									readonly="true" type="text" value="${employee.firstName}"
									ondblclick="enable(this.id)" onblur="disable(this.id)" /></td>
						</tr>
						<tr>
							<td><form:label path="lastName">Last Name: </form:label></td>
							<td><form:input id="lastName" path="lastName"
									disabled="true" type="text" value="${employee.lastName}" /></td>
						</tr>
						<tr>
							<td><form:label path="birthDate">Birth Date: </form:label></td>
							<td><form:input id="birthDate" path="birthDate"
									disabled="true" type="text" value="${employee.birthDate}" /></td>
						</tr>
						<tr>
							<td><form:label path="managerID">Manager: </form:label></td>
							<td><form:input id="managerID" path="managerID"
									disabled="true" type="text" value="${employee.managerID}" /></td>
						</tr>
						<tr>
							<td><form:label path="department">Department: </form:label></td>
							<td><form:input id="department" path="department"
									disabled="true" type="text" value="${employee.department}" /></td>
						</tr>
						<tr>
							<td><form:label path="jobTitle">Job Title: </form:label></td>
							<td><form:input id="jobTitle" path="jobTitle"
									disabled="true" type="text" value="${employee.jobTitle}" /></td>
						</tr>
						<tr>
							<td><form:label path="salary">Salary: </form:label></td>
							<td><form:input id="salary" path="salary" disabled="true"
									type="text" value="${employee.salary}" /></td>
						</tr>
					</table>
				</div>
			</form:form>
		</div>
		<div id="footer">
			<small>All content copyright &copy; 2006 Your Site, all
				rights reserved.<br /> Layout by <a
				href="http://cssweblayouts.com/" target="_blank">CSS Web Layouts</a>
			</small>
		</div>
	</div>
</body>
</html>

