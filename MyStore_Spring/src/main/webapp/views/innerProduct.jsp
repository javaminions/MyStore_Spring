<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Description</title>

<link rel="stylesheet" href="styles/ProductStyle.css">
</head>

<body>
<br><br>
	
	<div class="back">
<h2 class="des">Product Description</h2>
	<br><br>
		<div class="prod-image">
			<img src="${product.img}" height=200px width=200px alt="">
		</div>
		<br><br>
		<div class="prod-info">
			<span class="prod-details" id="prod-brand">${product.name}</span><br>
			<h3><i>Description</i></h3>
			<span class="prod-details" id="prod-name">${product.description}</span>
		</div>
		<div class="prod-price">
			<h5 class="prod-p">${product.getPriceCurrencyFormat()}</h5>
		</div>
		
		<div>
			<a id="cartadd" href="CartServlet?action=addtocart&amp;prodcode=${product.code}"
				class="btn btn-danger mt-3 cartButton ${disableButton}">Add to Cart</a>
		</div>

	</div>


</body>
</html>