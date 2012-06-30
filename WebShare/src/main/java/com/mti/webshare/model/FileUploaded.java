/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.model;



import java.util.Collection;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author yoan
 * EPITA MTI 2013
 * 
 */

@Entity
@Table (name="file")
public class FileUploaded
{
    @Id
    @GeneratedValue
    private int id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="public")
    private Boolean isPublic;
    
    @Column(name="path")
    private String path;
    
    @Column(name="isDir")
    private Boolean isDir;
    
    @Column(name="deleted")
    private Boolean deleted;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "event", 
                joinColumns = { @JoinColumn(name = "id") }, 
                inverseJoinColumns = { @JoinColumn(name = "file_id") })
    private List<Event> eventList;
    
    @ManyToMany(
        cascade = {CascadeType.PERSIST, CascadeType.MERGE},
        mappedBy = "files",
        targetEntity = User.class,
        fetch= FetchType.EAGER
    )
    private List<User> users;
    
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getIsDir() {
        return isDir;
    }

    public void setIsDir(Boolean isDir) {
        this.isDir = isDir;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
    
}
