/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mti.webshare.dao;

import com.mti.webshare.model.Event;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author yoan
 * EPITA MTI 2013
 *
 */


public interface EventDAO 
{
    public Boolean create (Integer action, Integer userId, Integer fileId, Date eventDate);
    public Boolean update (Event event);
    public Event get (int id);
    public List<Event> getList ();
    
}
