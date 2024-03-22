/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOS;

//import Entidades.PlacaEntidad;
//import Entidades.VehiculoEntidad;
import entidades.PlacaEntidad;
import entidades.VehiculoEntidad;
import java.util.List;

/**
 *
 * @author elimo
 */
public interface IPlacaDAO {
    
    void guardarPlaca(PlacaEntidad placaEntidad);
    
    PlacaEntidad buscarPlacaPorNumero(String numero);
    
    List<PlacaEntidad> buscarPlacasPorAutomovil(VehiculoEntidad vehiculo);
    
    List<PlacaEntidad> obtenerTodasLasPlacas();
    
}
