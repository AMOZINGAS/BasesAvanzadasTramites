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
 * @author Amós Helí Olguín Quiróz
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
        btnCancelar = new javax.swing.JButton();
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
        txtNombrePersona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombrePersonaKeyReleased(evt);
            }
        });
        jPanel12.add(txtNombrePersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 120, 20));

        cbxPersona.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbxPersonaFocusLost(evt);
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

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setForeground(new java.awt.Color(51, 102, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel12.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 105, 25));

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

    /**
     * Metodo que carga el combo box del vehiculo para llenarlo de los vehiculos
     * que tenga la persona seleccionada
     */
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
    
    /**
     * Metodo que carga el combo box de la persona
     */
    public void cargarComboBoxPersona(){
        DefaultComboBoxModel modeloComboBox = new DefaultComboBoxModel();
        cbxPersona.setModel(modeloComboBox);
        List<PersonaGeneradaDTO> personas = listaPersonasNombre();
        for (PersonaGeneradaDTO persona : personas) {
            modeloComboBox.addElement(persona);
        }
    }
    
    /**
     * Metodo que genera la lista de personas por nombre
     * @return 
     */
    public List<PersonaGeneradaDTO> listaPersonasNombre(){
        PersonaConsulta personaConsulta = new PersonaConsulta();
        return personaConsulta.listaPersonasNombre(txtNombrePersona.getText());
    }
    
    /**
     * metodo que genera la lista de vehiculo de una paersona
     * @return 
     */
    public List<VehiculoGeneradoDTO> listaVehiculosPersona(){
        VehiculoConsulta vehiculoConsulta = new VehiculoConsulta();
        PersonaGeneradaDTO personaGeneradaDTO = (PersonaGeneradaDTO)cbxPersona.getSelectedItem();
        if(personaGeneradaDTO==null){
            return null;
        }else{
            return vehiculoConsulta.listaVehiculosPersona(personaGeneradaDTO.getCurp());
        }
    }
    
    /**
     * Metodo que verifica que el combo box de persona este vacio
     * @param evt 
     */
    private void txtNombrePersonaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePersonaKeyReleased
        cargarComboBoxPersona();
        if(cbxPersona.getSelectedItem()== null){
            JOptionPane.showMessageDialog(this, "No hay personas con ese nombre", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            txtNombrePersona.setText("");
            cargarComboBoxVehiculo();
            cbxVehiculo.setEnabled(false);    
        }
    }//GEN-LAST:event_txtNombrePersonaKeyReleased

    /**
     * Metodo que verifica que la persona seleccionada no este vacia
     * @param evt 
     */
    private void cbxPersonaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxPersonaFocusLost
        if(listaPersonasNombre()==null){    
            JOptionPane.showMessageDialog(this, "No existe ese nombre", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            txtNombrePersona.setText("");    
        }
    }//GEN-LAST:event_cbxPersonaFocusLost

    /**
     * metodo que selecciona y verifica que la persona no este vaica
     * @param evt 
     */
    private void btnSeleccionarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarPersonaActionPerformed
        if(cbxPersona.getSelectedItem()==null){   
           JOptionPane.showMessageDialog(this, "No se a seleccionado ninguna persona", "ERROR!!", JOptionPane.ERROR_MESSAGE);   
        }else if(cbxPersona==null){   
        }else{   
           cbxPersona.setEnabled(false);
           btnSeleccionarPersona.setEnabled(false);
           cbxVehiculo.setEnabled(true);
           btnSeleccionarAuto.setEnabled(true);
           cargarComboBoxVehiculo();
       }
    }//GEN-LAST:event_btnSeleccionarPersonaActionPerformed

    /**
     * Metodo que inicializa la placa dto
     * @return 
     */
    public PlacaNuevaDTO inicializarPlaca(){
        PlacaConsulta placaConsulta = new PlacaConsulta();
        int costoFinal = tipo.getPrecio();
        placaNuevaDTO = new PlacaNuevaDTO(costoFinal, placaConsulta.generarPlaca(), Calendar.getInstance());
        return placaNuevaDTO;
    }
    
    /**
     * metodo que confirma la seleccion de los elementos vehiculo y persona
     * @param evt 
     */
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        PersonaGeneradaDTO personaGeneradaDTO = (PersonaGeneradaDTO)cbxPersona.getSelectedItem();
        PersonaConsulta personaConsulta = new PersonaConsulta();
        VehiculoConsulta vehiculoConsulta = new VehiculoConsulta();
        if(vehiculoConsulta.verificarNuevo((VehiculoGeneradoDTO)cbxVehiculo.getSelectedItem())){    
            tipo = TipoPlaca.NUEVO;    
        }else{    
            tipo = TipoPlaca.RENOVADO;    
        }
        if(personaConsulta.verificarLicencia(personaGeneradaDTO)){    
            if(TipoPlaca.NUEVO==tipo){    
                VehiculoPlacaAgregar vehiculoPlacaAgregar = new VehiculoPlacaAgregar();
                JOptionPane panel = new JOptionPane("El costo de su placa es de: " + tipo.getPrecio(), JOptionPane.INFORMATION_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, new String[]{"CANCELAR", "OK"});
                JDialog dialogo = panel.createDialog("Información");
                dialogo.setVisible(true);
                if(panel.getValue().equals("CANCELAR")){
                    this.dispose();
                }else if(panel.getValue().equals("OK")){
                    VehiculoGeneradoDTO vehiculoGeneradoDTO = (VehiculoGeneradoDTO)cbxVehiculo.getSelectedItem();
                    vehiculoPlacaAgregar.agregarVehiculoAPlaca(vehiculoGeneradoDTO, inicializarPlaca());
                    JOptionPane.showMessageDialog(this, "Se agregó correctamente la placa al vehiculo con serie " + vehiculoGeneradoDTO.getNumSerie(), "EXITO!!", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    this.dispose();
                }
            }else if(TipoPlaca.RENOVADO==tipo){            
                VehiculoPlacaAgregar vehiculoPlacaAgregar = new VehiculoPlacaAgregar();
                JOptionPane panel = new JOptionPane("El costo de su placa es de: " + tipo.getPrecio(), JOptionPane.INFORMATION_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, new String[]{"CANCELAR", "OK"});
                JDialog dialogo = panel.createDialog("Información");
                dialogo.setVisible(true);
                if(panel.getValue().equals("CANCELAR")){
                    this.dispose();
                }else if(panel.getValue().equals("OK")){
                    VehiculoGeneradoDTO vehiculoGeneradoDTO = (VehiculoGeneradoDTO)cbxVehiculo.getSelectedItem();
                    vehiculoPlacaAgregar.agregarVehiculoAPlaca(vehiculoGeneradoDTO, inicializarPlaca());
                    JOptionPane.showMessageDialog(this, "Se agregó correctamente la placa al vehiculo con serie " + vehiculoGeneradoDTO.getNumSerie(), "EXITO!!", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    this.dispose();
                }
            }            
        }else{            
            JOptionPane.showMessageDialog(this, "No cuenta con licencia vigente", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
            txtNombrePersona.setText(null);
            btnConfirmar.setEnabled(false);
            btnSeleccionarPersona.setEnabled(true);
            cbxPersona.setEnabled(true);
            cbxVehiculo.setEnabled(false);
            cargarComboBoxPersona();            
        }        
    }//GEN-LAST:event_btnConfirmarActionPerformed

    /**
     * Metodo que verifica que el vehiculo seleccionado no este null
     * @param evt 
     */
    private void btnSeleccionarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarAutoActionPerformed
        if(cbxVehiculo.getSelectedItem()==null){   
           JOptionPane.showMessageDialog(this, "No cuentas con ningun vehiculo", "ERROR!!", JOptionPane.ERROR_MESSAGE);   
       }else{   
           cbxVehiculo.setEnabled(false);
           btnSeleccionarAuto.setEnabled(false);
           btnConfirmar.setEnabled(true);
           cargarComboBoxVehiculo();   
       }
    }//GEN-LAST:event_btnSeleccionarAutoActionPerformed

    /**
     * metodo que regresa al frame anterior
     * @param evt 
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        JFrameTramitar tramitar = new JFrameTramitar();
        tramitar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * metodo que reinicia los valores para poder ingresar nuevos datos
     * @param evt 
     */
    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        txtNombrePersona.setText(null);
        btnConfirmar.setEnabled(false);
        btnSeleccionarPersona.setEnabled(true);
        cbxPersona.setEnabled(true);
        cbxVehiculo.setEnabled(false);
        cargarComboBoxPersona();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    /**
     * Metodo que verifica que los datos dados como parametro no tengan caracteres especiales
     * @param texto
     * @return 
     */
    public boolean sinCaracteresEspeciales(String texto){
        if(!texto.matches("^[a-zA-Z ]+$")){
            return false;
        }else{
            return true;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
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
