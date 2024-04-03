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

/**
 * 
 * @author Amós Helí Olguín Quiróz
 */
public class PlacaDAO implements IPlacaDAO {

    private final IConexionBD conexionBD = new ConexionBD();
    private EntityManager entityManager;

    /**
     * Constructor por defecto que manda a llamar a iniciarConexion
     */
    public PlacaDAO() {
        iniciarConexion();
    }
    
    /**
     * Metodo que inicializa la conexion
     */
    public void iniciarConexion(){
        try {
            entityManager = conexionBD.crearConexion();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Metodo que agrega una referencia de un vehiculo a la placa
     * @param vehiculoEntidad
     * @param placaEntidad
     * @return la placa con la referencia del vehiculo
     */
    @Override
    public PlacaEntidad agregarVehiculo(VehiculoEntidad vehiculoEntidad, PlacaEntidad placaEntidad) {
        placaEntidad.setVehiculo(vehiculoEntidad);
        return placaEntidad;
    }

    /**
     * Metodo que actualiza una placa dada como parametro
     * @param placaEntidad
     * @return la placa actualizada
     */
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

    /**
     * Metodo que busca una placa por un numero de placa dado como parametro
     * @param numeroPlaca
     * @return la placa encontrada, null en caso contrario
     */
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

    /**
     * Metodo que genera una lista de placas de un vehiculo enviado como
     * parametro
     * @param vehiculoEntidad
     * @return lista de las placas del vehiculo
     */
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