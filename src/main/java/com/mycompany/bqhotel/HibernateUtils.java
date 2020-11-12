/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bqhotel;

import com.mycompany.pojo.TABLE_CUSTOMERS;
import com.mycompany.pojo.TABLE_MENU;
import com.mycompany.pojo.TABLE_ROOMS;
import com.mycompany.pojo.TABLE_SERVICES;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author HOME
 */
public class HibernateUtils {
    private static final SessionFactory sessionFactory;
    
    static {
        try {
            Configuration conf = new Configuration();
            
            Properties pros = new Properties();
            pros.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            pros.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            pros.put(Environment.URL, "jdbc:mysql://localhost:3306/hoteldb?zeroDateTimeBehavior=CONVERT_TO_NULL");
            pros.put(Environment.USER, "root");
            pros.put(Environment.PASS, "123456789");
            
            conf.setProperties(pros);
            
            ServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .applySettings(conf.getProperties()).build();
            

            conf.addAnnotatedClass(TABLE_MENU.class);
            conf.addAnnotatedClass(TABLE_ROOMS.class);
            conf.addAnnotatedClass(TABLE_SERVICES.class);
            conf.addAnnotatedClass(TABLE_CUSTOMERS.class);
            
            sessionFactory =  conf.buildSessionFactory(registry); //new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
