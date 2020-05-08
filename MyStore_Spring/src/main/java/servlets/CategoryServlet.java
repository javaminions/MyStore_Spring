package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Product;
import pojo.ProductIO;

@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			ServletContext sc = getServletContext();

			HttpSession session = request.getSession();
			String path = sc.getRealPath("/WEB-INF/products.txt");
	        ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");
	                
			String filteredCategory = request.getParameter("filterCategory");
			String searchInput = request.getParameter("searchInput");
			
			System.out.println("search input: " + searchInput);
       
			if(filteredCategory != null && filteredCategory != "") {
				session.setAttribute("filteredCategory", filteredCategory); 
				System.out.println("filtered category is: " + filteredCategory);
			}
			
			ArrayList<Product> filteredProducts = new ArrayList<Product>();
		    if(searchInput != null && searchInput != "") {
		        System.out.println("searchInput " + searchInput);
		        for (Product p : products) {
					if(p.getName().contains(searchInput)) {
						filteredProducts.add(p);
					}
				}
		        session.setAttribute("filteredProducts", filteredProducts);
		        request.setAttribute("isProductsFiltered", "yes");
		        request.setAttribute("filter", searchInput);
		        }

            //request.setAttribute("products", products);
            String url = "/views/categories.jsp";
        
        sc.getRequestDispatcher(url)
                .forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
