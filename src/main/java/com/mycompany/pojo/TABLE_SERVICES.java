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
@Table(name = "table_services")
public class TABLE_SERVICES implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "services_id")
    private int services_id;
    @Column(name ="services_name")
    private  String services_name;

    @Override
    public String toString() {
        return String.valueOf(this.services_id);
    }

    @Override
    public boolean equals(Object obj) {
        TABLE_SERVICES ser = (TABLE_SERVICES) obj;
        return this.services_id == ser.services_id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.services_id;
        return hash;
    }
    
    
    /**
     * @return the services_id
     */
    public int getServices_id() {
        return services_id;
    }

    /**
     * @param services_id the services_id to set
     */
    public void setServices_id(int services_id) {
        this.services_id = services_id;
    }

    /**
     * @return the services_name
     */
    public String getServices_name() {
        return services_name;
    }

    /**
     * @param services_name the services_name to set
     */
    public void setServices_name(String services_name) {
        this.services_name = services_name;
    }
}
