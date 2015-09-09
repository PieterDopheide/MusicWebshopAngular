package nl.hiephiepmuziek.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import nl.hiephiepmuziek.model.Product;
import nl.hiephiepmuziek.model.ProductDao;

public class ProductResource {
	
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	int id;
	
	public ProductResource(UriInfo uriInfo, Request request, int id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		
		System.out.println("Uri: " + uriInfo);
		System.out.println("Request: " + request);
		System.out.println("ID: " + id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct() {
		Product product = (Product) ProductDao.instance.getModel().get(id);
		
		if (product == null) {
			throw new RuntimeException("Get: Todo with " + id +  " not found");
		}
		
		return product;
	}

}
