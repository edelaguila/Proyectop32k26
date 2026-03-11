/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Boris de Leon 9959-24-6203
package Modelo;

import Modelo.Conexion; // Importa la clase para obtener la conexión a la DB
import Controlador.Usuario;   // Importa el modelo de Usuario
import java.sql.*;       // Importa las librerías de JDBC para SQL
import java.util.ArrayList; // Importa la estructura de lista dinámica
import java.util.List;      // Importa la interfaz List
import javax.swing.JOptionPane; // Importa para mostrar mensajes en ventanas emergentes

public class UsuarioDAO {

    // Método para validar las credenciales de un usuario (Login)
    public Usuario login(String nombre, String contrasena) {
        // Consulta SQL para buscar coincidencia de nombre y contraseña
        String sql = "SELECT * FROM usuario WHERE UsuNOMBRE=? AND UsuCONTRASEÑA=?";
        Usuario usuario = null; // Inicializa el objeto usuario como nulo

        // Uso de try-with-resources para asegurar el cierre de la conexión y el statement
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Asigna los parámetros recibidos a los "?" de la consulta SQL
            stmt.setString(1, nombre);
            stmt.setString(2, contrasena);

            // Ejecuta la consulta y obtiene los resultados
            ResultSet rs = stmt.executeQuery();

            // Si encuentra un registro, crea una instancia de Usuario con los datos de la DB
            if (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("usuCodigo"),
                        rs.getString("UsuNOMBRE"),
                        rs.getString("UsuCORREO"),
                        rs.getString("UsuTELEFONO"),
                        rs.getString("UsuDIRECCION"),
                        rs.getString("UsuCONTRASEÑA"),
                        rs.getString("UsuESTADO")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Imprime el error en consola si ocurre un fallo en SQL
        }
        return usuario; // Retorna el usuario encontrado o null
    }

    // Método para insertar un nuevo registro (CREATE)
    public void insertar(Usuario usuario) {
        // SQL sin usuCodigo ya que la DB lo genera automáticamente (Auto-increment)
        String sql = "INSERT INTO usuario (UsuNOMBRE, UsuCORREO, UsuTELEFONO, UsuDIRECCION, UsuCONTRASEÑA, UsuESTADO) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Envía los datos del objeto usuario a la sentencia SQL
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getTelefono());
            stmt.setString(4, usuario.getDireccion());
            stmt.setString(5, usuario.getContrasena());
            stmt.setString(6, usuario.getEstado());

            // Ejecuta la inserción en la base de datos
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario insertado correctamente");

        } catch (SQLException e) {
            // Muestra una ventana de error en caso de fallo
            JOptionPane.showMessageDialog(null, "Error al insertar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // Método para obtener todos los usuarios (READ)
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>(); // Crea la lista para almacenar resultados
        String sql = "SELECT * FROM usuario";   // Consulta para traer todos los registros

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Recorre cada fila devuelta por la base de datos
            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("usuCodigo"),
                        rs.getString("UsuNOMBRE"),
                        rs.getString("UsuCORREO"),
                        rs.getString("UsuTELEFONO"),
                        rs.getString("UsuDIRECCION"),
                        rs.getString("UsuCONTRASEÑA"),
                        rs.getString("UsuESTADO")
                );
                lista.add(u); // Agrega el usuario a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista; // Retorna la lista de usuarios
    }

    // Método para modificar datos de un usuario existente (UPDATE)
    public void actualizar(Usuario usuario) {
        // Define la actualización basada en el usuCodigo
        String sql = "UPDATE usuario SET UsuNOMBRE=?, UsuCORREO=?, UsuTELEFONO=?, UsuDIRECCION=?, UsuCONTRASEÑA=?, UsuESTADO=? WHERE usuCodigo=?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Asigna los nuevos valores desde el objeto recibido
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getTelefono());
            stmt.setString(4, usuario.getDireccion());
            stmt.setString(5, usuario.getContrasena());
            stmt.setString(6, usuario.getEstado());
            stmt.setInt(7, usuario.getCodigo()); // El ID para identificar qué registro cambiar

            stmt.executeUpdate(); // Ejecuta la actualización
            System.out.println("Usuario actualizado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para borrar un registro (DELETE)
    public void eliminar(int codigo) {
        String sql = "DELETE FROM usuario WHERE usuCodigo=?"; // Borrado por ID

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, codigo); // Asigna el código del usuario a eliminar
            stmt.executeUpdate();    // Ejecuta la eliminación
            System.out.println("Usuario eliminado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar un usuario específico por su código
    public Usuario buscar(int codigo) {
        String sql = "SELECT * FROM usuario WHERE usuCodigo = ?";
        Usuario usuario = null;

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, codigo); // Filtra por el código recibido
            ResultSet rs = stmt.executeQuery();

            // Si existe el usuario, lo mapea al objeto
            if (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("usuCodigo"),
                        rs.getString("UsuNOMBRE"),
                        rs.getString("UsuCORREO"),
                        rs.getString("UsuTELEFONO"),
                        rs.getString("UsuDIRECCION"),
                        rs.getString("UsuCONTRASEÑA"),
                        rs.getString("UsuESTADO")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario; // Retorna el usuario o null
    }
}
