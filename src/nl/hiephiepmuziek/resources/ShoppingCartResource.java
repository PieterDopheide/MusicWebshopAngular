package nl.hiephiepmuziek.resources;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import nl.hiephiepmuziek.model.Product;
import nl.hiephiepmuziek.model.ShoppingCart;

@Path("/shopping-cart")
public class ShoppingCartResource {
	
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	
	@Context
    HttpServletRequest servletRequest;
	
	private ShoppingCart getShoppingCart() {
		ShoppingCart sc = null;

		HttpSession session = servletRequest.getSession();

		if (session.getAttribute("shopping-cart") == null) {
			sc = new ShoppingCart();
			session.setAttribute("shopping-cart", sc);
		} else {
			sc = (ShoppingCart) session.getAttribute("shopping-cart");
		}
		
		return sc;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		products.addAll(getShoppingCart().getCart());
		return products;
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = getShoppingCart().productCount();
		return String.valueOf(count);
	}
	
	@GET
	@Path("total")
	@Produces(MediaType.TEXT_PLAIN)
	public String getTotal() {
		BigDecimal count = getShoppingCart().total();
		return String.valueOf(count);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addProduct(Product product) {
		getShoppingCart().addToCart(product);
	}
	
	@DELETE
    @Path("{id}")
	public void removeProduct(@PathParam("id") int id) {
		System.out.println("Remove product with id: " + id);
		getShoppingCart().removeFromCart(id);
	}

}
