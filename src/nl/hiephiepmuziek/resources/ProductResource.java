package nl.hiephiepmuziek.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import nl.hiephiepmuziek.model.Product;
import nl.hiephiepmuziek.model.ProductDao;

public class ProductResource {
	
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	String id;
	
	public ProductResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	}
	
	@GET
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct() {
		Product product = ProductDao.instance.getModel().get(id);
		
		if (product == null) {
			throw new RuntimeException("Get: Todo with " + id +  " not found");
		}
		
		return product;
	}
	
//	@GET
//	@Produces(MediaType.TEXT_XML)
//	public Product getProductHTML() {
//		Product product = ProductDao.instance.getModel().get(id);
//		
//		if (product == null) {
//			throw new RuntimeException("Get: Todo with " + id +  " not found");
//		}
//		
//		return product;
//	}
	
//	private Response getResponse(Product product) {
//		Response res;
//		
//		if(ProductDao.instance.getModel().containsKey(product.getId())) {
//			res = Response.noContent().build();
//		} else {
//			res = Response.created(uriInfo.getAbsolutePath()).build();
//		}
//		
//		return res;
//	}

}
