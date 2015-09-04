package nl.hiephiepmuziek.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	
	private String id;
	private String name;
	private String snippet;
	
	public Product() {
		
	}
	
	public Product(String id, String name, String snippet) {
		this.id = id;
		this.name = name;
		this.snippet = snippet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	public String getId() {
		return id;
	}

}
