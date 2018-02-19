<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<form:form modelAttribute="cpl">	
<!-- 	<label for="textinput1"> Enter Minutes: </label> -->
<%-- 	<form:input path="minutes" cssErrorClass="error" /> --%>
<%-- 	<form:errors path="minutes" cssClass="error" /> --%>
<!-- 	<br /> -->
	<input type="submit" class="btn" value="cplGecmis" />
</form:form>

<body>

</body>
</html>