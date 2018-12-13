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
import shop.business.UserMember;

/**
 *
 * @author TRINH_PC
 */
public class UserMemberDAO {

    public static int insert(UserMember userMember) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO UserMember (Username,Password,FirstName,LastName,Email,CompanyName,Address1,Address2,City,Country)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, userMember.getUsername());
            ps.setString(2, userMember.getPassword());
            ps.setString(3, userMember.getFirstName());
            ps.setString(4, userMember.getLastName());
            ps.setString(5, userMember.getEmail());
            ps.setString(6, userMember.getCompanyName());
            ps.setString(7, userMember.getAddress1());
            ps.setString(8, userMember.getAddress2());
            ps.setString(9, userMember.getCity());
            ps.setString(10, userMember.getCountry());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            ps.close();
            pool.freeConnection(connection);
        }
    }

    public static boolean checkUser(String username, String password) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM usermember Where Username = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
               if (rs.getString("password").equalsIgnoreCase(password)){
                   return true;
               }
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            ps.close();
            pool.freeConnection(connection);
        }
        return false;
    }
}
