/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DTO.LicenciaGeneradaDTO;
import DTO.LicenciaNuevaDTO;
import DTO.PersonaGeneradaDTO;

/**
 *
 * @author PC
 */
public class PersonaLicenciaAgregar {
    
    public LicenciaGeneradaDTO agregarLicenciaAPersona(PersonaGeneradaDTO personaGeneradaDTO, LicenciaNuevaDTO licenciaNuevaDTO){
        
        PersonaConsulta personaConsulta = new PersonaConsulta();
        LicenciaConsulta licenciaConsulta = new LicenciaConsulta();
        personaGeneradaDTO = personaConsulta.agregarLicencia(licenciaNuevaDTO, personaGeneradaDTO);
        personaConsulta.actualizarPersona(personaGeneradaDTO);
        licenciaNuevaDTO = licenciaConsulta.agregarPersona(licenciaNuevaDTO, personaGeneradaDTO);
        LicenciaGeneradaDTO licenciaGeneradaDTO = licenciaConsulta.actualizarLicencia(licenciaConsulta.buscarLicenciaFolio(licenciaNuevaDTO.getFolio()));
        return licenciaConsulta.buscarLicenciaFolio(licenciaGeneradaDTO.getFolio());
        
    }
    
}
