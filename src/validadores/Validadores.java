/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validadores;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Stalin
 */
public class Validadores {
    
    public static String validarCodigoProducto(String codigo) {
        if (codigo.length() > 10 || !codigo.matches("^[a-zA-Z0-9]*$")) {
            return "Código de producto inválido - Ingrese un código válido";
        }
        if (productoYaRegistrado(codigo)) {
            return "Producto ya registrado";
        }
        return null;
    }
        private static boolean productoYaRegistrado(String codigo) {
        Connection conexion = Conexion.conectar(); 
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(*) FROM tb_producto WHERE idProducto = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                int cantidad = rs.getInt(1);
                return cantidad > 0; 
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar si el producto está registrado: " + e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e);
            }
        }
        return false; 
    }
    
    
    /***
     * VALIDADOR DE NOMBRE PRODUCTO
     */
     public static String validarNombreProducto(String codigo) {
        if (codigo.length() > 100 || !codigo.matches("^[a-zA-Z0-9 ]{1,100}$")) {
            return "Nombre de producto inválido - Ingrese un nombre válido";
        }
        if (productoYaRegistradoNombre(codigo)) {
            return "Producto ya registrado";
        }
        return null;
    }
        private static boolean productoYaRegistradoNombre(String codigo) {
        Connection conexion = Conexion.conectar(); 
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(*) FROM tb_producto WHERE nombre = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                int cantidad = rs.getInt(1);
                return cantidad > 0; 
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar si el producto está registrado: " + e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e);
            }
        }
        
        return false; 
    }
        
        
   /***
    * VALIDADOR CANTIDAD
    */
        public static String validarEnteroPositivo(String codigo) {
        if (!codigo.matches("\\d+")) {
        return "Cantidad inválida - Ingrese solo números";
    }

    int cantidad = Integer.parseInt(codigo);
    
    if (cantidad <= 0) {
        return "Cantidad inválida - Ingrese un número positivo";
    }

    return null;
    }
       
        
   /***
    * VALIDAR PRECIO
    */
        public static String validarPrecioUnitario(String precio) {
    if (!precio.matches("^\\d+(\\.\\d{1,2})?$")) {
        return "Precio inválido - Ingrese un número positivo con máximo dos decimales";
    }

    double precioUnitario = Double.parseDouble(precio);
    
    if (precioUnitario <= 0) {
        return "Precio inválido - Ingrese un número positivo";
    }

    return null;
}
        
        /***
         * 
         * @param cedula
         * @return 
         */
        
         public static String validarCedula(String cedula) {
    if (cedula.length() != 10) {
        return "Longitud de cédula inválida";
    }

    try {
        int provincia = Integer.parseInt(cedula.substring(0, 2));
        if (provincia < 0 || provincia > 24) {
            return "Cédula inválida - Provincia inválida";
        }

        //int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
        //if (tercerDigito >= 6) {
          //  return "Cédula inválida - Tercer dígito inválido";
        //}

        //for (int i = 3; i < 9; i++) {
          //  int digitoActual = Integer.parseInt(cedula.substring(i, i + 1));
            //int digitoAnterior = Integer.parseInt(cedula.substring(i - 1, i));
            //if (digitoActual != digitoAnterior + 1) {
              //  return "Cédula inválida - Dígitos no consecutivos";
            //}
        //}

        //int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        //int suma = 0;
        //for (int i = 0; i < 9; i++) {
          //  int digito = Integer.parseInt(cedula.substring(i, i + 1));
            //suma += digito * coeficientes[i];
        //}

        //int residuo = suma % 10;
        //int digitoVerificador = Integer.parseInt(cedula.substring(9, 10));
        //if (residuo != 0 && 10 - residuo != digitoVerificador) {
          //  return "Cédula inválida - Dígito verificador incorrecto";
        //}
        
        if (cedulaYaRegistrada(cedula)) {
            return "Cédula ya registrada en el sistema";
        }
        return null; 

    } catch (NumberFormatException e) {
        return "Cédula inválida - Formato incorrecto";
    }
}
         
         private static boolean cedulaYaRegistrada(String cedula) {
    Connection conexion = Conexion.conectar();
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        String consulta = "SELECT COUNT(*) FROM tb_cliente WHERE cedula = ?";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, cedula);
        rs = ps.executeQuery();
        if (rs.next()) {
            int cantidad = rs.getInt(1);
            return cantidad > 0; 
        }
    } catch (SQLException e) {
        System.out.println("Error al verificar si la cédula está registrada: " + e);
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conexion != null) conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e);
        }
    }
    return false; 
}

         
         
         public static String validarNombreCliente(String codigo) {
    if (codigo.length() > 100 || !codigo.matches("^[\\p{L}\\p{M}\\sáéíóúÁÉÍÓÚ]{1,100}$")) {
        return "Nombre y/o apellido de cliente inválido - Ingrese un Datos válidos";
    }

    String[] palabras = codigo.split("\\s+"); // Dividir el nombre en palabras
    for (String palabra : palabras) {
        if (!Character.isUpperCase(palabra.charAt(0))) { // Verificar si la primera letra de la palabra es mayúscula
            return "Nombre y/o Apellido de cliente inválido - Todas las palabras deben empezar con mayúscula";
        }
    }

    return null; // Si todas las palabras comienzan con mayúscula, retorna null (sin errores)
}

       
        
    /*
    * Validador de telefono     
    */
         
         public static String validarNumeroTelefono(String numero) {
        int longitud = numero.length();
        if (longitud != 7 && longitud != 10) {
            return "Número de teléfono inválido - La longitud debe ser de 7 o 10 caracteres";
        }
        
        if (longitud == 7) {
            int primerDigito = Character.getNumericValue(numero.charAt(0));
            if (primerDigito < 2 || primerDigito > 7) {
                return "Número de teléfono inválido - El primer dígito debe estar entre 2 y 7";
            }
        }
        
        if (longitud == 10) {
            if (!numero.startsWith("09")) {
                return "Número de teléfono inválido - Debe empezar con \"09\"";
            }
        }
        
        for (int i = 0; i < longitud; i++) {
            if (!Character.isDigit(numero.charAt(i))) {
                return "Número de teléfono inválido - Deben ser caracteres numéricos";
            }
        }
        
        return null;
    }
    
         
         
         /***
          * VALIDAR DIRECCION
          */
         public static String validardDireccionCliente(String codigo) {
        if (codigo.length() > 100 || !codigo.matches("^[a-zA-Z0-9. -]{1,100}$")) {
            return "Direccion de cliente inválido - Ingrese una direccion válida";
        }
        
        return null;
    }
         
         
         /***
          * VALIDAR Correo
          */
         public static String validardCorreoCliente(String codigo) {
        if (codigo.length() > 100 || !codigo.matches("^[\\w.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            return "Correo de cliente inválido - Ingrese un correo válida";
        }
        
        return null;
    }
         
         
     public static String validarClienteHabilitado(String cedula, String opcionSeleccionada) {
        boolean clienteHabilitado = clienteEstaHabilitado(cedula);
        if (opcionSeleccionada.equals("Habilitar") && clienteHabilitado) {
            return "El cliente ya está habilitado";
        }
        if (opcionSeleccionada.equals("Deshabilitar") && !clienteHabilitado) {
            return "El cliente ya está deshabilitado";
        }
        return null;
    }
    
    public static String validarClienteDeshabilitado(String cedula, String opcionSeleccionada) {
        boolean clienteHabilitado = clienteEstaHabilitado(cedula);
        if (opcionSeleccionada.equals("Habilitar") && !clienteHabilitado) {
            return "El cliente ya está deshabilitado";
        }
        if (opcionSeleccionada.equals("Deshabilitar") && clienteHabilitado) {
            return "El cliente ya está habilitado";
        }
        return null;
    }
    
    private static boolean clienteEstaHabilitado(String cedula) {
        Connection conexion = Conexion.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT estado FROM tb_cliente WHERE cedula = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, cedula);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                int estado = rs.getInt("estado");
                return estado == 1; 
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar el estado del cliente: " + e);
        } finally {
            
        }
        return false; 
    }    
         
         
}
