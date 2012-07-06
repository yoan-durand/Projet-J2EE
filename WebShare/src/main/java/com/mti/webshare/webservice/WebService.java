/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.webservice;

<<<<<<< HEAD



=======
>>>>>>> 88481cf14db0241ad8328116c07d0332cf8957f6
import com.mti.webshare.dao.FileDAO;
import com.mti.webshare.dao.UserDAO;
import com.mti.webshare.model.FileUploaded;
import com.mti.webshare.model.User;
<<<<<<< HEAD
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
=======
import java.net.URL;
import java.util.List;
import org.apache.cxf.jaxrs.client.WebClient;
>>>>>>> 88481cf14db0241ad8328116c07d0332cf8957f6
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


    
    @Autowired
    private FileDAO fileDAO;
    

    public WebService()
    {
    }
    
    @Override
    public String addUser(String lastName, String firstName, String email, String password)
    {
       
        String str;

       if(userDAO.create(lastName, firstName, password, email))
<<<<<<< HEAD
       {
           str = "Nouvel utlisateur creer : ";
           str +=  lastName +" "+firstName+" "+email;
           
       }
       else
       {
           str = "Une erreur est survenue lors de l'insertion.";
       }
       
       return str;
=======
            str = lastName +" "+firstName+" "+email+" "+password;  
        
       return (str);
>>>>>>> 88481cf14db0241ad8328116c07d0332cf8957f6
    }
        
 

<<<<<<< HEAD
    
    
=======
    @Override
    public String getEvents(String email) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
>>>>>>> 88481cf14db0241ad8328116c07d0332cf8957f6
    
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
