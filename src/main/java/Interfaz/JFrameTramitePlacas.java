/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import DTO.PersonaGeneradaDTO;
import DTO.PlacaNuevaDTO;
import DTO.VehiculoGeneradoDTO;
import controlador.TipoPlaca;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import negocio.PersonaConsulta;
import negocio.PlacaConsulta;
import negocio.VehiculoConsulta;
import negocio.VehiculoPlacaAgregar;

/**
 *
 * @author elimo
 */
public class JFrameTramitePlacas extends javax.swing.JFrame {

    private int costo;
    private TipoPlaca tipo;
    private PlacaNuevaDTO placaNuevaDTO;
    
    /**
     * Creates new form JFrameTramitePlacas
     */
    public JFrameTramitePlacas(TipoPlaca tipo) {
        initComponents();
        this.tipo = tipo;
        costo = tipo.getPrecio();
        placaNuevaDTO = new PlacaNuevaDTO();
        cargarComboBoxPersona();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtNombrePersona = new javax.swing.JTextField();
        cbxPersona = new javax.swing.JComboBox<>();
        cbxVehiculo = new javax.swing.JComboBox<>();
        btnSeleccionarPersona = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        btnSeleccionarAuto = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setFocusCycleRoot(true);
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(51, 102, 255));
        jPanel10.setMaximumSize(new java.awt.Dimension(600, 60));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/sonoraLogoImagen.png"))); // NOI18N
        jPanel10.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 94, 40));

        jPanel11.setBackground(new java.awt.Color(51, 204, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 600, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Transacciones y mas");
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 5, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/fondoImagen.jpeg"))); // NOI18N
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 0, 506, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Transacciones y mas");
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 5, -1, -1));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 60));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setMaximumSize(new java.awt.Dimension(393, 267));
        jPanel12.setMinimumSize(new java.awt.Dimension(393, 267));
        jPanel12.setPreferredSize(new java.awt.Dimension(393, 267));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Nombre del dueño");
        jPanel12.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        txtNombrePersona.setBackground(new java.awt.Color(204, 204, 204));
        txtNombrePersona.setForeground(new java.awt.Color(0, 0, 0));
        txtNombrePersona.setToolTipText("");
        txtNombrePersona.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombrePersona.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombrePersonaFocusLost(evt);
            }
        });
        txtNombrePersona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombrePersonaKeyReleased(evt);
            }
        });
        jPanel12.add(txtNombrePersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 120, 20));

        cbxPersona.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbxPersonaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbxPersonaFocusLost(evt);
            }
        });
        cbxPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPersonaActionPerformed(evt);
            }
        });
        cbxPersona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbxPersonaKeyReleased(evt);
            }
        });
        jPanel12.add(cbxPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 230, -1));

        cbxVehiculo.setEnabled(false);
        jPanel12.add(cbxVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 230, -1));

        btnSeleccionarPersona.setBackground(new java.awt.Color(204, 204, 204));
        btnSeleccionarPersona.setForeground(new java.awt.Color(51, 102, 255));
        btnSeleccionarPersona.setText("Seleccionar");
        btnSeleccionarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarPersonaActionPerformed(evt);
            }
        });
        jPanel12.add(btnSeleccionarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 105, 25));

        btnConfirmar.setBackground(new java.awt.Color(204, 204, 204));
        btnConfirmar.setForeground(new java.awt.Color(51, 102, 255));
        btnConfirmar.setText("Confrimar");
        btnConfirmar.setEnabled(false);
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel12.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 105, 25));

        btnSeleccionarAuto.setBackground(new java.awt.Color(204, 204, 204));
        btnSeleccionarAuto.setForeground(new java.awt.Color(51, 102, 255));
        btnSeleccionarAuto.setText("Seleccionar");
        btnSeleccionarAuto.setEnabled(false);
        btnSeleccionarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarAutoActionPerformed(evt);
            }
        });
        jPanel12.add(btnSeleccionarAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 105, 25));

        btnEditar.setBackground(new java.awt.Color(204, 204, 204));
        btnEditar.setForeground(new java.awt.Color(51, 102, 255));
        btnEditar.setText("Cancelar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel12.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 105, 25));

        btnReiniciar.setBackground(new java.awt.Color(204, 204, 204));
        btnReiniciar.setForeground(new java.awt.Color(51, 102, 255));
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        jPanel12.add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 105, 25));

        jPanel9.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 393, 267));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 350));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombrePersonaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombrePersonaFocusLost
        // TODO add your handling code here:
        
        

    }//GEN-LAST:event_txtNombrePersonaFocusLost

    
    public void cargarComboBoxVehiculo(){
        
        DefaultComboBoxModel modeloComboBox = new DefaultComboBoxModel();
        cbxVehiculo.setModel(modeloComboBox);
        if(listaVehiculosPersona()==null){
        }else{
            List<VehiculoGeneradoDTO> vehiculos = listaVehiculosPersona();
            for (VehiculoGeneradoDTO vehiculo : vehiculos) {
                modeloComboBox.addElement(vehiculo);
            }
        }
    }
    
    public void cargarComboBoxPersona(){
        
        DefaultComboBoxModel modeloComboBox = new DefaultComboBoxModel();
        cbxPersona.setModel(modeloComboBox);
        List<PersonaGeneradaDTO> personas = listaPersonasNombre();
        for (PersonaGeneradaDTO persona : personas) {
            modeloComboBox.addElement(persona);
        }
        
    }
    
    public List<PersonaGeneradaDTO> listaPersonasNombre(){
        
        PersonaConsulta personaConsulta = new PersonaConsulta();
        return personaConsulta.listaPersonasNombre(txtNombrePersona.getText());
        
    }
    
    public List<VehiculoGeneradoDTO> listaVehiculosPersona(){
        
        VehiculoConsulta vehiculoConsulta = new VehiculoConsulta();
        PersonaGeneradaDTO personaGeneradaDTO = (PersonaGeneradaDTO)cbxPersona.getSelectedItem();
        if(personaGeneradaDTO==null){
            
            return null;
            
        }else{
            
            return vehiculoConsulta.listaVehiculosPersona(personaGeneradaDTO.getCurp());
            
        }
       
        
    }
    
    private void txtNombrePersonaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePersonaKeyReleased
        // TODO add your handling code here:
        cargarComboBoxPersona();
        if(cbxPersona.getSelectedItem()== null){
            
            JOptionPane.showMessageDialog(this, "No hay personas con ese nombre", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            txtNombrePersona.setText("");
            cargarComboBoxVehiculo();
            cbxVehiculo.setEnabled(false);
            
        }
//        if(!sinCaracteresEspeciales(txtNombrePersona.getText())){
//
//            JOptionPane.showMessageDialog(this, "Solo se permiten letras", "ERROR!!", JOptionPane.ERROR_MESSAGE);
//            txtNombrePersona.setText("");
//
//        }

    }//GEN-LAST:event_txtNombrePersonaKeyReleased

    private void cbxPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPersonaActionPerformed

    private void cbxPersonaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxPersonaFocusGained
        // TODO add your handling code here:
        
        
