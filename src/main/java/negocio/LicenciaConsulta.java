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
import java.util.Random;
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
            System.out.println(licenciaEntidad.getFolio());
            licenciaDAO.agregarPersona(personaEntidad, licenciaEntidad);
            return  convertidor.entityToDTO(licenciaEntidad, new LicenciaNuevaDTO());
            
        }catch(PersistenceException px){
            
            JOptionPane.showMessageDialog(null, "Ocurrió un error al agregarle un vehiculo a una placa", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return null;
            
        }
        
    }
    
    public int generarFolio(){
        
        Random random = new Random();
        int folio = random.nextInt(100000000);
        System.out.println(folio);
        return folio;
        
    }
    
    public int verificarFolio(){
        
        int folio;
        
        do{
            
            folio = generarFolio();
            System.out.println(folio);
            
        }while(buscarLicenciaFolio(folio)!=null);
        
        return folio;
        
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
            if(licenicaEntidad==null){
                
                return null;
                
            }
            Convertidor convertidor = new Convertidor();
            LicenciaGeneradaDTO licenciaGeneradaDTO = convertidor.entityToDTO(licenicaEntidad, new LicenciaGeneradaDTO());
            return licenciaGeneradaDTO;
            
        }catch(NoResultException nre){
            
            JOptionPane.showMessageDialog(null, "No se encontró una placa con ese numero de placa");
            return null;
            
        }
        
    }
    
    public LicenciaGeneradaDTO buscarLicenciaId(Long id){
        
        try{
            
            LicenciaEntidad licenicaEntidad = licenciaDAO.buscarLicenciaId(id);
            if(licenicaEntidad==null){
                
                return null;
                
            }
            Convertidor convertidor = new Convertidor();
            LicenciaGeneradaDTO licenciaGeneradaDTO = convertidor.entityToDTO(licenicaEntidad, new LicenciaGeneradaDTO());
            return licenciaGeneradaDTO;
            
        }catch(NoResultException nre){
            
            JOptionPane.showMessageDialog(null, "No se encontró una placa con ese numero de placa");
            return null;
            
        }
        
    }
    
}
