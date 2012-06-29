/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vince
 */


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.controller;

import com.mti.webshare.dao.FileDAO;
import com.mti.webshare.model.File;
import com.mti.webshare.model.FileView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
@RequestMapping("/File")
public class FileController {
    
    @Autowired
    private FileDAO fileDAO;

    @RequestMapping("/navigator.htm")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            List<File> list_file_bdd = fileDAO.getList();
            List<FileView> list_file_item = new ArrayList<FileView> ();
           /* Iterator it = list_file_bdd.iterator ();
            while(it.hasNext ())
            {
                  FileView file = new FileView ();
                  File toto = (File)it.next();
                  file.convert(toto);
                  list_file_item.add(file);
            }*/
            
            for (int i = 0; i < list_file_bdd.size(); i++)
            {
                   FileView file = new FileView ();
                   File toto = list_file_bdd.get(i);
                   file.convert(toto);
                  list_file_item.add(file);
            }
            
            return new ModelAndView("navigator", "file_list", list_file_item);
    }
    
    @RequestMapping("/other.htm")
    public ModelAndView other() {
        return new ModelAndView("addShop", "message", "Remove method called");
    }
    
    @RequestMapping(value = "/upload.htm", method = RequestMethod.GET)
    public ModelAndView upload_get() throws ServletException, IOException
    {
        return new ModelAndView("Upload");
    }
    
    @RequestMapping(value = "/upload.htm", method = RequestMethod.POST)
    public ModelAndView upload_post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException, Exception
    {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart)
        {
        }
        else
        {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List items = null;
            items = upload.parseRequest(request);
            Iterator itr = items.iterator();
            while (itr.hasNext())
            {
                FileItem item = (FileItem) itr.next();
                if (item.isFormField())
                {
                }
                else
                {
                    String itemName = item.getName();
                    java.io.File savedFile = new java.io.File(request.getSession().getServletContext().getRealPath("/")+itemName);//+"uploadedFiles/"
                    item.write(savedFile);
                }
            }
        }
        return new ModelAndView("navigator");
    }

}

