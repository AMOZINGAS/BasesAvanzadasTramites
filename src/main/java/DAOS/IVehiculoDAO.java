/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOS;

import entidades.PersonaEntidad;
import entidades.PlacaEntidad;
import entidades.VehiculoEntidad;

/**
 *
 * @author PC
 */
public interface IVehiculoDAO {
    
    public VehiculoEntidad agregarPersona(VehiculoEntidad vehiculoEntidad, PersonaEntidad personaEntidad);
    
    public VehiculoEntidad agregarPlaca(PlacaEntidad placaEntidad, VehiculoEntidad vehiculoEntidad);
    
}
