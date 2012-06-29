/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.model;



import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author yoan
 * EPITA MTI 2013
 * 
 */

@Entity
@Table (name="event")
public class Event
{
    @Id
    @GeneratedValue
    private int id;
    
    @Column(name="action")
    private int eventAction;
    
    @Column(name="user_id")
    private int user_id;
    
    @Column(name="file_id")
    private int file_id;
    
    @Column(name="date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date eventDate;

    public int getEventAction() {
        return eventAction;
    }

    public void setEventAction(int eventAction) {
        this.eventAction = eventAction;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
