package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.Conexion;

public class MascotaDao {

    // Método para obtener las mascotas de un dueño específico
	public static List<Mascota> obtenerMascotasDeDueño(String rutDueno) throws ClassNotFoundException {
        List<Mascota> mascotas = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConnection();
            String sql = "SELECT * FROM Mascota WHERE RutDueño = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, rutDueno);
            rs = ps.executeQuery();

            while (rs.next()) {
                Mascota mascota = new Mascota();
                mascota.setIdMascota(rs.getInt("idMascota"));
                mascota.setRutDueno(rs.getString("RutDueño"));
                mascota.setTipoMascota(rs.getString("tipoMascota"));
                mascota.setEdad(rs.getInt("Edad"));
                mascota.setNombreMascota(rs.getString("nombreMascota"));
                mascotas.add(mascota);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mascotas;
    }

    
    public static List<String> obtenerMascotasDisponibles() {
        List<String> mascotasDisponibles = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT nombreMascota FROM Mascota"; // Query para obtener los nombres de las mascotas

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String nombreMascota = rs.getString("nombreMascota");
                mascotasDisponibles.add(nombreMascota);
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
        return mascotasDisponibles;
    }
 // Método para agregar una mascota
    public static boolean agregarMascota(Mascota mascota) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Conexion.getConnection();
            String sql = "INSERT INTO Mascota (idMascota, RutDueño, tipoMascota, Edad, nombreMascota) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            // Setear valores...
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Cerrar recursos...
        }
    }


    // Método para actualizar una mascota
    public static boolean actualizarMascota(Mascota mascota) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Conexion.getConnection();
            String sql = "UPDATE Mascota SET RutDueño=?, tipoMascota=?, Edad=?, nombreMascota=? WHERE idMascota=?";
            ps = con.prepareStatement(sql);
            // Setear valores...
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Cerrar recursos...
        }
    }


    // Método para eliminar una mascota
    public static boolean eliminarMascota(int idMascota) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Conexion.getConnection();
            String sql = "DELETE FROM Mascota WHERE idMascota=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMascota);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Cerrar recursos...
        }
    }


    public static boolean existeMascota(int idMascota) throws ClassNotFoundException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConnection();
            String sql = "SELECT count(*) FROM Mascota WHERE idMascota = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMascota);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;  // Retorna true si la cuenta es mayor que 0
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;  // Retorna false si no se encuentra la mascota
    }
    
    

}
