/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DTO.PlacaGeneradaDTO;
import DTO.PlacaNuevaDTO;
import DTO.VehiculoGeneradoDTO;
import DTO.VehiculoNuevoDTO;

/**
 *
 * @author PC
 */
public class VehiculoPlacaAgregar {
    
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
