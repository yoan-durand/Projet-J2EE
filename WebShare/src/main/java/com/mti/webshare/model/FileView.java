/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.model;

/**
 *
 * @author vince
 */
public class FileView
{
    private int id;
    
    private String name;

    
    private String visibility;
    
    private String modif_date;
    
    private String type;
    
    private Boolean deleted;
    
        public Boolean getDeleted() {
        return deleted;
    }

    public int getId() {
        return id;
    }

    public String getModif_date() {
        return modif_date;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModif_date(String modif_date) {
        this.modif_date = modif_date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
    
    public void convert (File init_file)
    {
        this.id = init_file.getId();
        this.name = init_file.getName();
        this.deleted = init_file.getDeleted();
        this.modif_date = "fix me";
        if (init_file.getIsDir())
        {
            this.type = "folder";
        }
        else
        {
            this.type = "type fix me";
        }
        if (init_file.getIsPublic())
        {
            this.visibility = "public";
        }
        else
        {
            this.visibility = "private";
        }
    }
    
}
