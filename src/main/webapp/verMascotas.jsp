<%@ page import="java.util.List" %>
<%@ page import="modelo.MascotaDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mascotas Disponibles</title>
</head>
<body>
    <h1>Listado de Mascotas Disponibles</h1>

    <ul>
    <%
        List<String> mascotasDisponibles = MascotaDao.obtenerMascotasDisponibles();
        for (String nombreMascota : mascotasDisponibles) {
    %>
        <li><%= nombreMascota %></li>
    <%
        }
    %>
    </ul>
	<br>
	<a href="paginaInicio.jsp">Volver a la Página de Inicio</a>
</body>
</html>
