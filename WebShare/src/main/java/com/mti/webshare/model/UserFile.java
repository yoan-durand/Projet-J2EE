/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name="user_has_right_to_file")
@AssociationOverrides({
		@AssociationOverride(name = "pk.file", 
			joinColumns = @JoinColumn(name = "file_id")),
		@AssociationOverride(name = "pk.user", 
			joinColumns = @JoinColumn(name = "user_id")) })
public class UserFile implements Serializable
{
    @EmbeddedId
    private UserFileId pk = new UserFileId();
    
    @Column(name="state")
    private Boolean state;

    public UserFile()
    {
    }
    
    @Transient
    public User getUser()
    {
        return getPk().getUser();
    }

    public void setUser(User user)
    {
        getPk().setUser(user);
    }

    @Transient
    public FileUploaded getFile()
    {
        return getPk().getFile();
    }

    public void setFile(FileUploaded file)
    {
        getPk().setFile(file);
    }
    
    public UserFileId getPk()
    {
        return pk;
    }

    public void setPk(UserFileId pk)
    {
        this.pk = pk;
    }

    public Boolean getState()
    {
        return state;
    }

    public void setState(Boolean state)
    {
        this.state = state;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
                return true;
        if (o == null || getClass() != o.getClass())
                return false;

        UserFile that = (UserFile) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                        : that.getPk() != null)
                return false;

        return true;
    }
 
    @Override
    public int hashCode()
    {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
}
