/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.storemarket.bll.test;

import com.seniorsteps.storemarket.dal.hibernate.entity.Catagories;
import static com.seniorsteps.storemarket.hibernateDAL.HibernateDBManager.hdbbeginTransaction;
import static com.seniorsteps.storemarket.hibernateDAL.HibernateDBManager.hdbbuildssseionfactory;
import static com.seniorsteps.storemarket.hibernateDAL.HibernateDBManager.hdbcommitTransaction;
import static com.seniorsteps.storemarket.hibernateDAL.HibernateDBManager.hdbgetcommonrepo;
import static com.seniorsteps.storemarket.hibernateDAL.HibernateDBManager.hdbrollbackTransaction;
import static com.seniorsteps.storemarket.hibernateDAL.HibernateDBManager.hdbsetDbconfigfilename;
import java.util.List;
import java.util.Locale;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Administrator
 */
public class DBTestClasses {

    public void insertcategory() {

        Session commonrepo = hdbgetcommonrepo();
        // newcategory--> Transient object 
        Catagories newcategory = new Catagories("pestist with persisteant obj ");
        // newcategory.setDecription("Hello maven");

        // Catagories newcategory = new Catagories("100", "maven 99");
        //  newcategory.setDecription("Hibernate Mapping Annotation99");
//                Catagories newcategory = new Catagories("12", "Maven12");
//                newcategory.setDecription("Hello maven");
//                Cities newcity = new Cities("Cairo");
//                newcity.setId(33);
//                
        try {
            hdbbeginTransaction();

            //newcategory --> Presistent object
            Catagories foundcategory = (Catagories) commonrepo.get(Catagories.class, "12");

            foundcategory.setDecription("save pessitent object");
            Catagories newCatagory = new Catagories("100", "merge presitent object");
            newCatagory.setDecription("merge presitent object2");
            commonrepo.merge(newCatagory);

            // commonrepo.save(foundcategory);
//            String savedcategoriesid = (String) commonrepo.save(newcategory);
//          
//            if (null != savedcategoriesid) {
//                System.out.println(savedcategoriesid);
//
//            }
            hdbcommitTransaction();
        } catch (HibernateException dbex) {
            System.err.println("Database Error  " + dbex.getMessage());
            hdbrollbackTransaction();
        }
        //newcategory --> Detatched object

    }

    public void deletecategory() {
        try {
            Session commonrepo = hdbgetcommonrepo();

            hdbbeginTransaction();
            Catagories newcategory = new Catagories();
            newcategory.setId("20");

            Catagories findcategory = (Catagories) commonrepo.get(Catagories.class, "20");

            commonrepo.delete(findcategory);
            hdbcommitTransaction();

        } catch (Exception e) {
            hdbrollbackTransaction();
        }

    }

    public void findcategorybyid() {

        try {
            Session commonrepo = hdbgetcommonrepo();

            hdbbeginTransaction();

            //Catagories findcategory = (Catagories) commonrepo.get(Catagories.class, "77");
            Catagories findcategory = (Catagories) commonrepo.load(Catagories.class, "9999");

            System.out.println("ID : " + findcategory.getId());
            System.out.println("Name : " + findcategory.getName());
            System.out.println("Description : " + findcategory.getDecription());

            hdbcommitTransaction();

        } catch (Exception e) {
            hdbrollbackTransaction();
            throw e;
        }

    }

    public void findAllgategoriesnative() {
        try {
            Session commonrepo = hdbgetcommonrepo();

            hdbbeginTransaction();

            String nativequery = "SELECT * FROM catagories;";

            SQLQuery query = commonrepo.createSQLQuery(nativequery);
            query.addEntity(Catagories.class);
            List<Catagories> result = query.list();

            for (Catagories icatagories : result) {
                System.out.print("ID " + icatagories.getId());
                System.out.print(" : ");
                System.out.println("Name " + icatagories.getName());
                // System.out.print("Description " + icatagories.getDecription());

            }

            hdbcommitTransaction();
        } catch (Exception e) {
            hdbrollbackTransaction();
        }
    }

    public void findAllgategoriesHQL() {
        try {
            Session commonrepo = hdbgetcommonrepo();

            hdbbeginTransaction();

            String hqlquery = "FROM Catagories";

            Query query = commonrepo.createQuery(hqlquery);
            
            List<Catagories> result = query.list();

            for (Catagories icatagories : result) {
                System.out.print("ID " + icatagories.getId());
                System.out.print(" : ");
                System.out.println("Name " + icatagories.getName());
                // System.out.print("Description " + icatagories.getDecription());

            }

            hdbcommitTransaction();
        } catch (Exception e) {
            hdbrollbackTransaction();
        }
    }
    
    public void findAllcategoriesCritrea(){
    
        try{
        Session commonrepo = hdbgetcommonrepo();
        hdbbeginTransaction();
            Criteria critrea = commonrepo.createCriteria(Catagories.class);
            
           // critrea.addOrder(Order.asc("name"));
          //  critrea.add(Restrictions.like("name","New", MatchMode.ANYWHERE));
              //critrea.add(Restrictions.or(Restrictions.like("name","New", MatchMode.ANYWHERE),
                        //  Restrictions.like ("name","maven", MatchMode.ANYWHERE)));
              Criteria criproj =  critrea.setProjection(Projections.count("id")); 
            
            
//            List<Catagories> resultList = critrea.list();
//            for (Catagories  icatagories : resultList) {
////                System.out.print("ID " + icatagories.getId());
////                System.out.print(" : ");
////                System.out.println("Name "+ icatagories.getName());
//
//                
//            }

            List<Catagories> result = criproj.list();
            for (Catagories icatagories : result) {
                System.out.println("No of Rowa of IDs "+icatagories);
            }
        
        
        hdbcommitTransaction();
        }catch(Exception e){
        hdbrollbackTransaction();
        
        }
    
    
    }
}
