<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product SKU ID Details page</title>
</head>
<body>
<jsp:include page="header.jsp" />
	
	<p>Product Details for SKU ID: ${x.sku}</p>
	<table border=1>
	<tr>
	<th>SKU ID</th>
	<th>Name</th>
	<th>Description</th>
	<th>Price Per Unit</th>
	<th>Unit Description</th>
	<th>Stock Level</th>
	</tr>
	<tr>
	<td>${x.sku}</td>
	<td>${x.name}</td>
	<td>${x.description}</td>
	<td>€${x.pricePerUnit}</td>
	<td>${x.unitDescription}</td>
 	<td>${x.stockLevel}</td>
	</tr>
	</table>
	<br>
		<security:authorize url="/product/invoice/*">
			<a href='<c:url value="/order/add/${x.sku}"/>'>Add Product to Order</a> 
		</security:authorize>
	<br>
	<p><a href='<c:url value="/product/"/>'>Return to Product List</a></p>
	<security:authorize url="/product/add/*">
		<a href='<c:url value="/product/add"/>'>Add Product</a>
	</security:authorize>

</body>
</html>