/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.storemarket.presntation.consoleapp;

import com.seniorsteps.storemarket.bll.BusinessLogicCore;
import com.seniorsteps.storemarket.dal.hibernate.entity.Catagories;
import static com.seniorsteps.storemarket.hibernateDAL.HibernateDBManager.hdbbeginTransaction;
import static com.seniorsteps.storemarket.hibernateDAL.HibernateDBManager.hdbcommitTransaction;
import static com.seniorsteps.storemarket.hibernateDAL.HibernateDBManager.hdbgetcommonrepo;
import static com.seniorsteps.storemarket.hibernateDAL.HibernateDBManager.hdbrollbackTransaction;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

/**
 *
 * @author Administrator
 */
public class MainConsoleApp {

    public static void main(String[] args) {

        System.out.println("Welcome to our Application-----");
        Scanner keyb = new Scanner(System.in);

        while (true) {

            System.out.println("Kindly choice operation from the List");
            System.out.println("1. Add new Category  ");
            System.out.println("2-Find All category  ");
            System.out.println("3-Delete Category  ");
            System.out.println("4-Exite");

            String operation = keyb.nextLine();
            Integer operationnumber = 0;
            try {
                operationnumber = Integer.parseInt(operation);
            } catch (NumberFormatException ex) {
                System.err.println("Invalid Ckoice. Please try Again" + ex.getMessage());
            }
            boolean exit = false;
            switch (operationnumber) {
                case 1:
                    addedcategoryFromConsole();
                    break;
                case 2:
                    findAllcategoriesCritreafromConsole();
                    break;
                case 3:
                    deletcategoryconsole();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Choice. Please try Again");
            }
            if (exit) {
                break;
            }

        }

    }

    public static void addedcategoryFromConsole() {

        try {
            Scanner keyboardscanner = new Scanner(System.in);
            System.out.println("ID No.");
            String id = keyboardscanner.nextLine();
            System.out.println("Category name");
            String name = keyboardscanner.nextLine();
            System.out.println("Category Description");
            String description = keyboardscanner.nextLine();

            Catagories newcategory = new Catagories(id, name);
            newcategory.setDecription(description);

            BusinessLogicCore blc = new BusinessLogicCore();
            Catagories addedcategory = blc.addcategory(newcategory);

            System.out.println("New category added Succesful by new id" + addedcategory.getId());
        } catch (Exception ex) {
            System.err.println("Error " + ex.getMessage());

        }

    }

    public static void findAllcategoriesCritreafromConsole() {

        try {

            System.out.println("----Table Categories ---");
            
            BusinessLogicCore blc = new BusinessLogicCore();
            blc.findAllcategory();
            

        } catch (Exception e) {
            System.err.println("Erorr" + e.getMessage());
        }

    }

    public static void deletcategoryconsole() {
        try {
            Scanner keyb = new Scanner(System.in);
            System.out.println("Enter ID  ");
           String id = keyb.nextLine();
            
            Catagories category = new Catagories();
            category.setId(id);
            BusinessLogicCore blc = new BusinessLogicCore();
            blc.deletecategory(category, id);
            System.out.println("Deleted Succesful  "+category.getId());
        } catch (Exception ex) {
            System.out.println("Erorrrr "+ex.getMessage());
        }
            
    }

}
