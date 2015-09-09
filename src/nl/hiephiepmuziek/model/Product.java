package nl.hiephiepmuziek.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
//@Entity
public class Product {
	
	@XmlElement // Because id has a get method but not a set method the default is to treat it as an unmapped property
//	@Id
	private int id;
	private String name;
	private String snippet;
	private String imageurl;
	
	public Product() {}
	
	public Product(int id, String name, String snippet) {
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

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

}
