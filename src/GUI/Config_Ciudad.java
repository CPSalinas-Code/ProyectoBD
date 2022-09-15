/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Negocios.Administrador;
import java.lang.reflect.Field;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian
 */
public class Config_Ciudad extends javax.swing.JFrame {

    public Administrador admin;
    public DefaultTableModel modelo;

    /**
     * Creates new form Config_Ciudad
     */
    public Config_Ciudad() {
        initComponents();
        admin = new Administrador();
        modelo = new DefaultTableModel();
        txtPrueba.setEditable(false);
        this.setTitle("Configuracion de Registros de la Tabla Ciudad");
        this.setSize(665, 305);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        actualizar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCiudades = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        btnActualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPrueba = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        tablaCiudades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Ciudad", "Nombre Ciudad", "Estado", "Pais", "Numero Habitantes"
            }
        ));
        tablaCiudades.setCellSelectionEnabled(true);
        tablaCiudades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCiudadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCiudades);
        tablaCiudades.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 11, 644, 193);

        btnActualizar.setText("Actualizar Tabla");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar);
        btnActualizar.setBounds(10, 210, 280, 23);

        jLabel2.setText("ID seleccionado a buscar:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(310, 210, 210, 20);
        getContentPane().add(txtPrueba);
        txtPrueba.setBounds(480, 210, 170, 23);

        btnEditar.setText("Buscar ID y editar Registro");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar);
        btnEditar.setBounds(484, 244, 170, 23);

        btnEliminar.setText("Eliminar Registros");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(308, 244, 170, 23);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(10, 244, 83, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoFor2.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 670, 280);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void actualizar() {
        Object objeto = new Object();
        String datos[] = new String[5];
        int cont = 0;
        modelo = new DefaultTableModel();
        modelo.addColumn("ID Ciudad");
        modelo.addColumn("Nombre Ciudad");
        modelo.addColumn("Estado");
        modelo.addColumn("Pais");
        modelo.addColumn("Numero Habitantes");

        datos[0] = "s";
        int numeroDeRegistros;
        numeroDeRegistros = admin.numeroReg("Ciudades");
        if (numeroDeRegistros == 0) {
            JOptionPane.showMessageDialog(null, "Error al contar los registros de la tabla Ciudades o No tiene permisos en este tabla con el usuario actual");
            this.setVisible(false);
        } else {
            this.setVisible(true);
            try {
                while (numeroDeRegistros > 0) {
                    
                    objeto =admin.obtenerDatosCiudades(cont);
                    int contadorPosicion = 0;
                    for (Field f : objeto.getClass().getDeclaredFields()) {
                        
                        datos [contadorPosicion] =  (String) f.get(objeto);
                        contadorPosicion++;
                    }
                    
                    modelo.addRow(datos);
                    cont++;
                    numeroDeRegistros--;
                }
                tablaCiudades.setModel(modelo);
            } catch (Exception e) {
                System.out.println("ERROR AL OBTENER LOS DATOS de Ciudades");
                JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LOS DATOS de Ciudades");
            }

        }

        //datos = admin.obtenerDatosPersona();
    }
    
    private void tablaCiudadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCiudadesMouseClicked
        // TODO add your handling code here:
        int row = tablaCiudades.getSelectedRow();
        int col = tablaCiudades.getSelectedColumn();
        String id = tablaCiudades.getValueAt(row, col).toString();
        txtPrueba.setText(id);
    }//GEN-LAST:event_tablaCiudadesMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        actualizar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        String clav = txtPrueba.getText();
        //System.out.println(clav.isEmpty());
        if (clav.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo de ID no Seleccionado");
        } else {
            EditarCiudad ventana = new EditarCiudad(clav, "Ciudades", this);
            //actualizar();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        String clav = txtPrueba.getText();
        //System.out.println(clav.isEmpty());
        if (clav.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo de ID no Seleccionado");
        } else {
            if(admin.eliminarReg(clav, "Ciudades")){
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
                actualizar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar registro, ID no valido");
            }
            
            
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(Config_Ciudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Config_Ciudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Config_Ciudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Config_Ciudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Config_Ciudad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCiudades;
    private javax.swing.JTextField txtPrueba;
    // End of variables declaration//GEN-END:variables
}