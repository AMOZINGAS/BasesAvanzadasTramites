/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Entidades.PersonaEntidad;
import excepciones.PersistenciaException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
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

    @Override
    public PersonaEntidad agregarPersona(PersonaEntidad personaEntidad) throws PersistenciaException{

        try {
            
            IPersistirDAO persistirDAO = new PersistirDAO();
            boolean respuesta = persistirDAO.persistirEntidad(personaEntidad);
            return personaEntidad;
            
        } catch (SQLException ex) {
            
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }

    }

    @Override
    public PersonaEntidad buscarPorId(Long id) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<PersonaEntidad> query = criteriaBuilder.createQuery(PersonaEntidad.class);
            Root<PersonaEntidad> root = query.from(PersonaEntidad.class);

            query.select(root).where(criteriaBuilder.equal(root.get("idPersona"), id));

            return entityManager.createQuery(query).getSingleResult();
        } catch (PersistenciaException ex) {

            ex.printStackTrace();

        }
        return null;

    }

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

    @Override
    public List<PersonaEntidad> listaPersonas() {
    
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonaEntidad> consulta = criteria.createQuery(PersonaEntidad.class);
        Root<PersonaEntidad> root = consulta.from(PersonaEntidad.class);
        TypedQuery<PersonaEntidad> query = entityManager.createQuery(consulta);
        List<PersonaEntidad> listaPersonas = query.getResultList();
        
        return listaPersonas;
        
    }
    
    
    
    

}
