
package com.tarea.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tarea.services.LoginService;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        LoginService servicio = new LoginService();
        servicio.logout(req.getSession());
        
        RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        rd.forward(req, resp); 
        
    }

   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
       
    }

   
    protected void doProcess(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    }
  
}