<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var = "req" value = "${ pageContext.request }"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consume REST APP</title>
</head>
<body>
	<div>
		<p>${ message }</p><br>
		<p>click any country to see details from rest service.</p>
		<c:forEach items = "${countryList}" var = "country">
			<a href = "<c:url value = "/getCountries/${ country.id }" /> ">${ country.countryName }</a><br>
		</c:forEach>
	</div>
	<div>
		<div>Add Country</div>
		<form action = "/ConsumeRESTApp/addCountry" method = "POST">
			<label>Name</label><input type = "text" name = "countryName" /><br>
			<label>Population</label><input type = "text" name = "population" /><br>
			<input type = "submit" value = "Save" />
		</form>
	</div>
</body>
</html>