package negocio;

import DAOS.ConexionBD;
import DAOS.IConexionBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amós Helí Olguín Quiróz
 */
public class ConexionBDConsulta {
    
    IConexionBD conexionBD;
    
    /**
     * Constructor que inciializa la conexion
     */
    public ConexionBDConsulta(){
        conexionBD = new ConexionBD();
    }
    
    /**
     * Metodo que crea la conexion
     */
    public void crearConexion(){
        
        try {
            conexionBD.crearConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
