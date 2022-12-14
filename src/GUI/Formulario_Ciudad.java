/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Negocios.Administrador;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class Formulario_Ciudad extends javax.swing.JFrame {
    
    public ArrayList datosCampos;
    public Administrador admin;
    /**
     * Creates new form Formulario_Ciudad
     */
    public Formulario_Ciudad() {
        admin = new Administrador();
        
        initComponents();
        this.setTitle("Crear Registro en Tabla Ciudades");
        this.setSize(440, 350);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
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
        txtIDCiudad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreCiudad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        txtNumHab = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        brnCancelar = new javax.swing.JButton();
        btnConfig = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("Formulario Ciudad");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 180, 32);
        getContentPane().add(txtIDCiudad);
        txtIDCiudad.setBounds(171, 65, 230, 30);

        jLabel2.setText("ID Ciudad:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(62, 68, 80, 14);

        jLabel3.setText("Nombre Ciudad:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(62, 106, 120, 14);
        getContentPane().add(txtNombreCiudad);
        txtNombreCiudad.setBounds(171, 103, 230, 30);

        jLabel4.setText("Estado o Provincia: ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(62, 144, 130, 14);
        getContentPane().add(txtEstado);
        txtEstado.setBounds(171, 141, 230, 30);
        getContentPane().add(txtPais);
        txtPais.setBounds(171, 179, 230, 30);
        getContentPane().add(txtNumHab);
        txtNumHab.setBounds(170, 220, 230, 30);

        jLabel5.setText("Pais:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(62, 182, 80, 14);

        jLabel6.setText("Numero Habitantes:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 220, 120, 20);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(70, 270, 91, 23);

        brnCancelar.setText("Cancelar");
        brnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(brnCancelar);
        brnCancelar.setBounds(180, 270, 82, 23);

        btnConfig.setText("Configurar Tabla");
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfig);
        btnConfig.setBounds(280, 270, 120, 23);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoFor.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 450, 320);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String verifacarInt = txtNumHab.getText();
        int numPisos;
        try{
            numPisos = Integer.parseInt(verifacarInt);
            if(numPisos<0){
                JOptionPane.showMessageDialog(null, "Error al ingresar el numero de habitantes");
            }else{
                if (admin.pasarDatosCiudad(txtIDCiudad.getText(),txtNombreCiudad.getText(),txtEstado.getText(),txtPais.getText(),txtNumHab.getText())){
                    JOptionPane.showMessageDialog(null, "Registro creado con exito en la tabla Ciudades");
                }else{
                    JOptionPane.showMessageDialog(null, "Rrror el crear registro en la tabla Ciudades o no tiene permisos para esta tabla con el usuario actual");
                }
                
            }
        }catch (Exception e) {
            System.out.println("Debe Ingresar digitos en el Numerde habitantes");
            JOptionPane.showConfirmDialog(null, "Debe Ingresar digitos en el Numerde habitantes");

        }
        
        

        /*Personas persona = new Personas();
        persona.setId_persona(txtID.getText());
        persona.setNombre(txtNombre.getText());
        persona.setApellido(txtApellido.getText());
        persona.setDireccion(txtDireccion.getText());
        persona.setF_nacimiento(txtFechaN.getText());
        persona.setTelefono(txtTelefono.getText());
        ConexionBD  conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        metodos.insertar(persona);*/
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void brnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_brnCancelarActionPerformed

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        // TODO add your handling code here:
        Config_Ciudad ventana = new Config_Ciudad();
        //ventana.setVisible(true);
    }//GEN-LAST:event_btnConfigActionPerformed

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
            java.util.logging.Logger.getLogger(Formulario_Ciudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_Ciudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_Ciudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_Ciudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario_Ciudad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnCancelar;
    private javax.swing.JButton btnConfig;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtIDCiudad;
    private javax.swing.JTextField txtNombreCiudad;
    private javax.swing.JTextField txtNumHab;
    private javax.swing.JTextField txtPais;
    // End of variables declaration//GEN-END:variables
}
