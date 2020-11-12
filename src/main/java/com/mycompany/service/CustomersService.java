/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.bqhotel.HibernateUtils;
import com.mycompany.pojo.TABLE_CUSTOMERS;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author HOME
 */
public class CustomersService {

    private final static SessionFactory factory = HibernateUtils.getSessionFactory();

      public boolean addCus(TABLE_CUSTOMERS c) {
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                c.setCustomers_password(DigestUtils.md2Hex(c.getCustomers_password()));
                session.save(c);
                session.getTransaction().commit();
                return true;
            } catch (Exception ex) {
                session.getTransaction().rollback();
            }
        }
        return false;
    }
    
     public TABLE_CUSTOMERS signIn(String username , String password)
    {
        password = DigestUtils.md5Hex(password);
        try(Session sn = factory.openSession())
        {
            CriteriaBuilder b = sn.getCriteriaBuilder();
            CriteriaQuery<TABLE_CUSTOMERS> q = b.createQuery(TABLE_CUSTOMERS.class);
            Root<TABLE_CUSTOMERS> root = q.from(TABLE_CUSTOMERS.class);
            q.select(root);
            q.where(b.and(
                         b.equal(root.get("customers_username").as(String.class),username),
                         b.equal(root.get("customers_password").as(String.class),password)
                         ));

            return  sn.createQuery(q).getSingleResult();
                        
        }
      
    }
}
