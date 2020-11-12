/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bean;

import com.mycompany.pojo.TABLE_CUSTOMERS;
import com.mycompany.service.CustomersService;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.persistence.Transient;

/**
 *
 * @author HOME
 */
@ManagedBean
@Named(value = "customers_Bean")
@RequestScoped
public class Customers_Bean {
    private int cusID;
    private String cusFullName;
    private String cusEmail;
    private String cusAddress;
    private int cusPhone;
    private String cusUsername;
    private String cusPassword;
    @Transient
    private String cusConfirmPass;
    
    
    private static final  CustomersService customersService = new CustomersService();
    
    
    public String Signup()
    {
        if(!this.cusPassword.isEmpty() && this.cusPassword.equals(this.cusConfirmPass))
        {
            TABLE_CUSTOMERS u = new TABLE_CUSTOMERS();
            u.setCustomers_fullname(cusFullName);
            u.setCustomers_email(cusEmail);
            u.setCustomers_address(cusAddress);
            u.setCustomers_phone(cusPhone);
            u.setCustomers_username(cusUsername);
            u.setCustomers_password(cusPassword);
           
            
            if(customersService.addCus(u)==true)
            {
                 return "signin_hotel?faces-redirect=true";
            }
            
        }
        return "signup_hotel";
    }
    
    
    public String Signin()
    {
        TABLE_CUSTOMERS tcu = customersService.signIn(cusUsername, cusPassword);
        if(tcu != null)
        {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("table_customers",tcu);
            return "index?faces-redirect=true";
        }
        return "signin_hotel"; //// CHƯA CHẠY ĐƯỢC  !!! BỊ LỖI  [java.lang.IllegalArgumentException: Unable to locate Attribute with the the given name [username] on this ManagedType [com.mycompany.pojo.TABLE_CUSTOMERS]]
    }
    /**
     * Creates a new instance of Customers_Bean
     */
    public Customers_Bean() {
    }

    /**
     * @return the cusID
     */
    public int getCusID() {
        return cusID;
    }

    /**
     * @param cusID the cusID to set
     */
    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    /**
     * @return the cusFullName
     */
    public String getCusFullName() {
        return cusFullName;
    }

    /**
     * @param cusFullName the cusFullName to set
     */
    public void setCusFullName(String cusFullName) {
        this.cusFullName = cusFullName;
    }

    /**
     * @return the cusEmail
     */
    public String getCusEmail() {
        return cusEmail;
    }

    /**
     * @param cusEmail the cusEmail to set
     */
    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    /**
     * @return the cusAddress
     */
    public String getCusAddress() {
        return cusAddress;
    }

    /**
     * @param cusAddress the cusAddress to set
     */
    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    /**
     * @return the cusPhone
     */
    public int getCusPhone() {
        return cusPhone;
    }

    /**
     * @param cusPhone the cusPhone to set
     */
    public void setCusPhone(int cusPhone) {
        this.cusPhone = cusPhone;
    }

    /**
     * @return the cusUsername
     */
    public String getCusUsername() {
        return cusUsername;
    }

    /**
     * @param cusUsername the cusUsername to set
     */
    public void setCusUsername(String cusUsername) {
        this.cusUsername = cusUsername;
    }

    /**
     * @return the cusPassword
     */
    public String getCusPassword() {
        return cusPassword;
    }

    /**
     * @param cusPassword the cusPassword to set
     */
    public void setCusPassword(String cusPassword) {
        this.cusPassword = cusPassword;
    }

    /**
     * @return the cusConfirmPass
     */
    public String getCusConfirmPass() {
        return cusConfirmPass;
    }

    /**
     * @param cusConfirmPass the cusConfirmPass to set
     */
    public void setCusConfirmPass(String cusConfirmPass) {
        this.cusConfirmPass = cusConfirmPass;
    }
    
}
