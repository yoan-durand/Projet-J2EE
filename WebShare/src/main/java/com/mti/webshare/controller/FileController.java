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

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Iterator;
import java.io.File;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;

@org.springframework.stereotype.Controller
@RequestMapping("/File")
public class FileController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping("/navigator.htm")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            return new ModelAndView("navigator", "message", "Remove method called");
    }
    
    @RequestMapping("/other.htm")
    public ModelAndView other() {
        return new ModelAndView("addShop", "message", "Remove method called");
    }
    
    @RequestMapping(value = "/upload.htm", method = RequestMethod.GET)
    public ModelAndView upload_get()
            throws ServletException, IOException {
            
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
                    File savedFile = new File(request.getSession().getServletContext().getRealPath("/")+itemName);//+"uploadedFiles/"
                    item.write(savedFile);
                }
            }
        }
        return new ModelAndView("navigator");
    }

}

