<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Agendar Cita</title>
</head>
<body>
    <h2>Agendar Cita</h2>

    <% if (request.getAttribute("error") != null) { %>
    <p style="color: red;"><%= request.getAttribute("error") %></p>
<% } %>

    <form action="AgendarCitaServlet" method="post">
        <div>
            <label for="idMascota">ID de la Mascota:</label><br>
            <input type="number" id="idMascota" name="idMascota" required>
        </div>
        <div>
            <label for="rutDueno">Rut del Dueño:</label><br>
			<input type="text" id="rutDueno" name="rutDueno" required>
        </div>
        <div>
            <label for="nombreMascota">Nombre de la Mascota:</label><br>
            <input type="text" id="nombreMascota" name="nombreMascota" required>
        </div>
        <div>
            <label for="hora">Hora:</label><br>
            <input type="time" id="hora" name="hora" required>
        </div>
        <div>
            <label for="fecha">Fecha:</label><br>
            <input type="text" id="fecha" name="fecha" required>
        </div>
        <div><br>
            <button type="submit">Agendar Cita</button>
        </div>
    </form><br>
    <a href="paginaInicio.jsp">Volver a la Página de Inicio</a>
</body>
</html>
