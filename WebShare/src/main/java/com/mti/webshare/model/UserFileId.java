package com.mti.webshare.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;


@Embeddable
public class UserFileId implements Serializable
{
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private FileUploaded file;

    public FileUploaded getFile()
    {
        return file;
    }

    public void setFile(FileUploaded file)
    {
        this.file = file;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
 
        UserFileId that = (UserFileId) o;
 
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (file != null ? !file.equals(that.file) : that.file != null)
            return false;
 
        return true;
    }
 
    @Override
    public int hashCode()
    {
        int result;
        result = (user != null ? user.hashCode() : 0);
        result = 31 * result + (file != null ? file.hashCode() : 0);
        return result;
    }
}