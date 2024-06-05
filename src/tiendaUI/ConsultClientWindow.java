/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tiendaUI;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JOptionPane;

import tiendaDataAccess.DataAccessManager;
import tiendaObjetos.Cliente;

/**
 *
 * @author angsaegim
 */
public final class ConsultClientWindow extends javax.swing.JInternalFrame {

    private TiendaManagementWindow mainMenu;
    // Para que el frame NO SE MUEVA
    private final int fixedX = 0;
    private final int fixedY = 0;

    /**
     * Creates new form consultClientWindow
     */
    public ConsultClientWindow(TiendaManagementWindow mainMenu) {

        this.setBorder(null);
        this.mainMenu = mainMenu;
        initComponents();
        this.setResizable(false);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null); // Eliminar el borde superior
        this.setLocation(fixedX, fixedY);

        // Desactivar el listener de arrastre
        this.removeMouseListener(this.getMouseListeners()[0]);

        // Para no poder arrastrar y mover el frame
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                setLocation(fixedX, fixedY);
            }
        });

        //cargamos todos los datos en la tabla
        try {
            loadData();
        } catch (SQLException e) {

        }

        //no permitimos editar el contenido de la tabla
        this.clientList.setCellSelectionEnabled(false);
        this.clientList.setRowSelectionAllowed(false);
        this.clientList.setColumnSelectionAllowed(false);

        idABuscar.setEnabled(true);
        idABuscar.setEditable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        regresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientList = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        idABuscar = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        botontablaCompleta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        nombreABuscar = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        paisABuscar = new javax.swing.JTextArea();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setToolTipText("");
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(950, 522));

        regresar.setText("Atrás");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setToolTipText("");

        clientList.setModel(new javax.swing.table.DefaultTableModel(
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
        clientList.setToolTipText("");
        clientList.setPreferredSize(new java.awt.Dimension(500, 600));
        jScrollPane1.setViewportView(clientList);

        idABuscar.setColumns(1);
        idABuscar.setRows(1);
        idABuscar.setAutoscrolls(false);
        idABuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        idABuscar.setEnabled(false);
        jScrollPane2.setViewportView(idABuscar);

        jLabel1.setText("ID a buscar :");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botontablaCompleta.setText("Ver tabla completa");
        botontablaCompleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botontablaCompletaActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre a buscar:");

        nombreABuscar.setColumns(1);
        nombreABuscar.setRows(1);
        nombreABuscar.setAutoscrolls(false);
        nombreABuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nombreABuscar.setEnabled(false);
        jScrollPane3.setViewportView(nombreABuscar);

        jLabel3.setText("Pais:");

        paisABuscar.setColumns(1);
        paisABuscar.setRows(1);
        paisABuscar.setAutoscrolls(false);
        paisABuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paisABuscar.setEnabled(false);
        jScrollPane4.setViewportView(paisABuscar);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(botontablaCompleta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonBuscar)
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botontablaCompleta)
                        .addComponent(botonBuscar)))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(regresar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(regresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Ventana fija
    @Override
    public void setLocation(int x, int y) {
        // evitar que el JInternalFrame se mueva
    }

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        // Hacer invisible la ventana actual
        this.dispose(); //cerramos
        mainMenu.setVisible(true); //enseñar menu
    }//GEN-LAST:event_regresarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        // Obtener el ID a buscar
        String id = idABuscar.getText().trim();
        try {
            buscarPorId(id);
        } catch (SQLException ex) {
            // Manejar la excepción en caso de error SQL
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botontablaCompletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botontablaCompletaActionPerformed
        // TODO add your handling code here:
        try {
            // Cargar la tabla completa
            loadData();
        } catch (SQLException ex) {
            // Manejar la excepción en caso de error SQL
        }
    }//GEN-LAST:event_botontablaCompletaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botontablaCompleta;
    private javax.swing.JTable clientList;
    private javax.swing.JTextArea idABuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea nombreABuscar;
    private javax.swing.JTextArea paisABuscar;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables

    private void loadData() throws SQLException {

        //carga de datos en memoria
        List<Cliente> allClientes = DataAccessManager.getInstance().loadAllClientes();

        //preparación del Data Model con las dos columnas a mostrar (no permiten edición)
        DefaultTableModel dtm = new NotEditableTableModel();
        dtm.addColumn("Id");
        dtm.addColumn("NombreCliente");
        dtm.addColumn("Telefono");
        dtm.addColumn("Pais");
        dtm.addColumn("CodigoEmpleadoRelacionado");

        //recorremos los países cargados en memoria
        for (int i = 0; i < allClientes.size(); i++) {
            //una fila por cliente
            Object[] dtmRow = new Object[5];
            Cliente cliente = allClientes.get(i);

            //las dos columnas de la fila, son dos propiedades del país, respectivamente
            dtmRow[0] = cliente.getCodigoCliente();
            dtmRow[1] = cliente.getNombreCliente();
            dtmRow[2] = cliente.getTelefono();
            dtmRow[3] = cliente.getPais();
            dtmRow[4] = cliente.getCodigoClienteEmpleado();

            //añadimos la fila al modelo de datos 
            dtm.addRow(dtmRow);
        }

        //asociamos el modelo de datos creado a la JTable de la ventana, para hacer los datos visibles
        this.clientList.setModel(dtm);
    }

    private void buscarPorId(String id) throws SQLException {
        // Cargar todos los clientes
        List<Cliente> allClientes = DataAccessManager.getInstance().loadAllClientes();

        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Id");
        dtm.addColumn("NombreCliente");
        dtm.addColumn("Telefono");
        dtm.addColumn("Pais");
        dtm.addColumn("CodigoEmpleadoRelacionado");

        // Convertir el ID ingresado a int
        int idBuscado = Integer.parseInt(id);

        boolean clienteEncontrado = false;

        // Filtrar los clientes que coincidan con el ID buscado
        for (Cliente cliente : allClientes) {
            if (cliente.getCodigoCliente() == idBuscado) {
                Object[] row = {
                    cliente.getCodigoCliente(),
                    cliente.getNombreCliente(),
                    cliente.getTelefono(),
                    cliente.getPais(),
                    cliente.getCodigoClienteEmpleado()
                };
                dtm.addRow(row); // Agregar el cliente filtrado al modelo de tabla
                clienteEncontrado = true;
            }
        }

        // Si no se encontró ningún cliente, mostrar un mensaje de error
        if (!clienteEncontrado) {
            JOptionPane.showMessageDialog(this, "No se encontró ningún cliente con el ID proporcionado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Actualizar la tabla con los resultados de la búsqueda
            clientList.setModel(dtm);
        }
    }

}
