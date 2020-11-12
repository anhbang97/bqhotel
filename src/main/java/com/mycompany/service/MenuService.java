/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.bqhotel.HibernateUtils;
import com.mycompany.pojo.TABLE_MENU;
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
public class MenuService {
     private  final  static  SessionFactory factory = HibernateUtils.getSessionFactory();
     
     
    public List<TABLE_MENU> getTable_menus()
    {
        try(Session session  = factory.openSession())
        {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<TABLE_MENU> query = builder.createQuery(TABLE_MENU.class);
            
            Root<TABLE_MENU> root =query.from(TABLE_MENU.class);
            query.select(root);
            
            return  session.createQuery(query).getResultList();
        }
    }
}
