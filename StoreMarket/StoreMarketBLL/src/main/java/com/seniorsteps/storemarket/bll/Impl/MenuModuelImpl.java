/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.storemarket.bll.Impl;

import com.seniorsteps.storemarket.bll.MenuModel;
import com.seniorsteps.storemarket.common.exception.StoreMarketValidation;
import com.seniorsteps.storemarket.dal.hibernate.entity.Catagories;
import com.seniorsteps.storemarket.dal.hibernate.entity.Products;
import static com.seniorsteps.storemarket.hibernateDAL.HibernateDBManager.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Administrator
 */
public class MenuModuelImpl implements MenuModel{
    private void validateCategory  (Catagories category)throws StoreMarketValidation{
        if(null == category){
        throw new StoreMarketValidation("Categories can not be null");
        
        }
        if(null == category.getName() || category.getName().isEmpty()){
        
        throw new StoreMarketValidation("Categories.name can not be null or Empty");
        
        }
    
    }
    @Override
    public Catagories addcategory (Catagories category) throws Exception {
        
          try{
              validateCategory(category);
        Session commonrepo = hdbgetcommonrepo();
        hdbbeginTransaction();
     String id =   (String) commonrepo.save(category);
        category.setId(id);
        
        hdbcommitTransaction();
        return category;
        
        }catch(Exception e){
        hdbrollbackTransaction();
              
                  throw e;
              } 
        

        
    }

    @Override
    public Catagories editcategory(Catagories category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletecategory(Catagories category ,String id) {
        
         try {
            Session commonrepo = hdbgetcommonrepo();
             System.out.println("begin Transaction");

            hdbbeginTransaction();
         System.out.println("2begin Transaction");
           
            Catagories findcategory = (Catagories)commonrepo.get(Catagories.class,id);
            commonrepo.delete(findcategory);
           //  String id =   (String) commonrepo.delete(category);
            // category.setId(id);
            System.out.println("3begin Transaction");
            
            hdbcommitTransaction();
            

        } catch (Exception e) {
            hdbrollbackTransaction();
        }
    }

    @Override
    public List<Catagories> findAllcategory()throws Exception{
        
        
      
    
        
        
        
        try{
        Session commonrepo = hdbgetcommonrepo();
            System.out.println("begincommonrepo");
        hdbbeginTransaction();
            Criteria crietrea = 
                    commonrepo.createCriteria(Catagories.class).addOrder(Order.asc("name"));
          //  List<Catagories> cateegoryresult = crietrea.list();
            List<Catagories> resultList = crietrea.list();
            for (Catagories  icatagories : resultList) {
                System.out.print("ID " + icatagories.getId());
                System.out.print(" : ");
                System.out.println("Name "+ icatagories.getName());}
        hdbcommitTransaction();
        return resultList;
        }catch(Exception e){
        hdbrollbackTransaction();
        throw e;
        }
    
    }
    @Override
    public Catagories findcategory(Catagories category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Products addproduct(Products product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Products editproduct(Products product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteproduct(Products product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Products> findallproduct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Products findproduct(Products product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Catagories> searchcategory(String categoryname) throws Exception {
          try{
        Session commonrepo = hdbgetcommonrepo();
        hdbbeginTransaction();
            Criteria crietrea = 
                    commonrepo.createCriteria(Catagories.class).addOrder(Order.asc("name"))
                    .add(Restrictions.like("name", categoryname, MatchMode.ANYWHERE));
            List<Catagories> cateegoryresult = crietrea.list();
        hdbcommitTransaction();
        return cateegoryresult;
        }catch(Exception e){
        hdbrollbackTransaction();
        throw e;
        
        
    }
    }
    
}
