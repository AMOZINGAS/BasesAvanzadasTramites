package DAOS;

import excepciones.PersistenciaException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.LicenciaEntidad;
import entidades.PersonaEntidad;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * 
 * @author Amós Helí Olguín Quiróz
 */
public class LicenciaDAO extends PersistenciaException implements ILicenciaDAO {

    private final IConexionBD conexionBD = new ConexionBD();
    private EntityManager entityManager;

    /**
     * Constructor que inicializa la conexion
     */
    public LicenciaDAO() {
        try {
            entityManager = conexionBD.crearConexion();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Metodo que busca una licnencia por un id de tipo Long dado como parametro
     * @param id
     * @return la licencia encontrada, null en caso contrario
     */
    @Override
    public LicenciaEntidad buscarLicenciaId(Long id) {
        return entityManager.find(LicenciaEntidad.class, id);
    }
    
    /**
     * Metodo que agrega una referencia de persona en la licencia enviada como
     * parametro
     * @param personaEntidad
     * @param licenciaEntidad
     * @return regresa la licencia con la referencia de la persona
     */
    @Override
    public LicenciaEntidad agregarPersona(PersonaEntidad personaEntidad, LicenciaEntidad licenciaEntidad){
        licenciaEntidad.setPersona(personaEntidad);
        return licenciaEntidad;
    }

    /**
     * Metodo que actualiza la licencia enviada como parametro
     * @param licenciaEntidad
     * @return la licencia actualizada
     */
    @Override
    public LicenciaEntidad actualizarLicencia(LicenciaEntidad licenciaEntidad){
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(licenciaEntidad);
            transaction.commit();
            return licenciaEntidad;
        } catch (PersistenciaException ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            return null;
        }
    }

    /**
     * Metodo que busca una licnencia por un folio dado como parametro
     * @param folio
     * @return la licencia encontrada, null en caso contrario
     */
    @Override
    public LicenciaEntidad buscarLicenciaFolio(int folio){
        try{
            CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
            CriteriaQuery<LicenciaEntidad> consulta = criteria.createQuery(LicenciaEntidad.class);
            Root<LicenciaEntidad> root = consulta.from(LicenciaEntidad.class);
            consulta = consulta.select(root).where(criteria.equal(root.get("folio"), folio));
            TypedQuery<LicenciaEntidad> query = entityManager.createQuery(consulta);
            if(query==null){
                return null;
            }
            return query.getSingleResult();
        }catch(NoResultException nre){
            return null;
        }
    }
    
    /**
     * Metodo que genera una lista de licencia dependiendo de la persona dueña
     * de las mismas
     * @param personaEntidad
     * @return la lista de licencias de una persona
     */
    @Override
    public List<LicenciaEntidad> listaLicenciaPersona(PersonaEntidad personaEntidad) {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<LicenciaEntidad> consulta = criteria.createQuery(LicenciaEntidad.class);
        Root<LicenciaEntidad> root = consulta.from(LicenciaEntidad.class);
        consulta = consulta.select(root).where(criteria.equal(root.get("personaLicencia"), personaEntidad));
        TypedQuery<LicenciaEntidad> query = entityManager.createQuery(consulta);
        List<LicenciaEntidad> listaLicenciaPersona = query.getResultList();
        return listaLicenciaPersona;
    }
    
}
