/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.storemarket.bll;

import com.seniorsteps.storemarket.dal.hibernate.entity.Branches;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface BranchesModule {

    Branches addBranch(Branches branche) throws Exception;

    Branches editBranch(Branches branche) throws Exception;

    public void deleteBranch(Branches branche) throws Exception;

    Branches getBranch(Branches branche) throws Exception;

    List<Branches> getAllBranch() throws Exception;

}
