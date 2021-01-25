
package com.tarea.web;

import com.tarea.model.DB;
import com.tarea.model.Tarea;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TareaServlet", urlPatterns = {"/tarea"})
public class TareaServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
           
        String sId = req.getParameter("id");
        String usuarios = req.getParameter("usuarios");
        String mensaje = null;
        String cambioEstado = req.getParameter("cambioEstado");
        String estado = null;

        int id = 0;
        if (sId == null || sId.trim().length() == 0) {
            mensaje = "Por favor, indique el Id de la tarea a cambiar";
        } else {
            try {
                id = Integer.parseInt(sId);
            } catch (NumberFormatException e) {
                mensaje = "Por favor, indique el Id de la tarea a modificar a número entero";
            }
        }

        if (usuarios == null || usuarios.trim().length() == 0) {
            mensaje = "Por favor, indicque el nombre del usuario";
        }

        if (mensaje == null) {
            Tarea t = DB.getTareaporId(id);
            mensaje = "Cambio de estado realizado";
            
            if (cambioEstado.equals("realizado")){
                if (t.getEstado().equals("To Do")) {
                            estado = "In Progress";
                }
                if (t.getEstado().equals("In Progress"))
                            estado = "Done";                            
                    }
            
                DB.CambioEstado(t, estado);           

        }

        RequestDispatcher rd = req.getRequestDispatcher("lista-tarea.jsp");
        req.setAttribute("usuarios", usuarios);
        req.setAttribute("mensaje", mensaje);
        rd.forward(req, resp);

    }

}