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
        <title>Formulario Registro Usuario</title>
        <%@include file="WEB-INF/vista/estilo.jspf"%>
        </head>
    <body>
        <%@include file="WEB-INF/vista/cabecera.jspf"%>
    <form action="nuevo-usuario" method="post">
            <div class="row">
                <div class="col"> 
                    <label for='usuarios'> Usuario: </label>
                    <input type='text' class="form-control" id='user' name="usuarios" placeholder="${requestScope.mensajeUsuario}"/> </br>
                </div>
            </div>
            <div class="row">
                <div class="col"> 
                    <label for='nombre'> Nombre:  </label>
                    <input type='text' class="form-control" id='name' name="nombre" placeholder="${requestScope.mensajeNombre}"/> </br>
                </div>
            </div>
            <div class="row">
                <div class="col"> 
                    <label for='apellidos'> Apellidos:  </label>
                    <input type='text' class="form-control" id='lastname' name="apellidos" placeholder="${requestScope.mensajeApellidos}"/> </br>
                </div>
            </div>
            <div class="row">
                <div class="col"> 
                    <label for='email'> Email:  </label>
                    <input type='text' class="form-control" id='email' name="email" placeholder="${requestScope.mensajeEmail}"/> </br>
                </div>
                          </div>
            <div class="row">
                <div class="col"> 
                    <label for='Password'> Password:  </label>
                    <input type='text' class="form-control" id='password' name="password" placeholder="${requestScope.messagePassword}"/> </br>
                </div>
            </div>
            <button type='submit' class="btn btn-primary"> Agregar Usuario </button>
            <button class="btn btn-primary" type="button">
            <span class="icon icon-thumbs-up"></span>
            Inicio
            </button>
        </form>
                
    </body>
</html>