<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Super Market</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" href="images/apple-touch-icon.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet" href="css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet" href="css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="css/custom.css">
</head>
<body>

	<h1>Success</h1>


	<div class="cart-box-main">
		<div class="container">
			<p class="error">${noItem}</p>

			<div class="row">
				<div class="col-lg-12">
					<div class="table-main table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>Images</th>
									<th>Product Name</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Total</th>
									<th>Remove</th>
								</tr>
							</thead>

							<c:forEach var="cartitem" items="${cartItems}">

								<tbody>
									<tr>
										<td class="thumbnail-img"><a href="#"> <img
												class="img-fluid" src="images/${cartitem.imageUrl }" alt="" />
										</a></td>
										<td class="name-pr"><a href="#"> ${cartitem.itemName }
										</a></td>
										<td class="price-pr">
											<p>&#8377 ${cartitem.itemPrice }</p>
										</td>

										<!--  <td class="quantity-box">
										<form action="/cartupdate/${cartitem.itemName }">
												<input type="text" name="quantity" size="3" value="1"
													 maxlength="2" class="c-input-text qty text"> <input
													type="submit" class="c-input-text qty text" value="&#43 Add Item">
											</form></td> -->

										<td class="quantity-box"><c:forEach var="type"
												items="${types}">
											<!--  <p>Key is ${type.key}</p>
												<p>Value is ${type.value}</p>-->	

												<!--<c:set var="q" value="${2000*2}" />-->
												<c:if test="${type.key eq cartitem.itemName }">
														<c:out value="${type.value}" />
													</c:if></c:forEach>
												 <a href="/cartupdate/${cartitem.itemName }"> <i
												class="fas fa-plus"></i>
											
										</a></td>


										<td class="total-pr">&#8377 ${ price}</td>
										<td class="remove-pr"><a
											href="/delete/${cartitem.itemName }"> <i
												class="fas fa-times"></i>
										</a></td>
									</tr>

								</tbody>
							</c:forEach>



						</table>
					</div>
				</div>
			</div>


			<c:forEach var="type" items="${types}">
				<p>Key is ${type.key}</p>
				<p>Value is ${type.value}</p>
			</c:forEach>
</body>
</html>