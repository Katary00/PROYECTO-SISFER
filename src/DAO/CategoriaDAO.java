/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    
    // Método para obtener todas las categorías de la base de datos
    public static List<String> obtenerCategorias() {
        List<String> categorias = new ArrayList<>();
        Connection conexion = Conexion.conectar(); 
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (conexion != null) {
            try {
                String consulta = "SELECT descripcion FROM tb_categoria WHERE estado = 1";
                ps = conexion.prepareStatement(consulta);
                rs = ps.executeQuery();
                
                while (rs.next()) {
                    categorias.add(rs.getString("descripcion"));
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener categorías: " + e);
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (conexion != null) conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar recursos: " + e);
                }
            }
        }
        
        return categorias;
    }
}
