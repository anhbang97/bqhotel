/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bqhotel;

import com.mycompany.pojo.TABLE_ROOMS;
import com.mycompany.pojo.TABLE_SERVICES;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle;
import org.hibernate.Session;

/**
 *
 * @author HOME
 */
public class Demo {
    public static void main(String[] args) {
       try( Session session = HibernateUtils.getSessionFactory().openSession();){
         session.getTransaction().begin();
        TABLE_SERVICES s = session.get(TABLE_SERVICES.class,2);
        TABLE_ROOMS r = new TABLE_ROOMS();
        r.setRooms_name("a");
        r.setRooms_descriptions("a");
        r.setRooms_prices(12);
        r.setRooms_category("a");
        r.setRooms_sizes(12);
        r.setRooms_bed("a");
        r.setTable_services(s);       
        session.save(r);
         session.getTransaction().commit();
       }
    }
}
