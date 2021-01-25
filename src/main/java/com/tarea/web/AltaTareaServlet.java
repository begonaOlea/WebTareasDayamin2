
package com.tarea.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AltaTareaServlet", urlPatterns = {"/alta-tarea"})
public class AltaTareaServlet extends HttpServlet {

  @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
        throws ServletException, IOException {
        super.doGet(req, resp); 
    }

    
    
}