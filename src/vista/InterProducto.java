/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import conexion.Conexion;
import controlador.Ctrl_Producto;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Producto;

/**
 *
 * @author Emilio
 */
public class InterProducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form InterUsuario
     */
    int obtenerIdCategoriaCombo = 0;
    int obtenerIdProveedorCombo = 0;

    public InterProducto() {
        initComponents();
        this.setSize(new Dimension(400, 440));
        this.setTitle("Nuevo Producto");

        this.CargarComboCategorias();
        this.CargarComboProveedores();
        cargarDatosConfig();
    }
    /*
        private void cargarDatosConfig() {
        int id = 1;
        EnviarDatosConfig(id);
    }

    private void EnviarDatosConfig(int id) {
        try {
            Connection con = Conexion.conectar();
            String sql = "SELECT * FROM tb_config WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txt_porcentajeganancia.setText(rs.getString("ganancia"));
                txt_porcentajeiva.setText(rs.getString("iva"));
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar cliente: " + e);
        }
    }
    /*
    

    /*public void calcularPrecioGanancia() {
    double preciocompra = Double.parseDouble(this.txt_precio.getText());
    precioganancia = (preciocompra * 0.25) + preciocompra;
}

public void calcularPrecioVenta() {
    double precioganancia = Double.parseDouble(this.txt_precio.getText());
    precioventa = (precioganancia * 0.15) + precioganancia;
}*/

 /*
    public void calcularPrecioGananciaYVenta() {
        String precioCompraTexto = txt_precio.getText().trim(); // Obtener el texto del campo precio y eliminar espacios en blanco al inicio y al final

        // Verificar si el campo de precio está en blanco
        if (precioCompraTexto.isEmpty()) {
            // Si está en blanco, borrar la información de los campos de precio ganancia y precio venta
            txt_precioganancia.setText("");
            txt_precioventa.setText("");
            return; // Salir del método ya que no hay nada más que hacer
        }

        try {
            double preciocompra = Double.parseDouble(precioCompraTexto);
            double precioganancia = calcularPrecioGanancia(preciocompra);
            double precioventa = calcularPrecioVenta(precioganancia);

            txt_precioganancia.setText(String.valueOf(precioganancia));
            txt_precioventa.setText(String.valueOf(precioventa));
        } catch (NumberFormatException e) {
            // Manejar la excepción si el valor en txt_precio no es un número válido
            // Aquí puedes mostrar un mensaje de error o realizar otra acción apropiada
            System.out.println("Ingrese un número válido en el campo de precio.");
        }
    }

    public double calcularPrecioGanancia(double preciocompra) {
        return (preciocompra * 0.25) + preciocompra;
    }

    public double calcularPrecioVenta(double precioganancia) {
        return (precioganancia * 0.15) + precioganancia;
    }*/
    private double valorGanancia;
    private double valorVenta;

// Método para cargar los datos de configuración desde la base de datos
    private void cargarDatosConfig() {
        int id = 1;
        EnviarDatosConfig(id);
    }

// Método para enviar los datos de configuración desde la base de datos
    private void EnviarDatosConfig(int id) {
        try {
            Connection con = Conexion.conectar();
            String sql = "SELECT * FROM tb_config WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                valorGanancia = Double.parseDouble(rs.getString("ganancia"));
                valorVenta = Double.parseDouble(rs.getString("iva"));
                txt_porcentajeganancia.setText(rs.getString("ganancia"));
                txt_porcentajeiva.setText(rs.getString("iva"));
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar cliente: " + e);
        }
    }

// Método para calcular el precio de ganancia y el precio de venta
    public void calcularPrecioGananciaYVenta() {
        String precioCompraTexto = txt_precio.getText().trim();

        if (precioCompraTexto.isEmpty()) {
            txt_precioganancia.setText("");
            txt_precioventa.setText("");
            return;
        }

        try {
            double preciocompra = Double.parseDouble(precioCompraTexto);
            double precioganancia = calcularPrecioGanancia(preciocompra);
            double precioventa = calcularPrecioVenta(precioganancia);

            txt_precioganancia.setText(String.valueOf(precioganancia));
            txt_precioventa.setText(String.valueOf(precioventa));
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número válido en el campo de precio.");
        }
    }

