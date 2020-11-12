/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.converter;

import com.mycompany.service.Ser_Service;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author HOME
 */
@FacesConverter("ServicesConverter")
public class ServicesConverter  implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return new Ser_Service().getServiceById(Integer.parseInt(value));
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
    
}
