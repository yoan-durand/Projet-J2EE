/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.dao;


import com.mti.webshare.model.User;
import java.util.List;



/**
 *
 * @author yoan
 */
public interface DAO<T>
{
    public Boolean create (T obj);
    public Boolean update (T obj);
    public Boolean delete (T obj);
    public T get (Integer id);
    public List<T> getList ();
    
}
