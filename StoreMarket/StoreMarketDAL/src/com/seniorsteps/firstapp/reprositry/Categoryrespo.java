/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.firstapp.reprositry;

import com.seniorsteps.storemarket.hibernateDAL.DBConnectionManager;
import com.seniorsteps.firstapp.entity.Category;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Categoryrespo {

    private DBConnectionManager dbconn = new DBConnectionManager();

    public int insert(Category category) throws ClassNotFoundException, SQLException {

        try (
                Connection conn = dbconn.connect();
                Statement stm = conn.createStatement();) {

            //2-Prepare Query
            String sqlquery = "INSERT INTO catagories(id,name,decription)"
                    + " VALUES ("+category.getId()+",'"+category.getName()+"','"+category.getDescription()+"');";
            //3-Excute Query
            int noofaffectedrows = stm.executeUpdate(sqlquery);
            //4-Fetch Result
            return noofaffectedrows;

            //5- Close Connection (Auto close with try-with-resources) 
        }

    }
    
    public int insertpreparedsystem(Category category) throws ClassNotFoundException, SQLException {

        try (
                Connection conn = dbconn.connect();
               ) {

            //2-Prepare Query
            String sqlquery = "INSERT INTO catagories(id,name,decription)"
                    + " VALUES (?,?,?);";
                PreparedStatement prtmt = conn.prepareStatement(sqlquery);
            //3-Excute Query
            prtmt.setInt(0x0, category.getId());
            prtmt.setString(1, category.getName());
            prtmt.setString(2, category.getDescription());
            
            int noofaffectedrows = prtmt.executeUpdate(sqlquery);
            //4-Fetch Result
            return noofaffectedrows;

            //5- Close Connection (Auto close with try-with-resources) 
        }

    }

    public int update(Category category) throws ClassNotFoundException, SQLException {

        try (
                Connection conn = dbconn.connect();
                Statement stm = conn.createStatement();) {

            //2-Prepare Query
            String sqlquery = "UPDATE catagories SET name= '" + category.getName() + "',"
                            + "decription = '" + category.getDescription() +
                            "' WHERE id= " + category.getId() + ";";
            //3-Excute Query
            int noofaffectedrows = stm.executeUpdate(sqlquery);
            //4-Fetch Result
            return noofaffectedrows;

            //5- Close Connection (Auto close with try-with-resources) 
        }
    }
     public int updateusingpreparedsystem(Category category) throws ClassNotFoundException, SQLException {

        try (
                Connection conn = dbconn.connect();
               ) {

            //2-Prepare Query
            String sqlquery = "UPDATE catagories "
                            + "SET name= ?,"
                            + "decription = ? WHERE id= ?;";
            
            //3-Excute Query
             PreparedStatement stm = conn.prepareStatement(sqlquery);
             stm.setString(0,category.getName());
             stm.setString(1,category.getDescription());
             stm.setInt(2,category.getId());
            int noofaffectedrows = stm.executeUpdate(sqlquery);
            //4-Fetch Result
            return noofaffectedrows;

            //5- Close Connection (Auto close with try-with-resources) 
        }
    }

    public int delete(Integer id) throws ClassNotFoundException, SQLException {

        try (
                Connection conn = dbconn.connect();
                Statement stm = conn.createStatement();) {

            //2-Prepare Query
            String sqlquery =   " DELETE FROM catagories "
                              + "WHERE id= " + id + ";";
            //3-Excute Query
            int noofaffectedrows = stm.executeUpdate(sqlquery);
            //4-Fetch Result
            return noofaffectedrows;

            //5- Close Connection (Auto close with try-with-resources) 
        }

    }

    public List<Category>   selectAll()throws ClassNotFoundException, SQLException{
    
             try (
                Connection conn = dbconn.connect();
                Statement stm = conn.createStatement();) {

            //2-Prepare Query
            String sqlquery = "SELECT * FROM catagories;";
            //3-Excute Query
                 ResultSet res = stm.executeQuery(sqlquery);
            //4-Fetch Result
            List<Category> allcategory = new ArrayList<>();
            while(res.next()){
            
                Category currentcategory = new Category();
                currentcategory.setId(res.getInt("id"));
                currentcategory.setName(res.getString("name"));
                currentcategory.setDescription(res.getString("decription"));
                allcategory.add(currentcategory);
            
            
            }
            
            return allcategory;

            //5- Close Connection (Auto close with try-with-resources) 
        }
    
    
    
    }
    
    public Category selectid(Integer id)throws ClassNotFoundException, SQLException{
        
        
          try (
                Connection conn = dbconn.connect();
                Statement stm = conn.createStatement();) {

            //2-Prepare Query
            String sqlquery = "SELECT * FROM catagories WHERE id = "+id+"; ";
            //3-Excute Query
                 ResultSet res = stm.executeQuery(sqlquery);
            //4-Fetch Result
            
            while(res.next()){
            
                Category currentcategory = new Category();
                currentcategory.setId(res.getInt("id"));
                currentcategory.setName(res.getString("name"));
                currentcategory.setDescription(res.getString("decription"));
                return currentcategory;
            
            
            }
            return null;
            

            //5- Close Connection (Auto close with try-with-resources) 
        }
    
    
    
    
    
    
    }
}
