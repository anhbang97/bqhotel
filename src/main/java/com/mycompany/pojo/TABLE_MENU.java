/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author HOME
 */
@Entity
@Table(name="table_menu", schema = "hoteldb" )
public class TABLE_MENU implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="menu_id")
    private int menu_id;
    @Column(name="menu_name")
    private String menu_name; 

    /**
     * @return the menu_id
     */
    public int getMenu_id() {
        return menu_id;
    }

    /**
     * @param menu_id the menu_id to set
     */
    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    /**
     * @return the menu_name
     */
    public String getMenu_name() {
        return menu_name;
    }

    /**
     * @param menu_name the menu_name to set
     */
    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

   
   


    

   
}
