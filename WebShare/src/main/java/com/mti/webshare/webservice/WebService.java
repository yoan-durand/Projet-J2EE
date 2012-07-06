/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.webservice;




import com.mti.webshare.dao.FileDAO;
import com.mti.webshare.dao.UserDAO;
import com.mti.webshare.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
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
    public int add(int a, int b) {
        return a+b;
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
    public String getUser(int id){
        User u = userDAO.get(id);
        return userDAO.toJson(u);
    }

}
