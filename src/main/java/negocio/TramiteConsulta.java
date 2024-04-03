/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOS.IPersonaDAO;
import DAOS.ITramiteDAO;
import DAOS.PersonaDAO;
import DAOS.TramiteDAO;
import DTO.LicenciaGeneradaDTO;
import DTO.PersonaGeneradaDTO;
import DTO.TramiteDTO;
import entidades.LicenciaEntidad;
import entidades.PersonaEntidad;
import entidades.TramiteEntidad;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author PC
 */
public class TramiteConsulta {
    
    private final ITramiteDAO tramiteDAO;
    
    
    public TramiteConsulta(){
        
        tramiteDAO = new TramiteDAO();
    
    }
    
    public List<TramiteDTO> listaTramitesPersona(PersonaGeneradaDTO personaGeneradaDTO, Calendar fechaHsta, Calendar fechaDesde){
        
        IPersonaDAO personaDAO = new PersonaDAO();
        PersonaEntidad persona = personaDAO.buscarPorId(personaGeneradaDTO.getIdPersona());
        List<TramiteEntidad> listaTramites = tramiteDAO.listaTramiterPersonaFecha(persona, fechaHsta, fechaDesde);
        List<TramiteDTO> listaDTO = new ArrayList<>();
        for(int i = 0; i < listaTramites.size(); i ++){
            
            TramiteEntidad tramiteEntidad = listaTramites.get(i);
            TramiteDTO tramiteDTO = new TramiteDTO();
            tramiteDTO.setId(tramiteEntidad.getId());
            tramiteDTO.setCosto(tramiteEntidad.getCosto());
            tramiteDTO.setEstado(tramiteEntidad.getEstado());
            tramiteDTO.setFechaTramite(tramiteEntidad.getFechaTramite());
            tramiteDTO.setTipo(tramiteEntidad.getTipo());
            listaDTO.add(tramiteDTO);
            
        }
        return listaDTO;
        
    }
    
    public int vigenciaLicencia(TramiteDTO tramiteDTO){
        
        LicenciaConsulta licenciaConsulta = new LicenciaConsulta();
        LicenciaGeneradaDTO licenciaGeneradaDTO = licenciaConsulta.buscarLicenciaId(tramiteDTO.getId());
        return licenciaGeneradaDTO.getVigencia();
        
    }
    
    public List<TramiteDTO> listaTramitePersonaTipo(PersonaGeneradaDTO personaGeneradaDTO, String tipo, Calendar fechaHsta, Calendar fechaDesde){
        
        IPersonaDAO personaDAO = new PersonaDAO();
        PersonaEntidad persona = personaDAO.buscarPorId(personaGeneradaDTO.getIdPersona());
        List<TramiteEntidad> listaTramites = tramiteDAO.listaTramitePersonaTipoFecha(persona, tipo, fechaHsta, fechaDesde);
        List<TramiteDTO> listaDTO = new ArrayList<>();
        for(int i = 0; i < listaTramites.size(); i ++){
            
            TramiteEntidad tramiteEntidad = listaTramites.get(i);
            TramiteDTO tramiteDTO = new TramiteDTO();
            tramiteDTO.setId(tramiteEntidad.getId());
            tramiteDTO.setCosto(tramiteEntidad.getCosto());
            tramiteDTO.setEstado(tramiteEntidad.getEstado());
            tramiteDTO.setFechaTramite(tramiteEntidad.getFechaTramite());
            tramiteDTO.setTipo(tramiteEntidad.getTipo());
            listaDTO.add(tramiteDTO);
            
        }
        return listaDTO;
        
    }
    
    public List<TramiteDTO> listaTramite(String tipo){
        
        List<TramiteEntidad> listaTramites = tramiteDAO.listaTramite(tipo);
        List<TramiteDTO> listaDTO = new ArrayList<>();
        for(int i = 0; i < listaTramites.size(); i ++){
            
            TramiteEntidad tramiteEntidad = listaTramites.get(i);
            TramiteDTO tramiteDTO = new TramiteDTO();
            tramiteDTO.setId(tramiteEntidad.getId());
            tramiteDTO.setCosto(tramiteEntidad.getCosto());
            tramiteDTO.setEstado(tramiteEntidad.getEstado());
            tramiteDTO.setFechaTramite(tramiteEntidad.getFechaTramite());
            tramiteDTO.setTipo(tramiteEntidad.getTipo());
            listaDTO.add(tramiteDTO);
            
        }
        return listaDTO;
        
    }
    
}
