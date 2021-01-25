
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.tarea.model.DB"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Collection"%>
<%@page import="com.tarea.model.Tarea"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Registro Tarea</title>
        <%@include file="WEB-INF/vista/estilo.jspf"%>
      </head>
    <body>
        <%@include file="WEB-INF/vista/cabecera.jspf"%>
    <form action="nuevo-usuario" method="post">
            <div class="row">
                <div class="col">
                    <label for='id'> ID:  </label>
                    <input type='number' class="form-control" id='id' name="id" placeholder="${requestScope.mensajeId}" /> </br>
                </div>
            </div>
            <div class="row">
                <div class="col"> 
                    <label for='descripcion'> Descripcion:  </label>
                    <input type='text' class="form-control" id='description' name="descripcion" placeholder="${requestScope.mensajeDescripcion}"/> </br>
                </div>
            </div>
            <div class="row">
                <div class="col"> 
                    <label for='estado'> Estado:  </label>
                    <input type='text' class="form-control" id='status' name="Estado" placeholder="${requestScope.mensajeEstado}"/> </br>
                </div>
            <button type='submit' class="btn btn-primary"> Agregar Tarea </button>
            <button class="btn btn-primary" type="button">
            <span class="icon icon-thumbs-up"></span>
            Inicio
            </button>
        </form>
    </body>
</html>