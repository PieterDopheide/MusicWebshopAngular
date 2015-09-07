package nl.hiephiepmuziek.model;

import java.util.HashMap;
import java.util.Map;

public enum ProductDao {
	instance;
	
	private Map<String, Product> contentProvider = new HashMap<>();
	
	private ProductDao() {
		Product product = new Product(0, "Guitar", "A simple guitar.");
		contentProvider.put("guitar", product);
		product = new Product(1, "Saxophone", "Excellent for playing jazz!");
		contentProvider.put("saxophone", product);
		product = new Product(2, "Piano", "A very expensive piano.");
		contentProvider.put("piano", product);
	}
	
	public Map<String, Product> getModel() {
		return contentProvider;
	}

}
