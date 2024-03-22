/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOS;

//import Entidades.LicenciaEntidad;
//import Entidades.PersonaEntidad;
//import Entidades.VehiculoEntidad;
import entidades.LicenciaEntidad;
import entidades.PersonaEntidad;
import entidades.VehiculoEntidad;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IPersonaDAO {
    
    public PersonaEntidad agregarPersona(PersonaEntidad personaEntidad);
    
    public PersonaEntidad actualizarPersona(PersonaEntidad personaEntidad);
    
    public PersonaEntidad buscarPorId(Long id);
    
    public List<PersonaEntidad> buscarPorNombre(String nombre);
    
    public List<PersonaEntidad> listaPersonas();
    
    public PersonaEntidad agregarVehiculo(VehiculoEntidad vehiculoEntidad, PersonaEntidad personEntidad);
    
    public PersonaEntidad agregarLicencia(LicenciaEntidad licenciaEntidad, PersonaEntidad personEntidad);
    
}
