/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import conexion.Conexion;

import controlador.Ctrl_Proveedor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Proveedor;

/**
 *
 * @author Emilio
 */
public class InterGestionarProveedor extends javax.swing.JInternalFrame {

    private int idProveedor;

    public InterGestionarProveedor() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestionar Proveedores");
        //Cargar tabla
        this.CargarTablaProveedores();
    }
    
    
    private void CargarTablaProveedores() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select * from tb_proveedor";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarProveedor.jTable_proveedores = new JTable(model);
            InterGestionarProveedor.jScrollPane1.setViewportView(InterGestionarProveedor.jTable_proveedores);

            model.addColumn("N°");//ID
            model.addColumn("RUC");
            model.addColumn("Nombre");
            model.addColumn("Teléfono");
            model.addColumn("Dirección");
            model.addColumn("Email");
            model.addColumn("Estado");

            while (rs.next()) {
                Object fila[] = new Object[7];
                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla proveedores: " + e);
        }
        //evento para obtener campo al cual el usuario da click
        //y obtener la interfaz que mostrara la informacion general
        jTable_proveedores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_proveedores.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idProveedor = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosProveedorSeleccionado(idProveedor);//metodo
                }
            }
        });
    }


    /*
     * **************************************************
     * Metodo que envia datos seleccionados
     * **************************************************
     */
    private void EnviarDatosProveedorSeleccionado(int idProveedor) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select * from tb_proveedor where idProveedor = '" + idProveedor + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txt_ruc.setText(rs.getString("ruc"));
                txt_nombre.setText(rs.getString("nombre"));
                txt_telefono.setText(rs.getString("telefono"));
                txt_direccion.setText(rs.getString("direccion"));
                txt_email.setText(rs.getString("email"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar proveedor: " + e);
        }
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_proveedores = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_ruc = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestionar Proveedores");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 6, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_proveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_proveedores);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 850, 250));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 870, 270));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Nombre:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel4.setText("Dirección:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel5.setText("RUC:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jLabel6.setText("Télefono:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        jLabel7.setText("E-mail:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, -1));

        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 170, -1));
        jPanel3.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 170, -1));

        txt_ruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rucActionPerformed(evt);
            }
        });
        jPanel3.add(txt_ruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 170, -1));

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        jPanel3.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 200, -1));
        jPanel3.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 170, -1));

        jButton_actualizar.setBackground(new java.awt.Color(153, 255, 153));
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, -1, -1));

        jButton_eliminar.setBackground(new java.awt.Color(255, 153, 153));
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 80, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 100));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo41.png"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
            if (txt_nombre.getText().isEmpty() && txt_ruc.getText().isEmpty() && txt_telefono.getText().isEmpty() && txt_direccion.getText().isEmpty()&& txt_email.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "¡Completa todos los campos!");
        } else {

            Proveedor proveedor = new Proveedor();
            Ctrl_Proveedor controlProveedor = new Ctrl_Proveedor();

            proveedor.setNombre(txt_nombre.getText().trim());
            proveedor.setRuc(txt_ruc.getText().trim());
            proveedor.setTelefono(txt_telefono.getText().trim());
            proveedor.setDireccion(txt_direccion.getText().trim());
            proveedor.setEmail(txt_email.getText().trim());
            proveedor.setEstado(1);

            if (controlProveedor.actualizar(proveedor, idProveedor)) {
                JOptionPane.showMessageDialog(null, "¡Datos del proveedor actualizados!");
                this.CargarTablaProveedores();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al actualizar!");
            }

        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_rucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rucActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
            Ctrl_Proveedor controlProveedor = new Ctrl_Proveedor();
        if (idProveedor == 0) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un proveedor!");
        } else {
            if (!controlProveedor.eliminar(idProveedor)) {
                JOptionPane.showMessageDialog(null, "¡Proveedor Eliminado!");
                this.CargarTablaProveedores();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al eliminar proveedor!");
                this.Limpiar();
            }
        }
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_proveedores;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_ruc;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

    /*
     * *****************************************************
     * metodo para limpiar
     * *****************************************************
     */
    private void Limpiar() {
        txt_nombre.setText("");
        txt_ruc.setText("");
        txt_telefono.setText("");
        txt_direccion.setText("");
        txt_email.setText("");
    }
 }


