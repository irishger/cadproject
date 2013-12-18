<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order page</title>
</head>
<body>
	
	
	<jsp:include page="header.jsp" />
	
	

	<h3>Order List:</h3>
	
	
	
	<table border=1>
		<tr>
			<th>Order ID</th>
				<th>Customer Name</th>
				<th>Product ID</th>
				<th>Quantity</th>
				<th>Total Cost of Order</th>
				<th>Delivery ID</th>
				<th>Delivery Name</th>
				<th>Delivery Address</th>
				<th>Delivery Date</th>
		</tr>
	
		<c:forEach var="ord" items="${orders}">
			<tr>
				<td>${ord.orderID}</td>
				<c:forEach var="cust" items="${customer}">
					<c:if test="${ord.customerID eq cust.id}">
						<td>${cust.firstName} ${cust.secondName}</td>
					</c:if>
				</c:forEach>
				<td>${ord.sku}</td>
				<td>${ord.quantity}</td>
				<td>€${ord.total}</td>
				<c:forEach var="dill" items="${delivery}">
					<c:if test="${ord.orderID eq dill.deliveryID}">
						<td>${dill.deliveryID}</td>
						<td>${dill.firstName} ${dill.secondName}</td>
						<td>${dill.address1}, ${dill.address2}, ${dill.address3}</td>
						<td>${dill.deliveryDate}</td>
					</c:if>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>

</body>
</html>