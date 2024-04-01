package DAOS;

//import Entidades.LicenciaEntidad;
//import Entidades.PersonaEntidad;
import DAOS.IConexionBD;
import excepciones.PersistenciaException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import DAOS.ILicenciaDAO;
import entidades.LicenciaEntidad;
import entidades.PersonaEntidad;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class LicenciaDAO extends PersistenciaException implements ILicenciaDAO {

    private final IConexionBD conexionBD = new ConexionBD();
    private EntityManager entityManager;

    public LicenciaDAO() {
        try {

            entityManager = conexionBD.crearConexion();
        } catch (SQLException ex) {

            ex.printStackTrace();

        }
    }

    @Override
    public LicenciaEntidad agregarPersona(PersonaEntidad personaEntidad, LicenciaEntidad licenciaEntidad){
        
        licenciaEntidad.setPersona(personaEntidad);
        return licenciaEntidad;
    
    }

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
