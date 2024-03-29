/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOS.IPlacaDAO;
import DAOS.IVehiculoDAO;
import DAOS.PlacaDAO;
import DAOS.VehiculoDAO;
import DTO.PlacaGeneradaDTO;
import DTO.PlacaNuevaDTO;
import DTO.VehiculoGeneradoDTO;
import entidades.PlacaEntidad;
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
public class PlacaConsulta {
    
    private final IPlacaDAO placaDAO;
    
    
    public PlacaConsulta(){
        
        placaDAO = new PlacaDAO();
        
    }
    
    public PlacaNuevaDTO agregarVehiculo(PlacaNuevaDTO placaNuevaDTO, VehiculoGeneradoDTO vehiculoGeneradoDTO){
        
        try{
            
            IVehiculoDAO vehiculoDAO = new VehiculoDAO();
            Convertidor convertidor = new Convertidor();
            VehiculoEntidad vehiculoEntidad = vehiculoDAO.buscarPorNumeroSerie(vehiculoGeneradoDTO.getNumSerie());
            PlacaEntidad placaEntidad = placaDAO.buscarPorNumeroPlaca(placaNuevaDTO.getNumeroPlaca());
            placaDAO.agregarVehiculo(vehiculoEntidad, placaEntidad);
            return convertidor.entityToDTO(placaEntidad, new PlacaNuevaDTO());
            
        }catch(PersistenceException px){
            
            JOptionPane.showMessageDialog(null, "Ocurrió un error al agregarle un vehiculo a una placa", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return null;
            
        }
        
    }
    
    public PlacaGeneradaDTO actualizarPlaca(PlacaGeneradaDTO placaGeneradaDTO){
        
        try{
            
            Convertidor convertidor = new Convertidor();
            PlacaEntidad placaEntidad = placaDAO.buscarPorNumeroPlaca(placaGeneradaDTO.getNumeroPlaca());
            placaDAO.actualizarPlaca(placaEntidad);
            return convertidor.entityToDTO(placaEntidad, new PlacaGeneradaDTO());
            
        }catch(PersistenceException px){
            
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar placa", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return null;
            
        }
    }
    
    public List<PlacaGeneradaDTO> listaPlacaVehiculo(String numeroSerie){
        
        IPlacaDAO placaDAO = new PlacaDAO();
        IVehiculoDAO vehiculoDAO = new VehiculoDAO();
        VehiculoEntidad vehiculoEntidad = vehiculoDAO.buscarPorNumeroSerie(numeroSerie);
        List<PlacaEntidad> listaEntidad = placaDAO.listaPlacasVehiculo(vehiculoEntidad);
        List<PlacaGeneradaDTO> listaPlacaDTO = new ArrayList<>();
        for(int i = 0; i < listaEntidad.size(); i ++){
            
            PlacaEntidad placa = listaEntidad.get(i);
            Convertidor convertidor = new Convertidor();
            PlacaGeneradaDTO placaGeneradaDTO = convertidor.entityToDTO(placa, new PlacaGeneradaDTO());
            listaPlacaDTO.add(placaGeneradaDTO);
            
        }
        
        return listaPlacaDTO;
        
    }
    
    public PlacaGeneradaDTO buscarPlacaNumeroPlaca(String numeroPlaca){
        
        try{
            
            PlacaEntidad placaEntidad = placaDAO.buscarPorNumeroPlaca(numeroPlaca);
            Convertidor convertidor = new Convertidor();
            PlacaGeneradaDTO placaGeneradaDTO = convertidor.entityToDTO(placaEntidad, new PlacaGeneradaDTO());
            return placaGeneradaDTO;
            
        }catch(NoResultException nre){
            
            JOptionPane.showMessageDialog(null, "No se encontró una placa con ese numero de placa");
            return null;
            
        }
        
    }
    
}
