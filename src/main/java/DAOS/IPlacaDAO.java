package DAOS;

import entidades.PlacaEntidad;
import entidades.VehiculoEntidad;
import java.util.List;

/**
 * Clase de la Interfaz de la placa
 * @author Amós Helí Olguín Quiróz
 */
public interface IPlacaDAO {
    
    /**
     * Metodo que agrega una referencia de un vehiculo a la placa
     * @param vehiculoEntidad
     * @param placaEntidad
     * @return la placa con la referencia del vehiculo
     */
    public PlacaEntidad agregarVehiculo(VehiculoEntidad vehiculoEntidad, PlacaEntidad placaEntidad);
    
    /**
     * Metodo que actualiza una placa dada como parametro
     * @param placaEntidad
     * @return la placa actualizada
     */
    public PlacaEntidad actualizarPlaca(PlacaEntidad placaEntidad);
    
    /**
     * Metodo que busca una placa por un numero de placa dado como parametro
     * @param numeroPlaca
     * @return la placa encontrada, null en caso contrario
     */
    public PlacaEntidad buscarPorNumeroPlaca(String numeroPlaca);
    
    /**
     * Metodo que genera una lista de placas de un vehiculo enviado como
     * parametro
     * @param vehiculoEntidad
     * @return lista de las placas del vehiculo
     */
    public List<PlacaEntidad> listaPlacasVehiculo(VehiculoEntidad vehiculoEntidad);
    
}
