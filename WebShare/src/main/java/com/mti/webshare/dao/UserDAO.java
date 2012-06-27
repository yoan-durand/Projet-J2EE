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
    public Boolean createUser (User user);
    public Boolean updateUser (User user);
    public Boolean deleteUser (User user);
    public User getUser (Integer id);
    public List<User> getListUser ();
    
}
