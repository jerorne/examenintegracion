<%@ page import="java.util.List" %>
<%@ page import="modelo.Dueño" %>
<%@ page import="modelo.DueñoDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ver Dueños</title>
</head>
<body>
    <h1>Lista de Dueños Registrados</h1>

    <table>
        <tr>
            <th>Rut</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Dirección</th>
            <th>Correo</th>
            <th>Teléfono</th>
        </tr>
        <%
            List<Dueño> dueños = DueñoDao.obtenerDueños(); // Obtener la lista de dueños desde la base de datos

            if (dueños != null && !dueños.isEmpty()) {
                for (Dueño dueño : dueños) {
        %>
        <tr>
            <td><%= dueño.getRut() %></td>
            <td><%= dueño.getNombre() %></td>
            <td><%= dueño.getApellido() %></td>
            <td><%= dueño.getDireccion() %></td>
            <td><%= dueño.getCorreo() %></td>
            <td><%= dueño.getTelefono() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="6">No hay dueños registrados.</td>
        </tr>
        <%
            }
        %>
    </table>
    <a href="paginaInicio.jsp">Volver a la Página de Inicio</a>
</body>
</html>
