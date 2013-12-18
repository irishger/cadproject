<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
   
</head>

<body>


<jsp:include page="header.jsp" />

	<form action='<c:url value="/order/"/>' method="POST">
	
		<p>Order Details for Product SKU ID: ${product.sku}</p>
		<table border=1>
			<tr>
				<th>SKU ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Price Per Unit</th>
				<th>Unit Description</th>
				<th>Stock Level</th>
				<th>Quantity</th>
			</tr>
			<tr>
				<td>${product.sku}</td>
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>€${product.pricePerUnit}</td>
				<td>${product.unitDescription}</td>
 				<td>${product.stockLevel}</td>
 				<td><form:input type="text" path="order.quantity" size="5" /></td>
			</tr>
		</table>
		<br><br>
		<form:hidden path="product.sku" />
		<form:hidden path="product.name" />
		<form:hidden path="product.description" />
		<form:hidden path="product.pricePerUnit" />
		<form:hidden path="product.unitDescription" />
		<form:hidden path="product.stockLevel" />
		
		<input type="submit" value="Next" />
	</form>
	<p><a href='<c:url value="/product/"/>'>Return to Product List</a></p>
</body>
</html>