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
 * Clase del vehiculo dao
 * @author Amós Helí Olguín Quiróz
 */
public class VehiculoDAO implements IVehiculoDAO{
    
    private final IConexionBD conexionBD = new ConexionBD();
    private EntityManager entityManager;

    /**
     * Constructor que inicializa la conexion
     */
    public VehiculoDAO() {
        try {
            entityManager = conexionBD.crearConexion();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

   /**
     * Metodo que genera una lista de vehiculos de una persona enviada como
     * parametro
     * @param persona tipo persona entidad
     * @return lista de los vehiculos coincidentes
     */
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
    
    /**
     * Metodo que busca en una lista dada como parametro un vehiculo 
     * coincidente con el numero de serie dado como parametro
     * @param listaVehiculos tipo lista vehiculo entidad
     * @param numeroSerie tipo string
     * @return el vehiculo coincidente, null en caso contrario
     */
    @Override
    public VehiculoEntidad vehiculoPorPersona(List<VehiculoEntidad> listaVehiculos, String numeroSerie){
        for(VehiculoEntidad vehiculo: listaVehiculos){
            if(vehiculo.getNumSerie().equalsIgnoreCase(numeroSerie)){
                return vehiculo;
            }
        }
        return null;
    }
    
    /**
     * Metodo que actualiza a un vehiculo dado como parametro
     * @param vehicloEntidad tipo vehiculo entidad
     * @return el vehiculo actualizado
     */
    @Override
    public VehiculoEntidad actualizarVehiculo(VehiculoEntidad vehicloEntidad){
        
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(vehicloEntidad);
            transaction.commit();
            return vehicloEntidad;
        } catch (PersistenciaException ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            return null;
        }
    }
    
    /**
     * Metodo que agrega una referencia de persona a un vehiculo
     * @param vehiculoEntidad tipo vehiculo entidad
     * @param personaEntidad tipo persona entidad
     * @return el vehiculo con la referencia de la persona
     */
    @Override
    public VehiculoEntidad agregarPersona(VehiculoEntidad vehiculoEntidad, PersonaEntidad personaEntidad) {
        vehiculoEntidad.setPersona(personaEntidad);
        return vehiculoEntidad;
    }
    
    /**
     * Metodo que busca un vehiculo por un numero de serie dado como parametro
     * @param numeroSerie tipo string
     * @return el vehiculo coincidente, null en caso contrario
     */
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
    
    /**
     * Metodo que agrega una referencia de una placa a un vehiculo dado como
     * parametro
     * @param placaEntidad tipo placa entidad
     * @param vehiculoEntidad tipo vehiculo entidadf
     * @return el vehiculo con la referencia de la placa
     */
    @Override
    public VehiculoEntidad agregarPlaca(PlacaEntidad placaEntidad, VehiculoEntidad vehiculoEntidad){
        List<PlacaEntidad> listaPlacas = vehiculoEntidad.getPlacas();
        for(PlacaEntidad placa: listaPlacas){
            placa.setEstado(0);
        }
        listaPlacas.add(placaEntidad);
        vehiculoEntidad.setPlacas(listaPlacas);
        return vehiculoEntidad;
    }
}