/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.dao;

import com.mti.webshare.model.User;
import java.util.List;
import org.hibernate.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vince
 */
@Repository
@Transactional
public class UserDAOHibernate implements UserDAO {
    
    @Autowired 
    private SessionFactory sessionFactory;

    @Override
    public Boolean create(String lastName, String fisrtName, String password, String email) {
        try
        {
            User user = new User();
            user.setLastname(lastName);
            user.setFirstname(fisrtName);
            user.setEmail(email);
            user.setPassword(password);
            user.setDeleted(Boolean.FALSE);
        
           
            sessionFactory.getCurrentSession().save(user);

            return (true);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean update(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean delete(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public User get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<User> getList() {
        
        try {
            List<User> users = sessionFactory.getCurrentSession().createQuery("from User order by id").list();
        
            return users;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    @Override
    public User getByEmail (String email)
    {
        try
        {
           Query q = sessionFactory.getCurrentSession().createQuery("from User u where u.email= :email");
           q.setString(":email", email);
           
           User user = (User) q.uniqueResult();
           return user;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
