/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mti.webshare.daoImpl;

import com.mti.webshare.dao.UserDAO;
import com.mti.webshare.hibernatesession.HibernateUtils;
import com.mti.webshare.model.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author yoan
 * EPITA MTI 2013
 *
 */


public class UserDAOImpl implements UserDAO
{

    @Override
    public Boolean createUser(User user)
    {
        Session s = HibernateUtils.getSession();
        Transaction t = s.beginTransaction();
        try
        {
            s.save(user);
            t.commit();
            s.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public Boolean updateUser(User user)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean deleteUser(User user)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public User getUser(Integer id)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<User> getListUser()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public static User getUserByEmail(String email)
    {
        Session s = HibernateUtils.getSession();
        Query q = s.createQuery("from user where email= :email");
        q.setString(":email", email);
        User user = (User) q.uniqueResult();
        
        return user;
        
    }

}
