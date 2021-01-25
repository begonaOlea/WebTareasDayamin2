
package com.tarea.model;

import com.tarea.exception.DBException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import com.tarea.model.Estado;
import com.tarea.model.Tarea;
import com.tarea.model.Usuario;
import java.util.Set;

public class DB {

 private static HashMap<Integer, Tarea>tareas;
    private static HashSet<Usuario> usuarios;

    static {
        tareas = new HashMap<Integer, Tarea>();
        tareas.put(1, new Tarea(1, "Manejar y gestionar de redes sociales", Estado.Done));
        tareas.put(2, new Tarea(2, "Asistencia en la medición y gestión KPI´s", Estado.Done));
        tareas.put(3, new Tarea(3, "Medición de eficiencia productiva", Estado.In_Progress));
        tareas.put(4, new Tarea(4, "Apoyo en la elaboración de informes", Estado.In_Progress));
        tareas.put(5, new Tarea(5, "Análisis de los problemas complejos del negocio", Estado.In_Progress));
        tareas.put(6, new Tarea(6, "Búsqueda de aplicaciones orientadas a creación de valor", Estado.To_Do));
        tareas.put(7, new Tarea(7, "Recopilar, analizar e interpretar grandes cantidades de datos", Estado.In_Progress));
        tareas.put(8, new Tarea(8, "proporcionar analisis predictivos relevante para la empresa", Estado.To_Do));
        tareas.put(9, new Tarea(9, "Modelización, clasificación y predicción de los requerimientos del negocio", Estado.To_Do));
        tareas.put(10, new Tarea(10, "Diseñar y comunicar informes que visualicen las conclusiones para tona de decisiones", Estado.To_Do));
        
        
        usuarios = new HashSet<>();
        usuarios.add(new Usuario("aaaaa@gmail.com", "1234", "Ainara", "Artea"));
        usuarios.add(new Usuario("bbbbb@gmail.com", "2345", "Begoña", "Bilbao"));
        usuarios.add(new Usuario("ddddd@gmail.com", "3456", "Aduri", "Deusto"));
        usuarios.add(new Usuario("eeeee@gmail.com", "4567", "Endika", "Enbeitia"));
        usuarios.add(new Usuario("iiiiii@gmail.com", "5678", "Iker", "Etxauri"));
        usuarios.add(new Usuario("llllll@gmail.com", "6789", "Leire", "Lezeaga"));
    }

   
    private DB() {
    }

    public synchronized static Collection<Tarea> getAllTarea() {
        return tareas.values();
    }
    
     
    public synchronized static Tarea getTareaporId(int id){    
        Tarea t = tareas.get(id);
        return t;
    }

    public synchronized static Collection<Tarea> getTareaToDoUsuario(String nombreUsuario) {
        Set<Tarea> tareaToDoUsuario = new HashSet<Tarea>();
        for (Tarea t : tareas.values()) {
            if (t.getNombreUsuario().equals(nombreUsuario) && t.getEstado().equals("To Do")) {
                tareaToDoUsuario.add(t);
            }
        }
        return tareaToDoUsuario;
    }    
     public synchronized static Collection<Tarea> getTareaInProgressUsuario(String nombreUsuario) {
        Set<Tarea> tareaInProgressUsuario = new HashSet<Tarea>();
        for (Tarea t : tareas.values()) {
            if (t.getNombreUsuario().equals(nombreUsuario) && t.getEstado().equals("In Progress")) {
                tareaInProgressUsuario.add(t);
            }
        }
        return tareaInProgressUsuario;
    } 
    
    public synchronized static Collection<Tarea> getTareaDoneUsuario(String nombreUsuario) {
        Set<Tarea> tareaDoneUsuario = new HashSet<Tarea>();
        for (Tarea t : tareas.values()) {
            if (t.getNombreUsuario().equals(nombreUsuario) && t.getEstado().equals("Done")) {
                tareaDoneUsuario.add(t);
            }
        }
        return tareaDoneUsuario;
    } 

    public static Collection<Tarea> getTareaEstado( Estado e) {
        Set<Tarea> estado = new HashSet<Tarea>();
        for (Tarea t : tareas.values()) {
            if (t.getEstado()==e) {
                estado.add(t);
            }
        }
        return estado;
    }

    public synchronized static void CambioEstado(int id) {
        tareas.get(id).setEstado(Estado.To_Do);
    }

    public synchronized static void AltaTarea(Tarea tareas) throws DBException {
        if (tareas.containsKey(tareas.getId())) {
            throw new DBException("No existe tarea con este ID" + tareas.getId());
        } else {
            tareas.put(tareas.getId(), tareas);
        }
       
    }

//    public synchronized static Object getAllUsuario() {
//     return null;
//    }
  
    public synchronized static Collection<Usuario> getUsuario() {
        return usuarios;
    }

    public synchronized static void AltaUsuario(Usuario u) throws DBException {
        boolean Agregar = usuarios.add(u);
        if (!Agregar) {
            throw new DBException("No se pudo agregar porque el usuario no existe");
        }

    }
    
     public static void CambioEstado(Tarea t, String estado) {
     }

    
}