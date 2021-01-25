
package com.tarea.web;

import com.tarea.exception.DBException;
import com.tarea.model.DB;
import com.tarea.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "AltaUsuarioServlet", urlPatterns = {"/alta-usuario"})
public class AltaUsuarioServlet extends HttpServlet {

      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String paramEmail = request.getParameter("email");
        String paramPwd = request.getParameter("pwd");
        String paramNombre = request.getParameter("nombre");
        String paramApellidos = request.getParameter("apellidos");

        String msgErrorEmail = null;
        String msgErrorPwd = null;
        String msgErrorNombre = null;
        String msgErrorApellidos = null;
        String msgErrorAlta = null;

        boolean valido = true;
       
        if (paramEmail == null || paramEmail.trim().length() == 0) {
            msgErrorEmail = "Por favor, indicar el email";
            valido = false;
        }

        if (paramPwd == null || paramPwd.trim().length() == 0) {
            msgErrorPwd = "Por favor, indicar el password";
            valido = false;
        }

        if (paramNombre == null || paramNombre.trim().length() == 0) {
            msgErrorNombre = "Por favor, indicar el nombre ";
            valido = false;
        }

        if (paramApellidos == null || paramApellidos.trim().length() == 0) {
            msgErrorApellidos = "Por favor, indicar el apellidos";
            valido = false;
        }

        if (valido) {
            Usuario usuarios = new Usuario(paramEmail,paramPwd,paramNombre,paramApellidos);
            try {
                DB.AltaUsuario(usuarios);
           HttpSession session = request.getSession();
           session.setAttribute("usuarios",usuarios);    
                
            } catch (DBException ex) {
                msgErrorAlta = ex.getMessage();
                valido = false;              }
        }

        String jspMostrar = "";
        if (valido) {
            jspMostrar = "lista-usuario.jsp";
        } else {
            jspMostrar = "form-alta-usuario.jsp";
            request.setAttribute("msgErrorEmail", msgErrorEmail);
            request.setAttribute("msgErrorPwd", msgErrorPwd);
            request.setAttribute("msgErrorNombre", msgErrorNombre);
            request.setAttribute("msgErrorApellidos", msgErrorApellidos);
            request.setAttribute("msgErrorAlta", msgErrorAlta);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(jspMostrar);
        rd.forward(request, response);

    }
}
