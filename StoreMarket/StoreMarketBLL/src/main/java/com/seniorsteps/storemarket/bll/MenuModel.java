/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.storemarket.bll;

import com.seniorsteps.storemarket.dal.hibernate.entity.Catagories;
import com.seniorsteps.storemarket.dal.hibernate.entity.Products;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface MenuModel {

    Catagories addcategory(Catagories category)throws Exception;

    Catagories editcategory(Catagories category)throws Exception;

   public void deletecategory(Catagories category ,String id)throws Exception;

    List<Catagories> findAllcategory()throws Exception;

    Catagories findcategory(Catagories category)throws Exception;

    Products addproduct(Products product)throws Exception;

    Products editproduct(Products product)throws Exception;

    void deleteproduct(Products product)throws Exception;

    List<Products> findallproduct()throws Exception;

    Products findproduct(Products product)throws Exception;
    
    List<Catagories> searchcategory(String categoryname)throws Exception;

}
