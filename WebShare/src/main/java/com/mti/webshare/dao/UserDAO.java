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
public interface UserDAO
{
    public Boolean create (String lastName, String fisrtname, String password, String email);
    public Boolean update (User user);
    public Boolean delete (User user);
    public User get (int id);
    public User getByEmail (String email);
    public List<User> getList ();
    
}
