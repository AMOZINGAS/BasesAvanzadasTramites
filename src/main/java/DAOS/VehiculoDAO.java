/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import entidades.PersonaEntidad;
import entidades.PlacaEntidad;
import entidades.VehiculoEntidad;
import java.util.List;

/**
 *
 * @author PC
 */
public class VehiculoDAO implements IVehiculoDAO{
    
    @Override
    public VehiculoEntidad agregarPersona(VehiculoEntidad vehiculoEntidad, PersonaEntidad personaEntidad) {
    
        vehiculoEntidad.setPersona(personaEntidad);
        return vehiculoEntidad;
        
    }
    
    @Override
    public VehiculoEntidad agregarPlaca(PlacaEntidad placaEntidad, VehiculoEntidad vehiculoEntidad){
        
        List<PlacaEntidad> listaPlacas = vehiculoEntidad.getPlacas();
        listaPlacas.add(placaEntidad);
        vehiculoEntidad.setPlacas(listaPlacas);
        return vehiculoEntidad;
        
    }
    
}
