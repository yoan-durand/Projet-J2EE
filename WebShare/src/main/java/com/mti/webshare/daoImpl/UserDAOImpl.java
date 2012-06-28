/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mti.webshare.daoImpl;

import com.mti.webshare.dao.DAO;
import com.mti.webshare.hibernatesession.HibernateUtils;
import com.mti.webshare.model.User;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author yoan
 * EPITA MTI 2013
 *
 */


public class UserDAOImpl extends HibernateDaoSupport implements DAO<User>
{
    
    @Override
    public Boolean create(User user)
    {
        
        try
        {
            getHibernateTemplate().save(user);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public Boolean update(User user)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean delete(User user)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public User get(Integer id)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<User> getList()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public User getUserByEmail(String email)
    {
        try
        {
            List<User> listuser = getHibernateTemplate().find("from User u where u.email=?", email);
            if (listuser.isEmpty())
                return null;
            else
                return listuser.get(0);
        }
        catch (Exception e)
        {
             return null;
        }
      
        
    }

}
