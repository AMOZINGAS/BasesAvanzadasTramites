/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOS.IPersonaDAO;
import DAOS.PersonaDAO;
import DTO.PersonaGeneradaDTO;
import DTO.PersonaNuevaDTO;
import DTO.VehiculoDTO;
import Entidades.PersonaEntidad;
import Entidades.VehiculoEntidad;
import java.util.Calendar;
import java.util.List;
import modificadores.Convertidor;

/**
 *
 * @author Amos Heli Olguin Quiroz
 */
public class PersonaConsulta {
    
    private final IPersonaDAO personaDAO;
    
    
    public PersonaConsulta(){
        
        personaDAO = new PersonaDAO();
    
    }
    
    /**
     * Metodo que llama a persistencia por una lista de las entidades persona
     * @return listaPersona
     */
    public List<PersonaEntidad> listaPersonas(){
        
        List<PersonaEntidad> listaPersonas = personaDAO.listaPersonas();
        return listaPersonas;
        
    }
    
    /**
     * Metodo que regresa una lista con las personas que coincidan con el nombre
     * @param nombres
     * @return listaPersonasNombre
     */
    public List<PersonaEntidad> listaPersonasNombre(String nombres){
        
        List<PersonaEntidad> listaPersonasNombre = personaDAO.buscarPorNombre(nombres);
        return listaPersonasNombre;
        
    }
    
    /**
     * Metodo que regresa un dto de una persona buscada por su id
     * @param id
     * @return personaGeneradaDTO
     */
    public PersonaGeneradaDTO personaPorID(Long id){
        
        PersonaEntidad personaEntidad = personaDAO.buscarPorId(id);
        Convertidor convertidor = new Convertidor();
        PersonaGeneradaDTO personaGeneradaDTO = convertidor.entityToDTO(personaEntidad, new PersonaGeneradaDTO());
        return personaGeneradaDTO;
       
    }
    
    /**
     * Metodo que regresa un dto que fue enviado a persistir
     * @param personaNuevaDTO
     * @return personaGeneradaDTO
     */
    public PersonaGeneradaDTO agregarPersona(PersonaNuevaDTO personaNuevaDTO){
        
        Convertidor convertidor = new Convertidor();
        PersonaEntidad personaEntidad = convertidor.DTOToEntidad(personaNuevaDTO, new PersonaEntidad());
        personaEntidad = personaDAO.agregarPersona(personaEntidad);
        PersonaGeneradaDTO personaGeneradaDTO = convertidor.entityToDTO(personaEntidad, new PersonaGeneradaDTO());
        return personaGeneradaDTO;
        
    }
    
    /**
     * Metodo que agrega 20 personas a la base de datos de manera masiva y para
     * ejemplos
     */
    public void agregarMasivoPersonas(){
        
        Calendar fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.set(2004, 3, 1);
        for(int i = 0; i < 20; i ++){
            fechaNacimiento.add(Calendar.DAY_OF_MONTH, 1);
            PersonaNuevaDTO personaNueva = new PersonaNuevaDTO(fechaNacimiento, "ABD02" + (i + 1), "64426211" + (i + 1), "Nombre numero " + (i + 1), "Apellido paterno " + (i + 1), "Apellido materno " + (i + 1));
            agregarPersona(personaNueva);
            
        }
        
    }
    
    /**
     * Metodo que agrega un vehiculo a la lista de vehiculos de una persona
     * @param vehiculoDTO
     * @param personaEntidad
     * @return persona generada con el vehiculo en su lista
     */
    public PersonaGeneradaDTO agregarVehiculo(VehiculoDTO vehiculoDTO, PersonaEntidad personaEntidad){
        
        Convertidor convertidor = new Convertidor();
        VehiculoEntidad vehiculoEntidad = convertidor.DTOToEntidad(vehiculoDTO, new VehiculoEntidad());
        PersonaDAO personaDAO = new PersonaDAO();
        personaEntidad = personaDAO.agregarVehiculo(vehiculoEntidad, personaEntidad);
        PersonaGeneradaDTO personaGeneradaDTO = convertidor.entityToDTO(personaEntidad, new PersonaGeneradaDTO());
        return personaGeneradaDTO;
    }
    
}
