package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Cart;
import pojo.LineItem;
import pojo.Product;
import utility.CookieMonster;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String signedin = (String) request.getSession().getAttribute("signedin");
		if(signedin==null || signedin.equalsIgnoreCase("no")) {
			request.getRequestDispatcher("IndexHandler?action=signinPage").forward(request, response);
		}
		
		Cart cart = null;
		if(request.getSession().getAttribute("cart")==null) {
			cart = new Cart();
		} else {
			cart = (Cart) request.getSession().getAttribute("cart");
		}
		
		String action = null;
		if(request.getParameter("action")!=null) {
			action = request.getParameter("action");
			actionHandler(cart, action, request, response);
			return;
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void actionHandler(Cart cart, String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(action.equalsIgnoreCase("showall")) {
			request.getRequestDispatcher("/views/Cart.jsp").forward(request, response);
			return;
		}
		if(action.equalsIgnoreCase("addtocart")) {
			addToCart(cart, request, response);
			return;
		}
		if(action.equalsIgnoreCase("plus") || action.equalsIgnoreCase("minus") || action.equalsIgnoreCase("delete")) {
			updateCount(action, cart, request, response);
		}
		
	}
	
	private void addToCart(Cart cart, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("prodcode");
		ArrayList<Product> products = (ArrayList<Product>) request.getSession().getAttribute("products");
		Product productToAdd = null;
		for(Product product: products) {
			if(product.getCode().equalsIgnoreCase(code)) {
				productToAdd = product;
			} else {
				//product not found, error 
				//products should have been loaded correctly by now 
			}
		}
		
		if(cart.getItemCount()==0) {
			//add to cart
			LineItem lineItem = new LineItem(1, productToAdd);
			cart.addLineItem(lineItem);
			request.getSession().setAttribute("cart", cart);
			request.getSession().setAttribute("cartCount", cart.getItemCount());
			
			String[] stringified = CookieMonster.stringify(lineItem);
			
			Cookie c = new Cookie(stringified[0], stringified[1]);
			c.setMaxAge(60*60*24*365*2);
			c.setPath("/");
			response.addCookie(c);
			
		} else {
			//check if item exists and then add to cart or add +1 to count 
			ArrayList<LineItem> lineItems = cart.getLineItems();
			boolean exists = false; 
			for(LineItem lineItem: lineItems) {
				if(lineItem.getProduct().getCode().equalsIgnoreCase(code)) {
					lineItem.setQuantity(lineItem.getQuantity()+1);
					exists = true; 
				}
			}
			if(!exists) {
				LineItem lineItem = new LineItem(1, productToAdd);
				cart.addLineItem(lineItem);
			}
			cart.setCart(lineItems);
			request.getSession().setAttribute("cart", cart);
			refreshCookies(cart, request, response);
		}
		request.getRequestDispatcher("/categories?filterCategory=all").forward(request, response);
	}
	
	public void initializeCart(Cart cart, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read cookies
		Cookie[] cookies = request.getCookies();
		List<Product> products = (List<Product>) request.getSession().getAttribute("products");
		//if a product matches set the cart line items 
		for(Cookie c: cookies) {
			if(c.getName().contains("cartprod")) {
				cart.addLineItem(CookieMonster.unstringify(c, products));
			}
		}
	}
	
	private void updateCount(String action, Cart cart, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		if(action.equalsIgnoreCase("plus")) {
			String code = request.getParameter("prodcode");
			ArrayList<LineItem> lineItems = cart.getLineItems();
			for(LineItem lineItem: lineItems) {
				if(lineItem.getProduct().getCode().equalsIgnoreCase(code)) {
					lineItem.setQuantity(lineItem.getQuantity()+1);
				}
			}
			cart.setCart(lineItems);
			refreshCookies(cart, request, response);
			request.getSession().setAttribute("cart", cart);
			request.getRequestDispatcher("CartServlet?action=showAll").forward(request, response);
			return;
		}
		if(action.equalsIgnoreCase("minus")) {
			String code = request.getParameter("prodcode");
			ArrayList<LineItem> lineItems = cart.getLineItems();
			for(LineItem lineItem: lineItems) {
				if(lineItem.getProduct().getCode().equalsIgnoreCase(code)) {
					if(lineItem.getQuantity()==1) {
						cart.removeLineItem(lineItem);
					} else {
						lineItem.setQuantity(lineItem.getQuantity()-1);
					}
				}
			}
			cart.setCart(lineItems);
			refreshCookies(cart, request, response);
			request.getSession().setAttribute("cart", cart);
			request.getRequestDispatcher("CartServlet?action=showAll").forward(request, response);
			return;
		}
		if(action.equalsIgnoreCase("delete")) {
			String code = request.getParameter("prodcode");
			ArrayList<LineItem> lineItems = cart.getLineItems();
			int index = 0;
			for(LineItem lineItem: lineItems) {
				if(lineItem.getProduct().getCode().equalsIgnoreCase(code)) {
					lineItems.remove(index);
					break;
				}
				index++;
			}
			cart.setCart(lineItems);
			refreshCookies(cart, request, response);
			request.getSession().setAttribute("cart", cart);
			request.getRequestDispatcher("CartServlet?action=showAll").forward(request, response);
			return;
		}
		
	}
	
	public void refreshCookies(Cart cart, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().contains("cartprod")) {
				c.setMaxAge(0);
				c.setPath("/");
			}
		}
		ArrayList<LineItem> lineItems = cart.getLineItems();
		for(LineItem lineItem: lineItems) {
			String[] cookieData = CookieMonster.stringify(lineItem);
			Cookie c = new Cookie(cookieData[0], cookieData[1]);
			c.setMaxAge(60*60*24*365*2);
			c.setPath("/");
			response.addCookie(c);
		}
		request.getSession().setAttribute("cartCount", cart.getItemCount());
	}
	
}
