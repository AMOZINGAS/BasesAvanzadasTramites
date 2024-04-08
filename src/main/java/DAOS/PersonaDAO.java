package DAOS;

import entidades.LicenciaEntidad;
import entidades.PersonaEntidad;
import entidades.VehiculoEntidad;
import excepciones.PersistenciaException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Clase de la persona dao
 * @author Amós Helí Olguín Quiróz
 */
public class PersonaDAO implements IPersonaDAO {

    private final IConexionBD conexionBD = new ConexionBD();
    private EntityManager entityManager;

    /**
     * Constructor que inicializa la conexion
     */
    public PersonaDAO() {
        try {
            entityManager = conexionBD.crearConexion();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Metodo que agrega a una persona a la base de datos
     * @param personaEntidad tipo persona entidad
     * @return la persona agregada
     */
    @Override
    public PersonaEntidad agregarPersona(PersonaEntidad personaEntidad) throws PersistenciaException{
        try {
            IPersistirDAO persistirDAO = new PersistirDAO();
            persistirDAO.persistirEntidad(personaEntidad);
            return personaEntidad;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Metodo que busca a una persona por el id enviado como parametro
     * @param id tipo long
     * @return la persona encontrada, null en caso contrario
     */
    @Override
    public PersonaEntidad buscarPorId(Long id) {
            try{
                CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
                CriteriaQuery<PersonaEntidad> consulta = criteria.createQuery(PersonaEntidad.class);
                Root<PersonaEntidad> root = consulta.from(PersonaEntidad.class);
                consulta = consulta.select(root).where(criteria.equal(root.get("idPersona"), id));
                TypedQuery<PersonaEntidad> query = entityManager.createQuery(consulta);
                return query.getSingleResult();
            }catch(NoResultException nre){
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, nre);
                return null;
            }
    }

    /**
     * Metodo que genera una lista de personas que coincidan con el nombre dado
     * como parametro
     * @param nombre tipo string
     * @return lista de personas encontradas
     */
    @Override
    public List<PersonaEntidad> buscarPorNombre(String nombre) {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonaEntidad> consulta = criteria.createQuery(PersonaEntidad.class);
        Root<PersonaEntidad> root = consulta.from(PersonaEntidad.class);
        consulta = consulta.select(root).where(criteria.like(root.get("nombres"), "%" + nombre + "%"));
        TypedQuery<PersonaEntidad> query = entityManager.createQuery(consulta);
        List<PersonaEntidad> listaPersonasPorNombre = query.getResultList();
        return listaPersonasPorNombre;
    }
    
    /**
     * Metodo que genera una lista de persona por nombre y una curp dados 
     * como parametro
     * @param nombre tipo string
     * @param curp tipo string
     * @return una lista de personas encontradas
     */
    @Override
    public List<PersonaEntidad> buscarPorNombreCurp(String nombre, String curp) {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonaEntidad> consulta = criteria.createQuery(PersonaEntidad.class);
        Root<PersonaEntidad> root = consulta.from(PersonaEntidad.class);
        consulta = consulta.select(root).where(criteria.like(root.get("nombres"), "%" + nombre + "%"));
        consulta = consulta.select(root).where(criteria.like(root.get("curp"), "%" + curp + "%"));
        TypedQuery<PersonaEntidad> query = entityManager.createQuery(consulta);
        List<PersonaEntidad> listaPersonasPorNombre = query.getResultList();
        return listaPersonasPorNombre;
    }
    
    /**
     * Metodo que genera la lista completa de personas que están registradas
     * @return lista de personas encontradas
     */
    @Override
    public List<PersonaEntidad> listaPersonas() {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonaEntidad> consulta = criteria.createQuery(PersonaEntidad.class);
        Root<PersonaEntidad> root = consulta.from(PersonaEntidad.class);
        TypedQuery<PersonaEntidad> query = entityManager.createQuery(consulta);
        List<PersonaEntidad> listaPersonas = query.getResultList();
        return listaPersonas;
    }

    /**
     * Metodo que actualiza a la persona enviada como parametro
     * @param personaEntidad tipo persona entidad
     * @return la persona que se actualizó
     */
    @Override
    public PersonaEntidad actualizarPersona(PersonaEntidad personaEntidad){
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(personaEntidad);
            transaction.commit();
            return personaEntidad;
        } catch (PersistenciaException ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            return null;
        }
    }
    
    /**
     * Metodo que agrega una referencia de un vehiculo a una personas enviada
     * como parametro
     * @param vehiculoEntidad tipo vehiculo entidad
     * @param personEntidad tipo persona entidad
     * @return la persona con la referencia del vehiculo
     */
    @Override
    public PersonaEntidad agregarVehiculo(VehiculoEntidad vehiculoEntidad, PersonaEntidad personEntidad) {
        List<VehiculoEntidad> listaVehiculos = personEntidad.getVehiculo();
        listaVehiculos.add(vehiculoEntidad);
        personEntidad.setVehiculo(listaVehiculos);
        return personEntidad;
    }

    /**
     * Metodo que busca una persona por una curp dada como parametro
     * @param curp tipo string
     * @return la persona encontrada, null en caso contrario
     */
    @Override
    public PersonaEntidad buscarPorCurp(String curp) {
        try{
                CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
                CriteriaQuery<PersonaEntidad> consulta = criteria.createQuery(PersonaEntidad.class);
                Root<PersonaEntidad> root = consulta.from(PersonaEntidad.class);
                consulta = consulta.select(root).where(criteria.equal(root.get("curp"), curp));
                TypedQuery<PersonaEntidad> query = entityManager.createQuery(consulta);
                return query.getSingleResult();
            }catch(NoResultException nre){
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, nre);
                return null;
            }
    }
    
    /**
     * Metodo que agrega una referencia de una licencia a una persona dada
     * como parametro
     * @param licenciaEntidad tipo licencia entidad
     * @param personEntidad tipo persona entidad
     * @return la persona con la referencia de la licencia
     */
    @Override
    public PersonaEntidad agregarLicencia(LicenciaEntidad licenciaEntidad, PersonaEntidad personEntidad) {
        List<LicenciaEntidad> listaLicencias = personEntidad.getLicencia();
        for(int i = 0; i < listaLicencias.size(); i ++){
            listaLicencias.get(i).setEstado(0);
        }
        listaLicencias.add(licenciaEntidad);
        personEntidad.setLicencia(listaLicencias);
        return personEntidad;
        
    }    
}