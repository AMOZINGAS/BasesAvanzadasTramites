package DAOS;

import excepciones.PersistenciaException;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Amós Helí Olguín Quiróz
 */
public class PersistirDAO implements IPersistirDAO{
    
    private final IConexionBD conexionBD;
    private final EntityManager entityManager;
    
    /**
     * Constructor que inicializa la conexion
     * @throws SQLException 
     */
    public PersistirDAO() throws SQLException{
        
        conexionBD = new ConexionBD();
        entityManager = conexionBD.crearConexion();
        
    }
    
    /**
     * Metodo que persiste una entidad generica a la base de datos
     * @param <Entidad>
     * @param entidad
     * @return Una entidad generica que a sido persistida
     */
    @Override
    public <Entidad> boolean persistirEntidad(Entidad entidad) throws PersistenciaException{
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(entidad);
            transaction.commit();
            return true;
        } catch (PersistenciaException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistenciaException("No se logró persistir correctamente\n" + e);
        }
    }
}