<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles/CarouselStyle.css">
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<!-- Carousel -->
	<div class="container" id="carousel2">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">

			<!-- Wrapper for slides -->
			<div class="carousel-inner">

				<div class="item active imgheight">
					<a href="IndexHandler?caroSelection=carousel&amp;prodcode=8"><img src="images/ball.jpg"></a>
					<div class="carousel-caption">
						<p>Balls for any occasion! <br>
						Soccer Ball - $79.99</p>
					</div>
				</div>
				<!-- End Item -->

				<div class="item imgheight">
					<a href="IndexHandler?caroSelection=carousel&amp;prodcode=6"><img src="images/shoe.jpg"></a>
					<div class="carousel-caption">
						<p>Have the best shoes on the field! <br>
						Running Shoes - $179.99</p>
					</div>
				</div>
				<!-- End Item -->

				<div class="item imgheight">
					<a href="IndexHandler?caroSelection=carousel&amp;prodcode=7"><img src="images/visor.jpg"></a>
					<div class="carousel-caption">
						<p>Look the best while playing! <br>
						Visor - $19.99</p>
					</div>
				</div>
				<!-- End Item -->

				<div class="item imgheight">
					<a href="IndexHandler?caroSelection=carousel&amp;prodcode=1"><img 
					src="https://s3.eu-central-1.amazonaws.com/bootstrapbaymisc/blog/24_days_bootstrap/vans.png"></a>
					<div class="carousel-caption">
						<p>Run Fast! <br>
						Vans Sk8-Hi MTE Shoes - $45.99</p>
					</div>
				</div>
				<!-- End Item -->

				<div class="item imgheight">
					<a href="IndexHandler?caroSelection=carousel&amp;prodcode=3"><img src="images/fishing_pole.jpg"></a>
					<div class="carousel-caption">
						<p> Be outdoors (6ft away from others)! <br>
						Fishing pole - $23.99</p>
					</div>
				</div>
				<!-- End Item -->

			</div>
			<!-- End Carousel Inner -->
			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a> <br>
			<ul class="nav nav-pills nav-justified carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active">Equipment</li>
				<li data-target="#myCarousel" data-slide-to="1">Footwear</li>
				<li data-target="#myCarousel" data-slide-to="2">Accessories</li>
				<li data-target="#myCarousel" data-slide-to="3">Apparel</li>
				<li data-target="#myCarousel" data-slide-to="4">Outdoors</li>
			</ul>

		</div>
		<!-- End Carousel -->

	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>