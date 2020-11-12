/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

/**
 *
 * @author HOME
 */
@FacesValidator("UploadValidator")
public class UploadValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Part p = (Part) value;
        
        /*if(!p.getContentType().equals("rooms_image/png")&&
           !p.getContentType().equals("rooms_image/jpg")){
            FacesMessage msg = new FacesMessage("Need png/jpg");
            throw new ValidatorException(msg);
        }*/
        if(p.getSize()>2097152){
            FacesMessage msg = new FacesMessage("Size <= 2MB");
            throw new ValidatorException(msg);
        }
    }
    
    
}
