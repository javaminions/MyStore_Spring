$(document).ready(function() {
					
					$(".toWishList").click(function() {
						console.log('redirect called');
						window.location.href = "index.html?name=WishList";
						$(window).scrollTop(0);
					});
					
					$(".dropdown").hover(function() {
						$('.dropdown-menu', this).not('.in .dropdown-menu').stop(true, true).slideDown("400");
						$(this).toggleClass('open');
						},function() {
							$('.dropdown-menu', this).not(
										'.in .dropdown-menu').stop(true, true)
										.slideUp("400");
								$(this).toggleClass('open');
							});
					

				});

