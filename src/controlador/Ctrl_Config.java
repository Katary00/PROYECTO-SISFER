/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Config;
import modelo.Usuario;

/**
 *
 * @author Emilio
 */
;

public class Ctrl_Config {
    
    

    
    
    
    
    
    
    
    
    
    /*Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public Config BuscarDatos() {
        Config conf = null;
        String sql = "select * from tb_config";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                conf = new Config(
                        rs.getInt("id"),
                        rs.getString("ruc"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email"),
                        rs.getInt("porcentajeGanancia"),
                        rs.getInt("porcentajeIva")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar datos de configuración: " + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.toString());
            }
        }
        return conf;
    }
    
    
    

    public boolean ModificarDatos(Config conf) {
        String sql = "UPDATE tb_config SET ruc=?, nombre=?, telefono=?, direccion=?, email=?, porcentajeGanancia=?, porcentajeIva=? WHERE id=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, conf.getRuc());
            ps.setString(2, conf.getNombre());
            ps.setString(3, conf.getTelefono());
            ps.setString(4, conf.getDireccion());
            ps.setString(5, conf.getEmail());
            ps.setInt(6, conf.getPorcentajeGanancia());
            ps.setInt(7, conf.getPorcentajeIva());
            ps.setInt(8, conf.getId());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            System.out.println("Error al modificar datos de configuración: " + e.toString());
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.toString());
            }
        }
    }*/
    
}

