package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Database;
import pojo.Cart;
import pojo.Product;
import pojo.UserProfile;
import utility.CookieMonster;

@WebServlet("/IndexHandler")
public class IndexHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		pageInitializer(request, response);
		
		String navSelection = request.getParameter("navSelection");
		System.out.println(navSelection);
		if(navSelection!=null) {
			navHandler(navSelection, request, response);
			return;
		}
		
		//My Change
		String caroSelection = request.getParameter("caroSelection");
		System.out.println(caroSelection);
		if(caroSelection!=null) {
			caroHandler(caroSelection, request, response);
			return;
		}
		
		String footerSelection = request.getParameter("footerSelection");
		System.out.println(footerSelection);
		if(footerSelection!=null) {
			footerHandler(footerSelection, request, response);
			return;
		}
		
		//For Registration
		String action = request.getParameter("action");
		if(action!=null) {
			try {
				actionHandler(action, request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void actionHandler(String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		if(action.equals("register")) {
			registerUser(request, response);
		} else if (action.equals("signin")) {
			signInUser(request,response);
		} else if (action.equals("registerPage")) {
			request.getRequestDispatcher("views/register.jsp").forward(request, response);
		} else if (action.equals("signinPage")) {
			request.getRequestDispatcher("views/signin.jsp").forward(request, response);
		} else if (action.equals("index")) {
			System.out.println("redirected");
			request.getRequestDispatcher("views/home.jsp").forward(request, response);
			return;
		} else if (action.equalsIgnoreCase("logout")) {
			logout(request, response);
		}
	}
	
	//My Change(HC)
	private void caroHandler(String caroHandler, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(caroHandler.equalsIgnoreCase("carousel")){
			ArrayList<Product> products = new ArrayList<Product>();
			products = (ArrayList<Product>) request.getSession().getAttribute("products"); 
			String code = request.getParameter("prodcode");
			for(Product prod: products) {
				if (prod.getCode().equalsIgnoreCase(code)) {
					request.getSession().setAttribute("product", prod);
				}
			}
			request.getRequestDispatcher("views/Product.jsp").forward(request, response);
			
		} 
		
	}
	
	private void navHandler(String navSelection, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(navSelection.equalsIgnoreCase("register")){
			request.getRequestDispatcher("views/register.jsp").forward(request, response);
		} 
		if(navSelection.equalsIgnoreCase("orders")) {
			request.getRequestDispatcher("views/Orders.jsp").forward(request, response);
		}
		if(navSelection.equalsIgnoreCase("cart")) {
			request.getRequestDispatcher("views/Cart.jsp").forward(request, response);
		}
		if(navSelection.equalsIgnoreCase("logout")) {
			request.getRequestDispatcher("views/Logout.jsp").forward(request, response);
		}
		if(navSelection.equalsIgnoreCase("profile")) {
			request.getRequestDispatcher("views/UserProfile.jsp").forward(request, response);
		}
	}
	
	private void footerHandler(String footerSelection, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(footerSelection.equalsIgnoreCase("contactus")) {
			request.getRequestDispatcher("views/ContactUs.jsp").forward(request, response);
		}
		if(footerSelection.equalsIgnoreCase("aboutus")) {
			request.getRequestDispatcher("views/AboutUs.jsp").forward(request, response);
		}
		if(footerSelection.equalsIgnoreCase("testimonials")) {
			request.getRequestDispatcher("views/Testimonials.jsp").forward(request, response);
		}
		if(footerSelection.equalsIgnoreCase("press")) {
			request.getRequestDispatcher("views/Press.jsp").forward(request, response);
		}
		if(footerSelection.equalsIgnoreCase("payments")) {
			request.getRequestDispatcher("views/Payments.jsp").forward(request, response);
		}
		if(footerSelection.equalsIgnoreCase("shipping")) {
			request.getRequestDispatcher("views/Shipping.jsp").forward(request, response);
		}
		if(footerSelection.equalsIgnoreCase("return")) {
			request.getRequestDispatcher("views/Return.jsp").forward(request, response);
		}
		if(footerSelection.equalsIgnoreCase("faq")) {
			request.getRequestDispatcher("views/FAQ.jsp").forward(request, response);
		}
	}

	private void registerUser (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
	
		HttpSession session = request.getSession();
		UserProfile user = new UserProfile(userName, password, firstName, lastName, email);
		session.setAttribute("user", user);
		
		//UserName Cookie
		session.setAttribute("userName", userName);
		Cookie unc = new Cookie("userNameCookie", userName);
		unc.setPath("/");
		unc.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(unc);
		
		
		//Password Cookie
		Cookie pc = new Cookie("passwordCookie", password);
		pc.setPath("/");
		pc.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(pc);
		
		//Email Cookie
		Cookie ec = new Cookie("emailCookie", email);
		ec.setPath("/");
		ec.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(ec);
		
		//First Name Cookie
		Cookie fnc = new Cookie("firstNameCookie", firstName);
		fnc.setPath("/");
		fnc.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(fnc);
		
		//Last Name Cookie
		Cookie lnc = new Cookie("lastNameCookie", lastName);
		lnc.setPath("/");
		lnc.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(lnc);
		
		try {
			Database database = Database.getInstance();
			database.addUserIntoDB(user);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("signedin", "yes");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	
	

	private void signInUser (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		

		Database database = Database.getInstance();

		UserProfile user = database.grabUserInfoFromDB(userName);
		
		if(user.getFirstName().equals("")) {
			request.getRequestDispatcher("views/register.jsp").forward(request, response);
		}
		
		else if (!user.equals(null)) {
			//set Session Attribute & Make Cookies!
			session.setAttribute("user", user);
			session.setAttribute("signedin", "yes");
			
			//UserName Cookie
			Cookie unc = new Cookie("userNameCookie", user.getUsername());
			unc.setPath("/");
			unc.setMaxAge(60 * 60 * 24 * 365 * 2);
			response.addCookie(unc);
			
			//Password Cookie
			Cookie pc = new Cookie("passwordCookie", user.getPassword());
			pc.setPath("/");
			pc.setMaxAge(60 * 60 * 24 * 365 * 2);
			response.addCookie(pc);
			
			//Email Cookie
			Cookie ec = new Cookie("emailCookie", user.getEmail());
			ec.setPath("/");
			ec.setMaxAge(60 * 60 * 24 * 365 * 2);
			response.addCookie(ec);
			
			//First Name Cookie
			Cookie fnc = new Cookie("firstNameCookie", user.getFirstName());
			fnc.setPath("/");
			fnc.setMaxAge(60 * 60 * 24 * 365 * 2);
			response.addCookie(fnc);
			
			//Last Name Cookie
			Cookie lnc = new Cookie("lastNameCookie", user.getLastName());
			lnc.setPath("/");
			lnc.setMaxAge(60 * 60 * 24 * 365 * 2);
			response.addCookie(lnc);
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		} 
			
		
	}
	
	
    public static String getCookieValue(
            Cookie[] cookies, String cookieName) {
        
        String cookieValue = "";
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if (cookieName.equals(cookie.getName())) {
                    cookieValue = cookie.getValue();
                }
            }
        }
        return cookieValue;
    }
    
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	
    	
    	Cookie[] cookies = request.getCookies();
    	for(Cookie c:cookies) {
    		c.setMaxAge(0);
    		c.setPath("/");
    		response.addCookie(c);
    	}
    	HttpSession session = request.getSession();
    	session.setAttribute("signedin", "no");
    	session.setAttribute("cartCount", "0");
    	session.setAttribute("cart", null);
    	request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    public void initCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Cookie[] cookies = request.getCookies();
    	Cart cart = new Cart();
    	if(request.getSession().getAttribute("cart")!=null) {
    		cart = (Cart) request.getSession().getAttribute("cart");
    	} else {
    		ArrayList<Product> products = (ArrayList<Product>) request.getSession().getAttribute("products");
    		//if a product matches set the cart line items 
    		for(Cookie c: cookies) {
    			if(c.getName().contains("cartprod")) {
    				cart.addLineItem(CookieMonster.unstringify(c, products));
    			}
    		}
    	}
		
		request.getSession().setAttribute("cart", cart);
		request.getSession().setAttribute("cartCount", cart.getItemCount());
    }
    
    public void pageInitializer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	

		HttpSession session = request.getSession();
		boolean signedin = false;
		
		//Load products in session if null 
		if(session.getAttribute("products")==null) {
			//init products
			Database database = null;
			List<Product> products = null;
			try {
				database = Database.getInstance();
				products = database.getAll();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("products", products);
		}
    	
		//check to see if signed in, 
		//if so set signedin to yes and 
		//retrieve firstName cookie to set as session attribute
    	Cookie[] cookies = request.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equalsIgnoreCase("usernamecookie")) {
				session.setAttribute("signedin", "yes");
				signedin = true;
			}
			if(c.getName().equalsIgnoreCase("firstnamecookie")) {
				session.setAttribute("firstName", c.getValue());
			}
		}
		
		//if not signed in set cart to 0 and set signedin to no
		if(signedin==false) {
			String firstName = null;
			//cart = 0 
			session.setAttribute("cartCount", "0");
			session.setAttribute("signedin", "no");
			//set navbar to say sign in 
		} 
		
		initCart(request, response);
    }
}
