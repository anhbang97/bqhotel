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
@Table(name="table_customers")
public class TABLE_CUSTOMERS implements Serializable {
    @Id
    @Column(name = "customers_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customers_id;
    @Column(name = "customers_fullname")
    private String customers_fullname;
   @Column(name = "customers_email")
    private String customers_email;
   @Column(name = "customers_address")
   private String customers_address;
    @Column(name = "customers_phone")   
   private int customers_phone;
    @Column(name = "customers_username")
    private String customers_username;
    @Column(name = "customers_password")
    private String customers_password;
    @Column(name = "u_role")
    private String u_role;

    /**
     * @return the customers_id
     */
    public int getCustomers_id() {
        return customers_id;
    }

    /**
     * @param customers_id the customers_id to set
     */
    public void setCustomers_id(int customers_id) {
        this.customers_id = customers_id;
    }

    /**
     * @return the customers_fullname
     */
    public String getCustomers_fullname() {
        return customers_fullname;
    }

    /**
     * @param customers_fullname the customers_fullname to set
     */
    public void setCustomers_fullname(String customers_fullname) {
        this.customers_fullname = customers_fullname;
    }

    /**
     * @return the customers_email
     */
    public String getCustomers_email() {
        return customers_email;
    }

    /**
     * @param customers_email the customers_email to set
     */
    public void setCustomers_email(String customers_email) {
        this.customers_email = customers_email;
    }

    /**
     * @return the customers_address
     */
    public String getCustomers_address() {
        return customers_address;
    }

    /**
     * @param customers_address the customers_address to set
     */
    public void setCustomers_address(String customers_address) {
        this.customers_address = customers_address;
    }

    /**
     * @return the customers_phone
     */
    public int getCustomers_phone() {
        return customers_phone;
    }

    /**
     * @param customers_phone the customers_phone to set
     */
    public void setCustomers_phone(int customers_phone) {
        this.customers_phone = customers_phone;
    }

    /**
     * @return the customers_username
     */
    public String getCustomers_username() {
        return customers_username;
    }

    /**
     * @param customers_username the customers_username to set
     */
    public void setCustomers_username(String customers_username) {
        this.customers_username = customers_username;
    }

    /**
     * @return the customers_password
     */
    public String getCustomers_password() {
        return customers_password;
    }

    /**
     * @param customers_password the customers_password to set
     */
    public void setCustomers_password(String customers_password) {
        this.customers_password = customers_password;
    }

    /**
     * @return the u_role
     */
    public String getU_role() {
        return u_role;
    }

    /**
     * @param u_role the u_role to set
     */
    public void setU_role(String u_role) {
        this.u_role = u_role;
    }
}

