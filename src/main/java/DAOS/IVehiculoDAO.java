/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
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
public interface IVehiculoDAO {
    
    public VehiculoEntidad agregarPersona(VehiculoEntidad vehiculoEntidad, PersonaEntidad personaEntidad);
    
    public VehiculoEntidad buscarPorNumeroSerie(String numeroSerie);
    
    public List<VehiculoEntidad> listaVehiculoPersona(PersonaEntidad persona);
    
    public VehiculoEntidad agregarPlaca(PlacaEntidad placaEntidad, VehiculoEntidad vehiculoEntidad);
    
}
