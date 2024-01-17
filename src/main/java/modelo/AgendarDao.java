package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utils.Conexion;

public class AgendarDao {

    // Método para agregar una cita en la tabla Agenda
    public static boolean agregarCita(Cita cita) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Conexion.getConnection();
            String sql = "INSERT INTO Agenda (idMascota, rutDueño, NombreMascota, hora, Fecha) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, cita.getIdMascota());
            ps.setString(2, cita.getRutDueño());
            ps.setString(3, cita.getNombreMascota());
            ps.setString(4, cita.getHora());
            ps.setString(5, cita.getFecha());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // Cerrar recursos...
        }
    }

    public static List<Cita> obtenerCitas() {
        List<Cita> citas = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConnection();
            String sql = "SELECT * FROM Agenda";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cita cita = new Cita();
                cita.setIdMascota(rs.getInt("idMascota"));
                cita.setRutDueño(rs.getString("rutDueño"));
                cita.setNombreMascota(rs.getString("NombreMascota"));
                cita.setHora(rs.getString("hora"));
                cita.setFecha(rs.getString("Fecha"));
                citas.add(cita);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos...
        }
        return citas;
    }
}
