/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOS.ConexionBD;
import DAOS.IConexionBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ConexionBDConsulta {
    
    IConexionBD conexionBD;
    
    public ConexionBDConsulta(){
        
        conexionBD = new ConexionBD();
        
    }
    
    public void crearConexion(){
        
        try {
            conexionBD.crearConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
