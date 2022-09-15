/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Negocios.Administrador;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class EditarEdificio extends javax.swing.JFrame {
    public String clave;
    public String nombreTabla;
    public Config_Edificio ventanaTabla;
    public Administrador admin;
    public ArrayList datosCampos;
    /**
     * Creates new form EditarEdificio
     */
    public EditarEdificio(String clav, String nombreT, Config_Edificio ventana) {
        initComponents();
        
        admin = new Administrador();
        this.clave=clav;
        this.nombreTabla=nombreT;
        this.ventanaTabla=ventana;
        inicializar();
        txtIDEdificio.setEnabled(false);
        this.setTitle("Editar Registro en Tabla Edificio");
        this.setSize(440, 300);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        verificar();
    }
    public void verificar(){
        if(this.txtIDEdificio.getText().isEmpty()){
            this.setVisible(false);
        }
    }

    private EditarEdificio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void inicializar(){
        ArrayList datos = new ArrayList<>();
        datos = admin.recuperarDatos(clave,nombreTabla);
        if (datos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No existen datos recuperados");
        }else{
            txtIDEdificio.setText((datos.get(0)).toString());
            txtNombreEdificio.setText((datos.get(1)).toString());
            txtDireccionEdificio.setText((datos.get(2)).toString());
            txtNumPisos.setText((datos.get(3)).toString());
            this.setVisible(true);
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

        jLabel5 = new javax.swing.JLabel();
        txtIDEdificio = new javax.swing.JTextField();
        txtNombreEdificio = new javax.swing.JTextField();
        txtDireccionEdificio = new javax.swing.JTextField();
        txtNumPisos = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        brnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jLabel5.setText("Numero de Pisos:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(62, 182, 83, 14);
        getContentPane().add(txtIDEdificio);
        txtIDEdificio.setBounds(170, 60, 224, 30);
        getContentPane().add(txtNombreEdificio);
        txtNombreEdificio.setBounds(170, 100, 224, 30);
        getContentPane().add(txtDireccionEdificio);
        txtDireccionEdificio.setBounds(170, 140, 224, 30);
        getContentPane().add(txtNumPisos);
        txtNumPisos.setBounds(170, 180, 224, 30);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(120, 217, 91, 23);

        brnCancelar.setText("Cancelar");
        brnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(brnCancelar);
        brnCancelar.setBounds(241, 217, 82, 23);

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("Editar Edificio");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 180, 32);

        jLabel2.setText("ID Edificio:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(62, 68, 51, 14);

        jLabel3.setText("Nombre Edificio:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(62, 106, 77, 14);

        jLabel4.setText("Direccion Edificio:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(62, 144, 83, 14);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoFor.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 460, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String []datos = new String [4];
        datos[0]= txtIDEdificio.getText();;
        datos[1]= txtNombreEdificio.getText();
        datos[2]= txtDireccionEdificio.getText();
        datos[3]= txtNumPisos.getText();
        if (admin.updateDatos(datos,nombreTabla)){
            JOptionPane.showMessageDialog(null, "Datos Modificados correctamente");
            this.setVisible(false);
            ventanaTabla.actualizar();
        }
        else {
            JOptionPane.showMessageDialog(null, "Error al modificar los Datos del registro o no tiene permisos");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void brnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_brnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(EditarEdificio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarEdificio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarEdificio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarEdificio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarEdificio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtDireccionEdificio;
    private javax.swing.JTextField txtIDEdificio;
    private javax.swing.JTextField txtNombreEdificio;
    private javax.swing.JTextField txtNumPisos;
    // End of variables declaration//GEN-END:variables
}