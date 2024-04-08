package DAOS;

import entidades.PersonaEntidad;
import entidades.TramiteEntidad;
import java.util.Calendar;
import java.util.List;

/**
 * Clase de la Interfaz del tramite
 * @author Amós Helí Olguín Quiróz
 */
public interface ITramiteDAO {
    
    /**
     * Metodo que busca un tramite por su id dado como parametro
     * @param id tipo long
     * @return el tramite encontrado por id
     */
    public TramiteEntidad buscaTramitePorId(Long id);
    
    /**
     * Metodo que busca el tipo de tramite mediante el id del mismo
     * @param id tipo long
     * @return el tipo de tramite
     */
    public String buscarTipoTramite(Long id);
    
    /**
     * Metodo que genera una lista de tramites de una persona en un periodo de 
     * fechas dados como parametro
     * @param personaEntidad tipo persona entidad
     * @param fechaHasta tipo Calendar
     * @param desde tipo calnedar
     * @return la lista de los tramites coincidentes
     */
    public List<TramiteEntidad> listaTramiterPersonaFecha(PersonaEntidad personaEntidad, Calendar fechaHasta, Calendar desde);
    
    
    /**
     * Metodo que genera una lista de tramites en generar en un periodo de 
     * fechas
     * @param fechaHasta tipo calendar
     * @param fechaDesde tipo calendar
     * @return la lista de los tramites coincidentes 
     */
    public List<TramiteEntidad> listaTramiterFecha(Calendar fechaDesde, Calendar fechaHasta);
    
    /**
     * Metodo que genera una lista de tramites en general de un nombre 
     * encontrado
     * @param nombre tipo string
     * @return la lista de los tramites coincidentes
     */
    public List<TramiteEntidad> listaTramiterNombre(String nombre);
    
    /**
     * Metodo que genera una lista de todos los tramites existentes sin 
     * discriminar
     * @return lista de tramites
     */
    public List<TramiteEntidad> listaTramites();
    
    /**
     * Metod que genera una lista de tramites de una persona en un periodo de 
     * fehcas y de un tipo de tramite dados como parametros
     * @param personaEntidad tipo persona entidad
     * @param tipo tipo string
     * @param fechaHasta tipo calendar
     * @param desde tipo calendar
     * @return lista de las personas coincidentes
     */
    public List<TramiteEntidad> listaTramitePersonaTipoFecha(PersonaEntidad personaEntidad, String tipo, Calendar fechaHasta, Calendar desde);
    
    /**
     * Metod que genera una lista de los tramites coincidentes con el tipo 
     * dado como parametro
     * @param tipo tipo string
     * @return la lista de los tramites coincidentes con el tipo
     */
    public List<TramiteEntidad> listaTramite(String tipo);
    
}
