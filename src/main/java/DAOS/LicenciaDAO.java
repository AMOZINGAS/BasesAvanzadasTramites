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
    public List<LicenciaEntidad> buscarLicenciaPorCURP(String curp) {

        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<LicenciaEntidad> query = criteriaBuilder.createQuery(LicenciaEntidad.class);
            Root<LicenciaEntidad> root = query.from(LicenciaEntidad.class);

            Join<LicenciaEntidad, PersonaEntidad> joinPersona = root.join("persona");

            query.select(root).where(criteriaBuilder.equal(joinPersona.get("curp"), curp));

            return entityManager.createQuery(query).getResultList();
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public List<LicenciaEntidad> buscarLicenciasPorNombre(String nombre) {

       try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<LicenciaEntidad> query = criteriaBuilder.createQuery(LicenciaEntidad.class);
            Root<LicenciaEntidad> root = query.from(LicenciaEntidad.class);

            Join<LicenciaEntidad, PersonaEntidad> joinPersona = root.join("persona");

            query.select(root).where(criteriaBuilder.equal(joinPersona.get("nombres"), nombre));

            return entityManager.createQuery(query).getResultList();
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public List<LicenciaEntidad> buscarLicenciasPorFechaNacimiento(Calendar fechaNacimiento) {

        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<LicenciaEntidad> query = criteriaBuilder.createQuery(LicenciaEntidad.class);
            Root<LicenciaEntidad> root = query.from(LicenciaEntidad.class);

            Join<LicenciaEntidad, PersonaEntidad> joinPersona = root.join("persona");

            query.select(root).where(criteriaBuilder.equal(joinPersona.get("fechaNacimiento"), fechaNacimiento));

            return entityManager.createQuery(query).getResultList();
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public List<LicenciaEntidad> obtenerTodasLasLicencias() {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<LicenciaEntidad> query = cb.createQuery(LicenciaEntidad.class);
            Root<LicenciaEntidad> root = query.from(LicenciaEntidad.class);

            query.select(root);

            return entityManager.createQuery(query).getResultList();

        } catch (PersistenciaException es) {
            es.printStackTrace();
        }
        return null;
    }

    @Override
    public void guardarLicenciaBD(LicenciaEntidad licencia) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(licencia);
            entityManager.getTransaction().commit();

        } catch (PersistenciaException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
