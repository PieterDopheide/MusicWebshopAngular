package nl.hiephiepmuziek.resources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import nl.hiephiepmuziek.model.Product;
import nl.hiephiepmuziek.model.ProductDao;

@Path("/products")
public class ProductsResource {
	
//	@Context
//	UriInfo uriInfo;
//	
//	@Context
//	Request request;
	
	@GET
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts() throws SQLException, NamingException {
//		List<Product> products = new ArrayList<Product>();
//		products.addAll(ProductDao.instance.getModel().values());
//		return products;
		
		List events = new ArrayList<>();
//        Connection db = getConnection();
		Connection db = null;
        
        try {
        	Context initContext = new InitialContext();
            Context envContext  = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/hiephiepmuziek");
            db = ds.getConnection();
        	
            PreparedStatement st = db.prepareStatement("SELECT id, name, snippet from products");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product e = getFromResultSet(rs);
                events.add(e);
            }
            return events;
        } finally {
        	if (db != null) {
        		db.close();
        	}
        }
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
	
//	@Path("{product}")
//	public ProductResource getProduct(@PathParam("product") String id) {
//		return new ProductResource(uriInfo, request, id);
//	}
	
	protected Connection getConnection() throws SQLException, NamingException {
        InitialContext ic = new InitialContext();
//        DataSource ds = (DataSource) ic.lookup("jdbc/DSTix");
        DataSource ds = (DataSource) ic.lookup("jdbc/hiephiepmuziek");
        return ds.getConnection();
    }
	
	public Product getFromResultSet(ResultSet rs) throws SQLException {
        Product event = new Product();
        event.setId(rs.getInt("id"));
        event.setName(rs.getString("name"));
        event.setSnippet(rs.getString("snippet"));
        return event;
    }

}
