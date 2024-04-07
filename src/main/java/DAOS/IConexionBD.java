package DAOS;

import java.sql.SQLException;
import javax.persistence.EntityManager;

/**
 *
 * @author Amós Helí Olguín Quiróz
 */
public interface IConexionBD {
 
    /**
     * Metodo que regresa una conexion hacia la base de datos
     * @return EntityMnager para usarlo
     * @throws SQLException 
     */
    public EntityManager crearConexion() throws SQLException;
    
}
