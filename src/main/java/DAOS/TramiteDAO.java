package DAOS;

import entidades.LicenciaEntidad;
import entidades.PersonaEntidad;
import entidades.PlacaEntidad;
import entidades.TramiteEntidad;
import excepciones.PersistenciaException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

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
     * Metodo que busca un tramite por su id dado como parametro
     * @param id
     * @return el tramite encontrado por id
     */
    @Override
    public TramiteEntidad buscaTramitePorId(Long id){
        return entityManager.find(TramiteEntidad.class, id);
        
    }
    
    /**
     * Metodo que genera una lista de todos los tramites existentes sin 
     * discriminar
     * @return lista de tramites
     */
    @Override
    public List<TramiteEntidad> listaTramites() {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<TramiteEntidad> consulta = criteria.createQuery(TramiteEntidad.class);
        Root<TramiteEntidad> root = consulta.from(TramiteEntidad.class);
        TypedQuery<TramiteEntidad> query = entityManager.createQuery(consulta);
        List<TramiteEntidad> listaTramites = query.getResultList();
        return listaTramites;
    }

    /**
     * metod que busca el tipo de tramite por el id del mismo
     * @param id
     * @return el tipo del tramite encontrado
     */
    @Override
    public String buscarTipoTramite(Long id) {
        try{
            entityManager.find(LicenciaEntidad.class, id);
            return "LicenciaEntidad";
        }catch(PersistenciaException pex){
            try{
                entityManager.find(PlacaEntidad.class, id);
                return "PlacaEntidad";
            }catch(PersistenciaException pex2){
                JOptionPane.showMessageDialog(null, "No se encontro ningun tramite con ese id", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                return null;
            }
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
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TramiteEntidad> criteriaQuery = criteriaBuilder.createQuery(TramiteEntidad.class);
        Root<TramiteEntidad> tramiteRoot = criteriaQuery.from(TramiteEntidad.class);
        String tipoLowerCase = tipo.toLowerCase();
        Predicate predicate = criteriaBuilder.equal(criteriaBuilder.lower(tramiteRoot.get("tipo")), tipoLowerCase);
        criteriaQuery.select(tramiteRoot).where(predicate);
        TypedQuery<TramiteEntidad> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<TramiteEntidad> listaTramiterFecha(Calendar fechaDesde, Calendar fechaHasta) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TramiteEntidad> criteriaQuery = criteriaBuilder.createQuery(TramiteEntidad.class);
        Root<TramiteEntidad> tramiteRoot = criteriaQuery.from(TramiteEntidad.class);
        Predicate condiciones = criteriaBuilder.and(
        criteriaBuilder.greaterThanOrEqualTo(tramiteRoot.get("fechaTramite"), fechaDesde),
        criteriaBuilder.lessThanOrEqualTo(tramiteRoot.get("fechaTramite"), fechaHasta)
        );
        criteriaQuery.select(tramiteRoot).where(condiciones);
        TypedQuery<TramiteEntidad> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * metodo que busca la lista de tramites que coincidan con el nombre de la
     * persona dado como parametro
     * @param nombre
     * @return 
     */
    @Override
    public List<TramiteEntidad> listaTramiterNombre(String nombre) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TramiteEntidad> criteriaQuery = criteriaBuilder.createQuery(TramiteEntidad.class);
        Root<TramiteEntidad> tramiteRoot = criteriaQuery.from(TramiteEntidad.class);
        IPersonaDAO personaDAO = new PersonaDAO();
        List<PersonaEntidad> listaPersonas = personaDAO.buscarPorNombre(nombre);
        criteriaQuery.select(tramiteRoot).where(tramiteRoot.get("persona").in(listaPersonas));
        TypedQuery<TramiteEntidad> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
    
}