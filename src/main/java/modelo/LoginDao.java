package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.Conexion;

public class LoginDao {

    public static Usuario validarUsuarioRecepcionista(String nombreUsuario, String password) {
        if (nombreUsuario == null || nombreUsuario.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            return null; // Autenticación fallida si los campos están vacíos
        }

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            con = Conexion.getConnection();
            String sql = "SELECT * FROM Usuario WHERE nombreUsuario = ? AND password = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                // Puedes agregar más atributos del usuario aquí si es necesario
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

        return usuario; // Devuelve el objeto Usuario si la autenticación fue exitosa, o null si falló
    }
}
