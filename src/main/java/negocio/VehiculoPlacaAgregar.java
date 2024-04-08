package negocio;

import DTO.PlacaGeneradaDTO;
import DTO.PlacaNuevaDTO;
import DTO.VehiculoGeneradoDTO;

/**
 *
 * @author Amós Helí Olguín Quiróz
 */
public class VehiculoPlacaAgregar {
    
    /**
     * metodo que le agrega a un vehiculo dado como parametro una placa dada
     * como parametro
     * @param vehiculoGeneradoDTO
     * @param placaNuevaDTO
     * @return 
     */
    public PlacaGeneradaDTO agregarVehiculoAPlaca(VehiculoGeneradoDTO vehiculoGeneradoDTO, PlacaNuevaDTO placaNuevaDTO){
        VehiculoConsulta vehiculoConsulta = new VehiculoConsulta();
        PlacaConsulta placaConsulta = new PlacaConsulta();
        vehiculoGeneradoDTO = vehiculoConsulta.agregarPlaca(vehiculoGeneradoDTO, placaNuevaDTO);
        vehiculoConsulta.actualizarVehiculo(vehiculoGeneradoDTO);
        placaNuevaDTO = placaConsulta.agregarVehiculo(placaNuevaDTO, vehiculoGeneradoDTO);
        PlacaGeneradaDTO placaGeneradaDTO = placaConsulta.actualizarPlaca(placaConsulta.buscarPlacaNumeroPlaca(placaNuevaDTO.getNumeroPlaca()));
        return placaConsulta.buscarPlacaNumeroPlaca(placaGeneradaDTO.getNumeroPlaca());
    }
}