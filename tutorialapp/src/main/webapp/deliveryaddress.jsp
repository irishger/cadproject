<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Delivery Address and Date </title>
</head>
<body>
	
	<form action='<c:url value="/delivery/"/>' method="POST">
	
		First name: <form:input path="delivery.firstName" size="30" /><br/>
		Last name: <form:input path="delivery.secondName" size="30" /><br/>
		Address 1:<form:input path="delivery.address1" size="50" /><br/>
		Address 2:<form:input path="delivery.address2" size="50" /><br/>
		Address 3:<form:input path="delivery.address3" size="50" /><br/>
		Delivery Date<form:input path="delivery.deliveryDate" size="30" /><br/>
		
		<form:hidden path="product.sku" />
		<form:hidden path="product.name" />
		<form:hidden path="product.description" />
		<form:hidden path="product.pricePerUnit" />
		<form:hidden path="product.unitDescription" />
		<form:hidden path="product.stockLevel" />
		
		<form:hidden path="order.customerID"/>
		<form:hidden path="order.sku"/>
		<form:hidden path="order.quantity"/>
		<form:hidden path="order.total"/>
	
		
		<input type="submit" value="Save" />
	</form>


<jsp:include page="header.jsp" />

</body>
</html>