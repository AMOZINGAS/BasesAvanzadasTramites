/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import DTO.PersonaGeneradaDTO;
import DTO.VehiculoNuevoDTO;
import controlador.TipoPlaca;
import java.util.Calendar;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import negocio.PersonaConsulta;
import negocio.PersonaVehiculoAgregar;

/**
 *
 * @author elimo
 */
public class JFrameAgregarVehiculo extends javax.swing.JFrame {

    private VehiculoNuevoDTO vehiculoNuevoDTO;
    
    /**
     * Creates new form JFrameVehiculo
     */
    public JFrameAgregarVehiculo() {
        initComponents();
        cargarComboBox();
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
        jLabel6 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnRegregar = new javax.swing.JButton();
        btnSIguiente = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtNombrePersona = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbxPersonas = new javax.swing.JComboBox<>();
        txtNumeroSerie = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Año");
        jPanel12.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        txtColor.setBackground(new java.awt.Color(204, 204, 204));
        txtColor.setForeground(new java.awt.Color(0, 0, 0));
        txtColor.setToolTipText("");
        txtColor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtColorKeyReleased(evt);
            }
        });
        jPanel12.add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 180, 20));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Color");
        jPanel12.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txtLinea.setBackground(new java.awt.Color(204, 204, 204));
        txtLinea.setForeground(new java.awt.Color(0, 0, 0));
        txtLinea.setToolTipText("");
        txtLinea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtLinea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLineaKeyReleased(evt);
            }
        });
        jPanel12.add(txtLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 180, 20));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Linea");
        jPanel12.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        txtMarca.setBackground(new java.awt.Color(204, 204, 204));
        txtMarca.setForeground(new java.awt.Color(0, 0, 0));
        txtMarca.setToolTipText("");
        txtMarca.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMarcaKeyReleased(evt);
            }
        });
        jPanel12.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 180, 20));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Marca");
        jPanel12.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        btnRegregar.setBackground(new java.awt.Color(204, 204, 204));
        btnRegregar.setForeground(new java.awt.Color(51, 102, 255));
        btnRegregar.setText("Regresar");
        btnRegregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegregarActionPerformed(evt);
            }
        });
        jPanel12.add(btnRegregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 105, 25));

        btnSIguiente.setBackground(new java.awt.Color(204, 204, 204));
        btnSIguiente.setForeground(new java.awt.Color(51, 102, 255));
        btnSIguiente.setText("Siguiente");
        btnSIguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSIguienteActionPerformed(evt);
            }
        });
        jPanel12.add(btnSIguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 105, 25));

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

        txtAnio.setBackground(new java.awt.Color(204, 204, 204));
        txtAnio.setForeground(new java.awt.Color(0, 0, 0));
        txtAnio.setToolTipText("");
        txtAnio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioActionPerformed(evt);
            }
        });
        txtAnio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAnioKeyReleased(evt);
            }
        });
        jPanel12.add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 120, 20));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Numero de serie");
        jPanel12.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jPanel12.add(cbxPersonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 230, -1));

        txtNumeroSerie.setBackground(new java.awt.Color(204, 204, 204));
        txtNumeroSerie.setForeground(new java.awt.Color(0, 0, 0));
        txtNumeroSerie.setToolTipText("");
        txtNumeroSerie.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel12.add(txtNumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 180, 20));

        jPanel9.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 393, 267));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 350));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnRegregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegregarActionPerformed
        // TODO add your handling code here:

        JFrameTramitar tramite = new JFrameTramitar();
        tramite.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnRegregarActionPerformed

    private void btnSIguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSIguienteActionPerformed
        // TODO add your handling code here:

        if(cbxPersonas.getSelectedItem()==null){
            
            JOptionPane.showMessageDialog(this, "No se a seleccionado ningún dueño", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            
        }else{
            
            construirVehiculoDTO();
            PersonaGeneradaDTO personaGeneradaDTO = (PersonaGeneradaDTO)cbxPersonas.getSelectedItem();
            agregarVehiculoAPersona(vehiculoNuevoDTO, personaGeneradaDTO);
            JFrameTramitePlacas tramitarPlaca = new JFrameTramitePlacas(TipoPlaca.NUEVO);
            tramitarPlaca.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnSIguienteActionPerformed

    
    private void construirVehiculoDTO(){
        
        vehiculoNuevoDTO = new VehiculoNuevoDTO();
        vehiculoNuevoDTO.setColor(txtColor.getText());
        vehiculoNuevoDTO.setLinea(txtLinea.getText());
        vehiculoNuevoDTO.setMarca(txtMarca.getText());
        vehiculoNuevoDTO.setNumSerie(txtNumeroSerie.getText());
        vehiculoNuevoDTO.setModelo(txtAnio.getText());
        
    }
    
    private void txtAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioActionPerformed

    private void txtAnioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnioKeyReleased
        // TODO add your handling code here:
        
        if(!txtAnio.getText().matches("\\d+")){
            
            JOptionPane.showMessageDialog(this, "Solo se permiten numeros", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            txtAnio.setText("");
            
        }
        if(txtAnio.getText().length()>4){
            
            JOptionPane.showMessageDialog(this, "Solo puedes ingresar hasta 4 digitos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            txtAnio.setText("");
            
        }
        if(txtAnio.getText().length()==4){
            
            if(Integer.parseInt(txtAnio.getText())<1900 || Integer.parseInt(txtAnio.getText())>Calendar.getInstance().get(Calendar.YEAR)){
            
                JOptionPane.showMessageDialog(this, "El año ingresado no esta permitido", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                txtAnio.setText("");
                
            }
            
        }
        
        
    }//GEN-LAST:event_txtAnioKeyReleased

    public List<PersonaGeneradaDTO> listaPersonasNombre(){
        
        PersonaConsulta personaConsulta = new PersonaConsulta();
        return personaConsulta.listaPersonasNombre(txtNombrePersona.getText());
        
    }
    
    public void cargarComboBox(){
        
        DefaultComboBoxModel modeloComboBox = new DefaultComboBoxModel();
        cbxPersonas.setModel(modeloComboBox);
        List<PersonaGeneradaDTO> personas = listaPersonasNombre();
        for (PersonaGeneradaDTO persona : personas) {
            modeloComboBox.addElement(persona);
        }
        
    }
    
    private void txtNombrePersonaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombrePersonaFocusLost
        // TODO add your handling code here:
        
        System.out.println("a");
        cargarComboBox();
        
    }//GEN-LAST:event_txtNombrePersonaFocusLost

    public void agregarVehiculoAPersona(VehiculoNuevoDTO vehiculoNuevoDTO, PersonaGeneradaDTO personaGeneradaDTO){
        
        PersonaVehiculoAgregar personaVehiculoConsulta = new PersonaVehiculoAgregar();
        personaVehiculoConsulta.agregarVehiculoAPersona(personaGeneradaDTO, vehiculoNuevoDTO);
        
    }
    
    public boolean sinCaracteresEspeciales(String texto){
        
        if(!texto.matches("^[a-zA-Z ]+$")){
            
            return false;
            
        }else{
            
            return true;
            
        }
        
    }
    
    private void txtColorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColorKeyReleased
        // TODO add your handling code here:
        if(!sinCaracteresEspeciales(txtColor.getText())){
            
            JOptionPane.showMessageDialog(this, "Solo se permiten letras", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            txtColor.setText("");
            
        }
        if(txtColor.getText().length()>20){
            
            JOptionPane.showMessageDialog(this, "Has sobre pasado el limite de letras (20)", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            txtColor.setText(txtColor.getText().substring(0, 20));
            
        }
        
    }//GEN-LAST:event_txtColorKeyReleased

    private void txtLineaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLineaKeyReleased
        // TODO add your handling code here:
        
        if(!sinCaracteresEspeciales(txtLinea.getText())){
            
            JOptionPane.showMessageDialog(this, "Solo se permiten letras", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            txtLinea.setText("");
            
        }
        
    }//GEN-LAST:event_txtLineaKeyReleased

    private void txtMarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyReleased
        // TODO add your handling code here:
        
        if(!sinCaracteresEspeciales(txtMarca.getText())){
            
            JOptionPane.showMessageDialog(this, "Solo se permiten letras", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            txtMarca.setText("");
            
        }
        
    }//GEN-LAST:event_txtMarcaKeyReleased

    private void txtNombrePersonaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePersonaKeyReleased
        // TODO add your handling code here:
        
        if(!sinCaracteresEspeciales(txtNombrePersona.getText())){
            
            JOptionPane.showMessageDialog(this, "Solo se permiten letras", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            txtNombrePersona.setText("");
            
        }
        
    }//GEN-LAST:event_txtNombrePersonaKeyReleased

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegregar;
    private javax.swing.JButton btnSIguiente;
    private javax.swing.JComboBox<String> cbxPersonas;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombrePersona;
    private javax.swing.JTextField txtNumeroSerie;
    // End of variables declaration//GEN-END:variables
}
