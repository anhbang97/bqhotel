/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bean;

import com.mycompany.pojo.TABLE_MENU;
import com.mycompany.pojo.TABLE_SERVICES;
import com.mycompany.service.MenuService;
import com.mycompany.service.Ser_Service;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author HOME
 */
@ManagedBean
@Named(value = "menu_Bean")
@SessionScoped
public class Menu_Bean implements Serializable 
{
    private  final  static MenuService menuService = new MenuService();
    
    private  final  static Ser_Service SER__SERVICE = new Ser_Service();
    /**
     * Creates a new instance of Rooms_Bean
     */
    public Menu_Bean() {
    }
   
    public List<TABLE_MENU> getTable_menus()
    {
        return menuService.getTable_menus();
    }
    
    public List<TABLE_SERVICES> getTable_ser()
    {
        return SER__SERVICE.getTable_serviceses();
    } 
    
    
}
