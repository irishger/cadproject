<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<body>


<jsp:include page="header.jsp" />

<h2>Welcome to the shop ${customer.firstName} ${customer.secondName} </h2>
	
	<security:authorize url="/home/order/">	
	
		<br>
		<h4>Your Credit Total is: €${customer.creditLimit}</h4>

		<p><a href="<c:url value="/product/" />" > Place New Order </a></p>
			
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
					<td>${customer.firstName} ${customer.secondName}</td>
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
	</security:authorize>
</body>
</html>
