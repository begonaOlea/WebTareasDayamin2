
<%@page import="com.tarea.model.DB"%>
<%@page import="com.tarea.model.Usuario"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        </><%@include file="WEB-INF/vista/estilo.jspf" %>
    </head>
    <body>
        </><%@include file="WEB-INF/vista/cabecera.jspf" %>
        </><%@include file="WEB-INF/vista/navegacion.jspf" %>
        <h1>Lista Usuarios</h1>

        <%Collection<Usuario>usuarios=DB.getUsuario();
            request.setAttribute("listaUsuarios", usuarios);
        %>

        <div>
            <table class="table" >
                <thead>
                    <tr>
                        <th>Usuario</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="usuarios" items="${requestScope.listaUsuarios}" >
                        <tr>
                            <th scope="row">${usuarios.nombreApellidos}</th>
                            <td>${usuarios.email}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>
</html>