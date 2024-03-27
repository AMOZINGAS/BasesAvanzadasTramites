/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOS.IPersonaDAO;
import DAOS.IVehiculoDAO;
import DAOS.PersonaDAO;
import DAOS.VehiculoDAO;
import DTO.PersonaGeneradaDTO;
import DTO.PlacaNuevaDTO;
import DTO.VehiculoGeneradoDTO;
import DTO.VehiculoNuevoDTO;
import entidades.PersonaEntidad;
import entidades.VehiculoEntidad;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import modificadores.Convertidor;

/**
 *
 * @author PC
 */
public class VehiculoConsulta {
    
    IVehiculoDAO vehiculoDAO;
    
    public VehiculoConsulta(){
        
        vehiculoDAO = new VehiculoDAO();
        
    }
    
    public List<VehiculoGeneradoDTO> listaVehiculosPersona(String curp){
        
        PersonaConsulta personaConsulta = new PersonaConsulta();
        PersonaGeneradaDTO personaGeneradaDTO = personaConsulta.personaPorCurp(curp);
        IVehiculoDAO vehiculoDAO = new VehiculoDAO();
        IPersonaDAO personaDAO = new PersonaDAO();
        PersonaEntidad personaEntidad = personaDAO.buscarPorId(personaGeneradaDTO.getIdPersona());
        List<VehiculoEntidad> listaEntidad = vehiculoDAO.listaVehiculoPersona(personaEntidad);
        List<VehiculoGeneradoDTO> listaVehiculoDTO = new ArrayList<>();
        for(int i = 0; i < listaEntidad.size(); i ++){
            
            VehiculoEntidad vehiculo = listaEntidad.get(i);
            Convertidor convertidor = new Convertidor();
            VehiculoGeneradoDTO vehiculoGeneradoDTO = convertidor.entityToDTO(vehiculo, new VehiculoGeneradoDTO());
            listaVehiculoDTO.add(vehiculoGeneradoDTO);
            
        }
        
        return listaVehiculoDTO;
        
    }
    
    public boolean agregarPlaca(VehiculoGeneradoDTO vehiculoDTO, PlacaNuevaDTO placaDTO){
        
        return false;
        
    } 
    
    public VehiculoGeneradoDTO buscarVehiculoNumeroSerie(String numeroSerie) throws NoResultException{
        
        try{
            
            VehiculoEntidad vehiculoEntidad = vehiculoDAO.buscarPorNumeroSerie(numeroSerie);
            Convertidor convertidor = new Convertidor();
            VehiculoGeneradoDTO vehiculoGeneradaDTO = convertidor.entityToDTO(vehiculoEntidad, new VehiculoGeneradoDTO());
            return vehiculoGeneradaDTO;
            
        }catch(NoResultException nre){
            
            JOptionPane.showMessageDialog(null, "No se encontró un vehiculo con ese numero de serie");
            return null;
            
        }
    }
    
    public VehiculoNuevoDTO agregarPersona(VehiculoNuevoDTO vehiculoNuevoDTO, PersonaGeneradaDTO personaGeneradaDTO) throws PersistenceException{
        
        try{
            
            PersonaDAO personaDAO = new PersonaDAO();
            Convertidor convertidor = new Convertidor();
            PersonaEntidad personaEntidad = personaDAO.buscarPorId(personaGeneradaDTO.getIdPersona());
            VehiculoEntidad vehiculoEntidad = convertidor.DTOToEntidad(vehiculoNuevoDTO, new VehiculoEntidad());
            vehiculoDAO.agregarPersona(vehiculoEntidad, personaEntidad);
            return convertidor.entityToDTO(vehiculoEntidad, new VehiculoNuevoDTO());
            
        }catch(PersistenceException px){
            
            JOptionPane.showMessageDialog(null, "Ocurrió un error al agregarle una persona a vehiculo", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return null;
            
        }
        
    }
    
}
