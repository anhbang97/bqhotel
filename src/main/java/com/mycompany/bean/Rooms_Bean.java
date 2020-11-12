/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bean;

import com.mycompany.pojo.TABLE_ROOMS;
import com.mycompany.pojo.TABLE_SERVICES;
import com.mycompany.service.RoomsService;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
/**
 *
 * @author HOME
 */
@ManagedBean
@Named(value = "rooms_Bean")
@RequestScoped
public class Rooms_Bean implements Serializable {

    /**
     * @return the name
     */
    

    /**
     * @return the rooms_name
     */
   

    /**
     * @return the descriptions
     */
    private int roomID;
    private String name;
    private String descriptions;
    private int price;
    private String category;
    private Double size;
    private String bed;
    private TABLE_SERVICES services;
    private Part imgFile;
    
    
    private static  RoomsService roomsService = new RoomsService();
    
   
    public Rooms_Bean() {
        if (!FacesContext.getCurrentInstance().isPostback()){
        String roomId = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get("rooms_id");
        if(roomId != null && !roomId.isEmpty()){
        TABLE_ROOMS r = roomsService.getTable_roomsByID(Integer.parseInt(roomId));
        this.roomID = r.getRooms_id();
        this.name = r.getRooms_name();
        this.category = r.getRooms_category();
        this.descriptions =r.getRooms_descriptions();
        this.price = r.getRooms_prices();
        this.size = r.getRooms_sizes();
        this.bed = r.getRooms_bed();
        this.services = r.getTable_services();
        }
     }
    }

    public List<TABLE_ROOMS> getTable_roomses()
    {
        List<TABLE_ROOMS> pListRooms = getRoomsService().getTable_roomses(null);
        return pListRooms;
    }
    public String addRooms()
    {
       // String roomId = FacesContext.getCurrentInstance()
        //        .getExternalContext().getRequestParameterMap().get("rooms_id");
        TABLE_ROOMS r ;
        if(this.roomID > 0)
             r = roomsService.getTable_roomsByID(this.roomID);
        else
             r = new TABLE_ROOMS();
        r.setRooms_name(this.name);
        r.setRooms_descriptions(this.descriptions);
        r.setRooms_prices(this.price);
        r.setRooms_category(this.category);
        r.setRooms_sizes(this.size);
        r.setRooms_bed(this.bed);
        r.setTable_services(this.services);
        
        try{ 
            if(this.imgFile != null){
            this.uploadFile();
            
            r.setRooms_image("upload/" + this.imgFile.getSubmittedFileName());
            }
            if (roomsService.addOrSaveRooms(r) == true)
            return "rooms_list?face-ridirect = true";
        } catch (IOException ex) {
            Logger.getLogger(Rooms_Bean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return "rooms_add" ;
    }
    
    public String deleteRooms(TABLE_ROOMS r) throws Exception
    {
        if(roomsService.deleteRooms(r))
            return "Success";
        
        throw new Exception ("Something wrong!");
    }
    
    private void uploadFile() throws IOException{
       // String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/img/upload")
         //       +"/"+this.imgFile.getSubmittedFileName();
          String path = FacesContext.getCurrentInstance()
            .getExternalContext()
            .getInitParameter("uploadPath")
            + this.imgFile.getSubmittedFileName();
        try (InputStream in= this.imgFile.getInputStream();
                FileOutputStream out = new FileOutputStream(path)){
            byte [] b = new byte [1024];
            int byteRead;
            while((byteRead = in.read(b)) != -1){
                out.write(b,0,byteRead);
            }
        }
    }

    /**
     * @return the roomsService
     */
        public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    public static RoomsService getRoomsService() {
        return roomsService;
    }

    /**
     * @param aRoomsService the roomsService to set
     */
    /**public static void setRoomsService(RoomsService aRoomsService) {
        roomsService = aRoomsService;
    }
    */
    /**
     * @return the name
     */

    /**
     * @param name the name to set
     */

    /**
     *
     */
   
 
    public String getDescriptions() {
        return descriptions;
    }

    /**
     * @param descriptions the descriptions to set
     */
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
  
    /**
     * @param des the des to set
     */
    
    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the size
     */
    public Double getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(Double size) {
        this.size = size;
    }

    /**
     * @return the bed
     */
    public String getBed() {
        return bed;
    }

    /**
     * @param bed the bed to set
     */
    public void setBed(String bed) {
        this.bed = bed;
    }

    /**
     * @return the services
     */
    public TABLE_SERVICES getServices() {
        return services;
    }

    /**
     * @param services the services to set
     */
    public void setServices(TABLE_SERVICES services) {
        this.services = services;
    }

    /**
     * @return the imgFile
     */
    public Part getImgFile() {
        return imgFile;
    }

    /**
     * @param imgFile the imgFile to set
     */
    public void setImgFile(Part imgFile) {
        this.imgFile = imgFile;
    }

    /**
     * @return the roomID
     */
    public int getRoomID() {
        return roomID;
    }

    /**
     * @param roomID the roomID to set
     */
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
}
