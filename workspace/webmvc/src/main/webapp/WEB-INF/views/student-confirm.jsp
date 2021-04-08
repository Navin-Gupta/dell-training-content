<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Profile Saved Successfully!!!</h1>
	<hr/>
	<h2>NAME  : ${student.uname}</h2>
	<h2>EMAIL : ${student.email}</h2>
	<h2>FREE PASSES : ${student.freePasses}</h2>
	<h2>COUNTRY : ${student.country}</h2>
	<h2>FAVORITE LANGUAGE: ${student.favoriteLanguage}</h2>
	<h2>OPERATING SYSTEMS : </h2>
	<ul>
		<core:forEach var="os" items="${student.operatingSystems}">
			<li>${os}</li>
		</core:forEach>
	</ul>
	
</body>
</html>