/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.Conexion; // Importa la clase para obtener la conexión a la DB
import Controlador.AsignacionAplicacionUsuario; 

/**
 * // Angoly Camila Aarujo Mayen 9959-24-17623
 * DAO encargado de gestionar las operaciones CRUD
 * de la tabla asignacionaplicacionusuario en la base de datos.
 */
public class AsignacionAplicacionUsuarioDAO {

    // Consultas SQL utilizadas por el DAO
    private static final String SQL_SELECT =
            "SELECT id, aplcodigo, usucodigo FROM asignacionaplicacionusuario";

    private static final String SQL_INSERT =
            "INSERT INTO asignacionaplicacionusuario(aplcodigo, usucodigo) VALUES(?,?)";

    private static final String SQL_UPDATE =
            "UPDATE asignacionaplicacionusuario SET aplcodigo=?, usucodigo=? WHERE id=?";

    private static final String SQL_DELETE =
            "DELETE FROM asignacionaplicacionusuario WHERE id=?";

    private static final String SQL_QUERY =
            "SELECT id, aplcodigo, usucodigo FROM asignacionaplicacionusuario WHERE id=?";


    /**
     * Método que obtiene todos los registros de la tabla
     * asignacionaplicacionusuario.
     */
    public List<AsignacionAplicacionUsuario> select() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<AsignacionAplicacionUsuario> asignaciones = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            // Recorrer los resultados y crear objetos de tipo AsignacionAplicacionUsuario
            while (rs.next()) {
                AsignacionAplicacionUsuario asignacion = new AsignacionAplicacionUsuario();
                asignacion.setId(rs.getInt("id"));
                asignacion.setAplcodigo(rs.getInt("aplcodigo"));
                asignacion.setUsucodigo(rs.getInt("usucodigo"));

                asignaciones.add(asignacion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            // Cierre de recursos
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return asignaciones;
    }


    /**
     * Inserta un nuevo registro en la tabla asignacionaplicacionusuario.
     */
    public int insert(AsignacionAplicacionUsuario asignacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setInt(1, asignacion.getAplcodigo());
            stmt.setInt(2, asignacion.getUsucodigo());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }


    /**
     * Actualiza un registro existente en la tabla
     * según el id proporcionado.
     */
    public int update(AsignacionAplicacionUsuario asignacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setInt(1, asignacion.getAplcodigo());
            stmt.setInt(2, asignacion.getUsucodigo());
            stmt.setInt(3, asignacion.getId());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }


    /**
     * Elimina un registro de la tabla según su id.
     */
    public int delete(AsignacionAplicacionUsuario asignacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, asignacion.getId());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }


    /**
     * Consulta un registro específico de la tabla
     * utilizando su id.
     */
    public AsignacionAplicacionUsuario query(AsignacionAplicacionUsuario asignacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);

            stmt.setInt(1, asignacion.getId());
            rs = stmt.executeQuery();

            // Si existe el registro, se cargan sus datos en el objeto
            if (rs.next()) {
                asignacion.setAplcodigo(rs.getInt("aplcodigo"));
                asignacion.setUsucodigo(rs.getInt("usucodigo"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return asignacion;
    }
}