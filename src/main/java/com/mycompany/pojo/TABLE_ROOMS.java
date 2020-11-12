/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author HOME
 */
@Entity
@Table(name = "table_rooms")
public class TABLE_ROOMS implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rooms_id")
    private int rooms_id;
    @Column(name = "rooms_name")
        private String rooms_name;
    @Column(name = "rooms_category")
    private String rooms_category;
    @Column(name = "rooms_prices")
    private int rooms_prices;
    @Column(name = "rooms_sizes")
    private double rooms_sizes;
    @Column(name = "rooms_bed")
    private String rooms_bed;
    @Column(name = "rooms_descriptions")
    private String rooms_descriptions;
    @Column(name = "rooms_image")
    private String rooms_image;
    @ManyToOne
    @JoinColumn(name = "fk_services")
    private TABLE_SERVICES table_services;
    
    /*@ManyToMany
    @JoinTable(
            name = "ROOM_SERVICES",
            joinColumns = {
                @JoinColumn(name = "rooms_id")
            },
            inverseJoinColumns
            = {
                @JoinColumn(name = "services_id")
            }
    )
    **/

    /**
     * @return the rooms_id
     */
    public int getRooms_id() {
        return rooms_id;
    }

    /**
     * @param rooms_id the rooms_id to set
     */
    public void setRooms_id(int rooms_id) {
        this.rooms_id = rooms_id;
    }

    /**
     * @return the rooms_name
     */
    public String getRooms_name() {
        return rooms_name;
    }

    /**
     * @param rooms_name the rooms_name to set
     */
    public void setRooms_name(String rooms_name) {
        this.rooms_name = rooms_name;
    }

    /**
     * @return the rooms_category
     */
    public String getRooms_category() {
        return rooms_category;
    }

    /**
     * @param rooms_category the rooms_category to set
     */
    public void setRooms_category(String rooms_category) {
        this.rooms_category = rooms_category;
    }

    /**
     * @return the rooms_prices
     */
    public int getRooms_prices() {
        return rooms_prices;
    }

    /**
     * @param rooms_prices the rooms_prices to set
     */
    public void setRooms_prices(int rooms_prices) {
        this.rooms_prices = rooms_prices;
    }

    /**
     * @return the rooms_sizes
     */
    public double getRooms_sizes() {
        return rooms_sizes;
    }

    /**
     * @param rooms_sizes the rooms_sizes to set
     */
    public void setRooms_sizes(double rooms_sizes) {
        this.rooms_sizes = rooms_sizes;
    }

    /**
     * @return the rooms_bed
     */
    public String getRooms_bed() {
        return rooms_bed;
    }

    /**
     * @param rooms_bed the rooms_bed to set
     */
    public void setRooms_bed(String rooms_bed) {
        this.rooms_bed = rooms_bed;
    }

    /**
     * @return the table_services
     */
    public TABLE_SERVICES getTable_services() {
        return table_services;
    }

    /**
     * @param table_services the table_services to set
     */
    public void setTable_services(TABLE_SERVICES table_services) {
        this.table_services = table_services;
    }

    /**
     
    /**
     * @return the rooms_descriptions
     */
    public String getRooms_descriptions() {
        return rooms_descriptions;
    }

    /**
     * @param rooms_descriptions the rooms_descriptions to set
     */
    public void setRooms_descriptions(String rooms_descriptions) {
        this.rooms_descriptions = rooms_descriptions;
    }

    /**
     * @return the rooms_image
     */
    public String getRooms_image() {
        return rooms_image;
    }

    /**
     * @param rooms_image the rooms_image to set
     */
    public void setRooms_image(String rooms_image) {
        this.rooms_image = rooms_image;
    }

}
