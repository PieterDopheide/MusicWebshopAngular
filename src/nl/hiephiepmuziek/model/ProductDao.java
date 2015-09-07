package nl.hiephiepmuziek.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public enum ProductDao {
	instance;
	
	private Map<Integer, Product> products = new HashMap<>();
	
	private ProductDao() {
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
                products.put(e.getId(), e);
            }
            
        } catch (SQLException sqle){} catch (NamingException e1) {
			e1.printStackTrace();
		} finally {
        	if (db != null) {
        		try {
					db.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
        }
	}
	
	public Map<Integer, Product> getModel() {
		return products;
	}
	
	protected Connection getConnection() throws SQLException, NamingException {
        InitialContext ic = new InitialContext();
        DataSource ds = (DataSource) ic.lookup("jdbc/hiephiepmuziek");
        return ds.getConnection();
    }
	
	public Product getFromResultSet(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setSnippet(rs.getString("snippet"));
        return product;
    }

}
