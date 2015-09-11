package nl.hiephiepmuziek.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public enum ShoppingCart {
	instance;
	
	private List<Product> cart;
	
	private ShoppingCart() {
		this.cart = new ArrayList<Product>();
	}

	public List<Product> getCart() {
		return cart;
	}
	
	public void addToCart(Product product) {
		cart.add(product);
	}
	
//	public void removeFromCart(Product product) {
//		cart.remove(product);
//	}
	
	public void removeFromCart(int id) {
		for (Product product : cart) {
			if (product.getId() == id) {
				cart.remove(product);
				return; // Remove only one product
			}
		}
	}
	
	public int countProducts() {
		return cart.size();
	}
	
	public BigDecimal total() {
		BigDecimal total = null;
		
		for (Product product : cart) {
			total = total.add(product.getPrice());
		}
		
		return total;
	}

}
