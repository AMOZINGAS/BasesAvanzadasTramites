package DAOS;

import entidades.PersonaEntidad;
import entidades.TramiteEntidad;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Amós Helí Olguín Quiróz
 */
public class TramiteDAO implements ITramiteDAO{

    private final IConexionBD conexionBD = new ConexionBD();
    private EntityManager entityManager;

    /**
     * Constructor que inicializa la conexion
     */
    public TramiteDAO() {
        try {
            entityManager = conexionBD.crearConexion();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Metodo que genera una lista de tramites de una persona en un periodo de 
     * fechas dados como parametro
     * @param personaEntidad
     * @param fechaHasta
     * @param desde
     * @return la lista de los tramites coincidentes
     */
    @Override
    public List<TramiteEntidad> listaTramiterPersonaFecha(PersonaEntidad personaEntidad, Calendar fechaHasta, Calendar fechaDesde) {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<TramiteEntidad> consulta = criteria.createQuery(TramiteEntidad.class);
        Root<TramiteEntidad> root = consulta.from(TramiteEntidad.class);
        Predicate condiciones = criteria.and(
        criteria.equal(root.get("persona"), personaEntidad),
        criteria.greaterThanOrEqualTo(root.get("fechaTramite"), fechaDesde),
        criteria.lessThanOrEqualTo(root.get("fechaTramite"), fechaHasta)
        );
        consulta = consulta.select(root).where(condiciones);
        TypedQuery<TramiteEntidad> query = entityManager.createQuery(consulta);
        List<TramiteEntidad> listaTramitesPersona = query.getResultList();
        return listaTramitesPersona;
    }

    /**
     * Metod que genera una lista de tramites de una persona en un periodo de 
     * fehcas y de un tipo de tramite dados como parametros
     * @param personaEntidad
     * @param tipo
     * @param fechaHasta
     * @param desde
     * @return lista de las personas coincidentes
     */
    @Override
    public List<TramiteEntidad> listaTramitePersonaTipoFecha(PersonaEntidad personaEntidad, String tipo, Calendar fechaHasta, Calendar fechaDesde) {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<TramiteEntidad> consulta = criteria.createQuery(TramiteEntidad.class);
        Root<TramiteEntidad> root = consulta.from(TramiteEntidad.class);
        Predicate condiciones = criteria.and(
        criteria.equal(root.get("persona"), personaEntidad),
        criteria.like(root.get("tipo"), "%" + tipo + "%"),
        criteria.greaterThanOrEqualTo(root.get("fechaTramite"), fechaDesde),
        criteria.lessThanOrEqualTo(root.get("fechaTramite"), fechaHasta)
        );
        consulta = consulta.select(root).where(condiciones);
        TypedQuery<TramiteEntidad> query = entityManager.createQuery(consulta);
        List<TramiteEntidad> listaTramitesPersona = query.getResultList();
        return listaTramitesPersona;
    }
    
    /**
     * Metod que genera una lista de los tramites coincidentes con el tipo 
     * dado como parametro
     * @param tipo
     * @return la lista de los tramites coincidentes con el tipo
     */
    @Override
    public List<TramiteEntidad> listaTramite(String tipo) {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<TramiteEntidad> consulta = criteria.createQuery(TramiteEntidad.class);
        Root<TramiteEntidad> root = consulta.from(TramiteEntidad.class);
        consulta = consulta.select(root).where(criteria.like(root.get("tipo"), "%" + tipo + "%"));
        TypedQuery<TramiteEntidad> query = entityManager.createQuery(consulta);
        List<TramiteEntidad> listaTramitesPersona = query.getResultList();
        return listaTramitesPersona;
    }
}