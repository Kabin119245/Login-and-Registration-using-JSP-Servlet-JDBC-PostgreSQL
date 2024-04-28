package com.login.dao;

import java.sql.*;


public class LoginDAO {

    public boolean checkDetails(String username, String password) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        String sql = "select * from login where username =? and password =?";


        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/College", "postgres", "2078");

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, username);
        pst.setString(2, password);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return true;
        }
        return false;
    }

}
