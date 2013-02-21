<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	Object user = session.getAttribute("user");
%>

<div id="header">
	<div id="user">
		User '<c:out value="${user.login}" />' logged in
	</div>
</div>
<ul id="nav">
	<li><a href="/organization/app/myprofile">My Profile</a></li>
	<li><a href="http://web-mastery.info/">Summary</a></li>
	<li><a href="http://web-mastery.info/">Departments</a></li>
	<li><a href="/organization/app/employees">Employees</a></li>
	<li><a href="/organization/logout">Logout</a></li>
</ul>