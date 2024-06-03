/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tiendaUI;

import java.awt.Window;
import java.util.*;
import java.sql.SQLException;
import javax.swing.*;
/**
 *
 * @author angsaegim
 */
public class TiendaManagementWindow extends javax.swing.JFrame {

    /**
     * Creates new form TiendaAppUI
     */
    // Lista para mantener las ventanas abiertas
    private final List<JInternalFrame> openWindows;
    
    //invocamos el método que completa la vista del formulario (se auto-implementa con las acciones que realizamos en tiempo de diseño)      
    public TiendaManagementWindow() throws SQLException {
        
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Tienda Jardineria");
        
        //Array de JinternalFrame abiertos (para poder cerrarlos correctamente cuando
        // cambie de pagina).
        openWindows = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jCheckBox1 = new javax.swing.JCheckBox();
        contenedor = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        consultarDatosButton = new javax.swing.JButton();
        nuevoClienteButton = new javax.swing.JButton();
        actualizarClientesButton = new javax.swing.JButton();
        borrarClientesButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tituloLabel = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 800));

        contenedor.setPreferredSize(new java.awt.Dimension(0, 500));

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        consultarDatosButton.setBackground(new java.awt.Color(208, 208, 208));
        consultarDatosButton.setFont(new java.awt.Font("Bitstream Charter", 1, 18)); // NOI18N
        consultarDatosButton.setActionCommand("Consultar");
        consultarDatosButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        consultarDatosButton.setLabel("Consultar Clientes");
        consultarDatosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarDatosActionPerformed(evt);
            }
        });

        nuevoClienteButton.setBackground(new java.awt.Color(208, 208, 208));
        nuevoClienteButton.setFont(new java.awt.Font("Bitstream Charter", 1, 18)); // NOI18N
        nuevoClienteButton.setText("Nuevo Cliente");
        nuevoClienteButton.setActionCommand("Consultar");
        nuevoClienteButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nuevoClienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoClienteActionPerformed(evt);
            }
        });

        actualizarClientesButton.setBackground(new java.awt.Color(208, 208, 208));
        actualizarClientesButton.setFont(new java.awt.Font("Bitstream Charter", 1, 18)); // NOI18N
        actualizarClientesButton.setText("Actualizar Clientes");
        actualizarClientesButton.setActionCommand("Consultar");
        actualizarClientesButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        actualizarClientesButton.setMaximumSize(new java.awt.Dimension(143, 143));
        actualizarClientesButton.setMinimumSize(new java.awt.Dimension(143, 143));
        actualizarClientesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarClienteActionPerformed(evt);
            }
        });

        borrarClientesButton.setBackground(new java.awt.Color(208, 208, 208));
        borrarClientesButton.setFont(new java.awt.Font("Bitstream Charter", 1, 18)); // NOI18N
        borrarClientesButton.setText("Borrar Clientes");
        borrarClientesButton.setActionCommand("Consultar");
        borrarClientesButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        borrarClientesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(consultarDatosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nuevoClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(actualizarClientesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(borrarClientesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consultarDatosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevoClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizarClientesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrarClientesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tituloLabel.setFont(new java.awt.Font("Noto Sans Display Medium", 1, 36)); // NOI18N
        tituloLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloLabel.setText("TIENDA JARDINERIA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(283, 283, 283))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void closeOpenWindows() {
        for (JInternalFrame window : openWindows) {
            window.dispose();
        }
        openWindows.clear();
    }
    
    private void consultarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarDatosActionPerformed
        // TODO add your handling code here:
         // Cerrar las ventanas abiertas
        closeOpenWindows();
        
        ConsultClientWindow ventanaConsultarCientes = new ConsultClientWindow(this);
        contenedor.add(ventanaConsultarCientes);
        ventanaConsultarCientes.setVisible(true);
        openWindows.add(ventanaConsultarCientes);
    }//GEN-LAST:event_consultarDatosActionPerformed

    private void nuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoClienteActionPerformed
        // TODO add your handling code here:
        // Cerrar las ventanas abiertas
        closeOpenWindows();
        
        InsertClientWindow ventanaInsertarClientes = new InsertClientWindow(this);
        contenedor.add(ventanaInsertarClientes);
        ventanaInsertarClientes.setVisible(true);
        openWindows.add(ventanaInsertarClientes);
    }//GEN-LAST:event_nuevoClienteActionPerformed

    private void actualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarClienteActionPerformed
        // TODO add your handling code here:
        // Cerrar la ventana actual
        UpdateClientWindow ventanaActualizarClientes = new UpdateClientWindow(this);
        contenedor.add(ventanaActualizarClientes);
        ventanaActualizarClientes.setVisible(true);
        openWindows.add(ventanaActualizarClientes);
    }//GEN-LAST:event_actualizarClienteActionPerformed

    private void borrarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarClientesActionPerformed
        // TODO add your handling code here:
        // Cerrar la ventana actual
        DeleteClientWindow ventanaBorrarClientes = new DeleteClientWindow(this);
        contenedor.add(ventanaBorrarClientes);
        ventanaBorrarClientes.setVisible(true);
        openWindows.add(ventanaBorrarClientes);
    }//GEN-LAST:event_borrarClientesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarClientesButton;
    private javax.swing.JButton borrarClientesButton;
    private javax.swing.JButton consultarDatosButton;
    private javax.swing.JDesktopPane contenedor;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton nuevoClienteButton;
    private javax.swing.JLabel tituloLabel;
    // End of variables declaration//GEN-END:variables
}
