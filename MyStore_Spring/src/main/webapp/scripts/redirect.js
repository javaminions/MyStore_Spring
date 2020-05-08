$(document).ready(function() {
	const queryString = window.location.search;
	console.log(queryString);
	const urlParams = new URLSearchParams(queryString);
	const product = urlParams.get('name')
	console.log(product);
	
	
	if(product == "WishList")
		$("#externalPlaceholder").load("WishList.html");
	else 
		$("#externalPlaceholder").load("Carousel.html");
});
