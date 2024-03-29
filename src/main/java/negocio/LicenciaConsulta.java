/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOS.ILicenciaDAO;
import DAOS.IPersonaDAO;
import DAOS.IVehiculoDAO;
import DAOS.LicenciaDAO;
import DAOS.PersonaDAO;
import DTO.LicenciaGeneradaDTO;
import DTO.LicenciaNuevaDTO;
import DTO.PersonaGeneradaDTO;
import entidades.LicenciaEntidad;
import entidades.PersonaEntidad;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import modificadores.Convertidor;
import org.eclipse.persistence.jpa.jpql.parser.ConcatExpression;

/**
 *
 * @author PC
 */
public class LicenciaConsulta {
    
    ILicenciaDAO licenciaDAO;
    
    public LicenciaConsulta(){
        
        licenciaDAO = new LicenciaDAO();
    
    }   
    
     public LicenciaNuevaDTO agregarPersona(LicenciaNuevaDTO licenciaNuevaDTO, PersonaGeneradaDTO personaGeneradaDTO){
        
        try{
            
            Convertidor convertidor = new Convertidor();
            IPersonaDAO personaDAO = new PersonaDAO();
            PersonaEntidad personaEntidad = personaDAO.buscarPorId(personaGeneradaDTO.getIdPersona());
            LicenciaEntidad licenciaEntidad = licenciaDAO.buscarLicenciaFolio(licenciaNuevaDTO.getFolio());
            licenciaDAO.agregarPersona(personaEntidad, licenciaEntidad);
            return  convertidor.entityToDTO(licenciaEntidad, new LicenciaNuevaDTO());
            
        }catch(PersistenceException px){
            
            JOptionPane.showMessageDialog(null, "Ocurrió un error al agregarle un vehiculo a una placa", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return null;
            
        }
        
    }
    
    public LicenciaGeneradaDTO actualizarLicencia(LicenciaGeneradaDTO licenciaGeneradaDTO){
        
        try{
            
            Convertidor convertidor = new Convertidor();
            LicenciaEntidad licenciaEntidad = licenciaDAO.buscarLicenciaFolio(licenciaGeneradaDTO.getFolio());
            licenciaDAO.actualizarLicencia(licenciaEntidad);
            return convertidor.entityToDTO(licenciaEntidad, new LicenciaGeneradaDTO());
            
        }catch(PersistenceException px){
            
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar placa", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return null;
            
        }
    }
    
    public List<LicenciaGeneradaDTO> listaLicenciaPersona(String curp){
        
        IPersonaDAO personaDAO = new PersonaDAO();
        PersonaEntidad personaEntidad = personaDAO.buscarPorCurp(curp);
        List<LicenciaEntidad> listaEntidad = licenciaDAO.listaLicenciaPersona(personaEntidad);
        List<LicenciaGeneradaDTO> listaLicenciaDTO = new ArrayList<>();
        for(int i = 0; i < listaEntidad.size(); i ++){
            
            LicenciaEntidad licencia = listaEntidad.get(i);
            Convertidor convertidor = new Convertidor();
            LicenciaGeneradaDTO licenciaGeneradaDTO = convertidor.entityToDTO(licencia, new LicenciaGeneradaDTO());
            listaLicenciaDTO.add(licenciaGeneradaDTO);
            
        }
        
        return listaLicenciaDTO;
        
    }
    
    public LicenciaGeneradaDTO buscarLicenciaFolio(int folio){
        
        try{
            
            LicenciaEntidad licenicaEntidad = licenciaDAO.buscarLicenciaFolio(folio);
            Convertidor convertidor = new Convertidor();
            LicenciaGeneradaDTO licenciaGeneradaDTO = convertidor.entityToDTO(licenicaEntidad, new LicenciaGeneradaDTO());
            return licenciaGeneradaDTO;
            
        }catch(NoResultException nre){
            
            JOptionPane.showMessageDialog(null, "No se encontró una placa con ese numero de placa");
            return null;
            
        }
        
    }
    
}
