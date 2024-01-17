package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.AgendarDao;
import modelo.Cita;
import modelo.DueñoDao;
import modelo.Mascota;
import modelo.MascotaDao;

/**
 * Servlet implementation class AgendarCitaServlet
 */
public class AgendarCitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendarCitaServlet() {
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
	    
		// Obtener los parámetros del formulario
	    int idMascota = Integer.parseInt(request.getParameter("idMascota"));
	    String rutDueno = request.getParameter("rutDueno");
	    String nombreMascota = request.getParameter("nombreMascota");
	    String hora = request.getParameter("hora");
	    String fecha = request.getParameter("fecha");

	    // Imprimir los valores para depuración
	    System.out.println("ID Mascota: " + idMascota);
	    System.out.println("Rut Dueño: " + rutDueno);
	    System.out.println("Nombre Mascota: " + nombreMascota);
	    System.out.println("Hora: " + hora);
	    System.out.println("Fecha: " + fecha);
	    
	    // Crear un objeto Cita
	    Cita cita = new Cita();
	    cita.setIdMascota(idMascota);
	    cita.setRutDueño(rutDueno);
	    cita.setNombreMascota(nombreMascota);
	    cita.setHora(hora);
	    cita.setFecha(fecha);
	    
	    

	 // Validaciones directamente en el método doPost
	    if (cita.getRutDueño() == null || cita.getRutDueño().trim().isEmpty() || !DueñoDao.existeDueño(cita.getRutDueño())) {
	        request.setAttribute("error", "El Rut del dueño es obligatorio o el dueño no existe.");
	        request.getRequestDispatcher("agendar.jsp").forward(request, response);
	        return;
	    }

	    // Intentar agendar la cita
	    boolean resultado = AgendarDao.agregarCita(cita);
	    if (resultado) {
	        // Redirige a una página de confirmación o actualiza la página actual
	        request.getRequestDispatcher("citaExitosa.jsp").forward(request, response);
	    } else {
	        request.setAttribute("error", "Error al agendar la cita.");
	        request.getRequestDispatcher("agendar.jsp").forward(request, response);
	    }
	}

}