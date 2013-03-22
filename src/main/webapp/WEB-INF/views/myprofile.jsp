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
	src="/organization/resources/scripts/jquery-1.9.1.min.js"></script>
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
					<h2 align="center">Actions</h2>
					<ul id="subnav">
						<li id="edit" class="visible"><input id="edit-button" type="button" value="Edit" class="button" /></li>
						<li id="save" class="invisible"><input id="save-button" type="submit" value="Save" class="button" /></li>
						<li id="cancel" class="invisible"><input id="cancel-button" type="button" value="Cancel" class="button" /></li>
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
							<td><form:input id="firstName" cssClass="input-disable" path="firstName" type="text" 
									value="${employee.firstName}" /></td>
						</tr>
						<tr>
							<td><form:label path="lastName">Last Name: </form:label></td>
							<td><form:input id="lastName" cssClass="input-disable" path="lastName" type="text"
									value="${employee.lastName}" /></td>
						</tr>
						<tr>
							<td><form:label path="birthDate">Birth Date: </form:label></td>
							<td><form:input id="birthDate" cssClass="input-disable" path="birthDate" type="text"
									value="${employee.birthDate}" /></td>
						</tr>
						<tr>
							<td><form:label path="managerID">Manager: </form:label></td>
							<td><form:input id="managerID" cssClass="input-disable" path="managerID" type="text"
									value="${employee.managerID}" /></td>
						</tr>
						<tr>
							<td><form:label path="department">Department: </form:label></td>
							<td><form:input id="department" cssClass="input-disable" path="department"
									type="text" value="${employee.department}" /></td>
						</tr>
						<tr>
							<td><form:label path="jobTitle">Job Title: </form:label></td>
							<td><form:input id="jobTitle" cssClass="input-disable" path="jobTitle" type="text"
									value="${employee.jobTitle}" /></td>
						</tr>
						<tr>
							<td><form:label path="salary">Salary: </form:label></td>
							<td><form:input id="salary" cssClass="input-disable" path="salary" type="text"
									value="${employee.salary}" /></td>
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

