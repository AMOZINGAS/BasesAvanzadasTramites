package DAOS;

import entidades.PersonaEntidad;
import entidades.TramiteEntidad;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Amós Helí Olguín Quiróz
 */
public interface ITramiteDAO {
    
    /**
     * Metodo que genera una lista de tramites de una persona en un periodo de 
     * fechas dados como parametro
     * @param personaEntidad
     * @param fechaHasta
     * @param desde
     * @return la lista de los tramites coincidentes
     */
    public List<TramiteEntidad> listaTramiterPersonaFecha(PersonaEntidad personaEntidad, Calendar fechaHasta, Calendar desde);
    
    /**
     * Metod que genera una lista de tramites de una persona en un periodo de 
     * fehcas y de un tipo de tramite dados como parametros
     * @param personaEntidad
     * @param tipo
     * @param fechaHasta
     * @param desde
     * @return lista de las personas coincidentes
     */
    public List<TramiteEntidad> listaTramitePersonaTipoFecha(PersonaEntidad personaEntidad, String tipo, Calendar fechaHasta, Calendar desde);
    
    /**
     * Metod que genera una lista de los tramites coincidentes con el tipo 
     * dado como parametro
     * @param tipo
     * @return la lista de los tramites coincidentes con el tipo
     */
    public List<TramiteEntidad> listaTramite(String tipo);
    
}
