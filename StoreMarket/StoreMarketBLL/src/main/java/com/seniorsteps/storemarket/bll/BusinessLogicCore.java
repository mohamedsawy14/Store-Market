/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.storemarket.bll;

import com.seniorsteps.storemarket.bll.Impl.BranchModuleImpl;
import com.seniorsteps.storemarket.bll.Impl.MenuModuelImpl;
import com.seniorsteps.storemarket.dal.hibernate.entity.Branches;
import com.seniorsteps.storemarket.dal.hibernate.entity.Catagories;
import com.seniorsteps.storemarket.dal.hibernate.entity.Products;
import static com.seniorsteps.storemarket.hibernateDAL.HibernateDBManager.*;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class BusinessLogicCore {
    
    private MenuModel menumodule;
    private BranchesModule branchmodule;

    public BusinessLogicCore() throws Exception {
        menumodule = new MenuModuelImpl();
        branchmodule = new BranchModuleImpl();
        hdbsetDbconfigfilename("hibernate.cfg.xml");
        hdbbuildssseionfactory();
        
    }

    public Catagories addcategory(Catagories category) throws Exception {
        return menumodule.addcategory(category);
    }

    public Catagories editcategory(Catagories category) throws Exception {
        return menumodule.editcategory(category);
    }

    public void deletecategory(Catagories category,String id) throws Exception {
        menumodule.deletecategory(category,id);
    }

    public List<Catagories> findAllcategory() throws Exception {
        return menumodule.findAllcategory();
    }

    public Catagories findcategory(Catagories category) throws Exception {
        return menumodule.findcategory(category);
    }

    public Products addproduct(Products product) throws Exception {
        return menumodule.addproduct(product);
    }

    public Products editproduct(Products product) throws Exception {
        return menumodule.editproduct(product);
    }

    public void deleteproduct(Products product) throws Exception {
        menumodule.deleteproduct(product);
    }

    public List<Products> findallproduct() throws Exception {
        return menumodule.findallproduct();
    }

    public Products findproduct(Products product) throws Exception {
        return menumodule.findproduct(product);
    }

    public List<Catagories> searchcategory(String categoryname) throws Exception {
        return menumodule.searchcategory(categoryname);
    }

    public Branches addBranch(Branches branche) throws Exception {
        return branchmodule.addBranch(branche);
    }

    public Branches editBranch(Branches branche) throws Exception {
        return branchmodule.editBranch(branche);
    }

    public void deleteBranch(Branches branche) throws Exception {
        branchmodule.deleteBranch(branche);
    }

    public Branches getBranch(Branches branche) throws Exception {
        return branchmodule.getBranch(branche);
    }

    public List<Branches> getAllBranch() throws Exception {
        return branchmodule.getAllBranch();
    }
    
    
    
}
