/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mti.webshare.daoimpl;

import com.mti.webshare.dao.FileDAO;
import com.mti.webshare.model.File;
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
public class FileDAOImpl implements FileDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Boolean create(String name, Boolean ispublic, String path, Boolean isDir)
    {
        try
        {
            File file = new File();
            
            file.setDeleted(Boolean.FALSE);
            file.setIsDir(isDir);
            file.setIsPublic(ispublic);
            file.setName(name);
            file.setPath(path);
            
            sessionFactory.getCurrentSession().save(file);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public Boolean update(File file)
    {
        try
        {
            sessionFactory.getCurrentSession().update(file);
            return true;
        }
        catch (Exception e)
                {
                    return false;
                }
    }
    
    @Override
    public Boolean deleted(File file)
    {
        try
        {
            file.setDeleted(Boolean.TRUE);
            sessionFactory.getCurrentSession().update(file);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public File get(int id)
    {
        try {
            List<File> file = sessionFactory.getCurrentSession().createSQLQuery("select f from file where f.id=:fileId").setProperties(id).list();
            if (!file.isEmpty())
            {
                return file.get(0);
            }
            return null;
        }
        catch (Exception e) 
        {
            return null;
        }
    }

    @Override
    public List<File> getList()
    {
        try 
        {
            List<File> file = sessionFactory.getCurrentSession().createSQLQuery("select * from file").list();
            
            if (!file.isEmpty())
            {
                return file;
            }
            return null;
        }
        catch (Exception e) 
        {
            return null;
        }
    }

}
