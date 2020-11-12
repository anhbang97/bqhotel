/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.bqhotel.HibernateUtils;
import com.mycompany.pojo.TABLE_SERVICES;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author HOME
 */
public class Ser_Service {
      private  final  static  SessionFactory factory = HibernateUtils.getSessionFactory();
     
     
    public List<TABLE_SERVICES> getTable_serviceses()
    {
        try(Session session  = factory.openSession())
        {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<TABLE_SERVICES> query = builder.createQuery(TABLE_SERVICES.class);
            
            Root<TABLE_SERVICES> root =query.from(TABLE_SERVICES.class);
            query.select(root);
            
            return  session.createQuery(query).getResultList();
        }
    }
    
    public TABLE_SERVICES getServiceById (int serID){
     try(Session session  = factory.openSession()){
         return session.get(TABLE_SERVICES.class, serID);
         
     }      
    
    }
}