// Método para calcular el precio de ganancia
    public double calcularPrecioGanancia(double preciocompra) {
        return (preciocompra * (valorGanancia/100)) + preciocompra;
    }

// Método para calcular el precio de venta
    public double calcularPrecioVenta(double precioganancia) {
        return (precioganancia * (valorVenta/100)) + precioganancia;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        jButton_Guardar = new javax.swing.JButton();
        jComboBox_proveedor = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        txt_precioganancia = new javax.swing.JTextField();
        txt_precioventa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox_categoria = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txt_porcentajeiva = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_porcentajeganancia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NUEVO PRODUCTO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 80, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cantidad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 80, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Precio de compra:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 110, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Precio con ganancia:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 120, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Precio con IVA:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 100, -1));
        getContentPane().add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 170, -1));
        getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 170, -1));

        txt_descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descripcionActionPerformed(evt);
            }
        });
        getContentPane().add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 170, -1));

        jButton_Guardar.setBackground(new java.awt.Color(0, 204, 204));
        jButton_Guardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_Guardar.setText("Guardar");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, -1, -1));

        jComboBox_proveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un proveedor:", "Item 2", "Item 3", "Item 4" }));
        jComboBox_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_proveedorActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 170, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Código:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        txt_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_precioActionPerformed(evt);
            }
        });
        txt_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_precioKeyReleased(evt);
            }
        });
        getContentPane().add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 170, -1));

        txt_precioganancia.setEditable(false);
        txt_precioganancia.setBackground(new java.awt.Color(204, 204, 204));
        txt_precioganancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_preciogananciaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_precioganancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 110, -1));

        txt_precioventa.setEditable(false);
        txt_precioventa.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(txt_precioventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 110, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Proveedor:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        jComboBox_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una categoría:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 170, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Categoría:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        txt_porcentajeiva.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(txt_porcentajeiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 60, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("%");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, -1, -1));

        txt_porcentajeganancia.setEditable(false);
        txt_porcentajeganancia.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(txt_porcentajeganancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 60, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("%");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, -1, -1));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.png"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed

        Producto producto = new Producto();
        Ctrl_Producto controlProducto = new Ctrl_Producto();
        String iva = "";
        String categoria = "";
        String proveedor = "";
        categoria = jComboBox_categoria.getSelectedItem().toString().trim();
        proveedor = jComboBox_proveedor.getSelectedItem().toString().trim();
        //validar campos
        if (txt_descripcion.getText().equals("") || txt_codigo.getText().equals("") || txt_cantidad.getText().equals("") || txt_precio.getText().equals("") || txt_precioganancia.getText().equals("") || txt_precioventa.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            txt_codigo.setBackground(Color.red);
            txt_descripcion.setBackground(Color.red);
            txt_cantidad.setBackground(Color.red);
            txt_precio.setBackground(Color.red);
            txt_precioventa.setBackground(Color.red);
            txt_porcentajeiva.setBackground(Color.red);

        } else {
            //consulta para ver si el producto ya existe
            if (!controlProducto.existeProducto(txt_descripcion.getText().trim())) {

                if (categoria.equalsIgnoreCase("Seleccione categoria:")) {
                    JOptionPane.showMessageDialog(null, "Seleccione categoria");
                } else {
                    try {
                        producto.setCodigo(txt_codigo.getText().trim());
                        producto.setNombre(txt_descripcion.getText().trim());
                        producto.setCantidad(Integer.parseInt(txt_cantidad.getText().trim()));

                        String precioTXT = "";
                        double Precio = 0.0;
                        precioTXT = txt_precio.getText().trim();
                        boolean aux = false;
                        /*
                            *Si el usuario ingresa , (coma) como punto decimal,
                            lo transformamos a punto (.)
                         */
                        for (int i = 0; i < precioTXT.length(); i++) {
                            if (precioTXT.charAt(i) == ',') {
                                String precioNuevo = precioTXT.replace(",", ".");
                                Precio = Double.parseDouble(precioNuevo);
                                aux = true;
                            }
                        }
                        //evaluar la condicion
                        if (aux == true) {
                            producto.setPrecio(Precio);
                        } else {
                            Precio = Double.parseDouble(precioTXT);
                            producto.setPrecio(Precio);
                        }

                        producto.setPrecioVenta(Double.parseDouble(txt_precioventa.getText().trim()));
                        //Porcentaje IVA
                        producto.setPorcentajeIva(Integer.parseInt(txt_porcentajeiva.getText().trim()));
                        //idcategoria - cargar metodo que obtiene el id de categoria
                        this.IdCategoria();
                        producto.setIdCategoria(obtenerIdCategoriaCombo);

                        this.IdProveedor();
                        producto.setIdProveedor(obtenerIdProveedorCombo);

                        producto.setEstado(1);

                        if (controlProducto.guardar(producto)) {
                            JOptionPane.showMessageDialog(null, "Registro Guardado");

                            txt_codigo.setBackground(Color.green);
                            txt_descripcion.setBackground(Color.green);
                            txt_cantidad.setBackground(Color.green);
                            txt_precio.setBackground(Color.green);
                            txt_precioventa.setBackground(Color.green);
                            txt_porcentajeiva.setBackground(Color.green);
                            this.CargarComboCategorias();
                            this.CargarComboProveedores();

                            this.Limpiar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al Guardar");
                        }

                    } catch (HeadlessException | NumberFormatException e) {
                        System.out.println("Error en: " + e);
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "El producto ya existe en la Base de Datos");
            }
        }
    }//GEN-LAST:event_jButton_GuardarActionPerformed

    private void txt_descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descripcionActionPerformed

    private void jComboBox_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_proveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_proveedorActionPerformed

    private void txt_precioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_precioKeyReleased
        /* calcularPrecioGanancia();
        txt_precioganancia.setText(String.valueOf(precioganancia));*/

        calcularPrecioGananciaYVenta();

