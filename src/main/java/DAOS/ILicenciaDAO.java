package DAOS;

import entidades.LicenciaEntidad;
import entidades.PersonaEntidad;
import java.util.List;
/**
 * Clase de la Interfaz de la licencia
 * @author Amós Helí Olguín Quiróz
 */
public interface ILicenciaDAO {
    
    /**
     * Metodo que agrega una referencia de persona en la licencia enviada como
     * parametro
     * @param personaEntidad tipo persona entidad
     * @param licenciaEntidad tipo licencia entidad
     * @return regresa la licencia con la referencia de la persona
     */
    public LicenciaEntidad agregarPersona(PersonaEntidad personaEntidad, LicenciaEntidad licenciaEntidad);
    
    /**
     * Metodo que actualiza la licencia enviada como parametro
     * @param licenciaEntidad tipo licencia entidad
     * @return la licencia actualizada
     */
    public LicenciaEntidad actualizarLicencia(LicenciaEntidad licenciaEntidad);
    
    /**
     * Metodo que busca una licnencia por un folio dado como parametro
     * @param folio tipo string
     * @return la licencia encontrada, null en caso contrario
     */
    public LicenciaEntidad buscarLicenciaFolio(int folio);

    /**
     * Metodo que busca una licnencia por un id de tipo Long dado como parametro
     * @param id tipo long
     * @return la licencia encontrada, null en caso contrario
     */
    public LicenciaEntidad buscarLicenciaId(Long id);
    
    /**
     * Metodo que genera una lista de licencia dependiendo de la persona dueña
     * de las mismas
     * @param personaEntidad tipo persona entidad
     * @return la lista de licencias de una persona
     */
    public List<LicenciaEntidad> listaLicenciaPersona(PersonaEntidad personaEntidad);
    
}
