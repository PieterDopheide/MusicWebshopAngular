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
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		products.addAll(ProductDao.instance.getModel().values());
		return products;
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = ProductDao.instance.getModel().size();
		return String.valueOf(count);
	}
	
//	@Path("{productId}")
//	public ProductResource getProduct(@PathParam("productId") int id) {
//		return new ProductResource(uriInfo, request, id);
//	}
	
	@GET
	@Path("{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@PathParam("productId") int id) {
		Product product = null;
		product = ProductDao.instance.getModel().get(id);
		
		if (product == null) {
			throw new RuntimeException("Get: Product with " + id + " not found");
		}
		
		return product;
	}

}
