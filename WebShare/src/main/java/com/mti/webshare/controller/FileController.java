package com.mti.webshare.controller;

import com.mti.webshare.dao.FileDAO;
import com.mti.webshare.model.FileUploaded;
import com.mti.webshare.model.FileView;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
        
            List<FileUploaded> list_file_bdd = fileDAO.getList();
            List<FileView> list_file_item = new ArrayList<FileView> ();
            
            for(Iterator<FileUploaded> it = list_file_bdd.iterator (); it.hasNext ();)
            {
                  FileView file = new FileView ();
                  file.convert((FileUploaded)it.next());
                  list_file_item.add(file);
            }
            
            return new ModelAndView("navigator", "file_list", list_file_item);
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
                    java.io.File savedFile = new java.io.File(request.getSession().getServletContext().getInitParameter("serverLocation")+itemName);
                    item.write(savedFile);
                }
            }
        }
        return new ModelAndView("navigator");
    }
    
    
    @RequestMapping(value = "/download.htm", method = RequestMethod.GET)
    public void download_get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String filename = request.getSession().getServletContext().getInitParameter("serverLocation")+"TP3-Spring.pdf";
        response.setContentType("application/octet-stream");
        String disHeader = "Attachment; Filename=\"TP3-spring\"";
        response.setHeader("Content-Disposition", disHeader);
        java.io.File fileToDownload = new java.io.File(filename);

        InputStream in = null;
        ServletOutputStream outs = response.getOutputStream();

        try
        {
            in = new BufferedInputStream(new FileInputStream(fileToDownload));
            int ch;
            while ((ch = in.read()) != -1)
            {
                outs.print((char) ch);
            }
        }
        finally
        {
            if (in != null) in.close(); // very important
        }

        outs.flush();
        outs.close();
        in.close();
    }

}

