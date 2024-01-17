<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
    <h2>Iniciar Sesión</h2>
    <% if(request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>
    <form action="ValidadorServlet" method="post">
        <div>
            <label for="nombreUsuario">Nombre de Usuario:</label><br>
            <input type="text" id="nombreUsuario" name="nombreUsuario">
        </div>
        <div>
            <label for="password">Contraseña:</label><br>
            <input type="password" id="password" name="password">
        </div>
        <div><br>
            <button type="submit">Iniciar Sesión</button>
        </div>
    </form>
</body>
</html>