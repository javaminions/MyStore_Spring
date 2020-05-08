package pojo;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private ArrayList<LineItem> lineItems = new ArrayList();
	
	public Cart() {
		
	}
	public void addLineItem(LineItem lineItem) {
		lineItems.add(lineItem);
	}
	public ArrayList<LineItem> getLineItems() {
		return lineItems;
	}
	public int getItemCount() {
		return lineItems.size();
	}
	public void setCart(ArrayList<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	public String getTotalCost() {
		double total = 0;
		for(LineItem line: lineItems) {
			total += line.getProduct().getPrice()*line.getQuantity();
		}
		
		return NumberFormat.getCurrencyInstance().format(total);
	}
	public void removeLineItem(LineItem lineItem) {
		int index=0;
		for(LineItem line: lineItems) {
			if(line.getProduct().getCode().equalsIgnoreCase(lineItem.getProduct().getCode())) {
				lineItems.remove(index);
				return;
			}
			index++;
		}
	}

}
