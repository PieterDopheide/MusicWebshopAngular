package nl.hiephiepmuziek.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import nl.hiephiepmuziek.model.Product;
import nl.hiephiepmuziek.model.ProductDao;

@Path("/products")
public class ProductsResource {
	
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	
	@GET
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		products.addAll(ProductDao.instance.getModel().values());
		return products;
	}
	
//	@GET
//	@Produces(MediaType.TEXT_XML)
//	public List<Product> getProductsBrowser() {
//		List<Product> products = new ArrayList<Product>();
//		products.addAll(ProductDao.instance.getModel().values());
//		return products;
//	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = ProductDao.instance.getModel().size();
		return String.valueOf(count);
	}
	
	@Path("{product}")
	public ProductResource getProduct(@PathParam("product") String id) {
		return new ProductResource(uriInfo, request, id);
	}

}
