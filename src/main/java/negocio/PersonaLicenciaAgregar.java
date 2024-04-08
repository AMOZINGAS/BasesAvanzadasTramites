package negocio;

import DTO.LicenciaGeneradaDTO;
import DTO.LicenciaNuevaDTO;
import DTO.PersonaGeneradaDTO;

/**
 *
 * @author Amós Helí Olguín Quiróz
 */
public class PersonaLicenciaAgregar {
    
    /**
     * metodo que agrega a una persona dada como parametro un licencia dada
     * como parametro y las actualiza
     * @param personaGeneradaDTO
     * @param licenciaNuevaDTO
     * @return 
     */
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
