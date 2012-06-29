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
import com.mti.webshare.model.FileItem;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
            List<FileItem> list_file_item = new ArrayList<FileItem> ();
            
            for(Iterator<File> it = list_file_bdd.iterator (); it.hasNext ();)
            {
                  FileItem file = new FileItem ();
                   file.convert(it.next());
                  list_file_item.add(file);
            }
            
            return new ModelAndView("navigator", "file_list", list_file_item);
    }
    
    @RequestMapping("/other.htm")
    public ModelAndView other() {
        return new ModelAndView("addShop", "message", "Remove method called");
    }

}

