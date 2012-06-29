/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.model;



import java.util.List;
import javax.persistence.*;

/**
 *
 * @author yoan
 * EPITA MTI 2013
 * 
 */

@Entity
@Table (name="user")
public class User
{
    @Id
    @GeneratedValue
    private int id;
    
    @Column(name="lastname")
    private String lastname;
    
    @Column(name="firstname")
    private String firstname;
    
    @Column(name="password")
    private String password;
    
    @Column(name="email")
    private String email;
    
    @Column(name="deleted")
    private Boolean deleted;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "event", 
                joinColumns = { @JoinColumn(name = "id") }, 
                inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private List<Event> eventList;


    public Boolean getDeleted()
    {
        return deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    
    
    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
    
}
