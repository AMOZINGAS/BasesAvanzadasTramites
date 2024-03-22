package DAOS;

//import Entidades.LicenciaEntidad;
//import Entidades.PersonaEntidad;
//import Entidades.PlacaEntidad;
//import Entidades.VehiculoEntidad;
import DAOS.IConexionBD;
import excepciones.PersistenciaException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import DAOS.IPlacaDAO;
import entidades.LicenciaEntidad;
import entidades.PersonaEntidad;
import entidades.PlacaEntidad;
import entidades.VehiculoEntidad;

public class PlacaDAO implements IPlacaDAO {

    private EntityManager em;
    private IConexionBD conexion;

    public PlacaDAO() {
        try {
            em = conexion.crearConexion();
        } catch (SQLException ex) {

        }
    }

    @Override
    public void guardarPlaca(PlacaEntidad placa) {
        try {
            em.getTransaction().begin();
            em.persist(placa);
            em.getTransaction().commit();

        } catch (PersistenciaException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

        } finally {
            em.close();
        }

    }

    @Override
    public PlacaEntidad buscarPlacaPorNumero(String numero) {
        CriteriaBuilder criteria = em.getCriteriaBuilder();
        CriteriaQuery<PlacaEntidad> query = criteria.createQuery(PlacaEntidad.class);
        Root<PlacaEntidad> root = query.from(PlacaEntidad.class);

        query.select(root).where(criteria.equal(root.get("numeroPlaca"), numero));

        return em.createQuery(query).getSingleResult();

    }

    @Override
    public List<PlacaEntidad> buscarPlacasPorAutomovil(VehiculoEntidad vehiculo) {
try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<PlacaEntidad> query = criteriaBuilder.createQuery(PlacaEntidad.class);
            Root<PlacaEntidad> root = query.from(PlacaEntidad.class);

            Join<LicenciaEntidad, PersonaEntidad> joinPersona = root.join("idVehiculo");

            query.select(root).where(criteriaBuilder.equal(joinPersona.get("idVehiculo"), vehiculo.getIdVehiculo()));

            return em.createQuery(query).getResultList();
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<PlacaEntidad> obtenerTodasLasPlacas() {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<PlacaEntidad> query = cb.createQuery(PlacaEntidad.class);
            Root<PlacaEntidad> root = query.from(PlacaEntidad.class);

            query.select(root);

            return em.createQuery(query).getResultList();

        } catch (PersistenciaException es) {
            es.printStackTrace();
        }
        return null;

    }

}
