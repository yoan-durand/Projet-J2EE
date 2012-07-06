/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.model;

import com.mti.webshare.daoimpl.UserDAOImpl;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author vince
 */
public class FileView
{
    private int id;
    
    private String name;
    
    private String visibility;
    
    private Date modif_date;
    
    private String type;
    
    private Boolean deleted;
    
    public FileView()
    {
    }
    
    public FileView(FileUploaded file)
    {
        this.id = file.getId();
        this.name = file.getName();
        this.deleted = file.getDeleted();
        this.modif_date = new Date();
        if (file.getIsDir())
        {
            this.type = "folder";
        }
        else
        {
            String[] filename = file.getName().split(".");
            this.type = filename[filename.length - 1];
        }
        if (file.getIsPublic())
        {
            this.visibility = "public";
        }
        else
        {
            this.visibility = "private";
        }
    }

    public Date getModif_date() {
        return modif_date;
    }

    public void setModif_date(Date modif_date) {
        this.modif_date = modif_date;
    }
    
    public Boolean getDeleted()
    {
        return deleted;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public String getVisibility()
    {
        return visibility;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setVisibility(String visibility)
    {
        this.visibility = visibility;
    }
    
    public String toJson(){
        JSONObject json = new JSONObject();
        try {
            json.put("id", this.id);
            json.put("name", this.name);
            json.put("visibility",this.visibility);
            json.put("modif_date", this.modif_date);
            json.put("type", this.type);
            return json.toString();
        } catch (JSONException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
