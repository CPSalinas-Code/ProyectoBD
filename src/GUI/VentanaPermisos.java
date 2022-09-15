/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Negocios.Administrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian
 */
public class VentanaPermisos extends javax.swing.JFrame implements ActionListener {

    public Administrador admin;
    public DefaultTableModel modelo;
    
    public String accion;
    public String nombreUser;
    public String permiso;
    public String TOorFrom;
    /**
     * Creates new form VentanaPermisos
     */
    public VentanaPermisos() {
        initComponents();
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setTitle("Permiso otorgados por system");
        this.setSize(850, 550);
        this.setResizable(false);
        this.setVisible(true);
        admin = new Administrador();
        modelo = new DefaultTableModel();
        this.setLocationRelativeTo(null);
        actualizar();

    }

    public void actualizar() {
        String datos[] = new String[1];
        int cont = 0;
        modelo = new DefaultTableModel();
        modelo.addColumn("Usuarios");

        datos[0] = "s";
        int numeroDeRegistros = 10;
        numeroDeRegistros = admin.numeroUsuarios("all_users");

        if (numeroDeRegistros == 0) {
            JOptionPane.showMessageDialog(null, "Error al contar el numero de usuarios d ela Base de Datos");
        } else {
            try {
                while (numeroDeRegistros > 0) {
                    datos = admin.obtenerUsuarios(cont);
                    modelo.addRow(datos);
                    cont++;
                    numeroDeRegistros--;
                }
                tablaUsuarios.setModel(modelo);

            } catch (Exception e) {
                System.out.println("ERROR AL OBTENER LOS DATOS de Ciudades");
                JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LOS DATOS de Ciudades");
            }
        }
        //datos = admin.obtenerDatosPersona();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoAcciones = new javax.swing.ButtonGroup();
        grupoPermisos = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        opcOtorgar = new javax.swing.JRadioButton();
        opcRevocar = new javax.swing.JRadioButton();
        btnRealizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jPanel3 = new javax.swing.JPanel();
        opcSelect = new javax.swing.JRadioButton();
        opcDrop = new javax.swing.JRadioButton();
        opcDelete = new javax.swing.JRadioButton();
        opcUpdate = new javax.swing.JRadioButton();
        opcInsert = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        txtConsulta = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPrivilegios = new javax.swing.JTable();
        btnActualizarPermisos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Permisos del Usuarios");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(21, 11, 175, 27);

        jPanel1.setBackground(new java.awt.Color(230, 241, 253));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Accion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 12))); // NOI18N

        grupoAcciones.add(opcOtorgar);
        opcOtorgar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        opcOtorgar.setText("Otorgar Permisos");

        grupoAcciones.add(opcRevocar);
        opcRevocar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        opcRevocar.setText("Revocar Permisos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opcRevocar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opcOtorgar, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(opcOtorgar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(opcRevocar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 50, 230, 100);

        btnRealizar.setText("Realizar Consulta");
        btnRealizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRealizar);
        btnRealizar.setBounds(30, 470, 140, 30);

        btnCancelar.setText("Salir");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(180, 470, 140, 30);

        jPanel2.setBackground(new java.awt.Color(230, 241, 253));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 12))); // NOI18N

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Usuarios"
            }
        ));
        jScrollPane1.setViewportView(tablaUsuarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 150, 230, 220);

        jPanel3.setBackground(new java.awt.Color(230, 241, 253));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione Permiso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 12))); // NOI18N

        grupoPermisos.add(opcSelect);
        opcSelect.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        opcSelect.setText("SELECT ANY TABLE");

        grupoPermisos.add(opcDrop);
        opcDrop.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        opcDrop.setText("DROP ANY TABLE");

        grupoPermisos.add(opcDelete);
        opcDelete.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        opcDelete.setText("DELETE ANY TABLE");

        grupoPermisos.add(opcUpdate);
        opcUpdate.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        opcUpdate.setText("UPDATE ANY TABLE");

        grupoPermisos.add(opcInsert);
        opcInsert.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        opcInsert.setText("INSERT ANY TABLE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opcSelect)
                    .addComponent(opcDrop))
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(opcUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(opcInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(opcDelete))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opcSelect)
                    .addComponent(opcUpdate)
                    .addComponent(opcInsert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opcDrop)
                    .addComponent(opcDelete))
                .addGap(41, 41, 41))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(260, 50, 510, 100);

        jPanel4.setBackground(new java.awt.Color(230, 241, 253));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 12))); // NOI18N

        txtConsulta.setEnabled(false);

        btnGenerar.setText("Generar Consulta");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 26, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(30, 380, 790, 70);

        jPanel5.setBackground(new java.awt.Color(230, 241, 253));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Permisos de Tabla Seleccionada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 12))); // NOI18N

        tablaPrivilegios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Grantee", "Privilegio", "ADM"
            }
        ));
        jScrollPane2.setViewportView(tablaPrivilegios);

        btnActualizarPermisos.setText("Ver Permisos de Tabla (Actualizar Tabla)");
        btnActualizarPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPermisosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
            .addComponent(btnActualizarPermisos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizarPermisos)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5);
        jPanel5.setBounds(260, 150, 560, 220);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoFor2.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 850, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
        String consulta = "";
        TOorFrom=null;
        accion = null;
        if (opcOtorgar.isSelected()) {
            accion = "grant";
            TOorFrom = "to";
        } else if (opcRevocar.isSelected()) {
            accion = "revoke";
            TOorFrom="from";
        }

        int row = tablaUsuarios.getSelectedRow();
        nombreUser = null;
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un Usuario");
        } else {
            nombreUser = tablaUsuarios.getValueAt(row, 0).toString();
        }

        permiso = null;
        if (opcDelete.isSelected()) {
            permiso = "DELETE ANY TABLE";
        } else if (opcDrop.isSelected()) {
            permiso = "DROP ANY TABLE";
        } else if (opcInsert.isSelected()) {
            permiso = "INSERT ANY TABLE";
        } else if (opcSelect.isSelected()) {
            permiso = "SELECT ANY TABLE";
        } else if (opcUpdate.isSelected()) {
            permiso = "UPDATE ANY TABLE";
        }
        if (accion == null || nombreUser == null || permiso == null) {
            JOptionPane.showMessageDialog(null, "Seleccione todos los valores requeridos");
        } else if (accion.equals("grant")) {
            consulta = accion + " " + permiso + " to " + nombreUser;
            System.out.println(consulta);
            txtConsulta.setText(consulta);
        } else {
            consulta = accion + " " + permiso + " from " + nombreUser;
            System.out.println(consulta);
            txtConsulta.setText(consulta);
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnActualizarPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPermisosActionPerformed
        // TODO add your handling code here:
        actualizarPermisos();
        //datos = admin.obtenerDatosPersona();

    }//GEN-LAST:event_btnActualizarPermisosActionPerformed
    public void actualizarPermisos(){
                String datos[] = new String[3];
        int cont = 0;
        modelo = new DefaultTableModel();
        modelo.addColumn("Grantee");
        modelo.addColumn("Privilegio");
        modelo.addColumn("ADM");
        datos[0] = "s";

        int numeroDeRegistros;
        numeroDeRegistros = admin.numeroPrivilegios("dba_sys_privs", tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString());
        if (numeroDeRegistros == 0) {
            JOptionPane.showMessageDialog(null, "Error al contar los usuarios en la bade de datos");
        }else{
            try {
                while (numeroDeRegistros > 0) {
                    datos = admin.obtenerDatosPrivilegios(cont, tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString());
                    modelo.addRow(datos);
                    cont++;
                    numeroDeRegistros--;
                }
                tablaPrivilegios.setModel(modelo);
            } catch (Exception e) {
                System.out.println("ERROR AL OBTENER el Numero de provilegios de usuario");
                JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LOS privilegios de usuario");
            }
        }

    }
    private void btnRealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarActionPerformed
        // TODO add your handling code here:
        if ((txtConsulta.getText()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Es necesario generar primero la consulta");
        } else if (admin.consultaPermisos(accion,permiso,TOorFrom,nombreUser)) {
            JOptionPane.showMessageDialog(null, "Proceso realizado correctamente");
            txtConsulta.setText(null);
            accion=null;
            permiso=null;
            TOorFrom=null;
            nombreUser=null;
            actualizarPermisos();
        } else {
            JOptionPane.showMessageDialog(null, "Error al Realizar consulta");
        }

    }//GEN-LAST:event_btnRealizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPermisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPermisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPermisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPermisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPermisos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarPermisos;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnRealizar;
    private javax.swing.ButtonGroup grupoAcciones;
    private javax.swing.ButtonGroup grupoPermisos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton opcDelete;
    private javax.swing.JRadioButton opcDrop;
    private javax.swing.JRadioButton opcInsert;
    private javax.swing.JRadioButton opcOtorgar;
    private javax.swing.JRadioButton opcRevocar;
    private javax.swing.JRadioButton opcSelect;
    private javax.swing.JRadioButton opcUpdate;
    private javax.swing.JTable tablaPrivilegios;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txtConsulta;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        /*if (ae.getSource()== this.opcOtorgar){
            if (this.opcOtorgar.isSelected()){
            txtConsulta.setText("grant");
            }
        }*/

    }
}