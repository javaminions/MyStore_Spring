package pojo;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class Product implements Serializable{

	private String code;
    private String name; 
    private String description;
    private int inventory; 
    private double price;
    private String category; 
    private String img;
    
	public Product(String code, String name, String description, int inventory, double price, String category,
			String img) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.inventory = inventory;
		this.price = price;
		this.category = category;
		this.img = img;
	}
	
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getInventory() {
		return inventory;
	}
	public double getPrice() {
		return price;
	}
	public String getCategory() {
		return category;
	}
	public String getImg() {
		return img;
	}
	public String getPriceCurrencyFormat() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(price);
    }
}
