<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Manage your profile here...</h2>
	<hr/>
	
	<spring:form action="save" method="post" modelAttribute="student">
		<spring:label path="uname">Enter name</spring:label>
		<spring:input path="uname"/>
		<%-- Special spring form tag to show error message --%>
		<spring:errors path="uname"/>
		<br/>
		<br/>
		<spring:label path="email">Enter email</spring:label>
		<spring:input path="email"/>
		<br/>
		<br/>
		
		<input type="submit" value="Submit">
	</spring:form>
</body>
</html>