package com.seniorsteps.storemarket.bll.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.seniorsteps.storemarket.dal.hibernate.entity.Catagories;
import com.seniorsteps.storemarket.dal.hibernate.entity.Cities;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import static com.seniorsteps.storemarket.hibernateDAL.HibernateDBManager.*;

/**
 *
 * @author Administrator
 */public class DALMainClass {
    
    public static void main(String[] args) {
        try {
            String filename = "hibernate.cfg.xml";
            hdbsetDbconfigfilename(filename);
           hdbbuildssseionfactory();
           
           DBTestClasses dtc = new DBTestClasses();
           
          // dtc.insertcategory();
           
          // dtc.deletecategory();
          //dtc.findcategorybyid();
         // dtc.findAllgategories();
        // dtc.findAllgategoriesHQL();
        dtc.findAllcategoriesCritrea();
        } catch (Exception ex) {
            System.out.println("Are this Exception "+ex.getMessage());
        }
        getDbsessionfactory().close();
    }
    
}
