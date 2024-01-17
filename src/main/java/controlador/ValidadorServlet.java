package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Dueño;
import modelo.LoginDao;
import modelo.Usuario;
import utils.Conexion;

/**
 * Servlet implementation class ValidadorServlet
 */
public class ValidadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidadorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreUsuario = request.getParameter("nombreUsuario");
        String password = request.getParameter("password");

        try {
            // Valida el inicio de sesión del usuario recepcionista utilizando LoginDao
            Usuario usuario = LoginDao.validarUsuarioRecepcionista(nombreUsuario, password);

            if (usuario != null) {
                // Autenticación exitosa, establece la información del usuario en la sesión
                HttpSession session = request.getSession();
                session.setAttribute("nombreUsuario", nombreUsuario);
                session.setAttribute("usuario", usuario);

                System.out.println("Autenticación exitosa. Nombre de usuario: " + nombreUsuario);

                // Redirige a la página de inicio del usuario recepcionista
                response.sendRedirect("paginaInicio.jsp");
            } else {
                System.out.println("Autenticación fallida para el nombre de usuario: " + nombreUsuario);

                request.setAttribute("error", "Nombre de usuario o contraseña incorrecto.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
