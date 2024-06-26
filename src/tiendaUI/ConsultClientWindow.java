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
import java.util.ArrayList;

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
            e.getMessage();
        }

        //no permitimos editar el contenido de la tabla
        this.clientList.setCellSelectionEnabled(false);
        this.clientList.setRowSelectionAllowed(false);
        this.clientList.setColumnSelectionAllowed(false);

        // Hacemos la busqueda editable (se puede escribir)
        idABuscar.setEnabled(true);
        idABuscar.setEditable(true);

        nombreABuscar.setEnabled(true);
        nombreABuscar.setEditable(true);

        paisABuscar.setEnabled(true);
        paisABuscar.setEditable(true);
        
        empleadoABuscar.setEnabled(true);
        empleadoABuscar.setEditable(true);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        idABuscar = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        nombreABuscar = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        paisABuscar = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        empleadoABuscar = new javax.swing.JTextArea();
        botonBuscar = new javax.swing.JButton();

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
        clientList.setPreferredSize(null);
        jScrollPane1.setViewportView(clientList);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
        );

        jLabel1.setText("ID a buscar :");

        idABuscar.setColumns(1);
        idABuscar.setRows(1);
        idABuscar.setAutoscrolls(false);
        idABuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        idABuscar.setEnabled(false);
        jScrollPane2.setViewportView(idABuscar);

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

        jLabel4.setText("Empleado : ");

        empleadoABuscar.setColumns(1);
        empleadoABuscar.setRows(1);
        empleadoABuscar.setAutoscrolls(false);
        empleadoABuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        empleadoABuscar.setEnabled(false);
        jScrollPane5.setViewportView(empleadoABuscar);

        botonBuscar.setText("Buscar");
        botonBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(regresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)))
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
        String id = idABuscar.getText().trim(); //trim elimina los espacios en blanco
        String nombre = nombreABuscar.getText().trim();
        String pais = paisABuscar.getText().trim();
        String idEmpleado = empleadoABuscar.getText().trim();

        // BUSQUEDA SIMULATENEA
        try {
            buscarClientes(id, nombre, pais, idEmpleado);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error en la búsqueda: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JTable clientList;
    private javax.swing.JTextArea empleadoABuscar;
    private javax.swing.JTextArea idABuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
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

        //recorremos los clientes
        for (int i = 0; i < allClientes.size(); i++) {
            //una fila por cliente
            Object[] dtmRow = new Object[5];
            Cliente cliente = allClientes.get(i);

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
         // Ajustar automáticamente la ventana al nuevo contenido de la tabla
        this.pack();
    }

    private void buscarClientes(String id, String nombre, String pais, String idEmpleado) throws SQLException {
        //Lista de todos los clientes cargados (a partir de LoadAll)
        List<Cliente> allClientes = DataAccessManager.getInstance().loadAllClientes();
        // ArrayList de los clientes que se han filtrado
        List<Cliente> clientesFiltrados = new ArrayList<>();

        for (Cliente cliente : allClientes) {
            boolean coincide = true; //boleean para controlar si coincide

            if (!id.isEmpty()) {
                try {
                    int idBuscado = Integer.parseInt(id);
                    coincide = coincide && (cliente.getCodigoCliente() == idBuscado);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "ID debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            //da igual que haya algunos vacios - buscará el textarea que este rellenado y luego irá filtrando
            if (!nombre.isEmpty()) {
                coincide = coincide && cliente.getNombreCliente().equalsIgnoreCase(nombre);
            }

            if (!pais.isEmpty()) {
                coincide = coincide && cliente.getPais().equalsIgnoreCase(pais);
            }
            if (!idEmpleado.isEmpty()) {
                try {
                    int idEmpleadoBuscado = Integer.parseInt(idEmpleado);
                    coincide = coincide && (cliente.getCodigoClienteEmpleado() == idEmpleadoBuscado);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "ID empleado debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            if (coincide) {
                clientesFiltrados.add(cliente);
            }
        }
        // la tabla se actualiza y muestra lo que ha encontrado
        actualizarTabla(clientesFiltrados);
    }

    // ACTUALIZA LA TABLA SEGÚN LOS CRITERIOS DE BUSQUEDA - por eso toma parametro la lista de clientes
    private void actualizarTabla(List<Cliente> clientes) {

        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron clientes con los criterios proporcionados.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return; // Salir del método sin actualizar la tabla
        }
        //creamos la tabla pero con SOLO esos clientes filtrados.
        DefaultTableModel dtm = new NotEditableTableModel();
        dtm.addColumn("Id");
        dtm.addColumn("NombreCliente");
        dtm.addColumn("Telefono");
        dtm.addColumn("Pais");
        dtm.addColumn("CodigoEmpleadoRelacionado");

        for (Cliente cliente : clientes) {
            Object[] row = {
                cliente.getCodigoCliente(),
                cliente.getNombreCliente(),
                cliente.getTelefono(),
                cliente.getPais(),
                cliente.getCodigoClienteEmpleado()
            };
            dtm.addRow(row);
        }

        this.clientList.setModel(dtm);
      
        // Ajustar automáticamente la ventana al nuevo contenido de la tabla
        this.pack();
    }

}
