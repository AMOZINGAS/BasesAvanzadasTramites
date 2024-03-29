/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DTO.PersonaGeneradaDTO;
import DTO.VehiculoGeneradoDTO;
import DTO.VehiculoNuevoDTO;

/**
 *
 * @author PC
 */
public class PersonaVehiculoAgregar {
    
    public VehiculoGeneradoDTO agregarVehiculoAPersona(PersonaGeneradaDTO personaGeneradaDTO, VehiculoNuevoDTO vehiculoNuevoDTO){
        
        PersonaConsulta personaConsulta = new PersonaConsulta();
        VehiculoConsulta vehiculoConsulta = new VehiculoConsulta();
        personaGeneradaDTO = personaConsulta.agregarVehiculo(vehiculoNuevoDTO, personaGeneradaDTO);
        personaConsulta.actualizarPersona(personaGeneradaDTO);
        vehiculoNuevoDTO = vehiculoConsulta.agregarPersona(vehiculoNuevoDTO, personaGeneradaDTO);
        VehiculoGeneradoDTO vehiculoGeneradoDTO = vehiculoConsulta.actualizarVehiculo(vehiculoConsulta.buscarVehiculoNumeroSerie(vehiculoNuevoDTO.getNumSerie()));
        return vehiculoConsulta.buscarVehiculoNumeroSerie(vehiculoGeneradoDTO.getNumSerie());
        
    }
    
}
