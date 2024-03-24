/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

//import Entidades.LicenciaEntidad;
//import Entidades.PersonaEntidad;
//import Entidades.VehiculoEntidad;
import entidades.LicenciaEntidad;
import entidades.PersonaEntidad;
import entidades.VehiculoEntidad;
import excepciones.PersistenciaException;
import java.sql.SQLException;
import java.util.ArrayList;
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
 *
 * @author PC
 */
public class PersonaDAO implements IPersonaDAO {

    private final IConexionBD conexionBD = new ConexionBD();
    private EntityManager entityManager;

    public PersonaDAO() {
        try {

            entityManager = conexionBD.crearConexion();
        } catch (SQLException ex) {

            ex.printStackTrace();

        }
    }

    /**
     * Metodo que agrega una persona a la base de datos
     * @param personaEntidad
     * @return la entidad persistida
     * @throws PersistenciaException 
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
     * Metodo que regresa la entidad que se encuentre mediante el id
     * @param id
     * @return la entidad encontrada, null en caso contrario
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
     * Metodo que regresa la lista de las personas que coincidan con el 
     * nombre dado como parametro
     * @param nombre
     * @return la lilsta de las personas que coincidan con el nombre
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
     * Metodo que regresa la lista de todas las personas en la base de datos
     * @return llista de personas en la base de datos
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
     * Metodo que agrega vehiculo a persona especifica
     * @param vehiculoEntidad
     * @param personEntidad
     * @return personaEntidad
     */
    @Override
    public PersonaEntidad agregarVehiculo(VehiculoEntidad vehiculoEntidad, PersonaEntidad personEntidad) {
        
        List<VehiculoEntidad> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(vehiculoEntidad);
        vehiculoEntidad.setPersona(personEntidad);
        personEntidad.setVehiculo(listaVehiculos);
        actualizarPersona(personEntidad);
        return personEntidad;
        
    }

    /**
     * Metodo que agrega licencia nueva a persona
     * @param licenciaEntidad
     * @param personEntidad
     * @return personaentidad
     */
    @Override
    public PersonaEntidad agregarLicencia(LicenciaEntidad licenciaEntidad, PersonaEntidad personEntidad) {
    
        return null;
        
    }
    
    
    
    
    
    

}
