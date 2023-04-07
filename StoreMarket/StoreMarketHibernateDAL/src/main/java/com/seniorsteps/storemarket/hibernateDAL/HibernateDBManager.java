package com.seniorsteps.storemarket.hibernateDAL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.imageio.spi.ServiceRegistry;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Administrator
 */
public class HibernateDBManager {

    private static SessionFactory dbsessionfactory;

    public static void hdbsetDbconfigfilename(String dbconfigfilename) {
        HibernateDBManager.dbconfigfilename = dbconfigfilename;
    }

    public static SessionFactory getDbsessionfactory() {
        return dbsessionfactory;
    }

    private static String dbconfigfilename;

    public static void hdbbuildssseionfactory() throws Exception {
        try {
            if (dbsessionfactory != null) {

                return;

            }
            if (dbconfigfilename == null) {
                throw new Exception("Erorr : You must call setDbconfigfilename(filename)first");

            }
            Configuration conf = new Configuration().configure(dbconfigfilename);

            StandardServiceRegistryBuilder serviceregistrybuilder = new StandardServiceRegistryBuilder();
            serviceregistrybuilder.applySettings(conf.getProperties());
            StandardServiceRegistry sv = serviceregistrybuilder.build();
            dbsessionfactory = conf.buildSessionFactory(sv);

        } catch (HibernateException ex) {
            dbsessionfactory = null;
            dbconfigfilename = null;
            throw ex;

        }
    }

    public static Session hdbgetcommonrepo() {

        return dbsessionfactory.getCurrentSession();

    }

    public static void hdbbeginTransaction() {

        dbsessionfactory.getCurrentSession().beginTransaction();
    }

    public static void hdbcommitTransaction() {

        dbsessionfactory.getCurrentSession().getTransaction().commit();
    }

    public static void hdbrollbackTransaction() {
        if (dbsessionfactory.getCurrentSession().getTransaction().isActive()) {
            dbsessionfactory.getCurrentSession().getTransaction().rollback();
        }

    }
}
//	if(sessionFactory == null) sessionFactory = buildSessionFactory();
//        return sessionFactory;
