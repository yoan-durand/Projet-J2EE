/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mti.webshare.hibernatesession;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author yoan
 * EPITA MTI 2013
 *
 */


public class HibernateUtils 
{
    private static final SessionFactory sessionFactory;
    
    // Crée une unique instance de la SessionFactory à partir de hibernate.cfg.xml
    static {
        try {
                sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
             } catch (HibernateException ex) 
             {
                throw new RuntimeException("Problème de configuration : " + ex.getMessage(), ex);
             }
            }
// Renvoie une session Hibernate
     public static Session getSession() throws HibernateException 
     {
            return sessionFactory.openSession();
     }
}

