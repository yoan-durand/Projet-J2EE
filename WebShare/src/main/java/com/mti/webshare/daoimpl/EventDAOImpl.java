/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mti.webshare.daoimpl;

import com.mti.webshare.dao.EventDAO;
import com.mti.webshare.model.Event;
import com.mti.webshare.model.User;
import java.sql.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yoan
 * EPITA MTI 2013
 *
 */

@Repository
@Transactional
public class EventDAOImpl implements EventDAO
{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Boolean create(Integer action, Integer userId, Integer fileId, Date eventDate)
    {
        try
        {
            Event event = new Event();
            event.setEventAction(action);
            event.setEventDate(eventDate);
            event.setFile_id(fileId);
            event.setUser_id(userId);
         
            sessionFactory.getCurrentSession().save(event);
         
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public Boolean update(Event event)
    {
        try
        {
           
         
            sessionFactory.getCurrentSession().update(event);
         
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    

    @Override
    public Event get(int id)
    {
        try {
            List<Event> event = sessionFactory.getCurrentSession().createSQLQuery("select e from event where e.id=:eventId").setProperties(id).list();
            if (!event.isEmpty())
            {
                return event.get(0);
            }
            return null;
        }
        catch (Exception e) 
        {
            return null;
        }
    }

    @Override
    public List<Event> getList()
    {
        try {
            List<Event> listEvent = sessionFactory.getCurrentSession().createSQLQuery("select * from event ").list();
            if (!listEvent.isEmpty())
            {
                return listEvent;
            }
            return null;
        }
        catch (Exception e) 
        {
            return null;
        }
    }

}
