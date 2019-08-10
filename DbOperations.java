/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.test;

import com.system.DBConnection.Registration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author PC
 */
public class DbOperations {

    public Connection db_connect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "root", "root");
          //  System.out.println("DB connected");
            //System.out.println(con.getCatalog());
        } catch (Exception ex) {
            System.out.println("Error :" + ex.toString());
        }
        return con;

    }

       public HashMap<String, Integer> loadCombo() {

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Connection con = db_connect();
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            String query = "SELECT category_id, category_name FROM category";
            rs = st.executeQuery(query);
            Model ctm;

            while (rs.next()) {

                ctm = new Model(rs.getInt(1), rs.getString(2));
                map.put(ctm.getCategory_name(), ctm.getCategory_id());

            }

        } catch (Exception ex) {

            System.out.println(ex.toString());
        }

        return map;

    }
    public HashMap<String, Integer> populateCombo() {

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        Connection con = db_connect();
        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            String query = "SELECT category_id, category_name FROM category";
            rs = st.executeQuery(query);
            Model md;

            while (rs.next()) {

                md = new Model(rs.getInt(1), rs.getString(2));
                map.put(md.getCategory_name(), md.getCategory_id());

            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        return map;
    }
}
