package DAOS;

import entidades.PersonaEntidad;
import entidades.PlacaEntidad;
import entidades.VehiculoEntidad;
import java.util.List;

/**
 * Clase de la Interfaz del vehiculo
 * @author Amós Helí Olguín Quiróz
 */
public interface IVehiculoDAO {
    
    /**
     * Metodo que agrega una referencia de persona a un vehiculo
     * @param vehiculoEntidad
     * @param personaEntidad
     * @return el vehiculo con la referencia de la persona
     */
    public VehiculoEntidad agregarPersona(VehiculoEntidad vehiculoEntidad, PersonaEntidad personaEntidad);
    
    /**
     * Metodo que busca un vehiculo por un numero de serie dado como parametro
     * @param numeroSerie
     * @return el vehiculo coincidente, null en caso contrario
     */
    public VehiculoEntidad buscarPorNumeroSerie(String numeroSerie);
    
    /**
     * Metodo que genera una lista de vehiculos de una persona enviada como
     * parametro
     * @param persona
     * @return lista de los vehiculos coincidentes
     */
    public List<VehiculoEntidad> listaVehiculoPersona(PersonaEntidad persona);
    
    /**
     * Metodo que agrega una referencia de una placa a un vehiculo dado como
     * parametro
     * @param placaEntidad
     * @param vehiculoEntidad
     * @return el vehiculo con la referencia de la placa
     */
    public VehiculoEntidad agregarPlaca(PlacaEntidad placaEntidad, VehiculoEntidad vehiculoEntidad);
    
    /**
     * Metodo que busca en una lista dada como parametro un vehiculo 
     * coincidente con el numero de serie dado como parametro
     * @param listaVehiculos
     * @param numeroSerie
     * @return el vehiculo coincidente, null en caso contrario
     */
    public VehiculoEntidad vehiculoPorPersona(List<VehiculoEntidad> listaVehiculos, String numeroSerie);
    
    /**
     * Metodo que actualiza a un vehiculo dado como parametro
     * @param vehicloEntidad
     * @return el vehiculo actualizado
     */
    public VehiculoEntidad actualizarVehiculo(VehiculoEntidad vehicloEntidad);
    
}
