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
 * Clase del tramite dao
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
     * @param id tipo long
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
     * Metodo que busca el tipo de tramite mediante el id del mismo
     * @param id tipo long
     * @return el tipo de tramite
     */
    @Override
    public String buscarTipoTramite(Long id) {
        
        LicenciaEntidad licencia = entityManager.find(LicenciaEntidad.class, id);
        PlacaEntidad placa = entityManager.find(PlacaEntidad.class, id);
        if(licencia!=null){
            
            return "LicenciaEntidad";
            
        }else if(placa!=null){
            
            return "PlacaEntidad";
            
        }else{
            
            JOptionPane.showMessageDialog(null, "No se encontro ningun tramite con ese id", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return null;
            
        }
    }
    
    
    
    /**
     * Metodo que genera una lista de tramites de una persona en un periodo de 
     * fechas dados como parametro
     * @param personaEntidad tipo persona entidad
     * @param fechaHasta tipo Calendar
     * @param fechaDesde tipo calnedar
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
     * @param personaEntidad tipo persona entidad
     * @param tipo tipo string
     * @param fechaHasta tipo calendar
     * @param fechaDesde tipo calendar
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
     * @param tipo tipo string
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

    /**
     * Metodo que genera una lista de tramites en generar en un periodo de 
     * fechas
     * @param fechaHasta tipo calendar
     * @param fechaDesde tipo calendar
     * @return la lista de los tramites coincidentes 
     */
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
     * Metodo que genera una lista de tramites en general de un nombre 
     * encontrado
     * @param nombre tipo string
     * @return la lista de los tramites coincidentes
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