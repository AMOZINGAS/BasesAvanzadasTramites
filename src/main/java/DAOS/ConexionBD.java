package DAOS;

import DAOS.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase de la conexion a la base de datos
 * @author Amós Helí Olguín Quiróz
 */
public class ConexionBD implements IConexionBD{
    
    EntityManagerFactory managerFactory;
    EntityManager entityManager;
    String nombrePersistencia = "persistencia";
    
    /**
     * Constructor por defecto
     */
    public ConexionBD(){}
    
    /**
     * Metodo que crea una conexion hacia la base de datos
     * @return el entityMnager para la conexion
     */
    @Override
    public EntityManager crearConexion(){
        
        managerFactory = Persistence.createEntityManagerFactory(nombrePersistencia);
        
        entityManager = managerFactory.createEntityManager();
        
        return entityManager;
        
    }
    
}