<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@include file="WEB-INF/vista/estilo.jspf" %>
       </head>
    <body>
        <div class="container">
            <%@include file="WEB-INF/vista/cabecera.jspf"%>
            <%@include file="WEB-INF/vista/navegacion.jspf"%>
                <div class="row">
                <div class="col">
                    <h1>Introducir Datos de Acceso</h1>
                </div>
            </div>
            <form action="login" method="post" >
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" name="email"
                           id="email" placeholder="email">
                     <div class="col">${requestScope.msgErrorEmail}</div>
                </div>
                <div class="form-group">
                    <label for="pwd">Password</label>
                    <input type="password" class="form-control" name="pwd"
                           id="pwd" placeholder="Password">
                     <div class="col">${requestScope.msgErrorPwd}</div>
                </div>
                <div class="container">
                    <a href="form-alta-usuario.jsp"class="btn btn-primary">Registro Usuario</a>
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
                <c:if test="${not empty requestScope.msgErrorLogin }" >
                <div class="alert alert-success" role="alert">
                    ${requestScope.msgErrorLogin}
                </div>
            </c:if>
        </div>
    </body>
</html>