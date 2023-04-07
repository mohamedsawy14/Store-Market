/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.firstwebapp.jsf;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Administrator
 */
@Named(value = "firstManagedBean")
@Dependent
public class FirstManagedBean implements Serializable{
    
    
    private String name;
    /**
     * Creates a new instance of FirstManagedBean
     */
    public FirstManagedBean() {
    }
    
    public String getmessage(){
    return "Hello";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
