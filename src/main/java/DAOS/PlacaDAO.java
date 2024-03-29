package DAOS;

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

public class PlacaDAO implements IPlacaDAO {

    private final IConexionBD conexionBD = new ConexionBD();
    private EntityManager entityManager;

    public PlacaDAO() {
        iniciarConexion();
    }
    
    public void iniciarConexion(){
        
        try {

            entityManager = conexionBD.crearConexion();
        } catch (SQLException ex) {

            ex.printStackTrace();

        }
        
    }
    
    @Override
    public PlacaEntidad agregarVehiculo(VehiculoEntidad vehiculoEntidad, PlacaEntidad placaEntidad) {
    
        placaEntidad.setVehiculo(vehiculoEntidad);
        return placaEntidad;
    
    }

    @Override
    public PlacaEntidad actualizarPlaca(PlacaEntidad placaEntidad) {
    
        EntityTransaction transaction = null;
        
        try {
            
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(placaEntidad);
            transaction.commit();
            return placaEntidad;
            
        } catch (PersistenciaException ex) {
            
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            
            return null;
            
        }
        
    }

    @Override
    public PlacaEntidad buscarPorNumeroPlaca(String numeroPlaca) {
    
        try{
            CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
            CriteriaQuery<PlacaEntidad> consulta = criteria.createQuery(PlacaEntidad.class);
            Root<PlacaEntidad> root = consulta.from(PlacaEntidad.class);
            consulta = consulta.select(root).where(criteria.equal(root.get("numeroPlaca"), numeroPlaca));
            TypedQuery<PlacaEntidad> query = entityManager.createQuery(consulta);
            return query.getSingleResult();
        }catch(NoResultException nre){
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, nre);
            return null;
        }
    
    }

    @Override
    public List<PlacaEntidad> listaPlacasVehiculo(VehiculoEntidad vehiculoEntidad) {
    
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<PlacaEntidad> consulta = criteria.createQuery(PlacaEntidad.class);
        Root<PlacaEntidad> root = consulta.from(PlacaEntidad.class);
        consulta = consulta.select(root).where(criteria.equal(root.get("vehiculo"), vehiculoEntidad));
        TypedQuery<PlacaEntidad> query = entityManager.createQuery(consulta);
        List<PlacaEntidad> listaPlacasVehiculo = query.getResultList();
        
        return listaPlacasVehiculo;
        
    }
    
    
    
    

}
