/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.bqhotel.HibernateUtils;
import com.mycompany.pojo.TABLE_ROOMS;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author HOME
 */
public class RoomsService {
     private  final  static  SessionFactory factory = HibernateUtils.getSessionFactory();
     public  List<TABLE_ROOMS> getTable_roomses(String KeyWord)
     {
            try(Session ssn = factory.openSession())
            {
                CriteriaBuilder builder = ssn.getCriteriaBuilder();
                CriteriaQuery<TABLE_ROOMS> query = builder.createQuery(TABLE_ROOMS.class);
                Root<TABLE_ROOMS> root = query.from(TABLE_ROOMS.class);
                query.select(root);
                
                if(KeyWord != null && !KeyWord.isEmpty())
                {
                    String search = String.format("%%%s%%", KeyWord);
                    Predicate p1 = builder.like(root.get("rooms_name").as(String.class), search);
                    Predicate p2 = builder.like(root.get("rooms_descriptions").as(String.class), search);
                    
                    query = query.where(builder.or(p1,p2));
                    
                }
                
                return  ssn.createQuery(query).getResultList();
            
            }
     
     }
    public boolean addOrSaveRooms(TABLE_ROOMS r) {
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.saveOrUpdate(r);
                session.getTransaction().commit();
            } catch(Exception ex) {
                session.getTransaction().rollback();
                return false;
            }
        }
        return true;
    }
    
    public boolean deleteRooms(TABLE_ROOMS r){
         try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.delete(r);
                session.getTransaction().commit();
            } catch(Exception ex) {
                session.getTransaction().rollback();
                return false;
            }
        }
        return true;
    }
    public TABLE_ROOMS getTable_roomsByID(int roomId)
    {
        try(Session session = factory.openSession()){
            return session.get(TABLE_ROOMS.class, roomId);
        }
    }

}
