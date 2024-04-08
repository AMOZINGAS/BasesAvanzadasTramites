package DAOS;

import entidades.LicenciaEntidad;
import entidades.PersonaEntidad;
import entidades.VehiculoEntidad;
import java.util.List;

/**
 * Clase de la Interfaz de la persona
 * @author Amós Helí Olguín Quiróz
 */
public interface IPersonaDAO {
    
    /**
     * Metodo que regresa la clave de encriptacion
     * @return clave
     */
    public int getClave();
    
    /**
     * metodo que encripta un texto con una clave
     * @param texto tipo string
     * @param clave tipo int
     * @return el nombre encriptado
     */
    public String encriptar(String texto, int clave);
    
    /**
     * Metodo que desencripta los nombre
     * @param textoEncriptado tipo string
     * @param clave tipo int
     * @return el texto desencriptado
     */
    public String desencriptar(String textoEncriptado, int clave);
    
    /**
     * Metodo que agrega a una persona a la base de datos
     * @param personaEntidad tipo persona entidad
     * @return la persona agregada
     */
    public PersonaEntidad agregarPersona(PersonaEntidad personaEntidad);
    
    /**
     * Metodo que actualiza a la persona enviada como parametro
     * @param personaEntidad tipo persona entidad
     * @return la persona que se actualizó
     */
    public PersonaEntidad actualizarPersona(PersonaEntidad personaEntidad);
    
    /**
     * Metodo que busca a una persona por el id enviado como parametro
     * @param id tipo long
     * @return la persona encontrada, null en caso contrario
     */
    public PersonaEntidad buscarPorId(Long id);
    
    /**
     * Metodo que busca una persona por una curp dada como parametro
     * @param curp tipo string
     * @return la persona encontrada, null en caso contrario
     */
    public PersonaEntidad buscarPorCurp(String curp);
    
    /**
     * Metodo que genera una lista de persona por nombre y una curp dados 
     * como parametro
     * @param nombre tipo string
     * @param curp tipo string
     * @return una lista de personas encontradas
     */
    public List<PersonaEntidad> buscarPorNombreCurp(String nombre, String curp);
    
    /**
     * Metodo que genera una lista de personas que coincidan con el nombre dado
     * como parametro
     * @param nombre tipo string
     * @return lista de personas encontradas
     */
    public List<PersonaEntidad> buscarPorNombre(String nombre);
    
    /**
     * Metodo que genera la lista completa de personas que están registradas
     * @return lista de personas encontradas
     */
    public List<PersonaEntidad> listaPersonas();
    
    /**
     * Metodo que agrega una referencia de un vehiculo a una personas enviada
     * como parametro
     * @param vehiculoEntidad tipo vehiculo entidad
     * @param personEntidad tipo persona entidad
     * @return la persona con la referencia del vehiculo
     */
    public PersonaEntidad agregarVehiculo(VehiculoEntidad vehiculoEntidad, PersonaEntidad personEntidad);
    
    /**
     * Metodo que agrega una referencia de una licencia a una persona dada
     * como parametro
     * @param licenciaEntidad tipo licencia entidad
     * @param personEntidad tipo persona entidad
     * @return la persona con la referencia de la licencia
     */
    public PersonaEntidad agregarLicencia(LicenciaEntidad licenciaEntidad, PersonaEntidad personEntidad);
    
}
