package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utils.Conexion;

public class DueñoDao {

    public static List<Dueño> obtenerDueños() {
        List<Dueño> dueños = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConnection();
            String sql = "SELECT * FROM Dueño"; // Asegúrate de que el nombre de la tabla coincida con tu BD
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Dueño dueño = new Dueño();
                dueño.setRut(rs.getString("Rut"));
                dueño.setNombre(rs.getString("nombre"));
                dueño.setApellido(rs.getString("apellido"));
                dueño.setDireccion(rs.getString("dirección"));
                dueño.setCorreo(rs.getString("correo"));
                dueño.setTelefono(rs.getString("teléfono"));

                dueños.add(dueño);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dueños;
    }

    public static boolean existeDueño(String rutDueño) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnection();
            String sql = "SELECT count(*) FROM Dueño WHERE Rut = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, rutDueño);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos...
        }
        return false;
    }
}
