package nl.hiephiepmuziek.model;

import java.util.HashMap;
import java.util.Map;

public enum ProductDao {
	instance;
	
	private Map<String, Product> contentProvider = new HashMap<>();
	
	private ProductDao() {
		Product product = new Product("guitar", "Guitar", "A simple guitar.");
		contentProvider.put("guitar", product);
		product = new Product("saxophone", "Saxophone", "Excellent for playing jazz!");
		contentProvider.put("saxophone", product);
		product = new Product("piano", "Piano", "A very expensive piano.");
		contentProvider.put("piano", product);
	}
	
	public Map<String, Product> getModel() {
		return contentProvider;
	}

}