// TODO add your handling code here:
    }//GEN-LAST:event_txt_precioKeyReleased

    private void txt_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_precioActionPerformed

    private void txt_preciogananciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_preciogananciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_preciogananciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Guardar;
    private javax.swing.JComboBox<String> jComboBox_categoria;
    private javax.swing.JComboBox<String> jComboBox_proveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_porcentajeganancia;
    private javax.swing.JTextField txt_porcentajeiva;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_precioganancia;
    private javax.swing.JTextField txt_precioventa;
    // End of variables declaration//GEN-END:variables

    private void Limpiar() {
        txt_descripcion.setText("");
        txt_cantidad.setText("");
        txt_precio.setText("");
        txt_codigo.setText("");
        txt_precioventa.setText("");
        txt_precioganancia.setText("");
    }

    /**
     *
     * Metodo para cargar las categorias
     */
    private void CargarComboCategorias() {
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_categoria";
        Statement st;

        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_categoria.removeAllItems();
            jComboBox_categoria.addItem("Seleccione categoria:");
            while (rs.next()) {
                jComboBox_categoria.addItem(rs.getString("descripcion"));
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al cargar categorias");
        }
    }

    private void CargarComboProveedores() {
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_proveedor";
        Statement st;

        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_proveedor.removeAllItems();
            jComboBox_proveedor.addItem("Seleccione un proveedor:");
            while (rs.next()) {
                jComboBox_proveedor.addItem(rs.getString("nombre"));
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al cargar proveedor");
        }
    }

    /**
     *
     * Metodo para obtener id categoria
     */
    private int IdCategoria() {
        String sql = "select * from tb_categoria where descripcion = '" + this.jComboBox_categoria.getSelectedItem() + "'";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                obtenerIdCategoriaCombo = rs.getInt("idCategoria");
            }
        } catch (SQLException e) {
            System.out.println("Error al obener id categoria");
        }
        return obtenerIdCategoriaCombo;
    }

    /**
     *
     * Metodo para obtener id proveedor
     */
    private int IdProveedor() {
        String sql = "select * from tb_proveedor where nombre = '" + this.jComboBox_proveedor.getSelectedItem() + "'";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                obtenerIdProveedorCombo = rs.getInt("idProveedor");
            }
        } catch (SQLException e) {
            System.out.println("Error al obener id proveedor");
        }
        return obtenerIdProveedorCombo;
    }
}
