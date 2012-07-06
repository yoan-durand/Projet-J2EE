/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.dao;


import com.mti.webshare.model.User;
import com.mti.webshare.model.UserFile;
import java.util.List;
import java.util.Set;
import org.codehaus.jettison.json.JSONObject;



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
    public User get (String email);
    public List<User> getList ();
    public Set<UserFile> getUserFile(String userMail);
    public String toJson(User user);
}