//        cargarComboBoxVehiculo();
//        cbxVehiculo.setEnabled(true);
        
    }//GEN-LAST:event_cbxPersonaFocusGained

    private void cbxPersonaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxPersonaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPersonaKeyReleased

    private void cbxPersonaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxPersonaFocusLost
        // TODO add your handling code here:
        
        if(listaPersonasNombre()==null){
            
            JOptionPane.showMessageDialog(this, "No existe ese nombre", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            txtNombrePersona.setText("");
            
        }
        
    }//GEN-LAST:event_cbxPersonaFocusLost

    private void btnSeleccionarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarPersonaActionPerformed
        // TODO add your handling code here:

       if(cbxPersona.getSelectedItem()==null){
           
           JOptionPane.showMessageDialog(this, "No se a seleccionado ninguna persona", "ERROR!!", JOptionPane.ERROR_MESSAGE);
           
       }else if(cbxPersona==null){//POR MODIFICAR
           
           
       }else{
           
           cbxPersona.setEnabled(false);
           btnSeleccionarPersona.setEnabled(false);
           cbxVehiculo.setEnabled(true);
           btnSeleccionarAuto.setEnabled(true);
           cargarComboBoxVehiculo();
           
       }
    }//GEN-LAST:event_btnSeleccionarPersonaActionPerformed

    
    public PlacaNuevaDTO inicializarPlaca(){
        
        PlacaConsulta placaConsulta = new PlacaConsulta();
        placaNuevaDTO = new PlacaNuevaDTO(costo, placaConsulta.generarPlaca(), Calendar.getInstance());
        return placaNuevaDTO;
        
    }
    
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        PersonaGeneradaDTO personaGeneradaDTO = (PersonaGeneradaDTO)cbxPersona.getSelectedItem();
        
        
//        if()
        if(TipoPlaca.NUEVO==tipo){
            
            VehiculoPlacaAgregar vehiculoPlacaAgregar = new VehiculoPlacaAgregar();
            JOptionPane panel = new JOptionPane("El costo de su placa es de: " + tipo.getPrecio(), JOptionPane.INFORMATION_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, new String[]{"CANCELAR", "OK"});
            JDialog dialogo = panel.createDialog("Información");
            dialogo.setVisible(true);
            if(panel.getValue().equals("CANCELAR")){
                //CANCELAR
                this.dispose();
            }else if(panel.getValue().equals("OK")){
                //OK
                VehiculoGeneradoDTO vehiculoGeneradoDTO = (VehiculoGeneradoDTO)cbxVehiculo.getSelectedItem();
                vehiculoPlacaAgregar.agregarVehiculoAPlaca(vehiculoGeneradoDTO, inicializarPlaca());
                JOptionPane.showMessageDialog(this, "Se agregó correctamente la placa al vehiculo con serie " + vehiculoGeneradoDTO.getNumSerie(), "EXITO!!", JOptionPane.INFORMATION_MESSAGE);
                
            }else{
                this.dispose();
            }
        }
        
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnSeleccionarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarAutoActionPerformed
        // TODO add your handling code here:
        
        if(cbxVehiculo.getSelectedItem()==null){
           
           JOptionPane.showMessageDialog(this, "No cuentas con ningun vehiculo", "ERROR!!", JOptionPane.ERROR_MESSAGE);
           
       }else{
           
           cbxVehiculo.setEnabled(false);
           btnSeleccionarAuto.setEnabled(false);
           btnConfirmar.setEnabled(true);
           cargarComboBoxVehiculo();
           
       }
        
    }//GEN-LAST:event_btnSeleccionarAutoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        
        JFrameTramitar tramitar = new JFrameTramitar();
        tramitar.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        // TODO add your handling code here:
        
        txtNombrePersona.setText(null);
        btnConfirmar.setEnabled(false);
        btnSeleccionarPersona.setEnabled(true);
        cbxPersona.setEnabled(true);
        cbxVehiculo.setEnabled(false);
        cargarComboBoxPersona();
        
    }//GEN-LAST:event_btnReiniciarActionPerformed

     public boolean sinCaracteresEspeciales(String texto){
        
        if(!texto.matches("^[a-zA-Z ]+$")){
            
            return false;
            
        }else{
            
            return true;
            
        }
        
    }
    
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JFrameTramitePlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JFrameTramitePlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JFrameTramitePlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JFrameTramitePlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JFrameTramitePlacas().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnSeleccionarAuto;
    private javax.swing.JButton btnSeleccionarPersona;
    private javax.swing.JComboBox<String> cbxPersona;
    private javax.swing.JComboBox<String> cbxVehiculo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField txtNombrePersona;
    // End of variables declaration//GEN-END:variables
}
