package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.config.PropertyManager;
import com.entities.Employee;

/**
 * This class is for directly SQL
 * 2016/03/23
 * author: Miao shan
 */

public class DirectlyDatabase {
    public static Connection getConnection() {
  
        Connection conn = null;
        try {
            String db_driver = PropertyManager.getProperty("db_driver");
            String db_url = PropertyManager.getProperty("db_url");
            String db_username = PropertyManager.getProperty("db_username");
            String db_password = PropertyManager.getProperty("db_password");
            Class.forName(db_driver);

            conn = DriverManager.getConnection(db_url, db_username, db_password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * query from database based on the input sql and params
     * @param query
     * @param params
     * @return a list
     * @throws SQLException 
     */
    public static List<Employee> query(String query, String... params) throws SQLException {
        Connection conn = null;
        List<Employee> list = new ArrayList<Employee>();
        try {
            conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            for (int i = 1; i <= params.length; i++) {
                pstmt.setString(i, params[i - 1]);
            }
            System.out.println(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	Employee e = new Employee();
            	e.setId(Integer.parseInt(rs.getString(1)));
            	e.setFirstName(rs.getString(2));
            	e.setLastName(rs.getString(3));
            	e.setDepartment(rs.getString(4));
            	list.add(e);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                System.out.println(PropertyManager.getProperty("db_conn_closed"));
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }
        return list;
    }

    /**
     * insert,update,delete record from database based on the input sql and params
     * @param query
     * @param params
     * @return the database result set first element
     * @throws SQLException 
     */
    public static int update(String query, String... params) throws SQLException {
        Connection conn = null;
        int result = 1;
        try {
            conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            for (int i = 1; i <= params.length; i++) {
                pstmt.setString(i, params[i - 1]);
            }
            System.out.println(query);
            int rowsEffect = pstmt.executeUpdate();
            //ResultSet rs = pstmt.getGeneratedKeys();
            
        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                System.out.println(PropertyManager.getProperty("db_conn_closed"));
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
