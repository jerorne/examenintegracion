<%@ page import="modelo.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Página de Inicio</title>
</head>
<body>
    <h1>Bienvenido, <%= session.getAttribute("nombreUsuario") %></h1>
    <p>Usuario recepcionista</p>

    <ul>
        <li><a href="verDueños.jsp">Ver Dueños</a></li>
        <li><a href="verMascotas.jsp">Ver Mascotas</a></li>
        <li><a href="agendar.jsp">Agendar</a></li>
        <li><a href=verAgendas.jsp>Ver Citas</a></li>
    </ul>

</body>
</html>
