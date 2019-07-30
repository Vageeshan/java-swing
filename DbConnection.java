
package com.system.db;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnection {
    
   
    public Connection db_connect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/registration", "root", "root");
            System.out.println("DB connected");
        } catch (Exception ex) {
            System.out.println("Error :" + ex.toString());
        }
        return con;
    }
    
    
    
    
    
}
