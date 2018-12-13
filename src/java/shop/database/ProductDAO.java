/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import shop.business.Product;

/**
 *
 * @author TRINH_PC
 */
public class ProductDAO {

    public static int insert(Product product) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO Product (ProductCode,ProductDescription,ProductPrice)VALUES ( ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getProductCode());
            ps.setString(2, product.getProductDescription());
            ps.setDouble(3, product.getProductPrice());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            ps.close();
            pool.freeConnection(connection);
        }
    }

    public static int delete(int productID) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query
                = "DELETE FROM Product WHERE productID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            ps.close();
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Product> selectProduct() throws SQLException {
        ArrayList<Product> products = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM product";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("productID"));
                product.setProductCode(rs.getString("productCode"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setProductPrice(rs.getDouble("productPrice"));
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static Product getProduct(int productID) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Product product = new Product();
        String query = "SELECT * FROM product Where productID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            rs = ps.executeQuery();
            if (rs.next()) {
                product.setProductID(rs.getInt("productID"));
                product.setProductCode(rs.getString("productCode"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setProductPrice(rs.getDouble("productPrice"));
            }
            return product;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
     public static int update(Product product) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                ="UPDATE product SET productCode = ?, productDescription = ?, productPrice = ? WHERE productID = ?";
//                = "INSERT INTO Product (ProductCode,ProductDescription,ProductPrice)VALUES ( ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getProductCode());
            ps.setString(2, product.getProductDescription());
            ps.setDouble(3, product.getProductPrice());
            ps.setInt(4, product.getProductID());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            ps.close();
            pool.freeConnection(connection);
        }
    }   

}
