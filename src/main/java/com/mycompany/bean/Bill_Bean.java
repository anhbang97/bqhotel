/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import jdk.internal.joptsimple.internal.Messages;

/**
 *
 * @author HOME
 */
@ManagedBean
@Named(value = "bill_Bean")
@SessionScoped
public class Bill_Bean implements Serializable {

    /**
     * Creates a new instance of Book_Bean
     */
    public Bill_Bean() {
    }
    @PostConstruct
    public void init()
    {
        if(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSessionMap().get("bill")==null)
        {
           FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("bill", new HashMap<>());
        }
        
        
    }
    
    public List<Map<String,Object>> getBills(){
        Map<Integer,Object> bill = (Map<Integer,Object>) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("bill");
        List<Map<String, Object>> kq = new ArrayList<>();
        for(Object o: bill.values() ){
            Map<String, Object> d =(Map<String, Object>) o;
            kq.add((Map<String, Object>)d.values());
        }
        return kq;
    }
    
    public String addItemsToBook(int IdR , String nameR , int priceR , String imgR  )
    {
    Map<Integer,Object> bill =(Map<Integer,Object>) FacesContext.getCurrentInstance()
            .getExternalContext().getSessionMap().get("bill");
    
    if(bill.get(IdR)== null)
    {
        Map<String,Object> d = new HashMap<>();
        d.put("roomId",IdR);
        d.put("roomName",nameR);
        d.put("roomPrice",priceR);
        d.put("count", 1);
        
        bill.put(IdR,d);
    }
    
     return "index" ; 
    }
    
    
}
