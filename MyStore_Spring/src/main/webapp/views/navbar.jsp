<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
  <script src="scripts/script.js" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="styles/styles.css">
	<script src="scripts/redirect.js"></script>
<!-- Add icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="top">
		<a href="index.jsp"><img alt="Costco Logo" src="https://javaminions.github.io/images/BossCo.png"
			style="width: 20%; height: auto;"></a>
	</div>
<nav class="navbar navbar-inverse topNav">
    <div class="navbar-header">
    	<button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".js-navbar-collapse">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
	</div>
	
	<div class="collapse navbar-collapse js-navbar-collapse topNav">
		<ul class="nav navbar-nav topNav">
			<li class="dropdown mega-dropdown topNav">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">Categories <span class="caret"></span></a>				
				<ul class="dropdown-menu mega-dropdown-menu ">
					<li class="col-sm-3">
						<ul>
							<li class="dropdown-header">Apparel</li>                            
                            <div id="menCollection" class="carousel slide" data-ride="carousel">
                              <div class="carousel-inner">
                                <div class="item active">
                                    <a href="#"><img src="images/apparel1.jpg" class="img-responsive" alt="product 1"></a>
                                    <h4><small>Summer shirts</small></h4>                                        
                                    <button class="btn btn-primary" type="button">$8.99</button> <button href="#" class="btn btn-default" type="button"><span class="glyphicon glyphicon-heart"></span> Add to Wishlist</button>       
                                </div><!-- End Item -->
                                <div class="item">
                                    <a href="#"><img src="images/apparel2.png" class="img-responsive" alt="product 2"></a>
                                    <h4><small>Summer outer wear</small></h4>                                        
                                    <button class="btn btn-primary" type="button">$8.99-$39.99</button> <button href="#" class="btn btn-default" type="button"><span class="glyphicon glyphicon-heart"></span> Add to Wishlist</button>        
                                </div><!-- End Item -->                               
                              </div><!-- End Carousel Inner -->
                              <!-- Controls -->
                              <a class="left carousel-control" href="#menCollection" role="button" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                              </a>
                              <a class="right carousel-control" href="#menCollection" role="button" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                              </a>
                            </div><!-- /.carousel -->
                            <li class="divider"></li>
                            <li><a href="#">View all Collection <span class="glyphicon glyphicon-chevron-right pull-right"></span></a></li>
						</ul>
					</li>
							
					<li class="col-sm-3">
						<ul>
							<li class="dropdown-header">Apparel</li>
							<li class="listItem"><a href="categories?filterCategory=apparel">Mens</a></li>
							<li class="listItem"><a href="categories?filterCategory=apparel">Womens</a></li>
							<li class="listItem"><a href="categories?filterCategory=apparel">Kids</a></li>
							<li class="divider"></li>
						 	<li class="dropdown-header">Accessories</li>
						    <li class="listItem"><a href="categories?filterCategory=accessories">Hats</a></li>
						    <li class="listItem"><a href="categories?filterCategory=accessories">Bags/Backpacks</a></li>
						    <li class="listItem"><a href="categories?filterCategory=accessories">Visors</a></li>
						    <li class="listItem"><a href="categories?filterCategory=accessories">Headbands</a></li>
						</ul>
					</li>
					<li class="col-sm-3">
						<ul>
							<li class="dropdown-header">Sports Equipment</li>
							<li class="listItem"><a href="categories?filterCategory=sports">Baseball</a></li>
							<li class="listItem"><a href="categories?filterCategory=sports">Basketball</a></li>
							<li class="listItem"><a href="categories?filterCategory=sports">Football</a></li>
							<li class="divider"></li>
							<li class="dropdown-header">Outdoor</li>
						    <li class="listItem"><a href="categories?filterCategory=outdoors">Hiking</a></li>
						    <li class="listItem"><a href="categories?filterCategory=outdoors">Surfing</a></li>	
						    <li class="listItem"><a href="categories?filterCategory=outdoors">Camping</a></li>			
						</ul>
					</li>
					<li class="col-sm-3">
						<ul>
							<li class="dropdown-header">Groceries</li>
							<li class="listItem"><a href="categories?filterCategory=groceries">Frozen</a></li>
							<li class="listItem"><a href="categories?filterCategory=groceries">Produce</a></li>
							<li class="listItem"><a href="categories?filterCategory=groceries">Canned items</a></li>
							<li class="divider"></li>
							<li class="dropdown-header">Sale</li>
						    <li class="listItem"><a href="categories?filterCategory=sale">30%</a></li>
						    <li class="listItem"><a href="categories?filterCategory=sale">50%</a></li>	
						    <li class="listItem"><a href="categories?filterCategory=sale">Clearance</a></li>					
						</ul>
					</li>
				
				</ul>				
			</li>	
			
		</ul>
		
        <ul class="nav navbar-nav navbar-right topNav">
			<!-- wishlist -->
			<a href="javascript:void(0)" id="WishList" class="btn btn-default btn-sm myButtons toWishList"> <span
				class="glyphicon glyphicon-gift"></span> Wishlist
			</a>&nbsp
        <li class="dropdown">
          
          <c:if test="${signedin=='yes'}">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Welcome ${user.firstName}<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
          	<li><a href="IndexHandler?navSelection=Profile" id="Profile">Profile</a></li>
            <li><a href="IndexHandler?navSelection=Orders" id="Orders">Orders</a></li>
            <li class="divider"></li>
            <li><a href="IndexHandler?action=Logout" id="Logout">Logout</a></li>
          </ul>
          </c:if>
          <c:if test="${signedin==null || signedin== 'no'}">
          <li><a href="IndexHandler?action=signinPage" id="Logout">Sign in</a></li>
          </c:if>
        </li>
        <li><a href="CartServlet?action=showAll" class="Cart-btn">My cart (${cartCount}) items</a></li>
      </ul>
         <form class="form-inline my-2 my-lg-0 " id="search-bar">
				<input class="form-control mr-sm-2" type="text" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0 box" type="submit" id="nav_button">Search</button>
			</form>

			
	</div><!-- /.nav-collapse -->
  </nav>

</body>
</html>