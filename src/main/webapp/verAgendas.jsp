<%@ page import="java.util.List" %>
<%@ page import="modelo.AgendarDao" %>
<%@ page import="modelo.Cita" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ver Agendas</title>
</head>
<body>
    <h1>Agendas Programadas</h1>
    <% 
        List<Cita> citas = AgendarDao.obtenerCitas();
        if (citas != null) {
    %>
    <table>
        <tr>
            <th>ID Mascota</th>
            <th>Rut Dueño</th>
            <th>Nombre Mascota</th>
            <th>Hora</th>
            <th>Fecha</th>
        </tr>
        <% for(Cita cita : citas) { %>
        <tr>
            <td><%= cita.getIdMascota() %></td>
            <td><%= cita.getRutDueño() %></td>
            <td><%= cita.getNombreMascota() %></td>
            <td><%= cita.getHora() %></td>
            <td><%= cita.getFecha() %></td>
        </tr>
        <% } %>
    </table>
    <% } else { %>
        <p>No hay citas programadas.</p>
    <% } %>
    
    <form action="paginaInicio.jsp" method="get">
        <button type="submit">Volver a Inicio</button>
    </form>
</body>
</html>
