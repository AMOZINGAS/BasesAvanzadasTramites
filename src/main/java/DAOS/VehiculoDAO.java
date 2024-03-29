/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import entidades.PersonaEntidad;
import entidades.PlacaEntidad;
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
 *
 * @author PC
 */
public class VehiculoDAO implements IVehiculoDAO{
    
    private final IConexionBD conexionBD = new ConexionBD();
    private EntityManager entityManager;

    public VehiculoDAO() {
        try {

            entityManager = conexionBD.crearConexion();
        } catch (SQLException ex) {

            ex.printStackTrace();

        }
    }

    @Override
    public List<VehiculoEntidad> listaVehiculoPersona(PersonaEntidad persona) {
    
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<VehiculoEntidad> consulta = criteria.createQuery(VehiculoEntidad.class);
        Root<VehiculoEntidad> root = consulta.from(VehiculoEntidad.class);
        consulta = consulta.select(root).where(criteria.equal(root.get("persona"), persona));
        TypedQuery<VehiculoEntidad> query = entityManager.createQuery(consulta);
        List<VehiculoEntidad> listaVehiculoPersona = query.getResultList();
        
        return listaVehiculoPersona;
        
    }
    
    @Override
    public VehiculoEntidad vehiculoPorPersona(List<VehiculoEntidad> listaVehiculos, String numeroSerie){
        
        for(int i = 0; i < listaVehiculos.size(); i ++){
            
            if(listaVehiculos.get(i).getNumSerie().equalsIgnoreCase(numeroSerie)){
                
                return listaVehiculos.get(i);
                
            }
            
        }
        
        return null;
        
    }
    
    @Override
    public VehiculoEntidad actualizarVehiculo(VehiculoEntidad vehiculoEntidad){
        
        EntityTransaction transaction = null;
        
        try {
            
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(vehiculoEntidad);
            transaction.commit();
            return vehiculoEntidad;
            
        } catch (PersistenciaException ex) {
            
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            
            return null;
            
        }
        
    }
    
    @Override
    public VehiculoEntidad agregarPersona(VehiculoEntidad vehiculoEntidad, PersonaEntidad personaEntidad) {
    
        vehiculoEntidad.setPersona(personaEntidad);
        return vehiculoEntidad;
        
    }
    
    @Override
    public VehiculoEntidad buscarPorNumeroSerie(String numeroSerie){
        
        try{
            CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
            CriteriaQuery<VehiculoEntidad> consulta = criteria.createQuery(VehiculoEntidad.class);
            Root<VehiculoEntidad> root = consulta.from(VehiculoEntidad.class);
            consulta = consulta.select(root).where(criteria.equal(root.get("numSerie"), numeroSerie));
            TypedQuery<VehiculoEntidad> query = entityManager.createQuery(consulta);
            return query.getSingleResult();
        }catch(NoResultException nre){
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, nre);
            return null;
        }
        
    }
    
    @Override
    public VehiculoEntidad agregarPlaca(PlacaEntidad placaEntidad, VehiculoEntidad vehiculoEntidad){
        
        List<PlacaEntidad> listaPlacas = vehiculoEntidad.getPlacas();
        listaPlacas.add(placaEntidad);
        vehiculoEntidad.setPlacas(listaPlacas);
        return vehiculoEntidad;
        
    }
    
}
