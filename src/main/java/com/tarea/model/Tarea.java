
package com.tarea.model;

import java.io.Serializable;
import java.util.Objects;

public class Tarea implements Serializable {
 int id;
 String descripcion;
 Estado estado;

    public Tarea(int id, String description, Estado status) {
        this.id = id;
        this.descripcion = description;
        this.estado = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.descripcion);
        hash = 89 * hash + Objects.hashCode(this.estado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarea other = (Tarea) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Homework{" + "id=" + id + ", description=" + descripcion + ", status=" + estado + '}';
    }

    Object getNameUser() {
      return null; 
        }

    boolean containsKey(int id) {
     return false;
       }

    void put(int id, Tarea tareas) {
       }

    Object getNombreUsuario() {
     return null;
       }
 
 
 
}
