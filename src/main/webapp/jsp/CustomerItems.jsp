<%@ page import="org.apache.commons.codec.binary.Base64"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Customer Menu</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	padding: 20px;
}

table {
	border-collapse: collapse;
	width: 100%;
	margin-bottom: 20px;
}

th, td {
	border: 1px solid #ccc;
	padding: 8px;
	text-align: center;
}

th {
	background-color: #007bff;
	color: #fff;
}

img.product-image {
	max-width: 200px;
	max-height: 200px;
}

a{
	text-decoration: none;
	font-size: 50px;
}

a.button {
	text-decoration: none;
}

button.edit-button {
	background-color: #007bff;
	color: #fff;
}

button.delete-button {
	background-color: #dc3545;
	color: #fff;
}

button.back-button {
	background-color: #333;
	color: #fff;
}
</style>
</head>
<body>
	<h3>${pos}</h3>
	<h2>${neg}</h2>
	<section class="product-list">
		<table>
			<tr>
				<th>Item Name</th>
				<th>Picture</th>
				<th>Price</th>
				<th>Description</th>
				<th>Stock</th>
				<th>Remove</th>
				<th>Quantity</th>
				<th>Add</th>
			</tr>
			<c:forEach var="item" items="${items}">
				<tr>
					<td>${item.getName()}</td>
					<td><img class="product-image" alt="Product Image"
						src="data:image/jpeg;base64,${Base64.encodeBase64String(item.getPicture())}">
					</td>
					<td>${item.getPrice()}</td>
					<td>${item.getDescription()}</td>
					<td>${item.getStock()}</td>
					<td><a href="/customer/cart-remove/${item.getId()}">-</a></td>
					<td>
						<c:if test="${cartItems==null}">
						0
						</c:if>
						<c:if test="${cartItems!=null}">
						<c:set var="flag" value="true"></c:set>
						<c:forEach var="food" items="${cartItems}">
						<c:if test="${food.getName().equals(item.getName())}">
						${food.getQuantity()}
						<c:set var="flag" value="false"></c:set>
						</c:if>
						</c:forEach>
						<c:if test="${flag==true}">
						0
						</c:if>
						</c:if>
					</td>
					<td><a href="/customer/cart-add/${item.getId()}">+</a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<a href="/customer/viewcart"><button>View Cart</button></a>
	</section>
	<a href="/customer/home" class="button">
		<button class="back-button">Back</button>
	</a>
</body>
</html>
