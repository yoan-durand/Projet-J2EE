/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mti.webshare.dao;

import com.mti.webshare.model.FileUploaded;
import java.util.List;



/**
 *
 * @author yoan
 * EPITA MTI 2013
 *
 */


public interface FileDAO 
{
    public Boolean create (String name, Boolean ispublic, String path, Boolean isDir);
    public Boolean update (FileUploaded file);
    public Boolean deleted (FileUploaded file);
    public FileUploaded get(int id);
    public List<FileUploaded> getList ();
}
