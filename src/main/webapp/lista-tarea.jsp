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
        <title>Lista Tarea</title>
        <%@include file="WEB-INF/vista/estilo.jspf" %>
       </head>
    <body>
        <%@include file="WEB-INF/vista/cabecera.jspf" %>
        <div class="container">
            <h1>Lista Tarea ${sessionScope.usuario.nombreUsuario}</h1> 
            <br>
            <hr/>
            <%
                String usuarios = (String) request.getAttribute("usuarios");
                Collection<Tarea> tareaToDo = DB.getTareaToDoUsuario(usuarios);
                Collection<Tarea> tareaInProgress = DB.getTareaInProgressUsuario(usuarios);
                Collection<Tarea> tareaDone = DB.getTareaDoneUsuario(usuarios);
            %>
            <div class="row">
                <div class="col">
                    <h3>Lista To_Do</h3> 

                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Descripcion</th>
                                <th scope="col">CambioEstado</th>
                            </tr>
                        </thead>
                        <tbody>

                            <% for (Tarea t : tareaToDo) {%>
                            <tr>
                                <th scope="row"><%= t.getId()%></th>
                                <td><%= t.getDescripcion()%></td>
                                <td><a href="TareaServlet?id=<%= t.getId()%>&usuarios=<%=usuarios%>&cambioEstado" > --> </a> </td>

                            </tr>
                            <% }%>
                        </tbody>
                    </table>

                </div>
                <div class="col">
                    <h3>In_Progress List </h3> 
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Descripcion</th>
                                <th scope="col">CambioEstado</th>
                            </tr>
                        </thead>
                        <tbody>

                            <% for (Tarea t : tareaInProgress) {%>
                            <tr>
                                <th scope="row"><%= t.getId()%></th>
                                <td><%= t.getDescripcion()%></td>
                                <td> <a href="TareaServlet?id=<%= t.getId()%>&usuarios=<%=usuarios%>&cambioEstado=In_Progress">  <--  </a>
                                    <a href="cambio-estado?id=<%= t.getId()%>&usuarios=<%=usuarios%>&cambioEstado=Done">  -->  </a> </td>

                            </tr>
                            <% }%>
                        </tbody>
                    </table>
                </div>

                <div class="col">

                    <h3>Lista Done</h3> 

                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Descripcion</th>
                                <th scope="col">CambioEstado</th>
                            </tr>
                        </thead>
                        <tbody>

                           <% for (Tarea t : tareaInProgress) {%>
                            <tr>
                                <th scope="row"><%= t.getId()%></th>
                                <td><%= t.getDescripcion()%></td>
                                <td><a href="TareaServlet?id=<%= t.getId()%>&usuarios=<%=usuarios%>&cambioEstado= Done">  <--  </a> </td>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>

                </div>

                <hr />

                <hr />

            </div>
        </div>

</body>

<footer>
</footer>

</html>