/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.webservice;


import com.mti.webshare.dao.FileDAO;
import com.mti.webshare.dao.UserDAO;
import com.mti.webshare.model.FileUploaded;
import com.mti.webshare.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author damiensoulard
 */

@javax.jws.WebService(
  endpointInterface = "com.mti.webshare.webservice.IWebService",
  serviceName = "WebService")
public class WebService implements IWebService
{
    
    @Autowired
    private UserDAO userDAO;
    private FileDAO fileDAO;
    

    public WebService()
    {
    }
    
    @Override
    public String addUser(String lastName, String firstName, String email, String password)
    {
       
        String str;

       if(userDAO.create(lastName, firstName, password, email))
       {
           str = "Nouvel utlisateur creer : ";
           str +=  lastName +" "+firstName+" "+email;
           
       }
       else
       {
           str = "Une erreur est survenue lors de l'insertion.";
       }
       
       return str;
    }
        
 


    @Override
    public String getEvents(String email) 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    @Override
    public String getUser(int id){
        User u = userDAO.get(id);
        if (u == null){
            return "User not found";
        }
        return userDAO.toJson(u);
    }
    
    @Override
    public String getFile(int id){
        FileUploaded file = fileDAO.get(id);
        if (file == null){
            return "File not found";
        }
        return fileDAO.toJson(file);
    }
    
    @Override
    public String getUserList(){
        List<User> u = userDAO.getList();
        if (u == null){
            return "No users found";
        }
        return userDAO.toJson(u);
    }
}
