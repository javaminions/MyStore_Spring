package utility;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.Cookie;

import database.Database;
import pojo.LineItem;
import pojo.Product;

public class CookieMonster {
	public static String[] stringify(LineItem lineItem) {
		
		String cookieName = "cartprod";
		String code;
		String quantity;
		String[] cookieData = new String[2];
		
		code = lineItem.getProduct().getCode();
		quantity = String.valueOf(lineItem.getQuantity());
				
		cookieData[0] = "" + cookieName + code;
		cookieData[1] = "" + quantity;
		
		return cookieData;
	}
	
	public static LineItem unstringify(Cookie c, List<Product> products) {
		
		LineItem lineItem = new LineItem();
		String[] trimmer = c.getName().split("cartprod");
		String quantity = c.getValue();
		
		for(Product p:products) {
			if(p.getCode().equals(trimmer[1])) {
				lineItem.setProduct(p);
				lineItem.setQuantity(Integer.parseInt(quantity));
			} else {
				//unable to return product
			}
		}
		
		return lineItem;
		
	}
	
	public static void main(String[]args) {
		Cookie c = new Cookie("cartprod1", "2");
		List<Product> products = null;
		try {
			products = Database.getInstance().getAll();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(unstringify(c, products));
	}
}
