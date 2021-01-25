
package com.tarea.web;

import com.tarea.exception.LoginException;
import com.tarea.services.LoginService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
      
        String email = req.getParameter("email");
        String pwd = req.getParameter("pwd");

        String msgErrorEmail = null;
        String msgErrorPwd = null;
        String msgErrorLogin = null;

        boolean valido = true;

        if (email == null || email.trim().length() == 0) {
            msgErrorEmail = "Por favor, indique el email";
            valido = false;
        }

        if (pwd == null || pwd.trim().length() == 0) {
            msgErrorPwd = "Por favor, indique el password";
            valido = false;
        }
        if (valido) {
            
            try{
            HttpSession sesion = req.getSession();
            LoginService servicio = new LoginService();
            servicio.login(email, pwd, sesion);
            }
            
            catch (com.tarea.exception.LoginException ex) {
            msgErrorLogin = ex.getMessage();
            valido = false;
            }
        }

        String jspMostrar = "";
        if (valido) {
            jspMostrar = "index.jsp";
        } else {
            jspMostrar = "login.jsp";
            req.setAttribute("msgErrorEmail", msgErrorEmail);
            req.setAttribute("msgErrorPwd", msgErrorPwd);
            req.setAttribute("msgErrorLogin", msgErrorLogin);
        }

        RequestDispatcher rd = req.getRequestDispatcher(jspMostrar);
        rd.forward(req, resp);
    }

}
